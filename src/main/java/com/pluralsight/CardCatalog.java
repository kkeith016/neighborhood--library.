package com.pluralsight;

import java.util.Scanner;

public class CardCatalog {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Initialize book array
        Books[] books = new Books[20];
        books[0] = new Books(1, "978-0439023528", "The Hunger Games", "Suzanne Collins", false, "");
        books[1] = new Books(2, "978-0439139601", "Harry Potter and the Goblet of Fire", "J.K. Rowling", true, "Alice Johnson");
        books[2] = new Books(3, "978-0061120084", "To Kill a Mockingbird", "Harper Lee", false, "");
        books[3] = new Books(4, "978-0451524935", "1984", "George Orwell", true, "Michael Smith");
        books[4] = new Books(5, "978-0316769488", "The Catcher in the Rye", "J.D. Salinger", false, "");
        books[5] = new Books(6, "978-0141439600", "Pride and Prejudice", "Jane Austen", false, "");
        books[6] = new Books(7, "978-0553382563", "A Game of Thrones", "George R.R. Martin", true, "Rachel Adams");
        books[7] = new Books(8, "978-0062315007", "The Alchemist", "Paulo Coelho", false, "");
        books[8] = new Books(9, "978-0375831003", "The Book Thief", "Markus Zusak", true, "David Lee");
        books[9] = new Books(10, "978-0307277671", "The Road", "Cormac McCathy", false, "");
        books[10] = new Books(11, "978-0140283297", "Brave New World", "Aldous Huxley", false, "");
        books[11] = new Books(12, "978-0385472579", "Zen and the Art of Motorcycle Maintenance", "Robert M. Pirsig", true, "Emily Carter");
        books[12] = new Books(13, "978-0143126560", "The Martian", "Andy Weir", false, "");
        books[13] = new Books(14, "978-0679783268", "Les Misérables", "Victor Hugo", true, "Daniel Harris");
        books[14] = new Books(15, "978-0060850524", "The Kite Runner", "Khaled Hosseini", false, "");
        books[15] = new Books(16, "978-1501128035", "It", "Stephen King", true, "Samantha Lee");
        books[16] = new Books(17, "978-0140449266", "The Odyssey", "Homer", false, "");
        books[17] = new Books(18, "978-0307588371", "Gone Girl", "Gillian Flynn", true, "Michael Johnson");
        books[18] = new Books(19, "978-0142424179", "The Fault in Our Stars", "John Green", false, "");
        books[19] = new Books(20, "978-0061122415", "Life of Pi", "Yann Martel", true, "Olivia Brown");

        System.out.println("---Welcome to the Library Catalog System---\n");

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("   1 - List All Books");
            System.out.println("   2 - Show Available Books");
            System.out.println("   3 - Show Checked Out Books");
            System.out.println("   4 - Add a Book");
            System.out.println("   5 - Exit\n");

            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    listAllBooks(books);
                    break;
                case 2:
                    showAvailableBooks(books, scan);
                    break;
                case 3:
                    showCheckedOutBooks(books, scan);
                    break;
                case 4:
                    books = addBook(books, scan);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // List all books
    public static void listAllBooks(Books[] books) {
        for (Books book : books) {
            System.out.println(book.getId() + ": " + book.getTitle() + " (ISBN: " + book.getIsbn() + ") - " + book.getAuthor());
        }
    }

    // Show available books and allow checkout
    public static void showAvailableBooks(Books[] books, Scanner scan) {
        System.out.println("---Available Books---");
        for (Books book : books) {
            if (!book.isCheckout()) {
                System.out.println(book.getId() + ": " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
            }
        }

        System.out.print("Enter book ID to check out or 0 to return: ");
        int id = scan.nextInt();
        scan.nextLine();

        if (id != 0) {
            System.out.print("Enter your name: ");
            String name = scan.nextLine();
            boolean found = false;
            for (Books book : books) {
                if (book.getId() == id && !book.isCheckout()) {
                    book.checkOut(name);
                    System.out.println("Book checked out successfully!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Book ID not found or already checked out.");
            }
        }
    }

    // Show checked out books and allow check-in
    public static void showCheckedOutBooks(Books[] books, Scanner scan) {
        System.out.println("---Checked Out Books---");
        for (Books book : books) {
            if (book.isCheckout()) {
                System.out.println(book.getId() + ": " + book.getTitle() + " - Checked out to: " + book.getCheckedOutTo());
            }
        }

        System.out.print("Enter 'C' to check in a book or 'X' to return: ");
        String input = scan.nextLine();

        if (input.equalsIgnoreCase("C")) {
            System.out.print("Enter book ID to check in: ");
            int id = scan.nextInt();
            scan.nextLine();
            boolean found = false;
            for (Books book : books) {
                if (book.getId() == id && book.isCheckout()) {
                    book.checkIn();
                    System.out.println("Book checked in successfully!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Book ID not found or not checked out.");
            }
        }
    }

    // Add a new book
    public static Books[] addBook(Books[] currentBooks, Scanner scan) {
        int id = currentBooks.length + 1; // auto-generate ID
        System.out.print("Enter ISBN: ");
        String isbn = scan.nextLine();

        System.out.print("Enter Title: ");
        String title = scan.nextLine();

        System.out.print("Enter Author: ");
        String author = scan.nextLine();

        Books newBook = new Books(id, isbn, title, author, false, "");

        // Add to array
        Books[] newBooks = new Books[currentBooks.length + 1];
        for (int i = 0; i < currentBooks.length; i++) {
            newBooks[i] = currentBooks[i];
        }
        newBooks[currentBooks.length] = newBook;

        System.out.println("Book added successfully!");
        return newBooks;
    }
}


