import controller.UserController;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.addUser("kamil@kamil", "pass", "role_user",true, LocalDate.now());


    }
}
