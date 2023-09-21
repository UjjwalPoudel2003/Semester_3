import java.util.Scanner;

public class Singers {
    // Creating Private Instance variables
    private Integer id;
    private String name;
    private String address;
    private String dateOfBirth;
    private Integer numberOfAlbumsPublished;

    // Creating Constructor with no parameters
    public Singers() {
        // System.out.println("Default constructor is Called");
    }

    // Creating Constructor with single parameters
    public Singers(Integer id) {
        this.id = id;
        // System.out.println("constructor with single parameter is Called");
    }

    // Creating Constructor with two parameters
    public Singers(Integer id, String name) {
        this.id = id;
        this.name = name;
        // System.out.println("constructor with double parameter is Called");
    }

    // Creating Constructor with three parameters
    public Singers(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        // System.out.println("constructor with three parameter is Called");
    }

    // Creating Constructor with four parameters
    public Singers(Integer id, String name, String address, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        // System.out.println("constructor with four parameter is Called");
    }

    // Creating Constructor with five parameters
    public Singers(Integer id, String name, String address, String dateOfBirth, int numberOfAlbumsPublished) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
        // System.out.println("constructor with five parameter is Called");
    }

    // Creating Getters for the instance variables
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Integer getNumberOfAlbumsPublished() {
        return this.numberOfAlbumsPublished;
    }

    // Creating Setters for the instance variables
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberOfAlbumsPublished(Integer numberOfAlbumsPublished) {
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }

    // Creating a setter that will set the values of all the instance variables at once
    public void setAttributes(Integer id, String name, String address, String dateOfBirth, Integer numberOfAlbumsPublished) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }
}