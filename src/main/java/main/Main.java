package main;

// The second variant

public class Main {
    public static void main(String[] args) {
        
        double y = Main.function(2);
        System.out.println(y);
        int numberOfSteps = Main.countNumberOfSteps(0.8,2.0,0.005);
        System.out.println(numberOfSteps);
    }

    private static final double A = 1.5;
    public static double function(double x) {
        if (x < 1.7) {
            return Math.PI * Math.pow(x,2) - 7 / Math.pow(x,2) ;
        }
        if (x == 1.7) {
            return A * Math.pow(x,3) + 7 * Math.sqrt(x);
        }
        return Math.log10(x + 7 * Math.sqrt(x));    //if (x > 1.7)
    }

    public static int countNumberOfSteps(double borderDown, double borderUp, double delta) {

        double currentY = borderDown;
        int count = 0;
        while (currentY <= borderUp) {
            count++;
            currentY+= delta;
        }
        return count;
    }
}
