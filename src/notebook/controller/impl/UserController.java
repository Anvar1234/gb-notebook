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
    public void saveUser(String stringUser) {
        repository.create(stringUser);
    }

    @Override
    public User readUser(Long userId) {
        return repository.findById(userId).get();
    }

    @Override
    public void updateUser(String stringUser) {
        repository.update(stringUser);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public boolean deleteUser(Long id){
        return repository.delete(id);
    }

}
