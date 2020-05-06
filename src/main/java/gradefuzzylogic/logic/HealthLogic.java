package gradefuzzylogic.logic;

import gradefuzzylogic.model.*;
import java.text.DecimalFormat;

public class HealthLogic {
    private static double[][] healthIndex = new double[5][5];
    private static double[] points = {0.2, 0.4, 0.6, 0.8};
    private static String[] healthPoints = {"Not Healthy",
                                            "Quite Healthy",
                                            "Healthy",
                                            "Very Healthy"};
    private static int[][] health = {{3, 2, 1, 0, 0},
                                     {2, 3, 2, 1, 0},
                                     {1, 3, 3, 1, 0},
                                     {0, 2, 3, 2, 0},
                                     {0, 1, 3, 2, 1}};

    public HealthLogic(double height, double weight) {
        Height.setHeight(height);
        Weight.setWeight(weight);
        calculateGradeIndex();
    }
    
    public static String[] maxMethod() {
        int iMax = 0, jMax = 0;
        double max = 0;
        String[] result = new String[2];
        
        for (int i = 0; i < healthIndex.length; i++) {
            for (int j = 0; j < healthIndex[i].length; j++) {
                if (healthIndex[i][j] >= max) {
                    max = healthIndex[i][j];
                    iMax = i;
                    jMax = j;
                }
            }
        }
        
        result[0] = getDecimalFormat(max);
        result[1] = healthPoints[health[iMax][jMax]];
        return result;
    }
    
    public static String[] sugenoMethod() {
        double crispDecision, cardinal = 0, ordinal = 0;
        String[] result = new String[2];
        
        for (int i = 0; i < healthIndex.length; i++) {
            for (int j = 0; j < healthIndex[i].length; j++) {
                if (healthIndex[i][j] != 0) {
                    cardinal += healthIndex[i][j] * points[health[i][j]];
                    ordinal += healthIndex[i][j];
                }
            }
        }
        
        crispDecision = cardinal / ordinal;
        result[0] = getDecimalFormat(crispDecision);
        result[1] = getFuzzy(crispDecision);
        
        return result;
    }
    
    public static String getFuzzy(double crisp) {
        String fuzzy = "";
        
        for (int i = 0; i < points.length; i++) {
            if (crisp <= points[0]) {
                fuzzy += healthPoints[0];
                break;
            } else if (crisp == points[i]) {
                fuzzy += healthPoints[i];
                break;
            } else if (i < points.length - 1 && points[i] < crisp && crisp < points[i + 1]) {
                fuzzy += String.valueOf(getBelowFuzzy(crisp, i, i + 1));
                fuzzy += "% " + healthPoints[i] + " & ";
                fuzzy += String.valueOf(getAboveFuzzy(crisp, i, i + 1));
                fuzzy += "% " + healthPoints[i + 1];
                break;
            }
        }
        
        return fuzzy;
    }
    
    public static String getBelowFuzzy(double crisp, int idx1, int idx2) {
        return getDecimalFormat((points[idx2] - crisp) / (points[idx2] - points[idx1]) * 100);
    }
    
    public static String getAboveFuzzy(double crisp, int idx1, int idx2) {
        return getDecimalFormat((crisp - points[idx1]) / (points[idx2] - points[idx1]) * 100);
    }
    
    public static void calculateGradeIndex(){
        healthIndex[0][0] = Math.min(Height.isVeryShort(), Weight.isVerySkinny());
        healthIndex[0][1] = Math.min(Height.isVeryShort(), Weight.isSkinny());
        healthIndex[0][2] = Math.min(Height.isVeryShort(), Weight.isNormal());
        healthIndex[0][3] = Math.min(Height.isVeryShort(), Weight.isFat());
        healthIndex[0][4] = Math.min(Height.isVeryShort(), Weight.isVeryFat());
        
        healthIndex[1][0] = Math.min(Height.isShort(), Weight.isVerySkinny());
        healthIndex[1][1] = Math.min(Height.isShort(), Weight.isSkinny());
        healthIndex[1][2] = Math.min(Height.isShort(), Weight.isNormal());
        healthIndex[1][3] = Math.min(Height.isShort(), Weight.isFat());
        healthIndex[1][4] = Math.min(Height.isShort(), Weight.isVeryFat());
        
        healthIndex[2][0] = Math.min(Height.isMedium(), Weight.isVerySkinny());
        healthIndex[2][1] = Math.min(Height.isMedium(), Weight.isSkinny());
        healthIndex[2][2] = Math.min(Height.isMedium(), Weight.isNormal());
        healthIndex[2][3] = Math.min(Height.isMedium(), Weight.isFat());
        healthIndex[2][4] = Math.min(Height.isMedium(), Weight.isVeryFat());
        
        healthIndex[3][0] = Math.min(Height.isTall(), Weight.isVerySkinny());
        healthIndex[3][1] = Math.min(Height.isTall(), Weight.isSkinny());
        healthIndex[3][2] = Math.min(Height.isTall(), Weight.isNormal());
        healthIndex[3][3] = Math.min(Height.isTall(), Weight.isFat());
        healthIndex[3][4] = Math.min(Height.isTall(), Weight.isVeryFat());
        
        healthIndex[4][0] = Math.min(Height.isVeryTall(), Weight.isVerySkinny());
        healthIndex[4][1] = Math.min(Height.isVeryTall(), Weight.isSkinny());
        healthIndex[4][2] = Math.min(Height.isVeryTall(), Weight.isNormal());
        healthIndex[4][3] = Math.min(Height.isVeryTall(), Weight.isFat());
        healthIndex[4][4] = Math.min(Height.isVeryTall(), Weight.isVeryFat());
    }
    
    public static String getDecimalFormat(double number) {
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(number);
    }
}
