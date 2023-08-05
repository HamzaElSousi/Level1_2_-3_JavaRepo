/*
 * Student Name: Hamza El Sousi
 * Lab Professor: Professor David Houtman
 * Due Date: March 31st, 2023 
 * Description: Assignment 02 (22W) Sample Solution  Update of original concept
 *              by Professor Stanley Pieda
 */

/**
 * This class is used to verify if the provided lumber meets the specifications.
 * It checks the thickness, width, and length of the lumber and returns a String
 * that reports if the lumber meets the specifications or if it does not, what
 * dimension(s) are incorrect.
 */
public class LumberChecker {
    // Create a public static final EPSILON with value 0.03125
    // i.e. 1/32 one-thirty-second inch
    public static final double EPSILON = 0.03125;

    /**
     * This method validates the lumber dimensions and returns a report.
     * It checks if the thickness, width, and length of the provided lumber
     * meet the specifications or if any dimension is incorrect.
     * @param lumber The DimensionalLumber object to validate.
     * @return A String report indicating if the lumber meets tolerance standards or
     * if any dimension is incorrect.
     */
    public String validate(DimensionalLumber lumber) {
        StringBuilder report = new StringBuilder();
        boolean isValid = true;

        // Check if the dimensions are negative, if so, return an error message
        if (lumber.getThickness() < 0 || lumber.getWidth() < 0 || lumber.getLength() < 0) {
            return "Negative dimensions entered, lumber cannot be verified.";
        }

        // Check if the thickness is within tolerance, if not, append to the report
        if (Math.abs(lumber.getThickness() - DimensionalLumber.EXPECTED_THICKNESS) > EPSILON) {
            report.append("Lumber dimensions are not within tolerance. Thickness exceeds tolerance of 0.03125. ");
            isValid = false;
        }

        // Check if the width is within tolerance, if not, append to the report
        if (Math.abs(lumber.getWidth() - DimensionalLumber.EXPECTED_WIDTH) > EPSILON) {
            report.append("Lumber dimensions are not within tolerance. Width exceeds tolerance of 0.03125. ");
            isValid = false;
        }

        // Check if the length is within tolerance, if not, append to the report
        if (Math.abs(lumber.getLength() - DimensionalLumber.EXPECTED_LENGTH) > EPSILON) {
            report.append("Lumber dimensions are not within tolerance. Length exceeds tolerance of 0.03125.");
            isValid = false;
        }

        // If the lumber is valid, return success message, else return report
        if (isValid) {
            return "The lumber meets tolerance standards of 0.03125 inches.";
        } else {
            return report.toString();
        }
    }
}

