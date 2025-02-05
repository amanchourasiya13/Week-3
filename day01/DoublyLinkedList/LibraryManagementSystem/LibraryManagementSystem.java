package day1.DoublyLinkedList.LibraryManagementSystem;

class Book {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private Book head = null;
    private Book tail = null;
    private int count = 0;

    // Add a book at the beginning
    public void addAtBeginning(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    // Add a book at the end
    public void addAtEnd(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(bookTitle, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    // Add a book at a specific position
    public void addAtPosition(int position, String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        if (position <= 0) {
            addAtBeginning(bookTitle, author, genre, bookId, isAvailable);
        } else if (position >= count) {
            addAtEnd(bookTitle, author, genre, bookId, isAvailable);
        } else {
            Book newBook = new Book(bookTitle, author, genre, bookId, isAvailable);
            Book temp = head;
            int counter = 0;
            while (counter < position - 1) {
                temp = temp.next;
                counter++;
            }
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
            count++;
        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        if (head == null) return;

        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                count--;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by Title or Author
    public void searchBook(String searchTerm) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.bookTitle.equalsIgnoreCase(searchTerm) || temp.author.equalsIgnoreCase(searchTerm)) {
                System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.bookTitle + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No book found with the title or author: " + searchTerm);
        }
    }

    // Update a book’s Availability Status
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Book ID " + bookId + " availability updated to " + (isAvailable ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayAllBooksForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.bookTitle + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayAllBooksReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.bookTitle + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Availability: " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        DoublyLinkedList library = new DoublyLinkedList();

        // Add some books to the library
        library.addAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addAtEnd("1984", "George Orwell", "Dystopian", 102, true);
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Fiction", 103, true);

        // Display books in forward order
        System.out.println("Books in forward order:");
        library.displayAllBooksForward();

        // Display books in reverse order
        System.out.println("\nBooks in reverse order:");
        library.displayAllBooksReverse();

        // Search for a book by title
        System.out.println("\nSearch for '1984':");
        library.searchBook("1984");

        // Update availability of a book
        library.updateAvailability(102, false); // Set availability of book with ID 102 to false

        // Display updated book list
        System.out.println("\nUpdated Books in forward order:");
        library.displayAllBooksForward();

        // Count total number of books
        System.out.println("\nTotal number of books in the library: " + library.countBooks());

        // Remove a book by ID
        library.removeBookById(101); // Remove book with ID 101
        System.out.println("\nBooks after removal:");
        library.displayAllBooksForward();
    }
}
