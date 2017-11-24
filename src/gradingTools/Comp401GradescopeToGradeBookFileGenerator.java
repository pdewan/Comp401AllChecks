package gradingTools;

import java.io.File;
import java.util.Map;

import gradingTools.sakai.gradebook.GradebookConverter;

public class Comp401GradescopeToGradeBookFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
	static String[] onyensToEmail = new String[] {
		"whglaser:whglaser@ad.unc.edu"
	};

	public static void main (String[] args) {
//		Map aMap = GradebookConverter.gradeBookToMap(new File("D:\\UNCGoogleDrive\\401-f15\\grades\\gradebook_export-F17 -Template.csv"));
		GradebookConverter.gradescopeToGradebook(
				"D:\\UNCGoogleDrive\\401-f15\\grades\\Midterm_scores_F17.csv", 
				"D:\\UNCGoogleDrive\\401-f15\\grades\\Midterm_scores_F17_Sakai_2.csv",
				Comp401GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,
				onyensToEmail);
		
	 
	}

}
