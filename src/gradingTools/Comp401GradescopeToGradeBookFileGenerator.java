package gradingTools;

public class Comp401GradescopeToGradeBookFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
	static String[] onyensToEmail = new String[] {
		"whglaser:whglaser@ad.unc.edu"
	};

	public static void main (String[] args) {
		GradeScopeFileGenerator.gradescopeToGradeBook(
				"D:\\UNCGoogleDrive\\401-f15\\grades\\Midterm_scores_F17.csv", 
				"D:\\UNCGoogleDrive\\401-f15\\grades\\Midterm_scores_F17_Sakai.csv",
				onyensToEmail);
		
	 
	}

}
