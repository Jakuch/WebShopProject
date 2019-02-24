package pl.sdacademy.database;

import pl.sdacademy.model.User;

import java.util.*;

public class UserDatabase {
    private static class SingletonHelper {
        private static final UserDatabase INSTANCE = new UserDatabase();
    }

    private List<User> users;

    private UserDatabase() {
        this.users = new LinkedList<>();
        users.add(new User("admin@admin.com", "admin", "admin", Arrays.asList("admin", "user")));
        users.add(new User("user@user.com", "user", "user", Collections.singletonList("user")));
    }

    public static UserDatabase getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public Optional<User> checkLogin(final String username, final String password) {
        return users.stream()
                .filter(user -> user.getUserName().equalsIgnoreCase(username) && user.getPassword().equals(password))
                .findFirst();
    }

    public boolean checkIfExists(final String userName, final String email) {
        return users.stream()
                .anyMatch(user -> user.getUserName().equalsIgnoreCase(userName) || user.getEmail().equalsIgnoreCase(email));
    }

    public User addUser(final String userName, final String email, final String password, final List<String> roles) {
        final User newUser = new User(email, password, userName, roles);
        users.add(newUser);
        return newUser;
    }
}
