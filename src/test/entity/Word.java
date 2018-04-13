package test.entity;


import java.util.Objects;

public class Word {

	final private String word;
	final private boolean date;

	public Word(String word, boolean date) {
		this.word = word;
		this.date = date;
	}

	public String getWord() {
		return word;
	}

	public boolean isDate() {
		return date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Word word1 = (Word) o;
		return isDate() == word1.isDate() &&
				Objects.equals(getWord(), word1.getWord());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getWord(), isDate());
	}
}
