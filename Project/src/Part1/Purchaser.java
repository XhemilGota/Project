package Part1;

import java.time.LocalDate;
import java.time.Period;

public class Purchaser {

	private Key id_number;
	private String name;
	private String address;
	private int[] order_id_nums;
	private LocalDate[] purchase_dates;
	
	public Purchaser(Key id, String n, String a, int[] o, LocalDate[] p)
	{
		id_number = id;
		name = n;
		address = a;
		order_id_nums = o;
		purchase_dates = p;
	}
	
	public Key getKey() {return id_number;}
	
	public String getName() {return name;}
	
	public String getAddress() {return address;}
	
	public int[] getOrderIdNUms() {return order_id_nums;}
	
	public LocalDate[] getPurchaseHistory() 
	{
		LocalDate now = LocalDate.now();
		LocalDate[] temp = new LocalDate[purchase_dates.length];
		for(int i = 0; i < purchase_dates.length; i++)
		{
			Period p = Period.between(purchase_dates[i], now);
			if(p.getYears() < 1)
			{
				temp[i] = purchase_dates[i];
			}
		}
		
		return temp;
	}
}
