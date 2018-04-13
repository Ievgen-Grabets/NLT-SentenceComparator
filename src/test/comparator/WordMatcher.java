package test.comparator;

import test.entity.Word;

import java.util.Objects;

public class WordMatcher {

	private final Word wordA;
	private final Word wordB;

	public WordMatcher(Word wordA, Word wordB) {
		this.wordA = wordA;
		this.wordB = wordB;
	}

	public Word getWordA() {
		return wordA;
	}

	public Word getWordB() {
		return wordB;
	}

	public boolean IsdifferentWords(){
		return !Objects.equals(wordA, wordB);
	}
}
