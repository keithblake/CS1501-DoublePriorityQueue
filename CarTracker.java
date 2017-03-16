import java.util.Scanner;

public class CarTracker {
	private static DPQ priorityQueue;
	
	public static void main(String[] args) {
		//initialize priorityQueue
		priorityQueue = new DPQ(1000);
		Scanner keyboard = new Scanner(System.in);
		//initialize PQ & other shit here
		System.out.println("Welcome to CarTracker.\nTo exit, enter \"exit\".\nFor a list of commands"
				+ " enter \"help\".");
		while (keyboard.hasNextLine()) {
			String input = keyboard.nextLine();
			if (input.equalsIgnoreCase("exit")) {	//exit program
				System.exit(0);
			}		
			if (input.equalsIgnoreCase("help")) {	//print commands
				printOptions();
			} else {	//else do stuff
				int action = getAction(input);
				if (action == -1) {		//if invalid input
					System.out.println("Error: Unknown Command");
					continue;
				} else if (action == 0) {		//if adding a car
					add(keyboard);
				} else if (action == 1) {
					remove(keyboard);
				} else if (action == 2) {		//retrieve min price car
					System.out.println(priorityQueue.getMinPrice());
				} else if (action == 3) {		//retrieve min mileage car
					System.out.println(priorityQueue.getMinMileage());
				} else if (action == 4) {
					getLowestPriceByMake(keyboard);
				} else if (action == 5) {
					getLowestMileageByMake(keyboard);
				} else if (action == 6) {
					update(keyboard);
				} else if (action == 7) {
					priorityQueue.print();
				}
				
			}
		}
	}
	
	private static int getAction(String input) {
		if (input.equalsIgnoreCase("add")) {
			return 0;
		} else if (input.equalsIgnoreCase("remove")) {
			return 1;
		} else if (input.equalsIgnoreCase("lp")) {
			return 2;
		} else if (input.equalsIgnoreCase("lm")) {
			return 3;
		} else if (input.equalsIgnoreCase("lpm")) {
			return 4;
		} else if (input.equalsIgnoreCase("lmm")) {
			return 5;
		} else if (input.equalsIgnoreCase("update")) {
			return 6;
		} else if (input.equalsIgnoreCase("p")){
			return 7;
		} else {
			return -1;
		}
	}
	
	private static void printOptions() {
		System.out.println("To add a car, enter \"add\".\nTo update a car, enter \"update\"."
				+ "to remove a car, enter \"remove\".\nTo find the lowest priced car, enter"
				+ " \"lp\".\nTo find the lowest mileage car, enter \"lm\"."
				+ "\nTo find the lowest priced car by make and model, enter \"lpm\"."
				+ "\nTo find the lowest mileage car by make and model, enter \"lmm\".");
	}
	
	private static void add(Scanner keyboard) {
		Car car = new Car();
		System.out.println("Enter the VIN: ");
		car.setVin(keyboard.nextLine());
		System.out.println("Enter the make: ");
		car.setMake(keyboard.nextLine());
		System.out.println("Enter the model: ");
		car.setModel(keyboard.nextLine());
		System.out.println("Enter the price: ");
		car.setPrice(keyboard.nextDouble());
		System.out.println("Enter the Mileage: ");
		car.setMileage(keyboard.nextInt());
		keyboard.nextLine();
		System.out.println("Enter the color: ");
		car.setColor(keyboard.nextLine());
		//add this new car to the DPQ
		priorityQueue.add(car);
		System.out.println("Your entry has been added to the system.");
	}
	
	private static void remove(Scanner keyboard) {
		System.out.println("Enter the VIN of the vehicle you wish to remove: ");
		String vin = keyboard.nextLine();
		priorityQueue.remove(vin);
	}
	
	private static void update(Scanner keyboard) {
		System.out.println("Enter the VIN of the vehicle you wish to update: ");
		String vin = keyboard.nextLine();
		System.out.println("To update the price enter \"1\", for mileage \"2\", or for color \"3\".");
		int u = keyboard.nextInt();
		keyboard.nextLine();
		if (u == 1) {	//updating price
			System.out.println("Please enter the new price: ");
			String newPrice = keyboard.nextLine();
			priorityQueue.update(vin, 1, newPrice);
		} else if (u == 2) {	//updating mileage
			System.out.println("Please enter the new mileage: ");
			String newMileage = keyboard.nextLine();
			priorityQueue.update(vin, 2, newMileage);
		} else if (u == 3) {	//updating color
			System.out.println("Please enter the new color: ");
			String newColor = keyboard.nextLine();
			priorityQueue.update(vin, 3, newColor);
		} else {
			System.out.println("Error: Invalid input. Returning to main menu.");
		}
	}
	
	private static void getLowestPriceByMake(Scanner keyboard) {
		System.out.println("Please enter the make: ");
		String make = keyboard.nextLine();
		System.out.println("Please enter the model: ");
		String model = keyboard.nextLine();
		String vin = priorityQueue.getLowestPriceByMake(make, model);
		if (vin == null) {
			System.out.println("Error: The car has not been added to the program.");
		} else {
			System.out.println("The VIN of the car requested is " + vin + ".");
		}
	}
	
	private static void getLowestMileageByMake(Scanner keyboard) {
		System.out.println("Please enter the make: ");
		String make = keyboard.nextLine();
		System.out.println("Please enter the model: ");
		String model = keyboard.nextLine();
		String vin = priorityQueue.getLowestMileageByMake(make, model);
		if (vin == null) {
			System.out.println("Error: The car has not been added to the program.");
		} else {
			System.out.println("The VIN of the car requested is " + vin + ".");
		}
	}
	
	
}