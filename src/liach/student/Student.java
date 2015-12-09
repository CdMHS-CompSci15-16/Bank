package liach.student;

import java.util.Random;

public class Student {
	
	public final String firstName;
	public final String lastName;
	public final String number;
	
	public Student() {
		this("", "");
	}
	
	public Student(String first, String last) {
		this(first, last, Long.toString(new Random().nextLong()));
	}

	public Student(String first, String last, String number) {
		this.firstName = first;
		this.lastName = last;
		this.number = number;
	}
}
