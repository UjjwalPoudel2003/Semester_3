import java.security.Signature;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Calling the test Method
        testMethod();
    }

    // Creating a test method in Main class
    public static void testMethod() {
        // Creating an object of Singers class
        Singers Bob = new Singers();

        // Displaying the default values of instance variables
        System.out.println("Singer ID: " + Bob.getId());
        System.out.println("Singer Name: " + Bob.getName());
        System.out.println("Singer Address: " + Bob.getAddress());
        System.out.println("Singer Date of Birth: " + Bob.getDateOfBirth());
        System.out.println("Singer Albums Number: " + Bob.getNumberOfAlbumsPublished());

        // Creating another object of Singers class with two arguments
        Singers eminem = new Singers(1, "Eminem");

        // Setting address and albums number of the object Eminem
        eminem.setAddress("342 California Street, LA");
        eminem.setNumberOfAlbumsPublished(34);

        // Displaying the default values and given values
        System.out.println("\n\nSinger ID: " + eminem.getId());
        System.out.println("Singer Name: " + eminem.getName());
        System.out.println("Singer Address: " + eminem.getAddress());
        System.out.println("Singer Date of Birth: " + eminem.getDateOfBirth());
        System.out.println("Singer Albums Number: " + eminem.getNumberOfAlbumsPublished());

        // Setting the values of each instance variables using setter and retrieving using getters
        Singers pop = new Singers();

        // Displaying the values before using setters
        System.out.println("\n\nBefore using the Setters ");
        System.out.println("Singer ID: " + pop.getId());
        System.out.println("Singer Name: " + pop.getName());
        System.out.println("Singer Address: " + pop.getAddress());
        System.out.println("Singer Date of Birth: " + pop.getDateOfBirth());
        System.out.println("Singer Albums Number: " + pop.getNumberOfAlbumsPublished());

        // Using setters to set the values
        pop.setId(5);
        pop.setName("Bruno Mars");
        pop.setAddress("324 Markham road, ON");
        pop.setDateOfBirth("22 September 1976");
        pop.setNumberOfAlbumsPublished(34);

        // Displaying the values
        System.out.println("\n\nAfter using the Setters ");
        System.out.println("Singer ID: " + pop.getId());
        System.out.println("Singer Name: " + pop.getName());
        System.out.println("Singer Address: " + pop.getAddress());
        System.out.println("Singer Date of Birth: " + pop.getDateOfBirth());
        System.out.println("Singer Albums Number: " + pop.getNumberOfAlbumsPublished());
    }
}