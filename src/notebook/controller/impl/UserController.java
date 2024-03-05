package notebook.controller.impl;

import notebook.controller.Controller;
import notebook.model.User;
import notebook.model.repository.Repository;

import java.util.List;

public class UserController implements Controller {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void saveUser(User user) {
        repository.create(user);
    }

    @Override
    public User readUser(Long userId) {
        return repository.findById(userId).get();
    }

    @Override
    public void updateUser(String userId, User update) {
        repository.update(Long.parseLong(userId), update);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }
}
