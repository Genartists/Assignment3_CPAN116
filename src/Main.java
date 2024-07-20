import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create an object for the BookDatabase class
        BookDatabase bookData = new BookDatabase();
        //object call the addbook method to add new book
        bookData.addBook("978-3-16-148410-6", "The lord of the rings", "J. R. R. Tolkien");
        bookData.addBook("978-2-245-58768-5", "A Game of Thrones", "George R. R. Martin");
        //object call the printAllISBNs method to print all isbn
        bookData.printAllISBNs();
        //using scanner allow user to prompt in ISBN to search for books
        Scanner sc = new Scanner(System.in);
        String isbn;
        boolean validInput;
        //do-while loop, allow user to continuously searching for books, only stop when they type exit or quit
        do {
            System.out.println("Enter the ISBN for the book that you want to search (or type 'exit' or 'quit' to stop): ");
            isbn = sc.nextLine();
            if ("exit".equalsIgnoreCase(isbn) || "quit".equalsIgnoreCase(isbn)) {
                break;
            }
            validInput = bookData.validateISBN(isbn);
            //check if the ISBN input is valid with 13 character long
            if (!validInput) {
                System.out.println("Invalid ISBN. Please enter a valid ISBN.");
                continue;
            }
            //if true call the bookCheck method to pull out information about the book
            bookData.bookCheck(isbn);
        } while (true);
    }
}
