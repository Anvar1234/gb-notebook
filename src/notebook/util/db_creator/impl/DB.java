package notebook.util.db_creator.impl;

import notebook.util.db_creator.DBCreator;
import notebook.util.logger.Logger;

import java.io.File;

public class DB implements DBCreator {
    private final String dbPath;

    public DB(String dbPath) {
        this.dbPath = dbPath;
    }

    @Override
    public void createDB(Logger logger) {

        try {
            File db = new File(dbPath);
            if (db.createNewFile()) {
                logger.logMessage("DB created");
            } else {
                logger.logMessage("DB already exists");
            }
        } catch (Exception e) {
            logger.logError(e.toString());
        }
    }

    @Override
    public String getDbPath() {
        return dbPath;
    }
}
