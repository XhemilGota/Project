package Part1;

public class Inventory {

	private Key id_num;
	private String name_of_item;
	private double wholesale_price;
	private double retail_price;
	private int quantity_in_stock;
	
	public Inventory(Key id, String n, double w, double r, int q)
	{
		id_num = id;
		name_of_item = n;
		wholesale_price = w;
		retail_price = r;
		quantity_in_stock = q;
	}
	
	public Key getKey() {return id_num;}
	
	public String getNameOfItem() {return name_of_item;}
	
	public double getWholesalePrice() {return wholesale_price;}
	
	public double getRetailPrice() {return retail_price;}
	
	public int getQuantityInStock() {return quantity_in_stock;}
}
