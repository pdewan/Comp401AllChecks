package gradingTools;

public class Comp401GradeBookToGradesScopeFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
	static String[] onyensToEmail = new String[] {
		"whglaser:whglaser@ad.unc.edu"
	};
	public static void main (String[] args) {
		GradeScopeFileGenerator.gradeBookToGradescope(
				"D:\\UNCGoogleDrive\\401-f15\\grades\\gradebook_export-F17 -Template.csv", 
				"D:\\UNCGoogleDrive\\401-f15\\grades\\gradescope_import-F17.csv",
				onyensToEmail);
		
	 
	}

}
