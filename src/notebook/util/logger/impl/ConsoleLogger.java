package notebook.util.logger.impl;

import notebook.util.logger.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }
    @Override
    public void logError(String errMessage) {
        System.out.println(errMessage);
    }
}
