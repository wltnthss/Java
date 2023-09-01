# 자바 헷갈리는 개념 정리

<details>
<summary style="font-size:20px">추상 클래스</summary>
<div markdown="1">

#### 개요

* 상속까지는 언제 왜 어떻게 사용하는지 알음 -> 추상 클래스는 실제로 구현해본적이 없기에 왜 언제 어떻게 사용하는지 알아보기위함.

* 상속은 왜 사용할까?
  * 만들어져 있는 클래스를 재사용함(overriding)으로써 중복된 코드를 줄이고 간결해지며 공통적인 기능을 부모 클래스에 추가하면 자식 클래스에서 재사용이 가능함으로 확장성 또한 용이함 즉, 유지보수가 쉽고, 확장성이 용이하며 재사용이 가능하고 코드가 간결해짐.
* 상속은 언제 사용할까?
  * IS-A 관계
    * 상위 클레스에서 하위 클래스보다 일반적인 개념의 사용(ex Animal)
    * 하위 클래스에서 상위 클래스보다 구체적인 개념 사용(ex Dog bark, Eagle flying)
    * 높은 클래스간의 결합도 -> 복잡한 구조는 어울리지 않음.
  * HAS-A 관계
    * 클래스를 재활용하고 싶다해서 무조건 상속을 받지 않음.
    * (ex Student가 Subject를 포함)
    * 일반적인 구현 방법

#### 추상 클래스

* 상속받는 자식 클래스가 반드시 추상 메소드를 구현하도록 하기 위함.
  * 그래서 왜 추상 클래스를 사용할까? why?? 
  * 공통적인 부분은 만들어진 기능을 사용하고, 이를 받아 사용하는 쪽에서는 자신에게 필요한 부분만 재정의하여 사용함으로써 유지보수와 통일성을 유지하기위함.
  * **공통된 필드와 메서드를 통일할 목적**
  * ex) 10명의 개발자가 자동차를 상속받아 각자만의 실체클래스를 구현하는경우
  * 수만줄의 A자동차가 계약만료되고, B자동차를 새로 교체할 때 객체 인스턴스만 변경하면됨.

> 추상클래스 예시

![Alt text](image.png)

```java
package oop4;

public abstract class Computer {

	public abstract void display();
	public abstract void typing();
	
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
```

```java
package oop4;

public class Desktop extends Computer{

	@Override
	public void display() {
		System.out.println("PC 화면");
	}

	@Override
	public void typing() {
		System.out.println("PC 타이핑");
	}

	@Override
	public void turnOff() {
		System.out.println("PC 전원끄기");
	}
}

```

```java
package oop4;

public abstract class NoteBook extends Computer{

	@Override
	public void display() {
		System.out.println("노트북 화면");
	}
}
```

```java
package oop4;

public class MyNoteBook extends NoteBook{

	@Override
	public void typing() {
		System.out.println("MyNoteBook typing");
	}
}
```

```java
package oop4;

public class ComputerTest {

	public static void main(String[] args) {
		
		Computer computer = new Desktop(); 
		NoteBook book = new MyNoteBook();
		//Computer computer = new Computer(); 추상메서드이므로 new를 통한 객체 생성 불가.
		
		computer.display();
		book.display();
	}
}
```
* 추상클래스에서 상위클래스인 Computer class 생성.
* Desktop은 Computer를 상속받으며, display(), typing() 메소드를 오버라이딩 하고있으며 turnOff() 도 재정의해서 사용함.
* Notebook도 Computer를 상속받으며 추상클래스로서 Notebook 클래스를 생성함.
* MyNoteBook은 NoteBook을 상속받음.
* Main 메소드인 ComputerTest에서는 다형성을 사용하여 객체의 메소드 호출이 가능함.
* 단, 추상메소드는 new를 통한 객체 생성이 불가함.
* 
</div>
</details>

<details>
<summary style="font-size:20px">인터페이스</summary>
<div markdown="1">

#### 인터페이스

* 

</div>
</details>