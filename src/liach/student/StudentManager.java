package liach.student;

import java.util.HashMap;

public final class StudentManager {
	private HashMap<String, Student> studentIdMap;
	
	private static final StudentManager INSTANCE = new StudentManager();
	
	private StudentManager() {
	}
	
	public static StudentManager instance() {
		return INSTANCE;
	}
	
	public boolean registerStudent(Student student) {
		if (studentIdMap.keySet().contains(student.number)) {
			return false;
		}
		return studentIdMap.put(student.number, student) != null;
	}
	
	public static boolean registerStudentStatic(Student student) {
		return instance().registerStudent(student);
	}
}
