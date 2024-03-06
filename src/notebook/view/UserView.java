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
            String command = prompt("Введите команду \"READ, READALL, CREATE, UPDATE, DELETE, EXIT\": ");
            System.out.println();
            com = Commands.valueOf(command.toUpperCase());
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String u = createUserWithoutID(); //здесь нужен без id
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
                    for (User user : allUsers) {
                        System.out.println(user);
                        System.out.println();
                    }
                    break;
                case DELETE:
                    String idToDeleted = prompt("Идентификатор пользователя: ");
                    if(userController.deleteUser(Long.parseLong(idToDeleted))) {
                        System.out.println("User deleted succefully");
                    }
                    break;
                case UPDATE:
                    String userId = prompt("Enter user id: ");
                    StringBuilder stringUser = new StringBuilder()
                            .append(userId)
                            .append(",")
                            .append(createUserWithoutID());
                    userController.updateUser(stringUser.toString()); //todo: почему break не нужен?
            }
        }
    }

    private String createUserWithoutID() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        return String.format("%s,%s,%s", firstName, lastName, phone);
    }
}
