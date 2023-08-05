/**
 * A brief description of the role of this class. This extends Matrix and is a matrix. Practicing packages and exploring Javadoc documentation.
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Surbhi Bahri, James Mwangi PhD.
 *
  */
package lab4test.matrices;

/**
 * @author owner
 *
 */
public class NamedMatrix extends Matrix {
    private String name;

    /**
     * Constructs a NamedMatrix object with the specified name and array data.
     *
     * @param name  The name of the matrix.
     * @param array The array representing the matrix data.
     */
    public NamedMatrix(String name, double[][] array) {
        super(array);
        this.name = name;
    }

    /**
     * Retrieves the name of the matrix.
     *
     * @return name of the matrix.
     */
    public String getName() {
        return name;
    }
}