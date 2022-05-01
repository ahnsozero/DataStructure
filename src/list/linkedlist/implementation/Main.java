package list.linkedlist.implementation;

public class Main {

	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		//numbers.addFirst(30);
		//numbers.addFirst(20);
		//numbers.addFirst(10);
		
		numbers.addLast(10);		
		numbers.addLast(20);
		numbers.addLast(30);
		//numbers.addFirst(5);
		//numbers.add(1, 15);		
		//numbers.add(2, 25);
		//System.out.println(numbers.removeFirst());	
		//System.out.println(numbers.remove(4));
		//System.out.println(numbers.removeLast());
		//System.out.println(numbers.get(2));
		//System.out.println(numbers.indexOf(35));
		System.out.println(numbers);
		LinkedList.ListIterator i = numbers.listIterator();
		/*
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		*/
		/*
		i.add(5);
		i.next();
		i.add(15);
		System.out.println(numbers);
		*/
		while(i.hasNext()){
			if((int)i.next() == 20) {
				i.remove();// 이것은 비효율적인 방법; 이미 위에서 노드 찾았는데 삭제하려고 처음 노드부터 다시 뒤져서 찾는 로직
							// 이래서 양방향 자료 구조임 더블 링크드 리스트 중요
			}
		}
		System.out.println(numbers);
	}

}
