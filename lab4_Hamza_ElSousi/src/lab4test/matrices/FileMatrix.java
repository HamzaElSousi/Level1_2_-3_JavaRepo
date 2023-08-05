/**
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 *
  */

/*A brief description of the role of this class. 
 * Class FileMatrix extends Matrix and is there to read and write to the file using I/O collection.  
 *  Practicing packages and exploring Javadoc documentation.
 */
package lab4test.matrices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents a matrix that can be read from or saved to a file. It
 * extends the Matrix class.
 */
public class FileMatrix extends Matrix {
	private File file;

	private FileMatrix(Scanner input) {
		super(readMatrixData(input));
	}

	/**
	 * Constructs a FileMatrix object from the data read from the specified file.
	 *
	 * @param file The file containing the matrix data.
	 * @throws IOException If an I/O error occurs while reading the file.
	 */
	public FileMatrix(File file) throws IOException {
		super(readMatrixDataFromFile(file));
		this.file = file;
	}

	/**
	 * Constructs a FileMatrix object from an existing Matrix object.
	 *
	 * @param matrix The Matrix object to create a FileMatrix from.
	 */
	public FileMatrix(Matrix matrix) {
		super(matrix.getData());
	}

	@Override
	public boolean save(File file) {
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(getRows() + " " + getColumns() + System.lineSeparator());
			double[][] data = getData();
			for (double[] row : data) {
				for (double value : row) {
					writer.write(value + " ");
				}
				writer.write(System.lineSeparator());
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Reads matrix data from the specified Scanner object.
	 *
	 * @param input The Scanner object to read input from.
	 * @return The matrix data read from the input.
	 */
	private static double[][] readMatrixData(Scanner input) {
		// System.out.print("Enter number of rows: ");
		int rows = input.nextInt();
		// System.out.print("Enter number of columns: ");
		int columns = input.nextInt();
		double[][] matrixData = new double[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				// System.out.print("Enter value for position [" + i + "][" + j + "]: ");
				matrixData[i][j] = input.nextDouble();
			}
		}
		return matrixData;
	}

	/**
	 * Reads matrix data from the specified file.
	 *
	 * @param file The file to read matrix data from.
	 * @return The matrix data from the file.
	 * @throws IOException If an I/O error occurs while reading the file.
	 */
	private static double[][] readMatrixDataFromFile(File file) throws IOException {
		try (Scanner scanner = new Scanner(file)) {
			int rows = scanner.nextInt();
			int columns = scanner.nextInt();
			double[][] matrixData = new double[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					matrixData[i][j] = scanner.nextDouble();
				}
			}
			return matrixData;
		}
	}
}