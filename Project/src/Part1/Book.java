package Part1;

public class Book {
	
	private Key catalog_num;
	private String name;
	private String author;
	private int borrowed_by;
	private String due_date;
	private int times_borrowed;
	private boolean borrowed;
	
	public Book(Key id, String n, String a, int b, String d, int t)
	{
		catalog_num = id;
		name = n;
		author = a;
		borrowed_by = b;
		due_date = d;
		times_borrowed = t;
		borrowed = true;
	}
	
	public Book(Key id, String n, String a, String d, int t)
	{
		catalog_num = id;
		name = n;
		author = a;
		due_date = d;
		times_borrowed = t;
		borrowed = false;
	}
	
	public Key getKey() {return catalog_num;}
	
	public String getName() {return name;}
	
	public String getAuthor() {return author;}
	
	public int getBorrower() {return borrowed_by;}
	
	public String getDueDate() {return due_date;}
	
	public int timesBorrowed() {return times_borrowed;}
	
	public boolean isBorrowed() {return borrowed;}
	
	public Book borrow() 
	{
		borrowed = true;
		times_borrowed++;
		return this;
	}
	
	public void returnBook() 
	{
		borrowed = false;
	}

}
