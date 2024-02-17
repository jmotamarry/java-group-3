import java.util.Arrays;

public class ProductSort 
{
	private int productID;
	private String productName;
	private double productRating;
	private double price;
	
	public ProductSort(int id, String name, double rating, double price)
	{
		this.productID = id;
		this.productName = name;
		this.productRating = rating;
		this.price = price;
	}
	
	public String getName()
	{
		return productName; 
	}
	
	public int getID()
	{
		return this.productID;
	}
	
	public double getRating()
	{
		return productRating; 
	}
	
	public double getPrice()
	{
		return price; 
	}
	
	
	// merge sort
	public static void sort(ProductSort[] productList, String sortType, String order)
	{
		if(sortType.equals("name"))
		{
			sortString(productList, sortType, order);
		}
		else {
			sortNotString(productList, sortType, order);
		}
	}
	
	//helper methods
	public static void sortString(ProductSort[] productList, String sortType, String order)
	{
		if(productList.length > 1)
		{
			ProductSort[] left = new ProductSort[productList.length/2];
			ProductSort[] right = new ProductSort[productList.length/2];
			
			left = Arrays.copyOfRange(productList, 0, productList.length/2);
			right = Arrays.copyOfRange(productList, productList.length/2, productList.length);
			
			sortString(left, sortType, order);
			sortString(right, sortType, order);
			
			int leftIndex = 0; 
			int rightIndex = 0;
			int index = 0;
						
			while (index < productList.length)
			{
				
				if(leftIndex >= left.length)
				{
					productList[index] = right[rightIndex];
					rightIndex++;
					index++;
				}
				else if(rightIndex >= right.length)
				{
					productList[index] = left[leftIndex];
					leftIndex++;
					index++;
				}
				
				else {
					String leftSide = left[leftIndex].getName().toLowerCase();
					String rightSide = right[rightIndex].getName().toLowerCase();
					
					if(order.equals("ascending"))
					{
						if (leftSide.compareTo(rightSide) >= 0)
						{
							productList[index] = right[rightIndex];
							rightIndex++;
							index++;
						}
						else if (leftSide.compareTo(rightSide) <= 0)
						{
							productList[index] = left[leftIndex];
							leftIndex++;
							index++;
						}
					}
					else 
					{
						if (leftSide.compareTo(rightSide) <= 0)
						{
							productList[index] = right[rightIndex];
							rightIndex++;
							index++;
						}
						else if (leftSide.compareTo(rightSide) >= 0)
						{
							productList[index] = left[leftIndex];
							leftIndex++;
							index++;
						}
					}
				}
			}
		}
		
	}
	
	
	
	public static void sortNotString(ProductSort[] productList, String sortType, String order)
	{
		if(productList.length > 1)
		{
			ProductSort[] left = new ProductSort[productList.length/2];
			ProductSort[] right = new ProductSort[productList.length/2];
			
			left = Arrays.copyOfRange(productList, 0, productList.length/2);
			right = Arrays.copyOfRange(productList, productList.length/2, productList.length);
			
			sortNotString(left, sortType, order);
			sortNotString(right, sortType, order);
			
			int leftIndex = 0; 
			int rightIndex = 0;
			int index = 0;
						
			while (index < productList.length)
			{
				
				if(leftIndex >= left.length)
				{
					productList[index] = right[rightIndex];
					rightIndex++;
					index++;
				}
				else if(rightIndex >= right.length)
				{
					productList[index] = left[leftIndex];
					leftIndex++;
					index++;
				}
				
				else {
					double leftSide = left[leftIndex].getPrice();
					double rightSide = right[rightIndex].getPrice();
					
					if(sortType.equals("rating"))
					{
						leftSide = left[leftIndex].getRating();
						rightSide = right[rightIndex].getRating();
					}
					
					if(order.equals("ascending"))
					{
						if (leftSide >= rightSide)
						{
							productList[index] = right[rightIndex];
							rightIndex++;
							index++;
						}
						else if (leftSide <= rightSide)
						{
							productList[index] = left[leftIndex];
							leftIndex++;
							index++;
						}
					}
					else 
					{
						if (leftSide <= rightSide)
						{
							productList[index] = right[rightIndex];
							rightIndex++;
							index++;
						}
						else if (leftSide >= rightSide)
						{
							productList[index] = left[leftIndex];
							leftIndex++;
							index++;
						}
					}
				}
			}
		}
		
	}
	
	
	public String toString()
	{
		String output = this.productName + " " + this.productRating + " $" + this.price;
		return output;
		
	}

}
