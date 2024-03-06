package notebook.model.repository;

import notebook.model.User;

import java.util.List;
import java.util.Optional;

public interface Repository {
    List<User> findAll();
    User create(String stringUser);
    Optional<User> findById(Long id);
    Optional<User> update(String stringUser);
    boolean delete(Long id);
}
