package test.comparator;

import test.entity.Sentence;
import java.util.List;
import java.util.stream.Collectors;


public class SentenceMatcherResult {

	private final Sentence sentenceA;
	private final Sentence sentenceB;
	private final List<String> difference;

	public SentenceMatcherResult(Sentence sentenceA, Sentence sentenceB, List<String> difference) {
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

	public List<String> getDifference() {
		return difference;
	}

	@Override
	public String toString() {
		return sentenceA + "\n"
				+ sentenceB + "\nThe changing word was: "
				+ difference.stream()
				.collect(Collectors.joining(", "));
	}

}
