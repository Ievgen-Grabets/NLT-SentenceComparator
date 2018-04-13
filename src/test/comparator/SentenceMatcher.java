package test.comparator;

import test.entity.Sentence;

import java.util.Collections;
import java.util.List;

public class SentenceMatcher {

	private Sentence sentenceA;
	private Sentence sentenceB;
	private List<WordMatcher> wordMatches = Collections.emptyList();

	public SentenceMatcher(Sentence sentenceA, Sentence sentenceB, List<WordMatcher> wordMatches) {
		this.sentenceA = sentenceA;
		this.sentenceB = sentenceB;
		this.wordMatches = wordMatches;
	}

	public Sentence getSentenceA() {
		return sentenceA;
	}

	public void setSentenceA(Sentence sentenceA) {
		this.sentenceA = sentenceA;
	}

	public Sentence getSentenceB() {
		return sentenceB;
	}

	public void setSentenceB(Sentence sentenceB) {
		this.sentenceB = sentenceB;
	}

	public List<WordMatcher> getWordMatches() {
		return wordMatches;
	}

	public void setWordMatches(List<WordMatcher> wordMatches) {
		this.wordMatches = wordMatches;
	}
}
