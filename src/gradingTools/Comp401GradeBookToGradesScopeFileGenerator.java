package gradingTools;

import gradingTools.sakai.gradebook.GradebookGradescopeConverter;

public class Comp401GradeBookToGradesScopeFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
	public static final String GRADEBOOK_TEMPLATE_FILE_NAME = 
			"D:\\UNCGoogleDrive\\401-f15\\grades\\gradebook_export-F17 -Template.csv";
	static String[] onyensToEmail = new String[] {
		"whglaser:whglaser@ad.unc.edu"
	};
	public static void main (String[] args) {
		GradebookGradescopeConverter.gradebookToGradescope(
				GRADEBOOK_TEMPLATE_FILE_NAME, 
				"D:\\UNCGoogleDrive\\401-f15\\grades\\gradescope_import-F17.csv",				
				onyensToEmail);
		
	 
	}

}
