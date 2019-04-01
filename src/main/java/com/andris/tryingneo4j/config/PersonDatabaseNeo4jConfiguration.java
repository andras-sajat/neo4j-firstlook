package com.andris.tryingneo4j.config;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = { "com.andris.tryingneo4j.services" })
@Configuration
@EnableNeo4jRepositories(basePackages = "com.andris.tryingneo4j.repository")
@EnableTransactionManagement
public class PersonDatabaseNeo4jConfiguration {

    public static final String URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL") : "bolt://neo4j:persons@localhost:7687";

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
    	org.neo4j.ogm.config.Configuration config = new Builder().uri(URL).credentials("neo4j", "admin").build();
        return config;
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(getConfiguration(), "com.andris.tryingneo4j.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}