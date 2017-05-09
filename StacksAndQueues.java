import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class StacksAndQueues{
	/**
	 * method mirImage
	 * appends a Stack in reverse order to the original Stack
	 * 
	 * @param Stack<Integer> toMirror a Stack to be mirrored
	 * @return Stack<Integer> stackCopy the mirrored Stack
	 * */
	static Stack<Integer> mirImage(Stack<Integer> toSwap){
		Queue<Integer> reverserQueue = new LinkedList<Integer>();//declare a queue for internal use only
		Stack<Integer> stackCopy = new Stack<Integer>();//instantiate a stack to make a copy
		//http://stackoverflow.com/questions/7919836/how-do-i-copy-a-stack-in-java
		/*Stack extends Vector, which has the method addAll(), so to make a unique copy
		 * of the stack, we use the addAll() method from Vector. Otherwise, the copy
		 * might end up pointing to the original object.*/
		stackCopy.addAll(toSwap);
		
		/*Stack's pop() method is destructive. This loop is the reason that a copy must be made*/
		while(!toSwap.isEmpty()){//loop through the stack
			reverserQueue.add(toSwap.pop());//add each element to the queue
			
		}
		while(!reverserQueue.isEmpty()){//loop through the queue
			stackCopy.push(reverserQueue.remove());//push all of the values onto the Stack copy
		}
		return stackCopy;//return the mirrored copy of the Stack
	}
	/**
	 * method moveToFront
	 * 
	 * moves an element to the front of a Queue while otherwise maintaining the order.
	 * @param Queue<Integer> q1 a Queue to be reordered
	 * @param int n an integer representing the element of the queue to be moved to the front
	 * @return Queue<Integer> q3 the reordered Queue
	 * */
	static Queue<Integer> moveToFront(Queue<Integer> q1, int n){
		Queue<Integer> q2 = new LinkedList<Integer>();//new Queue objects for shuffling
		Queue<Integer> q3 = new LinkedList<Integer>();
		if(n>q1.size()){//constrain n to be within the limits of the Queue
			n=q1.size();
		}else if(n<1){
			n=1;
		}
		for(int i=1;i<n;i++){//remove elements preceding n, place them in q2
			q2.add(q1.remove());
		}
		q3.add(q1.remove());//place n in q3
		//append elements in q2 to q3
		while(!q2.isEmpty()){
			q3.add(q2.remove());
		}
		//append elements in q1 to q3
		while(!q1.isEmpty()){
			q3.add(q1.remove());
		}
		return q3; //return reordered Queue	
	}
	public static void main(String[] args) {
		Queue<Integer> toReorder = new LinkedList<Integer>();
		toReorder.add(1);
		toReorder.add(2);
		toReorder.add(3);
		toReorder.add(4);
		toReorder.add(5);
		System.out.println(toReorder);
		toReorder = moveToFront(toReorder,3);
		System.out.println(toReorder);

//		Stack<Integer> gonnaSwap = new Stack<Integer>();
//		gonnaSwap.push(1);
//		gonnaSwap.push(2);
//		gonnaSwap.push(3);
//		gonnaSwap.push(4);
//		gonnaSwap.push(5);
//		System.out.println(gonnaSwap);
//		gonnaSwap = mirImage(gonnaSwap);
//		System.out.println(gonnaSwap);	
	}
}