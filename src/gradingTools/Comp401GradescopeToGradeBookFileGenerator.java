package gradingTools;

import java.io.File;
import java.util.Map;

import gradingTools.gradebook.GradebookGradescopeConverter;

public class Comp401GradescopeToGradeBookFileGenerator {
//	static String[] onyensToEmail = new String[] {
//		"whglaser:whglaser@ad.unc.edu",
//		"ellenecs:ellenecs@email.unc.edu"
//	};
//	public static final String GRADES_FOLDER = "D:\\UNCGoogleDrive\\401-f15\\grades\\";

//	public static final String GRADESCOPE_FILE_NAME = "Final_scores.csv";
//	public static final String SAKAI_FILE_NAME = "Final_scores_F17_Sakai.csv";
//	public static final String GRADE_COLUMN_NAME = "Final";
//	public static final String GRADESCOPE_FILE_NAME = 
//			"Midterm_scores.csv";
//	public static final String GRADESCOPE_FULL_FILE_NAME = 
//			Comp401GradeBookToGradesScopeFileGenerator.GRADES_DIR +
//			GRADESCOPE_FILE_NAME;
//	public static String toSakaiFileName (String aGradescopeFileName) {
//		String [] aPrefixAndSuffix = aGradescopeFileName.split("\\.");
//		return aPrefixAndSuffix[0] + "_" + "Sakai" +aPrefixAndSuffix[1];
//	}
//	public static final String SAKAI_FILE_NAME = 
//			Comp401GradeBookToGradesScopeFileGenerator.GRADES_DIR +
//			"Midterm_scores_Sakai.csv";
//	public static final String GRADE_COLUMN_NAME = "Midterm";
//	public static final String GRADE_COLUMN_NAME = "Assignment 11";
//	public static final String GRADE_COLUMN_NAME = "Assignment 10";
//	public static final String GRADE_COLUMN_NAME = "Assignment 12";
	public static final String GRADE_COLUMN_NAME = "G_Final";
//	public static final String GRADE_COLUMN_NAME = "G_Midterm";
//	public static final String GRADE_COLUMN_NAME = "G_Assignment_4";
//	public static final String GRADE_COLUMN_NAME = "G_Assignment_4";

//	public static final String GRADE_COLUMN_NAME = "G_Assignment_2_1";





    public static final String gradeScopeFileName() {
    	 return Comp401GradeBookToGradesScopeFileGenerator.GRADES_DIR + GRADE_COLUMN_NAME +"_scores.csv";
    }
    public static final String sakaiFileName() {
   	 return Comp401GradeBookToGradesScopeFileGenerator.GRADES_DIR + GRADE_COLUMN_NAME + ".csv";
   }
	
//	static String[] onyensToEmail = new String[] {
////		"whglaser:whglaser@ad.unc.edu"
//	};
	public static final String[] ONYENS_AND_EMAILS = new String[] {
//			"whglaser:whglaser@ad.unc.edu"
				//Elad,Ohana,720387631,elad_ohana@med.unc.edu,COMP301.001.S121,,123.0,Missing

				"eohana:elad_ohana@med.unc.edu",
		};

	public static void main (String[] args) {
		
		GradebookGradescopeConverter.gradescopeToGradebook(
				gradeScopeFileName(),
				sakaiFileName(),
//				"D:\\UNCGoogleDrive\\401-f15\\grades\\Final_scores.csv", 
//				"D:\\UNCGoogleDrive\\401-f15\\grades\\Final_scores_F17_Sakai.csv",
				Comp401GradeBookToGradesScopeFileGenerator.GRADEBOOK_TEMPLATE_FILE_NAME,
				ONYENS_AND_EMAILS,
				GRADE_COLUMN_NAME
//				,true
				);
		
	 
	}

}
