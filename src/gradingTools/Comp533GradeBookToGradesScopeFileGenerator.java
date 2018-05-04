package gradingTools;

import gradingTools.sakai.gradebook.GradebookGradescopeConverter;

public class Comp533GradeBookToGradesScopeFileGenerator {
	static String[] onyensToEmail = new String[] {
		
	};
	public static final String GRADEBOOK_TEMPLATE_FILE_NAME = 
			"D:\\UNCGoogleDrive\\533\\grades\\gradebook_export-template.csv";
	
	public static void main (String[] args) {
		GradebookGradescopeConverter.gradebookToGradescope(
				GRADEBOOK_TEMPLATE_FILE_NAME, 
				"D:\\UNCGoogleDrive\\533\\grades\\gradescope_import-S18.csv",				
				onyensToEmail);
		
	 
	}

}
