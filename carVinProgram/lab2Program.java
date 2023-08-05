import java.util.Scanner;
public class lab2Program {

public static void main(String[] args) {
        
		Scanner input = new Scanner (System.in);
        
		String vinInput; 
        double mileageInput;
        double priceInput;
        int year;
        String report;

        Car Car = new Car();

        System.out.print("please enter vehicle identification number:" );
        vinInput = input.nextLine(); 
        Car.setVin(vinInput); 
        
        System.out.print("please enter mileage(km): ");
        mileageInput = input.nextDouble(); 
        Car.setMileage(mileageInput);
        
        
        System.out.print("Please enter year: ");
        year = input.nextInt();
        Car.setYear(year);
       

        System.out.print("please enter invoice price: ");
        priceInput = input.nextDouble();
        Car.setPrice(priceInput);
        input.nextLine();
        
        
        report = Car.toString();
        System.out.println(report);
        
        System.out.print( "program by; Hamza El Sousi ");

}
}