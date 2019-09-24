package org;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
@Slf4j
public class Config {

    private static final Properties defaultProperties = new Properties();
    private final String mongoHost;
    private final int mongoPort;
    private final String mongoDatabaseName;
    private final String collectionName;

    Config() {
        try {
            InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties");
            defaultProperties.load(input);
        } catch (IOException e) {
            log.error("Properties not found");
        }
        this.mongoHost = getProperty("mongo.host");
        this.mongoPort = Integer.parseInt(getProperty("mongo.port"));
        this.mongoDatabaseName = getProperty("mongo.dbName");
        this.collectionName = getProperty("mongo.collectionName");
    }

    public static String getProperty(String key) {
        return defaultProperties.getProperty(key);
    }
}

