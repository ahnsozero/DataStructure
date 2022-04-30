package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);		
		//numbers.add(1, 15);		
		//numbers.addFirst(5);		
		/*
		System.out.println(numbers.remove(1));
		System.out.println(numbers);
		numbers.removeFirst();
		System.out.println(numbers);
		numbers.removeLast();
		System.out.println(numbers);
		System.out.println(numbers.get(1));
		System.out.println(numbers.get(0));
		System.out.println(numbers.size());
		System.out.println(numbers.indexOf(70));
		
		for(int i=0; i<numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		*/
		
		// 데이터 타입
		ArrayList.ListIterator li = numbers.listIterator();
		//System.out.println(li.next());
		//System.out.println(li.next());
		//System.out.println(li.next());
		//System.out.println(li.next());// 가져올 값이 없기 때문에 null
	
		/*
		while(li.hasNext()) {
			System.out.println(li.next());
		}
		
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
		*/
		
		// 이거 모르겠다★ 
		while(li.hasNext()) {
			System.out.println("뭐야");
			int number = (int)li.next();			
			if(number == 20) {
				System.out.println("이해안가서 찍어봄");
				li.add(25);
			}
		}
		System.out.println(numbers);
		
		/*
		while(li.hasNext()) {
			int number = (int)li.next();
			if(number == 30) {
				li.remove();
			}
			System.out.println(number);
		}
		System.out.println(numbers);
		*/
	}
	

}
