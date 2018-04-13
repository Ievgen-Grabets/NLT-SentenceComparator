package test.comparator;


import test.entity.Sentence;
import test.entity.Word;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ComparatorHandler {

	public static List<SentenceMatcherResult> matchSentence(List<Sentence> sentences) {
		return ridOfNotMatchedSentence(mergeSentences(sentences));
	}

	private static List<SentenceMatcherResult> ridOfNotMatchedSentence(List<SentenceMatcher> sentences) {
		return sentences
				.stream()
				.parallel()
				.filter(ComparatorHandler::matchFilter)
				.map(ComparatorHandler::generateSentenceResult)
				.collect(Collectors.toList());
	}

	private static List<SentenceMatcher> mergeSentences(List<Sentence> sentences) {
		List<SentenceMatcher> sentenceMatchers = new ArrayList<>();
		List<Sentence> sentenceList = new ArrayList<>(sentences);
		for (int index = 0; index < sentenceList.size(); index++) {
			Sentence sentenceA = sentenceList.get(index);
			sentenceMatchers.addAll(
					sentences
							.stream()
							.skip(index+1)
							.map(sentenceB -> mergeSentences(sentenceA, sentenceB))
							.filter(sentenceMatcher -> !Objects.isNull(sentenceMatcher))
							.collect(Collectors.toList()));
		}

		return sentenceMatchers;
	}

	private static SentenceMatcher mergeSentences(Sentence sentenceA, Sentence sentenceB) {
		int size = sentenceA.getWords().size();
		if (size != sentenceB.getWords().size()) {
			return null;
		}
		List<WordMatcher> wordMatchers = new ArrayList<>();
		List<Word> wordsA = sentenceA.getWords();
		List<Word> wordsB = sentenceB.getWords();
		for(int i=0; i<size; i++){
			Word wordA = wordsA.get(i);
			Word wordB = wordsB.get(i);
			if(!wordA.isDate() && !wordB.isDate()){
				wordMatchers.add(new WordMatcher(wordA, wordB));
			}
		}
		return new SentenceMatcher(sentenceA, sentenceB, wordMatchers);
	}

	private static boolean matchFilter(SentenceMatcher sentenceMatcher) {
		return sentenceMatcher.getWordMatches()
				.stream()
				.parallel()
				.filter(ComparatorHandler::matchFilter)
				.count() < 2 ;
	}

	private static boolean matchFilter(WordMatcher wordMatcher) {
		return (!Objects.equals( wordMatcher.getWordA(), wordMatcher.getWordB()));
	}

	private static SentenceMatcherResult generateSentenceResult(SentenceMatcher sentenceMatcher) {
		Set<Word> differentWords = new HashSet<>();
		sentenceMatcher.getWordMatches().stream()
				.parallel()
				.filter(WordMatcher::IsdifferentWords)
				.forEach(wordMatcher -> {
					differentWords.add(wordMatcher.getWordA());
					differentWords.add(wordMatcher.getWordB());
				});
		return new SentenceMatcherResult(
				sentenceMatcher.getSentenceA(),
				sentenceMatcher.getSentenceB(),
				differentWords);
	}

}
