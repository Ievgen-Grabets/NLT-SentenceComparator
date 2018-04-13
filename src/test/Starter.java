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

	public static void main(String...args) throws CantReadFileException {
		List<String> lines = FileReaderUtils.readFile();
		List<Sentence> sentence = SentenceBuilder.makeSentence(lines);
		List<SentenceMatcherResult> result = ComparatorHandler.matchSentence(sentence);
		ConsoleUtils.showSentencesResult(result);
	}

}
