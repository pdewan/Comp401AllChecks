package gradingTools;

public class ExecuteHeadlessHardwired {
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-1";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-2";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-3";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 3";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 2";
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 0-4";
	static final String ASSIGNMENT_FOLDER = "D:\\Assignment1";
	static final String ASSIGNMENT = "Assignment1";

	
//	static final String STUDENT = "kakiryan";
//	static final String STUDENT = "justin2";
//	static final String STUDENT = "sdgeorge";
	static final String STUDENT = "acorrect";
	static final String COURSE = "Comp301SS24";




//	static final String[] MY_ARGS = {COURSE, ASSIGNMENT, STUDENT };

	public static void main(String[] args) {
//	static final String ASSIGNMENT = "C:\\Users\\dewan\\Downloads\\Comp524F20Assignments\\Assignment 1";

//	static final String STUDENT = "sdgeorge";
//	static final String STUDENT = "kakiryan";

//		TestForkHeadlessOneStudent.main(MY_ARGS);
//		HeadlessOneStudentComp524F20.main(MY_ARGS);
		RunHeadlessOneStudent.runHeadlessOneStudent(COURSE, ASSIGNMENT, ASSIGNMENT_FOLDER, STUDENT);

//		RunHeadlessOneStudent.main(MY_ARGS);
//		Tracer.setMaxTraces(maxPrints);

//	TestHeadlessOneStudent.main(MY_ARGS);
	}
}
