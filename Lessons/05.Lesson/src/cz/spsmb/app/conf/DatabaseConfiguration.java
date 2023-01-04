package cz.spsmb.app.conf;

import cz.spsmb.app.logger.Logger;
import cz.spsmb.app.repository.DatabaseContext;

public class DatabaseConfiguration implements Configuration {

    private boolean inited;
    private Logger logger;

    public DatabaseConfiguration(Logger logger, DatabaseContext databaseContext) {
        this.inited = false;
        this.logger = logger;
    }

    public void openConnection() {
        this.inited = true;
    }

    @Override
    public Integer get(String key) {
        if(!this.inited) {
            throw new IllegalArgumentException("You must call 'openConnection()' before using this method.");
        }
        logger.debug("This is database configuration");
        return 11;
    }
}
