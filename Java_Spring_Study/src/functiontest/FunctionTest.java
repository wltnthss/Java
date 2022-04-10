package functiontest;

/*
 * 함수 호출과 메모리
 * 스택 : 함수가 호출될 때 지역 변수들이 사용하는 메모리
 * add함수가 스택에 생성되고 사용한 메모리는 자동으로 제거됨(GC)
 * 
 * + 함수와 메서드의 차이는?!
 * 
 * - 이론 
 * 함수는 독립적으로 존재함, 즉 독립된 기능을 수행하는 단위임
 * 메소드는 클래스안에서 사용가능함, 즉 클래스에 대한 객체가 생성되어야 사용이 가능함
 * 
 * - 정리
 * 클래스 안에 있는 함수를 메소드라고 지칭함
 * 함수 <- 메소드
 * 자바에서는 함수로 표현하지않고 메소드라고 부름
 */
public class FunctionTest {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;

		System.out.println(addNum(n1, n2));
		sayHello("static은 프로그램 시작시 메모리 공간에 생성");
		calc();
	}

	
	public static int addNum(int n1, int n2) {
		int result;
		result = n1 + n2;
		return result;
	}

	public static void sayHello(String greeting) {
		System.out.println(greeting);
	}

	public static void calc() {
		int i;
		int total = 0;

		for (i = 0; i < 100; i++) {
			total += i;
		}

		System.out.println(total);
	}
}
