package gradingTools;

public class Comp401GradesScopeFileGenerator {
	static String[] onyensToEmail = new String[] {
		"hollowaj:jonah_holloway@med.unc.edu",
		"ellenecs:ellenecs@email.unc.edu"
	};
	public static void main (String[] args) {
		GradeScopeFileGenerator.createAndWriteGeneratedFile("grades.csv", 
				onyensToEmail);
		
	 
	}

}
