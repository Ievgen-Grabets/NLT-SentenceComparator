package test.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sentence {

	private List<String> words = Collections.emptyList();
	private List<String> dates = Collections.emptyList();

	public Sentence( List<String> dates, List<String> words) {
		this.dates = dates;
		this.words = words;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public List<String> getDates() {
		return dates;
	}

	public void setDates(List<String> dates) {
		this.dates = dates;
	}

	@Override
	public String toString() {
		List<String> datesAndWords = new ArrayList<>();
		datesAndWords.addAll(dates);
		datesAndWords.addAll(words);
		return datesAndWords.stream()
				.collect(Collectors.joining(" "));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Sentence sentence = (Sentence) o;
		return Objects.equals(getWords(), sentence.getWords()) &&
				Objects.equals(getDates(), sentence.getDates());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getWords(), getDates());
	}
}
