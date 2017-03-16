public class Car {
	private String vin;
	private String make;
	private String model;
	private double price;
	private int mileage;
	private String color;

	public Car() {
		vin = "";
		make = "";
		model = "";
		price = 0;
		mileage = 0;
		color = "";
	}
	
	public Car(String v, String ma, String mo, double p, int m, String c) {
		vin = v;
		make = ma;
		model = mo;
		price = p;
		mileage = m;
		color = c;
	}
	
	public void setVin(String v) {
		vin = v;
	}

	public String getVin() {
		return vin;
	}

	public void setMake(String m) {
		make = m;
	}

	public String getMake() {
		return make;
	}

	public void setModel(String m) {
		model = m;
	}

	public String getModel() {
		return model;
	}
	
	public void setPrice (double p) {
		price = p;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setMileage(int m) {
		mileage = m;
	}
	
	public int getMileage() {
		return mileage;
	}

	public void setColor(String c) {
		color = c;
	}
	
	public String getColor() {
		return color;
	}
	
	public String toString() {
		return "VIN: " + vin + "\nMake: " + make + "\nModel: " + model + "\nPrice: " + price +	
				"\nMileage: " + mileage + "\nColor: " + color;
	}
}



