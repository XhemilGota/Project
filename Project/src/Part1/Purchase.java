package Part1;

public class Purchase {

	private Key id_num;
	private int[] item_id_nums;
	private int[] item_quantities;
	private String means_of_payment;
	
	public Purchase(Key id, int[] it_id, int[] it_q, String m) 
	{
		id_num = id;
		item_id_nums = it_id;
		item_quantities = it_q;
		means_of_payment = m;
	}
	
	public Key getKey() {return id_num;}
	
	public int[] getItemIdNums() {return item_id_nums;}
	
	public int[] getItemQuantities() {return item_quantities;}
	
	public String getMeansOfPayment() {return means_of_payment;}
	
}
