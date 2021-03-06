package iteration1;
/**
 * 
 * @author chaima_arfaoui
 *
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import iteration2.GridMatrix;
import iteration2.GridMatrix.GridArray;

public class FileLoad {

	/**
	 * @param Charset
	 */

	public static final Charset ENCODING = StandardCharsets.UTF_8;
	private static final String ALIVE = "+";
	private static final String SEPARATOR = "x";

	public FileLoad() {
		super();
	}

	public GameOfLife retrieveDataFromFile(String sourceFileName) {
		List<String> lines = null;
		try {
			lines = readFile(sourceFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int row = extractRow(lines);
		int col = extractCol(lines);
		GridMatrix grid = extractGrid(lines);

		GameOfLife gameOfLife = new GameOfLife(row, col, grid);

		return gameOfLife;
	}

	public String getPath(String dataFileName) {

		ClassLoader classLoader = getClass().getClassLoader();
		String fileDataPath = new File(classLoader.getResource(dataFileName).getFile()).getAbsolutePath();
		return fileDataPath;

	}

	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private List<String> readFile(String fileName) throws IOException {

		Path path = Paths.get(fileName);
		return Files.readAllLines(path, ENCODING);
	}

	private int extractRow(List<String> lines) {
		return Integer.parseInt(lines.get(0).split(SEPARATOR)[0]);
	}

	private int extractCol(List<String> lines) {
		return Integer.parseInt(lines.get(0).split(SEPARATOR)[1]);
	}

	/**
	 * transformer les cellules de grille de type String par des cellules Type
	 * Boolean finalement : transformer la grille entire de type String vers
	 * type GridMatrix
	 */

	private GridMatrix extractGrid(List<String> lines) {
		List<String> subLines = lines.subList(1, lines.size());
		GridMatrix matrix = new GridMatrix();
		// GridArray array = new GridArray();
		for (int i = 0; i < subLines.size(); i++) {
			String[] s = subLines.get(i).split("");
			GridArray g = setRow(s);
			matrix.getGridArray().add(g);

		}

		return matrix;

	}

	/**
	 * transformer les caractère : + par true et - par false pour obtenir un
	 * matrice de type boolean
	 */

	GridArray setRow(String[] s) {
		GridArray gridArray = new GridArray();
		for (int i = 0; i < s.length; i++) {

			if (s[i].equals(ALIVE)) {
				gridArray.getArray().add(true);
			} else {
				gridArray.getArray().add(false);
			}

		}
		return gridArray;

	}

}
