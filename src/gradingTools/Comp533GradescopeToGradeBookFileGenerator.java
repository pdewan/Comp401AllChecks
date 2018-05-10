package gradingTools;

import java.io.File;
import java.util.Map;

import gradingTools.sakai.gradebook.GradebookGradescopeConverter;

public class Comp533GradescopeToGradeBookFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
	public static final String GRADES_FOLDER = "G:\\My Drive\\533\\grades\\";

	public static final String GRADESCOPE_FILE_NAME = "Comp533_S18_Midterm_scores.csv";
	public static final String SAKAI_FILE_NAME = "Midterm_scores_S18_Sakai.csv";
	public static final String GRADE_COLUMN_NAME = "Midterm";


	
	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu"
	};

	public static void main (String[] args) {
//		Map aMap = GradebookConverter.gradeBookToMap(new File("D:\\UNCGoogleDrive\\401-f15\\grades\\gradebook_export-F17 -Template.csv"));
		GradebookGradescopeConverter.gradescopeToGradebook(
				GRADES_FOLDER + GRADESCOPE_FILE_NAME, 
				GRADES_FOLDER + SAKAI_FILE_NAME,
				Comp533GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,
				onyensToEmail,
				GRADE_COLUMN_NAME);
		
	 
	}

}
