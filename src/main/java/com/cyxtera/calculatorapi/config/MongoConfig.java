/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
*
* @author <a href="mailto:josephfmj@gmail.com"> Joseph Alexander Rubio Tapias</a>
* @version 1.0
* 
*/
@Configuration
public class MongoConfig {

	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.port}")
	private int port;
	@Value("${spring.data.mongodb.authentication-database}")
	private String authenticationDB;
	@Value("${spring.data.mongodb.database}")
	private String database;
	@Value("${spring.data.mongodb.username}")
	private String user;
	@Value("${spring.data.mongodb.password}")
	private String password;

	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(new ServerAddress(host, port),
				MongoCredential.createCredential(user, authenticationDB, password.toCharArray()),
				MongoClientOptions.builder().build());
	}

	@Bean
	public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(mongoClient(), database);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

	}

}