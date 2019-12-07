package queue;

import java.util.PriorityQueue;

public class Queue_Demo {

	/**
	 * boolean offer(Object o)
	 * ==>to add an object into the queue.
	 * Object peek()
	 * ==>to return head element of the queue.If queue is empty then this method return null.
	 * Object element()
	 * ==>to return head element of the queue.If queue is empty then this method raises RE:NOSuchElementException
	 * Object poll()
	 * ==>to remove and return head element of the queue.If queue is empty then this method return null.
	 * Object remove()
	 * ==>to remove and return head element of the queue.If queue is empty then this method raises RE:NOSuchElementException
	 * constructer
	 * ============
	 * PriorityQueue q=new PriorityQueue();//11
	 * PriorityQueue q=new PriorityQueue(int initialcapacity);
	 * PriorityQueue q=new PriorityQueue(int initialcapacity,Comparator c);
	 * PriorityQueue q=new PriorityQueue(SortedSet s);
	 * PriorityQueue q=new PriorityQueue(Collection c);
	 * @param args
	 */
	public static void main(String[] args)
	{
		PriorityQueue q=new PriorityQueue();
//		System.out.println(q.peek());//null
//		System.out.println(q.element());//RE:NSEE
		
		for (int i = 0; i <=10; i++)
		{
			q.offer(i);
		}
		System.out.println(q);//[0,1,2....10]
		System.out.println(q.poll());//0
		System.out.println(q);//[1,2,3....10]
	}

}
