import java.util.ArrayList;

//http://stackoverflow.com/questions/6324826/converting-arraylist-of-characters-to-a-string
//http://docs.oracle.com/javase/tutorial/java/data/buffers.html

/*This ended up being a very simple solution to what I thought was going 
 * to be a complicated problem that I found while searching how to convert 
 * a list object of characters or strings to a string. 
 * I have pasted reference URLs at the top. Java's StringBuilder is a method of java.lang.
 * whose method, append(), proved very useful in this instance.*/

/**
 * class GetString
 * 
 * contains methods to build strings from ArrayLists of characters and strings.
 * 
 * @author John Voorhess
 * 
 **/
class GetString{
	
		
		String getStringFromCharList(ArrayList<Character> list){    
		    StringBuilder builder = new StringBuilder(list.size());
		    for(Character ch: list)
		    {
		        builder.append(ch);
		    }
		    return builder.toString();
		}
		String getStringFromStringList(ArrayList<String> list){    
		    StringBuilder builder = new StringBuilder(list.size());
		    for(String ch: list)
		    {
		        builder.append(ch);
		    }
		    return builder.toString();
		}
	
}