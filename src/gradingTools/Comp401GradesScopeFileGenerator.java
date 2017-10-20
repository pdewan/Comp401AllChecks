package gradingTools;

public class Comp401GradesScopeFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
	static String[] onyensToEmail = new String[] {
		"whglaser:whglaser@ad.unc.edu"
	};
	public static void main (String[] args) {
		GradeScopeFileGenerator.createAndWriteGeneratedFile("grades.csv", 
				onyensToEmail);
		
	 
	}

}
