package array;

public class Array {
	
	/*
	 * 배열 : 여러 데이터를 하나의 이름으로 그룹핑해서 관리하기 위한 데이터 스트럭쳐
	 * index : 배열 전체 집단에서 식별자의 역할
	 * value : 인덱스에 저장된 값 그 자체
	 * element : index + value
	 * 
	 * 장점
	 * - 그룹핑되어 있는 데이터를 그룹으로 관리할 수 있다. (그룹에 해당되는 데이터들만)
	 * - 반복문(while, for, iterator)을 이용해 배열에 저장되어 있는 하나하나의 값을 꺼내 사용할 수 있다.
	 * - 크기가 정해져 있다./ 기능이 없다 => 작고 가볍고 단순하게 사용할떄 장점
	 * 
	 * 
	 * 단점
	 * - 크기가 정해져 있다.
	 * - 기능이 없다. 데이터를 추가하고 삭제하고 수정X
	 */
	
	// 배열안에 어떤 값이 들어갈지 모를때 (배열크기 4개짜리 선언)
	static int[] number = new int[4];
	
	// 이배열 안에 어떤값이 들어가는지 알떄
	int[] numbers2 = {10, 20, 30, 40};
	int[] numbers3 = new int[] {10,20,30,40};
	
	
	public static void main(String[] args) {
		System.out.println(number[3]); 
		// int형이라 초기값 셋팅되어 있지않으면 0, String이나 다른 참조형은 null로 셋팅
		
		System.out.println(number.length);
		
		int i = 0;
		while(number.length > i) {
			System.out.println(number[i]);
		}
		// while문의 단점 -- 반복문을 실행시키는 초기값설정;조건식;증감식이 떨어져 있어서 그 사이사이에 다른 코드가 끼어들어갈 수 가 있다.
		// 그사이에 수많은 버그를 발생시키는 코드가 포함될 가능성 높아짐. 반복문의 동작방법을 파악하는데 어렵.
		
		// 그걸 보완한게 for문		
		for(i=0; i < number.length ; i++) {
			System.out.println(number[i]);
		}
	}

}
