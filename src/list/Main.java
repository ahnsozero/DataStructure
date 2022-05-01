package list;

import list.arraylist.implementation.ArrayList;
import list.linkedlist.implementation.DoublyLinkedList;

public class Main {

	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.addLast(10);
		a.addLast(20);
		a.addLast(30);
		a.addFirst(5);		
		// 데이터를 중간에 추가하고 삭제함에 있어서 모두 자리를 옮겨야 하기 때문에 처리 속도가 오래 걸린다.
		a.get(2);
		// 내부적으로 배열을 기반으로 인덱스를 통해 다이렉트로 데이터에 접근을 하기 때문에 조회 속도가 빠르다.
		ArrayList.ListIterator ai = a.listIterator();		
		while(ai.hasNext()) {
			if((int)ai.next() == 20) {
				ai.add(25);
			}
		}
		
		
		DoublyLinkedList l = new DoublyLinkedList(); //단방향 리스트
		l.addLast(10);
		l.addLast(20);
		l.addLast(30);	
		a.addFirst(5);
		// 데이터를 중간에 추가하고 삭제함에 있어서 연결링크만 바꿔주면 되기 때문에 처리 속도가 빠르다.
		a.get(2);
		// 일일히 처음 head부터 순차적으로 데이터를 링크를 타고 조회해 오기 때문에 조회 속도가 느리다.
		DoublyLinkedList.ListIterator li = l.listIterator();
		while(li.hasNext()) {
			if((int)li.next() == 20) {
				li.add(25);
			}
		}
	}

}
