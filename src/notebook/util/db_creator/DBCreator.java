package notebook.util.db_creator;

import notebook.util.logger.Logger;

public interface DBCreator {
    void createDB(Logger logger);
    String getDbPath();
}
