package notebook.controller;

import notebook.model.User;

import java.util.List;

public interface Controller {
     void saveUser(String stringUser);

     User readUser(Long userId);

     void updateUser(String stringUser);

     List<User> findAllUsers();
     boolean deleteUser(Long id);
}
