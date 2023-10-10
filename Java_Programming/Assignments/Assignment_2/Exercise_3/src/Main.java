public class Main {
    public static void main(String[] args) {
        // Summing Integers
       int firstSum = staticExample.summation(4, 5);
       System.out.println("The integer sum is : " + firstSum);

       // Summing the floating values
       double secondSum = staticExample.summation(5.3, 6.1);
       System.out.println("\nThe double sum is : " + secondSum);

       // Summing the Strings
       String thirdSum = staticExample.summation( "The number is ", 6.1);
       System.out.println("\nThe String sum is : " + thirdSum);
    }
}