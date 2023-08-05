/*Assessment: Lab Assignment 1
 *Student Name: Enter Hamza El Sousi
 *Lab Professor Name: Leanne Seaward
 *Lab Section Number: CST_8116_302
 *Due Date: June 9th, 2023
 */

/*
     * Constructs a Donut object with the specified outer and inner radii.
     * outerRadius the outer radius of the donut
     * innerRadius the inner radius of the donut
     */
public class Donut {
    private double outerRadius;
    private double innerRadius;

    public Donut(double outerRadius, double innerRadius) {
        this.outerRadius = outerRadius;
        this.innerRadius = innerRadius;
    }
// accessor and mutator for Radii
    public double getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(double outerRadius) {
        this.outerRadius = outerRadius;
    }

    public double getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }
// Computing Volume formula for a Donut
    public double computeDonutVolume() {
        double volume = (1.0 / 4.0) * Math.pow(Math.PI ,2) * ( Math.pow(outerRadius ,2)  -  Math.pow(innerRadius ,2) ) * (outerRadius - innerRadius);
        return volume;
    }}

   