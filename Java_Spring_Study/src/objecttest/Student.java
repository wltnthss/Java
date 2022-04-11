package objecttest;

/**
 * @author sonjisu
 * 
 * 문제점
 * getter, setter 자동완성을 하지 않고 타이핑할시에 헷갈렸던점
 * 
 * 해결방안
 * 자동완성을 하지 않고 흐름을 이해하며 손에 익을 때까지 타이핑
 */
public class Student {
	
	public String studentID;
	public String studentName;
	public String address;
	
	public void studentinfo() {
		System.out.println(studentID + "학번 학생의 이름은 " +studentName+ "이고 주소는 " + address + "입니다.");
	}
	
	public void setstudentName(String name) {
		studentName = name;
	}
	
	public String getstudentName() {
		return studentName;
	}
	
	public String getstudentTest() {
		return this.studentName;
	}
}
