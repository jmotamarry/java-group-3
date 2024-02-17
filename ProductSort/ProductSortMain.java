package ProductSort;
import java.util.*;
import java.lang.Math;

public class ProductSortMain {
	
	public static void main (String[] args)
	{
		
		ProductSort product1 = new ProductSort(10001, "iPhone", 4.5, 1500.78);
		ProductSort product2 = new ProductSort(12345, "iPad", 3.9, 1450.65);
		ProductSort product3 = new ProductSort(10724, "TV", 4.0, 3500.56);
		ProductSort product4 = new ProductSort(34782, "watch", 3.7, 700.01);
		ProductSort product5 = new ProductSort(98763, "mac", 4.8, 2000.54);
		ProductSort product6 = new ProductSort(45637, "pc", 3.8, 1500.99);
		ProductSort product7 = new ProductSort(60641, "table", 4.7, 500.65);
		ProductSort product8 = new ProductSort(10425, "chair", 3.5, 250.0);
		ProductSort product9 = new ProductSort(56223, "airpods", 4.5, 300.0);
		ProductSort product10 = new ProductSort(56224, "airpods", 4.5, 300.0);
		
		ProductSort[] productList = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
		
		/**
		ProductSort[] productList = new ProductSort[1000];

		for (int i = 0; i < 1000; i++) {
			int rand = (int) (Math.random() * 1000000);
			productList[i] = new ProductSort(rand, "iPhone", 4.5, 1500.78);
		}
		**/

		System.out.println(Arrays.toString(productList));
		
		double startTime = System.nanoTime();
		ProductSort.sort(productList, "rating", "descending");
		double endTime = System.nanoTime();
		
		System.out.println(Arrays.toString(productList));
		System.out.println("\nThe amount of time the algorithm took to run is: " + (endTime - startTime));
	}

}
