package gradingTools;

import gradingTools.sakai.gradebook.GradebookGradescopeConverter;

public class Comp401GradeBookToGradesScopeFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
	public static final String GRADEBOOK_TEMPLATE_FILE_NAME = 
			"G:\\My Drive\\401-f15\\grades\\f18\\gradebook_export_template.csv";
	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu"
	};
	public static void main (String[] args) {
		GradebookGradescopeConverter.gradebookToGradescope(
				GRADEBOOK_TEMPLATE_FILE_NAME, 
				"G:\\My Drive\\401-f15\\grades\\f18\\gradescope_import.csv",				
				onyensToEmail);
		
	 
	}

}
