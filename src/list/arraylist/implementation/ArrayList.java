package list.arraylist.implementation;

public class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100];
	
	public boolean addFirst(Object element) {		
		return add(0, element);
	}
	
	public boolean addLast(Object element) {
		elementData[size] = element;		
		size++;
		return true;
	}
	
	public boolean add(int index, Object element) {
		System.out.println("너 뭐로전달도돼? " + index);
		for(int i = size-1; i>=index; i--) {
			elementData[i+1] = elementData[i];
		}
		elementData[index] = element;
		size++;
		return true;
	}
	
	@Override
	public String toString() {
		String str = "[";
		for(int i=0; i < size; i++) {
			str += elementData[i];
			if(i < size-1) { // 마지막 인덱스 다음엔 콤마를 붙이지 않겠다
				str += ", "; 	
			}
		}
		return str + "]";
	}
	
	public Object remove(int index) {
		Object removed = elementData[index]; // 삭제전에 리턴해주기 위해 임시저장하는 변수
		for(int i = index + 1; i <= size - 1; i++) {
			elementData[i-1] = elementData[i];
		}
		size--;
		elementData[size] = null;
		
		return removed; //삭제한 값을 리턴
	}
	
	public Object removeFirst() {
		return remove(0);
	}
	
	public Object removeLast() {
		return remove(size-1); 
	}
	
	public Object get(int index) {
		return elementData[index];
	}
	
	public int size() {
		return size;
	}
	
	public int indexOf(Object o) {
		for(int i = 0; i < size; i++) {
			if(o.equals(elementData[i])) {
				return i;
			}
		}			
		return -1; //없는 값일때 반환
	}
	
	public ListIterator listIterator() {
		return new ListIterator(); //새로운 ListIterator객체를 반환
	}
	
	class ListIterator{
		private int nextIndex = 0;
		
		public Object next() {
			/*
			Object returnData = elementData[nextIndex];
			nextIndex++;
			return returnData;
			*/
			System.out.println(nextIndex);
			return elementData[nextIndex++]; // 위코드와 동일한 코드
			
		}
		
		public boolean hasNext() {
			
			return nextIndex < size();
		}
		
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0; // 0과 같다면 --nextIndex일때 -1로 되서 outofIndex 에러뜸
		}
		
		public void add(Object element) {
			System.out.println(nextIndex);
			ArrayList.this.add(nextIndex++, element);
			System.out.println(nextIndex);
		}
		
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
		
	}
	

}
