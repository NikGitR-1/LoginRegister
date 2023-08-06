import java.util.Scanner;

public class Main {
    public static final String POSSIBLE_ANSWER_1 = "register";
    public static final String POSSIBLE_ANSWER_2 = "login";
    public static final String POSSIBLE_ANSWER_3 = "show db";

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
        String login;
        String password;
        String command;
        String email;
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("Welcome! \nIf do you want to login, " +
                    "please write 'login'.  \nIf you want to register, " +
                    "write 'register'" + "\nShow user database: 'show db'.");
            System.out.print("Write command: ");
            command = scanner.nextLine();
            switch (command) {
                case POSSIBLE_ANSWER_1:
                    System.out.println("Ok, I understand you, want to register.\n"
                            + "We need you login and password");
                    System.out.print("Login: ");
                    login = scanner.nextLine();
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    if (userDAO.register(login, email, password)) {
                        System.out.println("Cool! User with login " + login +
                                " was register");
                    } else {
                        System.out.println("Error! User with login " + login +
                                "is exist");
                    }
                    break;
                case POSSIBLE_ANSWER_2:
                    System.out.println("Ok, I understand you, you want to login. \n"
                            + "We need you login and password");
                    System.out.print("Login/Email: ");
                    login = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    if (userDAO.auth(login, password)) {
                        System.out.println("Cool! User with login " + login +
                                " was login in his personal area");
                    } else {
                        System.out.println("Error! Login or password is incorrect");
                    }
                    break;
                case POSSIBLE_ANSWER_3:
                    System.out.println("User database: ");
                    userDAO.getAll().forEach(System.out::println);
                    break;
                default:
                    System.out.println("I not understand you. Can do this again");
            }
        }
    }
}

