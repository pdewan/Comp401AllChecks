package gradingTools;

import java.io.File;
import java.util.Map;

import gradingTools.sakai.gradebook.GradebookGradescopeConverter;

public class Comp401GradescopeToGradeBookFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
	public static final String GRADES_FOLDER = "D:\\UNCGoogleDrive\\401-f15\\grades\\";

	public static final String GRADESCOPE_FILE_NAME = "Final_scores.csv";
	public static final String SAKAI_FILE_NAME = "Final_scores_F17_Sakai.csv";
	public static final String GRADE_COLUMN_NAME = "Final";


	
	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu"
	};

	public static void main (String[] args) {
//		Map aMap = GradebookConverter.gradeBookToMap(new File("D:\\UNCGoogleDrive\\401-f15\\grades\\gradebook_export-F17 -Template.csv"));
		GradebookGradescopeConverter.gradescopeToGradebook(
				"D:\\UNCGoogleDrive\\401-f15\\grades\\Final_scores.csv", 
				"D:\\UNCGoogleDrive\\401-f15\\grades\\Final_scores_F17_Sakai.csv",
				Comp401GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,
				onyensToEmail,
				"Final");
		
	 
	}

}