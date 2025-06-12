import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Add Book: " + book);
    }

    public void removeBook(String isbn) {
        Optional<Book> bookToRemove = books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
        if (bookToRemove.isPresent()) {
            books.remove(bookToRemove.get());
            System.out.println("Remove Book: " + bookToRemove.get());
        } else {
            System.out.println("Book Not Found!");
        }
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User Registration: " + user);
    }

    public void issueBook(String isbn, int userId) {
        Optional<Book> bookToIssue = books.stream()
                .filter(book -> book.getIsbn().equals(isbn) && !book.isIssued())
                .findFirst();
        Optional<User> member = users.stream()
                .filter(m -> m.getuserId() == userId)
                .findFirst();

        if (bookToIssue.isPresent() && member.isPresent()) {
            bookToIssue.get().setIssued(true);
            LocalDate issueDate = LocalDate.now();
            LocalDate dueDate = issueDate.plusDays(14);
            Loan loan = new Loan(bookToIssue.get(), member.get(), issueDate, dueDate);
            loans.add(loan);
            System.out.println("Book Issued: " + loan);
        } else {
            System.out.println("Issue Failed: \n Book or Member not found, or book is already issued.");
        }
    }

    public void returnBook(String isbn, int userId) {
        Optional<Loan> loanToClose = loans.stream()
                .filter(loan -> loan.getBook().getIsbn().equals(isbn) && loan.getUser().getuserId() == userId)
                .findFirst();

        if (loanToClose.isPresent()) {
            loanToClose.get().getBook().setIssued(false);
            loans.remove(loanToClose.get());
            System.out.println("Book Returned: " + loanToClose.get().getBook());
        } else {
            System.out.println("Return Failed: \n Loan Not Found.");
        }
    }

    public void listOverdueBooks() {
        loans.stream()
                .filter(Loan::isOverdue)
                .forEach(loan -> System.out.println("Overdue Book: " + loan));
    }
}
