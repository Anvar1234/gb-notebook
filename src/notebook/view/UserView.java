package notebook.view;

import notebook.controller.Controller;
import notebook.model.User;
import notebook.util.Commands;

import java.util.List;

import static notebook.util.Utils.prompt;

public class UserView {
    private final Controller userController;

    public UserView(Controller userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = prompt("Введите команду \"READ, READALL, CREATE, UPDATE, EXIT\": ");
            System.out.println();
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    User u = createUser();
                    userController.saveUser(u);
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case READALL:
                    List<User> allUsers = userController.findAllUsers();
                    for(User user : allUsers){
                        System.out.println(user);
                        System.out.println();
                    }
                    break;
                case UPDATE:
                    String userId = prompt("Enter user id: ");
                    userController.updateUser(userId, createUser()); //todo: почему break не нужен?
            }
        }
    }

    private User createUser() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        return new User(firstName, lastName, phone);
    }
}
