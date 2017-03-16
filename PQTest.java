public class PQTest {
	public static void main(String[] args) {
		PricePriorityQueue priceTest = new PricePriorityQueue(60);
		MileagePriorityQueue mileageTest = new MileagePriorityQueue(60);
		Car car1 = new Car("aaaaa1", "ford", "fiesta", 2.01, 14555, "red");
		Car car2 =  new Car("aaaba2", "ford", "swagmobile", 33.14, 145, "blue");
		Car car3 =  new Car("aaabb3", "ford", "taurus", 12.67, 154, "blue");
		Car car4 = new Car("aaabc4", "ford", "dumpster", 5.99, 123, "brown");
		Car car5 = new Car("aaabc5", "ford", "dumpster", 59.99, 13, "brown");
		Car car6 = new Car("aaabc6", "ford", "dumpster", 69.99, 2375, "brown");
		Car car7 = new Car("aaabc7", "ford", "dumpster", 9.99, 87, "brown");
	
/*		
		priceTest.add(car1);
		priceTest.add(car2);
		priceTest.add(car3);
		priceTest.add(car4);
		priceTest.add(car5);
		priceTest.add(car6);
		priceTest.add(car7);
		priceTest.print();
		priceTest.remove("aaaaa1");
		priceTest.print();
		
		
		System.out.println("price test:");
		priceTest.print();
		
		mileageTest.add(car1);
		mileageTest.add(car2);
		mileageTest.add(car3);
		mileageTest.add(car4);
		mileageTest.add(car5);
		mileageTest.add(car6);
		mileageTest.add(car7);
		mileageTest.print();
		mileageTest.remove("aaabc588");
		mileageTest.print();
		System.exit(0);
		
		System.out.println("mileage test:");
		mileageTest.print();
		*/
		DPQ dpq = new DPQ(60);
		dpq.add(car1);
		dpq.add(car2);
		dpq.add(car3);
		dpq.add(car4);
		dpq.add(car5);
		dpq.add(car6);
		dpq.add(car7);
		
		dpq.print();
		dpq.update("aaaaa1", 1, "99.12");
		dpq.print();
		
	}
}