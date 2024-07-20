import java.util.ArrayList;

public class BookDatabase {
    private ArrayList<String> isbnArray;
    private ArrayList<String> bookNameArray;
    private ArrayList<String> authorNameArray;

    //constructor set array value for each type
    public BookDatabase() {
        this.isbnArray = new ArrayList<>();
        this.bookNameArray = new ArrayList<>();
        this.authorNameArray = new ArrayList<>();
        addBook("978-3-16-148410-0", "To Kill a Mockingbird", "Harper Lee");
        addBook("978-1-4028-9462-6", "1984", "George Orwell");
        addBook("978-0-316-92004-4", "Pride and Prejudice", "Jane Austen");
        addBook("978-0-7432-7356-5", "The Great Gatsby", "F. Scott Fitzgerald");
    }

    //check if the book isbn is existed in size the array, if true print out book title and author name
    public boolean bookCheck(String isbn) {
        for (int i = 0; i < isbnArray.size(); i++) {
            if (isbnArray.get(i).equals(isbn)) {
                System.out.println("The book that you're looking for is: " + bookNameArray.get(i) + " by " + authorNameArray.get(i));
                return true;
            }
        }
        System.out.println("Sorry, the book does not exist in our database");
        return false;
    }

    public boolean validateISBN(String isbn) {
        String isbnDigits = isbn.replace("-", ""); // Remove hyphens
        // Check if the ISBN is 13 digits long
        return isbnDigits.length() == 13;
    }


    public void addBook(String isbn, String bookName, String authorName) {
        if (validateISBN(isbn)) {
            // Add the new book to the arrays
            isbnArray.add(isbn);
            bookNameArray.add(bookName);
            authorNameArray.add(authorName);
        } else {
            System.out.println("Invalid ISBN. The book was not added to the database.");
        }
    }
    //method to print all the available isbn in the database
    public void printAllISBNs() {
        System.out.println("All ISBNs available in our database:");
        for (String isbn : isbnArray) {
            System.out.println(isbn);
        }
    }
}