package gradefuzzylogic.model;

public class Height {
    private static double height;  
    private static double[] points = {0, 115, 120, 140, 145, 160, 165, 180, 185};
    
    public static double isVeryShort(){
        if (points[0] <= height && height <= points[1])
            return 1;
        else if (points[1] < height && height < points[2])
            return (points[2] - height) / (points[2] - points[1]);
        else
            return 0;
    }
    
    public static double isShort(){
        if (points[2] <= height && height <= points[3])
            return 1;
        else if (points[1] < height && height < points[2])
            return (height - points[1]) / (points[2] - points[1]);
        else if (points[3] < height && height < points[4])
            return (points[4] - height) / (points[4] - points[3]);
        else
            return 0;
    }
    
    public static double isMedium(){
        if (points[4] <= height && height <= points[5])
            return 1;
        else if (points[3] < height && height < points[4])
            return (height - points[3]) / (points[4] - points[3]);
        else if (points[5] < height && height < points[6])
            return (points[6] - height) / (points[6] - points[5]);
        else
            return 0;
    }
    
    public static double isTall(){
        if (points[6] <= height && height <= points[7])
            return 1;
        else if (points[5] < height && height < points[6])
            return (height - points[5]) / (points[6] - points[5]);
        else if (points[7] < height && height < points[8])
            return (points[8] - height) / (points[8] - points[7]);
        else
            return 0;
    }
    
    public static double isVeryTall(){
        if (points[7] < height && height < points[8])
            return (height - points[7]) / (points[8] - points[7]);
        else if (points[8] <= height)
            return 1;
       else
            return 0;
    }

    public static double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        Height.height = height;
    }
}
