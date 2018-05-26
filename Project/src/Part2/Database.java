package Part2;

public class Database {

	private User[] base;
	private int NOT_FOUND = -1;
	
	public Database() {base = new User[1000];}
	
	private int findLocation(Key k)
	  { int result = NOT_FOUND;
	    boolean found = false;
	    int i = 0;
	    while ( !found  &&  i != base.length )
	          { if ( base[i] != null  &&  base[i].getKey().equals(k) )
	                 { found = true;
	                   result = i;
	                 }
	            else { i = i + 1; }
	          }
	    return result;
	  }

	 
	  public User find(Key k)
	  { User answer = null;
	    int index = findLocation(k);
	    if ( index != NOT_FOUND )
	       { answer = base[index]; }
	    return answer;
	  }
	  
	  public boolean insert(User r)
	  { boolean success = false;
	    if ( findLocation(r.getKey()) == NOT_FOUND )  
	       {
	         boolean found_empty_place = false;
	         int i = 0;
	         while ( !found_empty_place  &&  i != base.length )
	        
	               { if ( base[i] == null ) 
	                      { found_empty_place = true; }
	                 else { i = i + 1; }
	               }
	         if ( found_empty_place )
	              { base[i] = r; }
	         else { 
	                User[] temp = new User[base.length * 2];
	                for ( int j = 0;  j != base.length;  j = j + 1 )
	                    { temp[j] = base[j]; } 
	                temp[base.length] = r;  
	                base = temp;  
	              }
	         success = true;
	       }
	    return success;
	  }

	  public boolean delete(Key k)
	  { boolean result = false;
	    int index = findLocation(k);
	    if ( index != NOT_FOUND )
	       { base[index] = null;
	         result = true;
	       }
	    return result;
	  }
	}

