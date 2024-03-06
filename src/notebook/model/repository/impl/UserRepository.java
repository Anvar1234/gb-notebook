package notebook.model.repository.impl;

import notebook.model.User;
import notebook.model.dao.Operation;
import notebook.model.repository.Repository;
import notebook.util.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository {
    private final Mapper mapper;
    private final Operation operation;

    public UserRepository(Operation operation, Mapper mapper) {
        this.mapper = mapper;
        this.operation = operation;
    }

    @Override
    public List<User> findAll() {
        List<String> lines = operation.readAll();
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.toOutputWithID(line));
        }
        return users;
    }

    @Override
    public User create(String stringUser) {
        User user = mapper.toOutputWithoutID(stringUser);
        List<User> users = findAll();
        long max = 0L;
        for (User u : users) {
            long id = u.getId();
            if (max < id) {
                max = id;
            }
        }
        long next = max + 1;
        user.setId(next);
        users.add(user);
        write(users);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        List<User> users = findAll();
        return Optional.of(users.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public Optional<User> update(String stringUser) {
        User update = mapper.toOutputWithID(stringUser);

        List<User> users = findAll();
        User editUser = users.stream()
                .filter(u -> u.getId()
                        .equals(update.getId()))
                .findFirst().orElseThrow(() -> new RuntimeException("User not found"));
        editUser.setFirstName(update.getFirstName());
        editUser.setLastName(update.getLastName());
        editUser.setPhone(update.getPhone());
        write(users);
        return Optional.of(update);
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    private void write(List<User> users) {
        List<String> lines = new ArrayList<>();
        for (User u : users) {
            lines.add(mapper.toInput(u));
        }
        operation.saveAll(lines);
    }

}
