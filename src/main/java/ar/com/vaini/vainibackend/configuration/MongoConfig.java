package ar.com.vaini.vainibackend.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "ar.com.vaini.vainibackend.repositories")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${db.name:vaini}")
    private String databaseName;

    @Value("${db.host:localhost}")
    private String databaseHost;

    @Value("${db.port:27017}")
    private String databasePort;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString = new ConnectionString("mongodb://" + databaseHost + ":" + databasePort + "/" + databaseName);
        final MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(settings);
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("ar.com.vaini.vainibackend.repositories");
    }
}
