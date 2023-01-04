package cz.spsmb.app.repository;

import cz.spsmb.app.conf.Configuration;
import cz.spsmb.app.logger.Logger;

public class DatabaseUserRepository implements UserRepository {

    private Logger logger;
    private DatabaseContext databaseContext;
    private Configuration configuration;

    public DatabaseUserRepository(Logger logger, DatabaseContext databaseContext, Configuration configuration) {
        this.logger = logger;
        this.databaseContext = databaseContext;
        this.configuration = configuration;
    }

    @Override
    public int count() {
        return 10;
    }
}
