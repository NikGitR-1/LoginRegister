import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users = new ArrayList<>();

    public boolean auth(String loginOrEmail, String password) {
        User userByLogin = findUserByLogin(loginOrEmail);
        if (userByLogin != null) {
            return userByLogin.getPassword().equals(password);
        } else {
            User userByEmail = findUserByEmail(loginOrEmail);
            if (userByEmail != null) {
                return userByEmail.getPassword().equals(password);
            } else return false;
        }
    }

    public boolean register(String login, String email, String password) {
        if (findUserByLogin(login) != null || findUserByEmail(email) != null) return false;
        User user = new User(login, email, password);
        users.add(user);
        return true;
    }

    public List<User> getAll() {
        return users;
    }

    private User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    private User findUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}

