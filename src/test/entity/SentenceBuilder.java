package test.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceBuilder {

	private static final String[] DATE_PATTERN = {"\\d{2}-\\d{2}-\\d{4}", "\\d{2}:\\d{2}:\\d{2}"};

	public static List<Sentence> makeSentence(List<String> lines) {
		return lines.stream()
				.map(line -> {
					String[] stringWords = line.split(" ");
					List<Word> words = Arrays.stream(stringWords)
							.map(word -> new Word(word, isWordDate(word)))
							.collect(Collectors.toList());
					return new Sentence(words);
				})
				.collect(Collectors.toList());
	}

	private static boolean isWordDate(String word){
		return Arrays.stream(DATE_PATTERN).filter(word::matches).count()>=1;
	}
}
