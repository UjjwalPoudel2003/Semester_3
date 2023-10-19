import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String title = JOptionPane.showInputDialog("Enter the Book Title:");
        String ISBN = JOptionPane.showInputDialog("Enter the Book ISBN:");
        String publisher = JOptionPane.showInputDialog("Enter the Book publisher:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the Book Price:"));
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the Book Year"));

        // Creating the objects of science book and setting the book information
        ScienceBook firstScienceBook = new ScienceBook();
        firstScienceBook.setTitle(title);
        firstScienceBook.setISBN(ISBN);
        firstScienceBook.setPublisher(publisher);
        firstScienceBook.setPrice(price);
        firstScienceBook.setYear(year);

        // Getting the price and genre of the first science book
        double firstSciencePrice = firstScienceBook.getPrice();
        String firstScienceGenre = firstScienceBook.getGenre();

        // Creating the objects of children book and setting the information
        ChildrenBook firstChildrenBook = new ChildrenBook();
        firstChildrenBook.setTitle(title);
        firstChildrenBook.setISBN(ISBN);
        firstChildrenBook.setPublisher(publisher);
        firstChildrenBook.setPrice(price);
        firstChildrenBook.setYear(year);

        // Getting the price and genre of the first children book
        double firstChildrenPrice = firstChildrenBook.getPrice();
        String firstChildrenGenre = firstChildrenBook.getGenre();

        // Setting information to display
        String scienceInformation = "Title: " + title + "\nISBN: " + ISBN + "\nPublisher: " + publisher + "\nPrice: " + firstSciencePrice + "\nYear: " + year + "\nGenre: " + firstScienceGenre;
        String childrenInformation = "Title: " + title + "\nISBN: " + ISBN + "\nPublisher: " + publisher + "\nPrice: " + firstChildrenPrice + "\nYear: " + year + "\nGenre: " + firstChildrenGenre;

        JOptionPane.showMessageDialog(null, scienceInformation);
        JOptionPane.showMessageDialog(null, childrenInformation);
    }
}