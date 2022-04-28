package list;

import java.util.ArrayList;
import java.util.Iterator;

public class List {
	/*
	 * 배열에서는 index 유일무이한 식별자
	 * 리스트에서는 index는 몇번째 데이터인가 정도의 의미
	 * 
	 * C언어는 리스트 지원 안함, 따라서 직접 만들거나 다른 사람이 만들어 놓은 라이브러리 가져다 써야함
	 * 최근의 언어인 자바스크립트, 파이썬은 리스트를 기본적으로 지원한다.
	 * 자바만이 배열/리스트 모두 지원
	 */
	
	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		
		System.out.println("\nadd(인덱스, 값)");
		
		Iterator <Integer> it = numbers.iterator();
		while(it.hasNext()) {
			int value = it.next();
			if(value == 30) {
				it.remove();
			}
			System.out.println(value);
		}
		System.out.println(numbers);
		
		//향상된 for문
		for(int value : numbers) {
			System.out.println(value);
		}
	}

}
