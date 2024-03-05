package notebook.controller;

import notebook.model.User;

import java.util.List;

public interface Controller {
     void saveUser(User user);

     User readUser(Long userId);

     void updateUser(String userId, User update);

     List<User> findAllUsers();
}
