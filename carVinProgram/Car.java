
public class Car {

/*
 *  Instance variables
 */
	    private double mileage;
	    private double price;
	    private String vin;
	    private int year;
/*
 * 
 */
	    public String getVin(){return vin;}
	     public void setVin ( String vin) {
	     this.vin = vin;
	         }

	     public double getMileage(){ return mileage;}
	     public void setMileage ( double mileage) {
	     	this.mileage = mileage;
	     	}
	     
	     public int getYear() {return year;}
	     public void setYear(int year) {
	         this.year = year;
	         }
	     
	     public double getPrice(){return price;}
	     public void setPrice ( double price) {
	     this.price = price;

	     }


	    public String toString() {
	        String output = "%s, %.1f (Km), %d, $%.2f";
	        return String.format(output, vin, mileage, year, price);
	    }
	}


