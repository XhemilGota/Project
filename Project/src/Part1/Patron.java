package Part1;

public class Patron {

	private Key id_number;
	private String name;
	private String address;
	private int[] loaned_books_catalog_numbers;
	private int number_of_loaned_books;
	private int max_num_of_loaned_books = 6;

	public Patron(Key id, String n, String a, int[] l)
	{
		id_number = id;
		name = n;
		address = a;
		
		loaned_books_catalog_numbers = new int[max_num_of_loaned_books];
		if(l.length > max_num_of_loaned_books)
		{
			int j = 0;
			for(int i = l.length - max_num_of_loaned_books; i < l.length; i++)
			{
				loaned_books_catalog_numbers[j] = l[i];
				j++;
			}
			number_of_loaned_books = max_num_of_loaned_books;
		}
		
		else
		{
			for(int i = 0; i < max_num_of_loaned_books; i++)
			{
				if(i < l.length)
				loaned_books_catalog_numbers[i] = l[i];
				
				else
					loaned_books_catalog_numbers[i] = -1;
			}
			number_of_loaned_books = l.length;
		}
	}
	
	public boolean borrowBook(int catalog_num)
	{
		boolean rez = true;
		
		for(int i = 0; i < loaned_books_catalog_numbers.length; i++)
		{
			if(loaned_books_catalog_numbers[i] == catalog_num)
			{
				System.out.println("You already have this book!");
				rez = false;
				break;
			}
		}
		
		if(rez && number_of_loaned_books < max_num_of_loaned_books)
		{
			int index = 0;
			for(int i = 0; i < max_num_of_loaned_books; i++)
			{
				if(loaned_books_catalog_numbers[i] == -1)
				{	
					index = i;
					break;
				}
			}
			loaned_books_catalog_numbers[index] = catalog_num;
			number_of_loaned_books++;
		}
		
		else if(number_of_loaned_books >= max_num_of_loaned_books)
		{
			System.out.println("You have borrowed max number of books allowed!");
			rez = false;
		}
			
		return rez;
	}
	
	public boolean returnBook(int catalog_num)
	{
		boolean rez = false;
		int index = -1;
		for(int i = 0; i < number_of_loaned_books; i++)
		{
			if(loaned_books_catalog_numbers[i] == catalog_num)
				index = i;
		}
		
		if(index == -1)
		{
			System.out.println("You have not borrowed this book!");
		}
		
		else
		{
			loaned_books_catalog_numbers[index] = -1;
			number_of_loaned_books--;
			rez = true;
		}
		
		return rez;
	}
	
	public Key getKey() {return id_number;}
	
	public String getName() {return name;}
	
	public String getAddress() {return address;}
	
	public int[] getLoanedBooksCatalogNums() {return loaned_books_catalog_numbers;}
	
	
}