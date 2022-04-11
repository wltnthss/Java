package objecttest;

public class StudentTest {

	public static void main(String[] args) {
		Student student = new Student();
		
		student.studentID = "123";
		student.setstudentName("Son");
		student.address = "서울";
		
		student.studentinfo();
		
		System.out.println(student.getstudentName());
		System.out.println(student.getstudentTest());
		
	}
	
}
