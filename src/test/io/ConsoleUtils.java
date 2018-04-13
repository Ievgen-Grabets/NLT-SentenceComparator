package test.io;

import test.comparator.SentenceMatcherResult;

import java.util.List;

public class ConsoleUtils {

	public static void showSentencesResult(List<SentenceMatcherResult> sentenceMatcherResults){
		sentenceMatcherResults.forEach(sentenceMatcherResult -> {
			System.out.println("==================================");
			System.out.println(sentenceMatcherResult);
			System.out.println("==================================");
		});
	}

}
