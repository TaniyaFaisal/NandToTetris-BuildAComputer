import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Parser {

	private static final String SPACE = " ";

	public Parser() {}

	public List<String> parse(File sourceCode) throws IOException {
		List<String> commands = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceCode));
		String line = "";

		while ((line = bufferedReader.readLine()) != null) {
			String command = removeSpaces(removeComment(line));
			if (!("".equals(command))) {
				commands.add(command);
			}
		}

		return commands;
	}

	private String removeComment(String line) {
		int index = line.indexOf("//");
		if (index > -1) {
			return line.substring(0, index);
		}

		return line.trim();
	}

	private String removeSpaces(String line) {
		return line.replaceAll("\\s+", SPACE);
	}
}