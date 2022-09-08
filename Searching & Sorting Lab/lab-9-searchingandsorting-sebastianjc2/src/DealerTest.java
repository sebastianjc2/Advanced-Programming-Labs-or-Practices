import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;

public class DealerTest {

	Dealer.Car[] unsortedStock1 = {
            new Dealer.Car("Camry", 2010, "Toyota", 25000.00),
            new Dealer.Car("Corolla", 2005, "Toyota", 10000.00),
            new Dealer.Car("Murcielago", 2005, "Lamborghini", 70000.00),
            new Dealer.Car("WRX", 2005, "Subaru", 20500.00),
            new Dealer.Car("Model X", 2019, "Tesla", 45500.00),
            new Dealer.Car("Fiesta", 2010, "Ford", 19000.00),
            new Dealer.Car("Fusion", 2012, "Ford", 17900.00),
            new Dealer.Car("FRS", 2005, "Scion", 18000.00),
            new Dealer.Car("Lancer", 2009, "Mitsubishi", 20000.00),
            new Dealer.Car("Hellcat", 2018, "Dodge", 45000.00),
            new Dealer.Car("Charger", 1975, "Dodge", 100000.00),
            new Dealer.Car("GTR", 2000, "Nissan", 23000.00),
            new Dealer.Car("R-35", 2003, "Nissan", 30000.00),
            new Dealer.Car("Challenger", 1975, "Dodge", 120000.00),
            new Dealer.Car("Supra", 1998, "Toyota", 30000.00)
    };
	
	@Test 
    public void testQuickSort() {
        Dealer.Car[] toBeSortedStock1 = Dealer.copyOf(unsortedStock1);
        Comparator<Dealer.Car> comp = new Dealer.CarComparator();
        long st = System.nanoTime();
        Dealer.quickSort(comp, toBeSortedStock1);
        long et = System.nanoTime();
//        System.out.println("Quick Sort Time: " + (et-st) + " nanoseconds.");
        assertEquals("These should be the same size", unsortedStock1.length, toBeSortedStock1.length);
//        for(int i = 1; i < toBeSortedStock1.length; i++) { 
//            System.out.println(toBeSortedStock1[i].toString());
//        }
        for(int i = 1; i < toBeSortedStock1.length; i++) { 
            assertTrue("These should be in ascending order.", 
                    comp.compare(toBeSortedStock1[i-1], toBeSortedStock1[i]) < 0);
        }
    }
	
    @Test
    public void testComparator() {
    	Comparator<Dealer.Car> comp = new Dealer.CarComparator();
    	Dealer.Car car1 = new Dealer.Car("Camry", 2010, "Toyota", 25000.00);
    	Dealer.Car car2 = new Dealer.Car("Camry", 2010, "Toyota", 25000.00);
    	Dealer.Car car3 = new Dealer.Car("Lancer", 2009, "Mitsubishi", 20000.00);
    	Dealer.Car car4 = new Dealer.Car("Corolla", 2005, "Toyota", 10000.00);
    	Dealer.Car car5 = new Dealer.Car("Fusion", 2012, "Ford", 17900.00);
    	Dealer.Car car6 = new Dealer.Car("Supra", 1998, "Toyota", 30000.00);

    	assertTrue("Incorrect: Car is not equal to itself.", 0 == comp.compare(car1, car1));
    	assertTrue("Incorrect: Car is not equal to copy.", 0 == comp.compare(car1, car2));
    	assertTrue("Incorrect: Returned a positive value.", 0 > comp.compare(car1, car3));
    	assertTrue("Incorrect: Returned a negative value.", 0 < comp.compare(car3, car4));
    	assertTrue("Incorrect: Returned a negative value.", 0 < comp.compare(car6, car5));
    	assertTrue("Incorrect: Returned a positive value.", 0 > comp.compare(car3, car6));

    }
    
    @Test 
    public void testMergeSort() {
        Dealer.Car[] toBeSortedStock1 = Dealer.copyOf(unsortedStock1);
        Comparator<Dealer.Car> comp = new Dealer.CarComparator();
        long st = System.nanoTime();
        Dealer.mergeSort(comp, toBeSortedStock1);
        long et = System.nanoTime();
//        System.out.println("Merge Sort Time: " + (et-st) + " nanoseconds.");
        assertEquals("These should be the same size", unsortedStock1.length, toBeSortedStock1.length);
//        for(int i = 1; i < toBeSortedStock1.length; i++) { 
//            System.out.println(toBeSortedStock1[i].toString());
//        }
        for(int i = 1; i < toBeSortedStock1.length; i++) { 
            assertTrue("These should be in ascending order.", 
                    comp.compare(toBeSortedStock1[i-1], toBeSortedStock1[i]) < 0);
        }
    }

}
