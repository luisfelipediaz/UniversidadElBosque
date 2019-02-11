import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Program {
	private static ArrayList<String> lines;
	private static File file;
	
	private static ArrayList<String> paquetes = new ArrayList<String>();
	private static ArrayList<String> clases = new ArrayList<String>();
	private static ArrayList<String> attributes = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		init();
		proccessLines();
	}

	private static void proccessLines() {
		lines.stream().forEach(line -> {
			Matcher m = Pattern.compile("^import\\s*(.+);$").matcher(line);
			if (m.find()) {
				paquetes.add(m.group(1));
			}
			
			Matcher mClass = Pattern.compile("class\\s+(\\w+)").matcher(line);
			if (mClass.find()) {
				clases.add(mClass.group(1));
			}
			
			Matcher mAttributes = Pattern.compile("((public|private|protected|static|native|synchronized|final)+\\s)+((byte|short|int|long|float|double|boolean|char|String)+\\s)+([a-zA-Z_$][\\w$]*)(\\[\\])*")
					.matcher(line);
			
			if (mClass.find()) {
				attributes.add(mClass.group(mClass.end()));
			}
			
		});

	}

	private static void init() throws Exception {
		selectFile();
		readAllLinesOfFile();
	}

	public static void selectFile() throws Exception {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Java files", "java");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			return;
		}

		throw new Exception("No se seleccionó ningún archivo");
	}

	private static void readAllLinesOfFile() throws FileNotFoundException, IOException {
		lines = new ArrayList<String>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}
	}
}