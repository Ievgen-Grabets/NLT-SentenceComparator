package test.entity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence {

	private List<Word> words = Collections.emptyList();

	public Sentence(List<Word> words) {
		this.words = words;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return words.stream()
				.map(Word::getWord)
				.collect(Collectors.joining(" "));
	}
}
