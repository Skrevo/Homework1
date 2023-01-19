package main;

// The second variant

public class Main {
    public static void main(String[] args) {
        
        double y = Main.function(2);
        System.out.println(y);
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
}
