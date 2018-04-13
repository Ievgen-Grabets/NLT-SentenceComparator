package test.io;

import test.exception.CantReadFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderUtils {

	private static final String FILE_PATH = "input.txt";

	public static List<String> readFile() throws CantReadFileException {
		try (BufferedReader lineReader = new BufferedReader(new FileReader(FILE_PATH))) {
			List<String> linesReturn = lineReader.lines().collect(Collectors.toList());
			lineReader.close();
			return linesReturn;
		} catch (IOException ex) {
			throw new CantReadFileException(ex.getMessage(), ex.getCause());
		}
	}

}
