package gradingTools;

import java.io.File;
import java.util.Map;

import gradingTools.sakai.gradebook.GradebookGradescopeConverter;

public class Comp524GradescopeToGradeBookFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
//	public static final String GRADES_FOLDER = "G:\\My Drive\\533\\grades\\";
	public static final String GRADES_FOLDER = Comp524GradeBookToGradesScopeFileGenerator.GRADES_DIR;
//
//	public static final String GRADESCOPE_FILE_NAME = "Comp524_F19_Midterm_scores.csv";
//	public static final String SAKAI_FILE_NAME = "Midterm_scores_F19_Sakai.csv";
//	public static final String GRADE_COLUMN_NAME = "Midterm";
	
	public static final String GRADESCOPE_FILE_NAME = "Comp524_F19_Final_scores.csv";
	public static final String SAKAI_FILE_NAME = "Final_scores_F19_Sakai.csv";
	public static final String GRADE_COLUMN_NAME = "Final";


	
	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu"
	};

	public static void main (String[] args) {
//		Map aMap = GradebookConverter.gradeBookToMap(new File("D:\\UNCGoogleDrive\\401-f15\\grades\\gradebook_export-F17 -Template.csv"));
		GradebookGradescopeConverter.gradescopeToGradebook(
				GRADES_FOLDER + GRADESCOPE_FILE_NAME, 
				GRADES_FOLDER + SAKAI_FILE_NAME,
				Comp524GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,
				onyensToEmail,
				GRADE_COLUMN_NAME);
		
	 
	}

}
