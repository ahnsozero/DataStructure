package list.doublylinkedlist.implementation.copy;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		private Object data;
		private Node next; // 다음 노드의 
		private Node prev; // 이전 노드
		public Node(Object input) { // 노드가 처음 생성됐을때 값을 갖고 있어야함
			this.data = input;
			this.next = null;
			this.prev = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		
		if(head != null) { //만일 헤드에 어떤 노드도 참조하고 있지 않을 경우 에러방지 하기위한 if문
			head.prev = newNode;
		}
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;// 현재 마지막노드의 다음을 새로 생성한 노드를 가리키도록
			newNode.prev = tail;
			tail = newNode;
			size++;
		}
	}
	
	Node node(int index) { //외부에서의 접근막기위해  접근제하자 public X
		if(index < size/2) {
			Node x = head;
			for(int i=0; i < index; i++) {
				x = x.next;
			}
			return x;
		}else {
			Node x = tail; //만약 노드갯수/2 보다 큰 인덱스라면 끝에서부터 검색하는게 속도 더 빠름
			for(int i= size()-1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
	}
	
	public void add(int k, Object input) {
		if(k == 0) {
			addFirst(input);
		}else {
			Node temp1 = node(--k); //사이에 집어넣고싶은 이전의 노드
			Node temp2 = temp1.next; // 사이에 집어넣고 싶은 다음의 노드
			Node newNode = new Node(input); // 새 노드 생성
			temp1.next = newNode; // 이전 노드의 다음이 새로 생성된 노드
			newNode.next = temp2; // 새로 생성한 노드의 다음에 위에 답아놓은 다음의 노드 대입
			if(temp2 != null) { // 마지막에 노드 추가된다면 다음 노드가 null일 수도 있음
				temp2.prev = newNode;
			}
			newNode.prev = temp1;
			size++;
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	
	public String toString() {
		if(head == null) {// LinkedList의 출입문이 없다면
			return "[]";
		}else {
			Node temp = head; //LinkedList의 시작값 대입
			String str = "[";
			
			while(temp.next != null) {
				str += temp.data + ", ";
				temp = temp.next;
			}
			str += temp.data; //마지목 노드는 위의 while문에 실행하지 못하기때문에 수동으로 data값 넣어줘야한다.
			return str + "]";
		}
	}
	
	public Object removeFirst() {
		Node temp = head;
		head = head.next;
		Object returnData = temp.data; // 기존의 데이터 임시 저장
		temp = null;
		if(head != null) {
			head.prev = null;
		}
		size--;
		return returnData;
	}
	
	public Object remove(int k) {
		if(k == 0) {
			return removeFirst();
		}else {
			Node temp = node(k-1); //삭제하고자 하는 노드의 이전 노드 구하기
			Node todoDeleted = temp.next; /*node(k)*/ //삭제하고자하는 노드
			temp.next = temp.next.next;
			if(temp.next != null) {
				temp.next.prev = temp; 
			}
			Object returnData = todoDeleted.data;
			if(todoDeleted == tail) { //만약 삭제하려는 노드가 마지막 꼬리 노드라면
				tail = temp; // 마지막꼬리 노드는 삭제하려는 노드 이전 노드이다.
			}
			todoDeleted = null; //삭제하려는 노드 삭제
			size--; // 노드 사이즈 하나 감소
			return returnData;
		}
	}
	
	public Object removeLast() {		
		return remove(size-1);
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}
	
	public int indexOf(Object data) {
		Node temp = head;
		int index = 0;
		while(temp.data != data) { //찾고자 하는 데이터가 노드의 데이터에서 일치할때까지
			temp = temp.next;
			index++;
			if(temp == null) { // 마지막노드까지 도달했는데도 일치하는 데이터 없다면 -1을 반환
				return -1;
			}
		}
		return index;
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	public class ListIterator{
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		
		ListIterator(){
			next = head;
			nextIndex = 0;
		}
		
		public Object next() {
			lastReturned = next; //현재 노드
			next = next.next; //현재 노드의 다음 노드
			nextIndex++;
			return lastReturned.data;
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;
		}
		
		public Object previous() {
			if(next == null) {
				lastReturned = next = tail;
			}else {
				lastReturned = next = next.prev;
			}
			nextIndex--;
			return lastReturned.data;
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public void add(Object input) {
			Node newNode = new Node(input);
			
			if(lastReturned == null) {
				head = newNode;
				newNode.next = next; 			
			}else {				
				// 중간위치에 노드를 추가하는 코드
				lastReturned.next = newNode;
				newNode.prev = lastReturned;
				if(next != null) {
					newNode.next = next;
					next.prev = newNode;
				}else {
					tail = newNode;
				}
			}			
			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		
		public void remove() {
			if(nextIndex == 0) { //한번도 next() 노드를 호출하지 않은 상태
				throw new IllegalStateException(); // 예외발생 시키기
			}
			Node n = lastReturned.next;
			Node p = lastReturned.prev;
			
			if(p == null) { // 가장 앞에 있는 노드를 삭제할때
				head = n;
				head.prev = null;
				lastReturned = null;
			}else {
				p.next = next;
				lastReturned.prev = null;
			}
			
			if(n != null) { 
				n.prev = p;
			}else { // 가장 마지막에 있는 노드를 삭제할때
				tail = p;
				tail.next = null;
			}
			
			if(next == null) { // 중간에 있는 노드를 삭제할때
				lastReturned = tail;				
			}else {
				lastReturned = next.prev;
			}
			
			size--;
			nextIndex--;
		}
		
	}
	
	
	

}
