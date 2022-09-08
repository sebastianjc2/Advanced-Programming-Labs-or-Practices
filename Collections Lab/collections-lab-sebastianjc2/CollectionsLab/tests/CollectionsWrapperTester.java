import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class CollectionsWrapperTester {

	@Test
	public void testBuyCar() {
		CollectionsWrapper.Car c1 = new CollectionsWrapper.Car("BMW", "M4", 2018, 70000),
		c2 = new CollectionsWrapper.Car("Toyota", "Corolla", 2016, 19600),
		c3 = new CollectionsWrapper.Car("Ford", "F-350", 2019, 35550),
		c4 = new CollectionsWrapper.Car("Nissan", "Maxima", 2020, 34999.99),
		c5 = new CollectionsWrapper.Car("Honda", "Accord", 2017, 30120.82),
		c6 = new CollectionsWrapper.Car("Honda", "Fit", 2015, 17995.29),
		c7 = new CollectionsWrapper.Car("Fiat", "500", 2016, 20745.93),
		c8 = new CollectionsWrapper.Car("Lincoln", "Navigator", 2020, 96000);
		
		CollectionsWrapper.Car[] A = {c1,c2,c3,c4,c5,c6,c7,c8},
		a1 = {c1,c2,c5,c8},
		a2 = {c1,c5,c6,c8},
		a3 = {c1,c3,c5,c7,c8},
		a4 = {c8,c5,c4,c3,c1},
		a5 = {c1,c8,c2,c7,c3,c6,c4,c5},
		a1A = {c2},
		a2A = {c6},
		a3A = {c3,c5,c7},
		a4A = {c5},
		a5A = {c2,c7,c6};


		int budget;
		assertArrayEquals("Failed with budget = " + (budget=20000), a1A, queueToArray(CollectionsWrapper.buyCar(arrayToQueue(a1), budget)));
		assertArrayEquals("Failed with budget = " + (budget=25000), a2A, queueToArray(CollectionsWrapper.buyCar(arrayToQueue(a2), budget)));
		assertArrayEquals("Failed with budget = " + (budget=28000),a1A, queueToArray(CollectionsWrapper.buyCar(arrayToQueue(a1), budget)));
		assertArrayEquals("Failed with budget >= " + (budget=96000), queueToArray(CollectionsWrapper.buyCar(arrayToQueue(a1), budget)), queueToArray(CollectionsWrapper.buyCar(arrayToQueue(a1), budget=100000)));
		assertArrayEquals("Failed with budget = " + (budget=45000), a3A, queueToArray(CollectionsWrapper.buyCar(arrayToQueue(a3), budget)));
		assertArrayEquals("Failed with budget = " + (budget=34995), a4A, queueToArray(CollectionsWrapper.buyCar(arrayToQueue(a4), budget)));
		assertArrayEquals("Failed with budget = " + (budget=29775), a5A, queueToArray(CollectionsWrapper.buyCar(arrayToQueue(a5), budget)));
		assertArrayEquals("Failed with budget = " + (budget=(int)Double.POSITIVE_INFINITY), A, queueToArray(CollectionsWrapper.buyCar(arrayToQueue(A), budget)));

	}

	@Test
	public void testCountNames() {

		String[] l = {"Dionel", "Fatima", "Joshua", "Ricardo", "Bienve", "Joshua", "Rey", "Andres"};
		String[] l2 = {"Rey", "Joshua", "Joshua", "Bienve", "Rey", "Andres", "Pedro"};
		String[] l3 = {"A", "Jose", "C", "Dionel", "Josian", "Rey", "Alejandra", "Fatima", "Alejandra"};

		ArrayList<String[]> list = new ArrayList<>();
		for (int i = 0; i < 3; list.add(l), list.add(l2), list.add(null), list.add(l3), list.add(new String[0]),i+=3,i-=Math.pow(1, -1));

		assertEquals("Incorrect result. Verify your implementation", 2, CollectionsWrapper.countName(list, "Jose"));
		assertEquals("Incorrect result. Verify your implementation", 2, CollectionsWrapper.countName(list, "Ricardo"));
		assertEquals("Incorrect result. Verify your implementation", 4, CollectionsWrapper.countName(list, "Andres"));
		assertEquals("Incorrect result. Verify your implementation", 0, CollectionsWrapper.countName(null, "Andres"));
		assertEquals("Incorrect result. Verify your implementation", 4, CollectionsWrapper.countName(list, "Fatima"));
		assertEquals("Incorrect result. Verify your implementation", 4, CollectionsWrapper.countName(list, "Alejandra"));
		assertEquals("Incorrect result. Verify your implementation", 8, CollectionsWrapper.countName(list, "Rey"));
		assertEquals("Incorrect result. Verify your implementation", 4, CollectionsWrapper.countName(list, "Dionel"));
		assertEquals("Incorrect result. Verify your implementation", 0, CollectionsWrapper.countName(list, null));

	}
	
	/* Methods for testers */
	
	@SuppressWarnings("unchecked")
	public <T> T[] queueToArray(Queue<T> arr){
		ArrayList<T> list = new ArrayList<T>();
		for (T e : arr) list.add(e);
		return (T[]) list.toArray(new Object[0]);
		
	}

	public <T> Queue<T> arrayToQueue(T[] arr){
		Queue<T> result = new LinkedList<>();
		for (int i = 0; i < arr.length;result.add(arr[i]), i++);
		return result;
	}

}
