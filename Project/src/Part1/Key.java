package Part1;

public class Key {

	private int k;
	
	public Key(int id)
	{
		k = id;
	}
	
	public boolean equals(Key a)
	{
		return (k == a.getInt());
	}
	
	private int getInt()
	{
		return k;
	}
	
}
