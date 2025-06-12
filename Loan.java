import java.time.LocalDate;

public class Loan {
    private Book book;
    private User user;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public Loan(Book book, User user, LocalDate issueDate, LocalDate dueDate) {
        this.book = book;
        this.user = user;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", User=" + user +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", overdue=" + isOverdue() +
                '}';
    }
}
