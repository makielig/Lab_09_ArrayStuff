import java.util.Random;
import java.util.Scanner;

public class Lab09ArrayStuff {

    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random random = new java.util.Random();

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1; // Generate random values between 1 and 100
        }

        System.out.print("dataPoints: ");
        for (int value : dataPoints) {
            System.out.print(value + " | ");
        }
        System.out.println();

        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }

        double average = (double) sum / dataPoints.length;

        System.out.println("The average of the random array dataPoints is: " + average);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a value between 1 and 100: ");
        int target = SafeInput.getRangedInt(scanner, "Please enter a number between 1 and 100:",1, 100); // Assuming SafeInput is implemented

        int count = occuranceScan(dataPoints, target);
        System.out.println("The value " + target + " was found " + count + " times in the array.");

        boolean found = contains(dataPoints, target);
        if (found) {
            int index = findIndex(dataPoints, target); // Helper method to find first index
            System.out.println("The value " + target + " was found at array index " + index + ".");
        } else {
            System.out.println("The value " + target + " was not found in the array.");
        }

        int minVal = min(dataPoints);
        int maxVal = max(dataPoints);
        System.out.println("The minimum value in the array is: " + minVal);
        System.out.println("The maximum value in the array is: " + maxVal);

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }
    public static double getAverage(int values[]) {
        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
    public static int min(int values[]) {
        int min = values[0];
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    public static int max(int values[]) {
        int max = values[0];
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    public static int occuranceScan(int values[], int target) {
        int count = 0;
        for (int value : values) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }
    public static int sum(int values[]) {
        int totalSum = 0;
        for (int value : values) {
            totalSum += value;
        }
        return totalSum;
    }
    public static boolean contains(int values[], int target) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
    // Helper method to find the first index of a value (for part c of linear search)
    public static int findIndex(int values[], int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
}