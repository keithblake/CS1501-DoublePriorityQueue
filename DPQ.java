public class DPQ {
	private PricePriorityQueue pricePQ;
	private MileagePriorityQueue milePQ;
	
	public DPQ(int size) {
		pricePQ = new PricePriorityQueue(size);
		milePQ = new MileagePriorityQueue(size);
	}
	
	public void add(Car car) {
		pricePQ.add(car);
		milePQ.add(car);
	}
	
	public void remove(String vin) {
		boolean result1 = pricePQ.remove(vin);
		boolean result2 = milePQ.remove(vin);
		if (result1 == false || result2 == false)
			System.out.println("Error: No car with that VIN has been added to the program.");
		else
			System.out.println("Vehicle removed.");
	}
	
	public Car getMinPrice() {
		return pricePQ.getMin();
	}
	
	public Car getMinMileage() {
		return milePQ.getMin();
	}
	
	public String getLowestPriceByMake(String make, String model) {
		Car c = pricePQ.lowestByMake(make, model);
		if (c == null) {
			return null;
		}
		return c.getVin();
	}
	
	public String getLowestMileageByMake(String make, String model) {
		Car c = milePQ.lowestByMake(make, model);
		if (c == null) {
			return null;
		}
		return c.getVin();
	}
	
	public void print() {
		System.out.println("price PQ: ");
		pricePQ.print();
		System.out.println("mileage PQ: ");
		milePQ.print();
	}
	
	public void update(String vin, int change, String value) {
		Car updatedCar;
		//get the two indices for the car
		int priceIndex = pricePQ.getIndexOf(vin);
		int mileIndex = milePQ.getIndexOf(vin);
		updatedCar = pricePQ.getCarAt(priceIndex);
		if (change == 1) {	//updating price
			updatedCar.setPrice(Double.parseDouble(value));
		} else if (change == 2) {	//updating mileage
			updatedCar.setMileage(Integer.parseInt(value));
		} else if (change == 3) {	//updating color
			updatedCar.setColor(value);
		}
		//insert updated car into the arrays
		pricePQ.updateCar(updatedCar, priceIndex, change);
		milePQ.updateCar(updatedCar, mileIndex, change);
		System.out.println("Vehicle updated.");
	}
}