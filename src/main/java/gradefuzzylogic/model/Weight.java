package gradefuzzylogic.model;

public class Weight {
    private static double weight;  
    private static double[] points = {0, 40, 45, 50, 55, 60, 65, 80, 85};
    
    public static double isVerySkinny(){
        if (points[0] <= weight && weight <= points[1])
            return 1;
        else if (points[1] < weight && weight < points[2])
            return (points[2] - weight) / (points[2] - points[1]);
        else
            return 0;
    }
    
    public static double isSkinny(){
        if (points[2] <= weight && weight <= points[3])
            return 1;
        else if (points[1] < weight && weight < points[2])
            return (weight - points[1]) / (points[2] - points[1]);
        else if (points[3] < weight && weight < points[4])
            return (points[4] - weight) / (points[4] - points[3]);
        else
            return 0;
    }
    
    public static double isNormal(){
        if (points[4] <= weight && weight <= points[5])
            return 1;
        else if (points[3] < weight && weight < points[4])
            return (weight - points[3]) / (points[4] - points[3]);
        else if (points[5] < weight && weight < points[6])
            return (points[6] - weight) / (points[6] - points[5]);
        else
            return 0;
    }
    
    public static double isFat(){
        if (points[6] <= weight && weight <= points[7])
            return 1;
        else if (points[5] < weight && weight < points[6])
            return (weight - points[5]) / (points[6] - points[5]);
        else if (points[7] < weight && weight < points[8])
            return (points[8] - weight) / (points[8] - points[7]);
        else
            return 0;
    }
    
    public static double isVeryFat(){
        if (points[7] < weight && weight < points[8])
            return (weight - points[7]) / (points[8] - points[7]);
        else if (points[8] <= weight)
            return 1;
       else
            return 0;
    }

    public static double getWeight() {
        return weight;
    }

    public static void setWeight(double weight) {
        Weight.weight = weight;
    }
}
