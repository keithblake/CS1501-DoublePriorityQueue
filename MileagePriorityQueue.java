import java.util.HashMap;

public class MileagePriorityQueue {
	private int max;	//max number of items
	private int n;		//current number of items
	private Car[] arr;			//array containing heap
	private HashMap<String, Integer> indirection;

	public MileagePriorityQueue(int size) {
		max = size;
		n = 0;
		arr = new Car[max];
		indirection = new HashMap<String, Integer>();
	}

	public void add(Car car) {
		arr[n] = car;	//add new car to array
		indirection.put(car.getVin(), n);
		//need to potentially swim up object
		swim(n, car);
		n++;
	}

	public boolean remove(String vin) {
		int i = getIndexOf(vin);
		if (i == -1)
			return false;
		arr[i] = arr[n-1];
		indirection.put(arr[i].getVin(), i);
		n--;
		indirection.remove(vin);
		sink(i);
		return true;
	}

	public Car getMin() {		
		return arr[0];
	}

	public int getIndexOf(String vin) {
		Integer i = indirection.get(vin);
		if (i == null)
			return -1;
		else
			return indirection.get(vin);
	}

	public Car getCarAt(int index) {
		return arr[index];
	}

	public void updateCar(Car newCar, int index, int category) {
		arr[index] = newCar;
		//STILL NEED TO ACCOUNT FOR SINKING/SWIMMING AND UPDATING INDIRECTION
		if (category == 2) {	//may need to rearrange queue
			swim(index, newCar);
			sink(index);
		}
	}
	
	public Car lowestByMake(String make, String model) {
		int index = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i].getMake().equalsIgnoreCase(make) && arr[i].getModel().equalsIgnoreCase(model)) {
				if (index == -1)	//if first time
					index = i;
				else if (arr[i].getMileage() < arr[index].getMileage())
					index = i;	
			}
		}
		if (index == -1)
			return null;
		else
			return arr[index];
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.println("index: " + i + "\n" + arr[i].getMileage() + " ");
		}
		System.out.println("indirection: " + indirection);
	}

	private void swim(int index, Car newCar) {
		int currIndex = index;
		int parentIndex = (index-1)/2;
		while (arr[parentIndex].getMileage() > 1 && arr[parentIndex].getMileage() > arr[currIndex].getMileage()) {
			//swap positions
			Car tmp = arr[parentIndex];
			arr[parentIndex] = newCar;
			arr[currIndex] = tmp;
			//update indirection
			indirection.put(newCar.getVin(), parentIndex);
			indirection.put(tmp.getVin(), currIndex);
			//update cur/parent
			currIndex = parentIndex;
			parentIndex = currIndex/2;
		}
	}

	private void sink(int index) {
		// while child is > parent, swap them			
		while (2*index+2 < n && (arr[index].getMileage() > arr[2*index+1].getMileage() || 
				arr[index].getMileage() > arr[2*index+2].getMileage())) {
			if (arr[index].getMileage() > arr[2*index+1].getMileage()) {
				//swap them, update index
				Car tmp = arr[index];
				arr[index] = arr[2*index+1];
				indirection.put(arr[index].getVin(), index);
				arr[2*index+1] = tmp;
				indirection.put(arr[2*index+1].getVin(), 2*index+1);
				index = 2*index+1;
			} else if (arr[index].getMileage() > arr[2*index+2].getMileage()) {
				//swap them, update index
				Car tmp = arr[index];
				arr[index] = arr[2*index+2];
				indirection.put(arr[index].getVin(), index);
				arr[2*index+2] = tmp;
				indirection.put(arr[2*index+2].getVin(), 2*index+2);
				index = 2*index+2;
			}
		}
	}
	
}