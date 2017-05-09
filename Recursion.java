import java.util.*;


/**
 * class Recursion
 * contains recursive methods to demonstrate recursion concepts
 * 
 * @author John Voorhess
 * 
 * */

public class Recursion{
	public int x=0;
	public int z=0;
	public int min=0;
	
	public Recursion(){
		
	}
	/**
	 * recursionOne()
	 * 
	 * prints the sum of all integers up to n
	 * @param int n
	 * 
	 * */
	public void recursionOne(int n){
		x+=n;
		if(n<=0){
			//base case
			System.out.println(x);
		}else{
			//recursive case
			recursionOne(n-1);
			x+=n;
		}
	}
	/**
	 * recursionTwo()
	 * 
	 * prints the smallest element of an ArrayList of integers
	 * 
	 * @param ArrayList<Integer> list
	 * @param int size
	 * 
	 * */
	public void recursionTwo(ArrayList<Integer> list,int size){
		int y = size;
		
		if(y<=1){
			//base case
			System.out.println(min);
		}else{
			//recursive case
			if(list.get(y-2)<list.get(y-1)){
				min=list.get(y-2);
				System.out.println("recursive call: " + min);	
			}
			recursionTwo(list,y-1);
		}
	}
	/**
	 * recursionThree()
	 * 
	 * prints the sum of all elements of an ArrayList of integers
	 * 
	 * @param ArrayList<Integer> list
	 * @param int size
	 * 
	 * */
	public void recursionThree(ArrayList<Integer> list,int size){
		
		
		if(size<1){
			//base case
			System.out.println(z);
		}else{
			//recursive case
			z+=list.get(size-1);
			System.out.println("recursive call: " + z);	
			recursionThree(list,size-1);
			}
		
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> listForRecursion = new ArrayList<>(Arrays.asList(1,10,5,40,22,42,2,78));
		Recursion r = new Recursion();
		r.recursionOne(10);
		r.recursionTwo(listForRecursion, listForRecursion.size());
		r.recursionThree(listForRecursion, listForRecursion.size());
		
	}
}