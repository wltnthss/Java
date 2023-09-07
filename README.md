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
  
</div>
</details>

<details>
<summary style="font-size:20px">인터페이스</summary>
<div markdown="1">

#### 개요

* 추상 클래스는 부모인 최상단 클래스에서 공통적인 기능을 구현함으로써 자식 클래스에서 오버라이딩하여 확장성 및 유지보수에 용이하도록 도와줌.
* 인터페이스는?? 다중 상속 기능 제공과 추상 클래스와 비슷한 역할을 한다는 것으로 알고있음.
* 추상클래스와 어떤 다른 점이 있고 어떤 상황에 쓰이는가?
  
#### 인터페이스

* 추상 클래스는 IS-A, 인터페이스는 HAS-A.
* 추상 클래스는 한 개의 클래스만 상속이 가능하고 자식 클래스에서 선택적으로 오버라이딩하여 사용할 수 있도록 하기위함.
* 인터페이스는 다중 상속이 가능하고 공통으로 필요한 기능들도 모든 클래스에서 오버라이딩하여 재정의 해야함.


> 인터페이스와 추상 클래스 예시

![Alt text](image-1.png)

```java
public abstract class Creature {
    private int x;
    private int y;
    private int age;
    
    public Creature(int x, int y, int age) {
        this.age = age;
        this.x = x;
        this.y = y;
    }
    
    public void age() {
        age++;
    }
    
    public void move(int xDistance) {
        x += xDistance;
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    public abstract void attack();
    public abstract void printInfo();
    
    @Override
    public String toString() {
        return "x : " + x + ", y : " + y + ", age : " + age;
    }
}
```
* 인간과 동물은 생명체를 상속.
* 각 생명체들은 구분에 따라서 인간과 동물을 상속, 할 수 있는 기능들을 인터페이스로 구현.
* 공통적으로 이동할 수 있는 기능인 move를 하위클래스에서 상속할 수 있도록 일반 메소드로 구현.
* attack, printInfo 는 각각 생명체에 따라 다른 기능으로 구현하기 때문에 추상메소드로 구현.

```java
public abstract class Animal extends Creature{
    
    public Animal(int x, int y, int age) {
        super(x, y, age);
    }
    
    @Override
    public void attack() {
        System.out.println("몸을 사용하여 공격!!");
    }
}
```

* 동물 클래스는 생명체이므로 Creature 추상클래스를 상속받음.
* 몸을 사용하여 공격하는 attack 메소드를 오버라이딩.
* **Q.조상클래스인 Creature 에서 지정한 printInfo 메소드는 왜 사용하지 않았을까?**
  * 동물클래스도 abstract 추상 클래스를 사용함으로써 앞으로의 생길 자식클래스에게 위임해서 사용하기 위함.

```java
public abstract class Human extends Creature implements Talkable{
    public Human(int x, int y, int age) {
        super(x, y, age);
    }
    
    @Override
    public void attack() {
        System.out.println("도구를 사용!!");
    }
    
    @Override
    public void talk() {
        System.out.println("사람은 말을 할 수 있다.");
    }
}
```

* Human 클래스도 Animal 클래스와 마찬가지로 추상 클래스로 구함.
* 하지만 여기서 Animal 클래스와 다르게 Talkable 인터페이스를 구현한 차이점이 있음.

```java
public interface Talkable {
    abstract void talk();
}
```

* 인터페이스는 이정표와 같은 것으로 정리해두자.
* Talable를 인터페이스를 구현할 경우 talk() 메소드를 오버라이딩하여 사용할 수 있음.

```java
public interface Flyable {
    void fly(int yDistance);
    void flyMove(int xDistance, int yDistance);
}
```

* 새 종류가 구현할 인터페이스 구현. 다른 동물들과는 다르게 y행으로 이동할 수 있는 메소드 선언함.

```java
public class Pigeon extends Animal implements Flyable{
    public Pigeon(int x, int y, int age) {
        super(x, y, age);
    }
    
    @Override
    public void fly(int yDistance) {
        setY(getY() + yDistance);
    }
    
    @Override
    public void flyMove(int xDistance, int yDistance) {
        setY(getY() + yDistance);
        setX(getX() + xDistance);
    }
    
    @Override
    public void printInfo() {
        System.out.println("Pigeon -> " + toString());
    }
}
```

* 비둘기는 동물 클래스를 상속받고 날 수 있는 동물이므로 Flyable 인터페이스를 구현함.
* 여기서 printInfo 는 조상 클래스인 Creature 클래스에서의 추상메소드를 오버라이딩하였음.

```java
public interface Swimable {
    void swimDown(int yDistance);
}
```

* **중요한 공통된 기능을 사용하는 인터페이스**
  * 거북이와, 케빈이라는 클래스를 작성할 때 두 생명체는 모두 수영을 할 수 있다고 정의함.
  * 하지만 동물이나 사람중에서도 수영을 못하는 경우도 있기에 swimDown 추성메소드가 아닌 Siwmable 인터페이스를 구현.
  * 각각 따로 정의하여 구현시킴으로써 가독성도 좋고 유지보수측면에서 좋음.

```java
public class Turtle extends Animal implements Swimable{
    public Turtle(int x, int y, int age) {
        super(x, y, age);
    }
    
    @Override
    public void swimDown(int yDistance) {
        setY(getY() - yDistance);
    }
    
    @Override
    public void printInfo() {
        System.out.println("Turtle -> " + toString());
    }
}

```

* 거북이 클래스에서는 Swimable 을 구현하고 swimDown 재정의하여 사용.

```java
public class Kevin extends Human implements Programmer, Swimable{
    public Kevin(int x, int y, int age) {
        super(x, y, age);
    }
    
    @Override
    public void coding() {
        System.out.println("Hello World!");
    }
    
    @Override
    public void swimDown(int yDistance) {
        setY(getY() - yDistance);
        if(getY() < -10) {
            System.out.println("너무 깊이 들어가면 죽을수도 있어!!");
        }
    }
    
    @Override
    public void printInfo() {
        System.out.println("Kevin -> " + toString());
    }
}

```

* Kevin은 다중구현을 통해서 수영도 할 수 있고, 코딩도 할 수 있는 사람

```java
public interface Programmer {
    void coding();
}
```

```java
public class Main {
    public static void main(String[] args) {
        Pigeon p = new Pigeon(5,10,14);
        p.printInfo();
        p.age();
        p.move(100);
        p.printInfo();
        p.fly(5);
        p.printInfo();
        p.flyMove(10, 20);
        p.printInfo();
        p.attack();
        System.out.println();
        
        Kevin kev = new Kevin(0, 0, 35);
        kev.printInfo();
        kev.age();
        kev.move(10);
        kev.printInfo();
        kev.attack();
        kev.coding();
        kev.swimDown(20);
        kev.printInfo();
        kev.talk();
        System.out.println();
        
        Turtle tur = new Turtle(100, -10, 95);
        tur.printInfo();
        tur.age();
        tur.move(-100);
        tur.printInfo();
        tur.attack();
        tur.swimDown(1000);
        tur.printInfo();
    }
}
```

* 메인메소드 구현.
 
#### 요약
> **추상 클래스 : 상속 관계를 타고 올라갔을 때 같은 조상클래스를 상속하는 똑같은 기능이 필요할 때!**	
> **인터페이스: 상속 관계를 타고 올라갔을 때 다른 조상클래스를 상속하는 기능이 필요할 때!**
 
</div>
</details>