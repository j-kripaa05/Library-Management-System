public class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getuserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + name + '\'' +
                ", User Id=" + userId +
                '}';
    }
}
