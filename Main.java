package SimpleLibraryManagementSystem;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();

        boolean running = true;

        while (running) {

            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Choose an Option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title : ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author     : ");
                    String author = sc.nextLine();

                    boolean exist = false;
                    for (Book book : library) {
                        if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                            exist = true;
                            break;
                        }
                    }

                    if (exist) {
                        System.out.print("This Book Already Exists In The Library!");
                        System.out.println();
                    } else {
                        library.add(new Book(title, author));
                        System.out.println(title + " Added Successfully!");
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Available Books In The Library: ");
                    if (library.isEmpty()) {
                        System.out.println("No Books Found");
                        System.out.println();
                    } else {
                        for (int i = 0; i < library.size(); i++) {
                            System.out.println((i + 1) + ". " + library.get(i));
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.print("Search A Book Or Author Name: ");
                    String searchBook = sc.nextLine();

                    boolean found = false;
                    for (Book book : library) {
                        if (book.getTitle().equalsIgnoreCase(searchBook) || book.getAuthor().equalsIgnoreCase(searchBook)) {
                            System.out.println("Book found: " + book);
                            found = true;
                            System.out.println();
                        }
                    }
                    if (!found) {
                        System.out.println("Book Not Found!");
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();

                    Book bookToIssue = null;

                    for (Book book : library) {
                        if (book.getTitle().equalsIgnoreCase(issueTitle) || book.getAuthor().equalsIgnoreCase(issueTitle)) {
                            bookToIssue = book;
                            break;
                        }
                    }
                    if (bookToIssue != null) {
                        System.out.println("Book Issued Successfully");
                        bookToIssue.setIssued(true);
                        System.out.println();
                    } else {
                        System.out.println("Book Not Found Or Already Issued.");
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    Book bookToReturn = null;

                    for (Book book : library) {
                        if (book.getTitle().equalsIgnoreCase(returnTitle) && book.isIssued()) {
                            bookToReturn = book;
                            break;
                        }
                    }

                    if (bookToReturn != null) {
                        bookToReturn.setIssued(false);
                        System.out.println("Book Returned Successfully!");
                        System.out.println();
                    } else {
                        System.out.println("Book Not Found Or Not Issued!");
                        System.out.println();
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Invalid Option Please Try Again!");
                    System.out.println();

            }

        }
        sc.close();

    }

}
