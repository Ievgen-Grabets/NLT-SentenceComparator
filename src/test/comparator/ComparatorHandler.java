package test.comparator;

import test.entity.Sentence;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComparatorHandler {

	private static final int ACCEPTED_DIFFERENCE = 2;

	public List<SentenceMatcherResult> matchSentence(List<Sentence> sentences) {
		List<SentenceMatcherResult> sentenceMatcherResults = new ArrayList<>();
		for (int index = 0; index < sentences.size(); index++) {
			Sentence sentenceA = sentences.get(index);
			sentenceMatcherResults.addAll(
					sentences.stream()
							.skip(index + 1)
							.parallel()
							.map(sentenceB -> generateCloseSentenceResult(sentenceA, sentenceB))
							.filter(sentenceResult -> !Objects.isNull(sentenceResult))
							.collect(Collectors.toList()));
		}
		return sentenceMatcherResults;
	}

	private SentenceMatcherResult generateCloseSentenceResult(Sentence sentenceA, Sentence sentenceB) {
		if (sentenceA == sentenceB || sentenceA.equals(sentenceB)) {
			return null;
		}
		List<String> difference = difference(sentenceA, sentenceB);
		return difference.size() <= ACCEPTED_DIFFERENCE ? new SentenceMatcherResult(sentenceA, sentenceB, difference) : null;
	}

	private List<String> difference(Sentence sentenceA, Sentence sentenceB) {

		List<String> difference = new ArrayList<>();

		List<String> wordsA = sentenceA.getWords();
		List<String> wordsB = sentenceB.getWords();

		Set<Integer> definedA = IntStream.range(0, wordsA.size()).boxed().collect(Collectors.toCollection(TreeSet::new));
		Set<Integer> definedB = IntStream.range(0, wordsB.size()).boxed().collect(Collectors.toCollection(TreeSet::new));

		for (int i = 0; i < wordsA.size(); i++) {
			String wordA = wordsA.get(i);
			for (int j = 0; j < wordsB.size(); j++) {
				if (definedB.contains(j)) {
					String wordB = wordsB.get(j);
					if (Objects.equals(wordA, wordB)) {
						definedA.remove(i);
						definedB.remove(j);
					}
				}
			}
		}
		difference.addAll(definedA.stream().map(wordsA::get).collect(Collectors.toList()));
		difference.addAll(definedB.stream().map(wordsB::get).collect(Collectors.toList()));
		return difference;
	}

}
