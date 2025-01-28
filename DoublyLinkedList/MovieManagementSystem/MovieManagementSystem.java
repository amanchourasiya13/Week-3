package day1.DoublyLinkedList.MovieManagementSystem;

class MovieNode {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
class MovieManagement{
    private MovieNode head;
    private MovieNode tail;

    public MovieManagement() {
        head = null;
        tail = null;
    }

    // Add a movie at the beginning
    public void addMovieAtBeginning(String title, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a movie at the end
    public void addMovieAtEnd(String title, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a movie at a specific position
    public void addMovieAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position <= 0) {
            addMovieAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);
        MovieNode current = head;
        int index = 0;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null || current.next == null) {
            addMovieAtEnd(title, director, yearOfRelease, rating);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
    }

    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        MovieNode current = head;

        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
            System.out.println("Movie Removed By Title");
        }
        System.out.println("Movie not found.");
    }

    // Search for movies by director
    public void searchMoviesByDirector(String director) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("\nMovie found By Director Name: " + current.title + " (" + current.yearOfRelease + ") - Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found by the director: " + director);
        }
    }

    // Search for movies by rating
    public void searchMoviesByRating(double rating) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("\nMovie found By Rating: " + current.title + " (" + current.yearOfRelease + ") - Director: " + current.director);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Update a movie's rating based on title
    public void updateMovieRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating of movie \"" + title + "\" updated to " + newRating);
                return;
            }
            current = current.next;
        }
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        MovieNode current = head;
        while (current != null) {
            System.out.println(current.title + " (" + current.yearOfRelease + ") - Director: " + current.director + " - Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        MovieNode current = tail;
        while (current != null) {
            System.out.println(current.title + " (" + current.yearOfRelease + ") - Director: " + current.director + " - Rating: " + current.rating);
            current = current.prev;
        }
    }
}
public class MovieManagementSystem{
    public static void main(String[] args) {
        MovieManagement system = new MovieManagement();

        System.out.println("ALl movies: ");
        system.addMovieAtBeginning("firangi", "Mr.Chopra", 2010, 8.8);
        system.addMovieAtEnd("Hungama", "Rahul Bacchan", 2008, 9.0);
        system.addMovieAtPosition(1, "Interstellar", "Christopher Nolan", 2014, 8.6);
        system.displayMoviesForward();

        system.searchMoviesByDirector("Mr.Chopra");
        system.searchMoviesByRating(8.6);

        system.updateMovieRating("Hungama", 9.2);
        System.out.println("\nAll Movies Display Reverse: ");
        system.displayMoviesReverse();

        system.removeMovieByTitle("Interstellar");
        System.out.println("Remain All Movies: ");
        system.displayMoviesForward();
    }
}


