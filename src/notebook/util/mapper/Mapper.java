package notebook.util.mapper;

import notebook.model.User;

public interface Mapper {
    String toInput(User e);
    User toOutputWithID(String str);
    User toOutputWithoutID(String str);
}
