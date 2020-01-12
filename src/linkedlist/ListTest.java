package linkedlist;
public class ListTest {
	public static void main(String [] arg) {
		List<Integer> list = new List<Integer>();
		
		list.isEmpty();
		list.addFirst(12);
		list.addLast(22);
		list.addFirst(44);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getLength());
		System.out.println(list.toString());
		
		list.removeFirst();
		list.removeLast();
		System.out.println(list.toString());
	}
}
