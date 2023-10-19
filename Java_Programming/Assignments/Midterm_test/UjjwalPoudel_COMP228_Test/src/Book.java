// Creating abstract class Book
abstract class Book {
    // Instance variables for Book class
    public String title;
    public String ISBN;
    public String publisher;
    public double price;
    public int year;

    // Default constructor without parameters
    public Book() {
    }

    // Constructor with 5 parameters
    public Book(String title, String ISBN, String publisher, double price, int year) {
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.price = price;
        this.year = year;
    }

    // Getter and setter for the title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter for the ISBN
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    // Getter and setter for the publisher
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Getter and setter for the year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Creating abstract method for setting price
    abstract void setPrice(double price);

    // Creating abstract method for getting genre
    abstract String getGenre();

    // Override to string method
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}
