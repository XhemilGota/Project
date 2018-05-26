package Part2;

public class Key {

	private String k;
	
	public Key(String s)
	{
		k = s;
	}
	
	public boolean equals(Key i) 
	{
		return (k.equals(i.getString()));
	}
	
	public String getString() {return k;}
}
