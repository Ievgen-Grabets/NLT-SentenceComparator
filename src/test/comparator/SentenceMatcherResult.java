package test.comparator;

import test.entity.Sentence;
import test.entity.Word;
import java.util.Set;
import java.util.stream.Collectors;

public class SentenceMatcherResult {

	private final Sentence sentenceA;
	private final Sentence sentenceB;
	private final Set<Word> difference;

	public SentenceMatcherResult(Sentence sentenceA, Sentence sentenceB, Set<Word> difference) {
		this.sentenceA = sentenceA;
		this.sentenceB = sentenceB;
		this.difference = difference;
	}

	public Sentence getSentenceA() {
		return sentenceA;
	}

	public Sentence getSentenceB() {
		return sentenceB;
	}

	public Set<Word> getDifference() {
		return difference;
	}

	@Override
	public String toString() {
		return sentenceA + "\n"
				+ sentenceB + "\nThe changing word was: "
				+ difference.stream()
				.map(Word::getWord)
				.collect(Collectors.joining(", "));
	}

}
