package notebook;

import notebook.controller.Controller;
import notebook.controller.impl.UserController;
import notebook.model.dao.Operation;
import notebook.model.dao.impl.FileOperation;
import notebook.model.repository.Repository;
import notebook.model.repository.impl.UserRepository;
import notebook.util.Utils;
import notebook.util.db_creator.DBCreator;
import notebook.util.db_creator.impl.DB;
import notebook.util.logger.impl.ConsoleLogger;
import notebook.util.mapper.Mapper;
import notebook.util.mapper.impl.UserMapper;
import notebook.view.UserView;


public class Main {
    public static void main(String[] args) {

        String dbPath = Utils.prompt("Введите путь к БД и наименование вида \" db.txt\": ");
        DBCreator db = new DB(dbPath);
        db.createDB(new ConsoleLogger());

        Operation fileOperation = new FileOperation(db.getDbPath());
        Mapper userMapper = new UserMapper();
        Repository userRepository = new UserRepository(fileOperation, userMapper);
        Controller userController = new UserController(userRepository);
        UserView view = new UserView(userController);
        view.run();

    }
}
