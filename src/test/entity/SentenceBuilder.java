package test.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceBuilder {

	private static final String[] DATE_PATTERN = {"\\d{2}-\\d{2}-\\d{4}", "\\d{2}:\\d{2}:\\d{2}"};

	public List<Sentence> makeSentence(List<String> lines) {
		return lines.stream()
				.map(line -> {
					String[] stringWords = line.split(" ");
					List<String> dates = new ArrayList<>();
					List<String> words = new ArrayList<>();
					Arrays.stream(stringWords).forEach(word -> {
						if(isWordDate(word)){
							dates.add(word);
						}else {
							words.add(word);
						}
					});
					return new Sentence(dates, words);
				})
				.collect(Collectors.toList());
	}

	private boolean isWordDate(String word){
		return Arrays.stream(DATE_PATTERN).filter(word::matches).count()>=1;
	}
}
