package cz.spsmb.app.logger;

import cz.spsmb.app.repository.DatabaseContext;

public class DatabaseLogger implements Logger {

    private boolean init;

    public DatabaseLogger(DatabaseContext databaseContext) {
        this.init = false;
    }

    public void openConnection() {
        this.init = true;
    }

    private void checkIfConnectionIsOpened() {
        if (!this.init) {
            throw new IllegalArgumentException("You must call 'openConnection()' before using");
        }
    }

    @Override
    public void warn(String log, Object... args) {
        checkIfConnectionIsOpened();
        System.out.printf("'DATABASE - %s' " + String.format(log, args), "WARN");
    }

    @Override
    public void info(String log, Object... args) {
        checkIfConnectionIsOpened();
        System.out.printf("'DATABASE - %s' " + String.format(log, args) + "\n", "INFO");
    }

    @Override
    public void debug(String log, Object... args) {
        checkIfConnectionIsOpened();
        System.out.printf("'DATABASE - %s' " + String.format(log, args) + "\n", "DEBUG");
    }

    @Override
    public void error(String log, Object... args) {
        checkIfConnectionIsOpened();
        System.out.printf("'DATABASE - %s' " + String.format(log, args) + "\n", "ERROR");
    }

}
