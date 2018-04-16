package test;

import test.comparator.ComparatorHandler;
import test.comparator.SentenceMatcherResult;
import test.entity.Sentence;
import test.entity.SentenceBuilder;
import test.exception.CantReadFileException;
import test.io.ConsoleUtils;
import test.io.FileReaderUtils;

import java.util.List;

public class Starter {

	private static SentenceBuilder sentenceBuilder = new SentenceBuilder();
	private static ComparatorHandler comparatorHandler = new ComparatorHandler();

	public static void main(String...args) throws CantReadFileException {
		List<String> lines = FileReaderUtils.readFile();
		List<Sentence> sentence = sentenceBuilder.makeSentence(lines);
		List<SentenceMatcherResult> result = comparatorHandler.matchSentence(sentence);
		ConsoleUtils.showSentencesResult(result);
	}

}
