package main;

// The second variant

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        double y = Main.function(2);
        System.out.println("y = " + y);
        int numberOfSteps = Main.countNumberOfSteps();
        System.out.println("Number of steps: " + numberOfSteps);
        double[] arrayOfX = Main.createArrayOfX();
        System.out.println("Array of X: " + Arrays.toString(arrayOfX));
        double[] arrayOfY = Main.createArrayOfY();
        System.out.println("Array of Y:" + Arrays.toString(arrayOfY));
        System.out.println("Index of max Y: " + Main.indexOfMaxY());
        System.out.println("Index of min Y: " + Main.indexOfMinY());
        System.out.println("Sum of Y: " + Main.sumOfY());
        System.out.println("Average of Y: " + Main.averageOfY());
    }

    private static final double A = 1.5;
    private static final double BORDER1 = 0.8;
    private static final double BORDER2 = 2;
    private static final double DELTA = 0.005;
    public static double function(double x) {
        if (x < 1.7) {
            return Math.PI * Math.pow(x,2) - 7 / Math.pow(x,2) ;
        }
        if (x == 1.7) {
            return A * Math.pow(x,3) + 7 * Math.sqrt(x);
        }
        return Math.log10(x + 7 * Math.sqrt(x));    //if (x > 1.7)
    }

    public static int countNumberOfSteps() {

        double currentY = BORDER1;
        int count = 0;
        while (currentY <= BORDER2) {
            count++;
            currentY+= DELTA;
        }
        return count;
    }

    public static double[] createArrayOfX() {

        double[] arrayOfX = new double[Main.countNumberOfSteps()];
        double currentX = 0.8;
        for (int i = 0; i < arrayOfX.length; i++) {
            arrayOfX[i] = currentX;
            currentX+= 0.005;
        }
        return arrayOfX;
    }

    public static double[] createArrayOfY() {
        double[] arrayOfY = new double[Main.countNumberOfSteps()];
        double currentY;
        for (int i = 0; i < arrayOfY.length; i++) {
            currentY = Main.function(Main.createArrayOfX()[i]);
            arrayOfY[i] = currentY;
        }
        return arrayOfY;
    }

    public static int indexOfMaxY() {
        int index = 0;
        double maxY = createArrayOfY()[0];
        for (int i = 0; i < createArrayOfY().length; i++) {
            if (createArrayOfY()[i] > maxY ) {
                maxY = createArrayOfY()[i];
                index = i;
            }
        }

        return index;
    }

    public static int indexOfMinY() {
        int index = 0;
        double minY = createArrayOfY()[0];
        for (int i = 0; i < createArrayOfY().length; i++) {
            if (createArrayOfY()[i] < minY ) {
                minY = createArrayOfY()[i];
                index = i;
            }
        }
        return index;
    }

    public static double sumOfY() {
        double sum = 0;
        for (int i = 0; i < createArrayOfY().length; i++) {
            sum += createArrayOfY()[i];
        }
        return sum;
    }

    public static double averageOfY() {
        return Main.sumOfY()/Main.countNumberOfSteps();
    }

}
