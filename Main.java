import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner obj = new Scanner(System.in);
        int choice;

        do {
            System.out.println(" WELCOME TO \n LIBRARY MANAGEMENT SYSTEM .. \n");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register User");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. List Overdue Books");
            System.out.println("0. Exit");
            obj.nextLine();
            System.out.print("Enter Your Choice: ");
            choice = obj.nextInt();
            obj.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = obj.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = obj.nextLine();
                    System.out.print("Enter ISBN Of Book: ");
                    String isbn = obj.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter Book ISBN To Remove: ");
                    String isbnToRemove = obj.nextLine();
                    library.removeBook(isbnToRemove);
                    break;
                case 3:
                    System.out.print("Enter User Name: ");
                    String name = obj.nextLine();
                    System.out.print("Enter User ID: ");
                    int userId = obj.nextInt();
                    obj.nextLine();
                    library.registerUser(new User(name, userId));
                    break;
                case 4:
                    System.out.print("Enter Book ISBN To Issue: ");
                    String isbnToIssue = obj.nextLine();
                    System.out.print("Enter User ID: ");
                    int userToIssue = obj.nextInt();
                    obj.nextLine();
                    library.issueBook(isbnToIssue, userToIssue);
                    break;
                case 5:
                    System.out.print("Enter Book ISBN To Return: ");
                    String isbnToReturn = obj.nextLine();
                    System.out.print("Enter User ID: ");
                    int userToReturn = obj.nextInt();
                    obj.nextLine();
                    library.returnBook(isbnToReturn, userToReturn);
                    break;
                case 6:
                    library.listOverdueBooks();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again.");
                    break;
            }
        } while (choice != 0);

    }
}
