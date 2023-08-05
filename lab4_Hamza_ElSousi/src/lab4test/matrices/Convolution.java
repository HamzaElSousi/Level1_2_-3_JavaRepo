/**
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 *
  */

/*A brief description of the role of this class. 
 * Class Convolution is responsible for convoluting  the matrix.
 *  Practicing packages and exploring Javadoc documentation.
 */
package lab4test.matrices;

/**
 * @author owner
 *
 */
public class Convolution {
	private Matrix kernel;

	/**
	 * Constructs a Convolution object with the specified kernel.
	 * 
	 * @param kernel The kernel matrix used for convolution.
	 */
	public Convolution(Matrix kernel) {
		this.kernel = kernel;
	}

	/**
	 * Applies the convolution filter to the given image matrix.
	 *
	 * @param image The input image matrix.
	 * @return The filtered output image matrix. outputImage
	 */
	public Matrix filter(Matrix image) {
		int rows = image.getRows() - kernel.getRows() + 1;
		int columns = image.getColumns() - kernel.getColumns() + 1;
		double[][] outputImage = new double[rows][columns];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				Matrix subMatrix = null;
				try {
					// Extract a submatrix from the image
					subMatrix = image.subMatrix(r, c, kernel.getRows(), kernel.getColumns());
					// Multiplies the submatrix with the kernel
					Matrix multiplicationResult = subMatrix.mult(kernel);
					// Calculates the sum of the multiplication result
					outputImage[r][c] = multiplicationResult.sum();
				} catch (IllegalArgumentException e) {
					// Handle any invalid arguments exceptions
					e.printStackTrace();
				} finally {
					if (subMatrix != null) {
						// Clean up resources and output result.
					}
				}
			}
		}

		return new Matrix(outputImage);
	}
}
