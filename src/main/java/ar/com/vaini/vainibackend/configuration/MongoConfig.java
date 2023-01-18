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

    @Value("${db.user}")
    private String databaseUser;

    @Value("${db.password}")
    private String databasePassword;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public MongoClient mongoClient() {
        final String connection = String.format("mongodb+srv://%s:%s@cluster0.u6flvrh.mongodb.net/%s?retryWrites=true&w=majority",databaseUser, databasePassword, databaseName);
        final ConnectionString connectionString = new ConnectionString(connection);
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
