/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.MappingConfiguration;
import org.springframework.data.redis.core.index.IndexConfiguration;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 *
 * @author <a href="mailto:josephfmj@gmail.com"> Joseph Alexander Rubio Tapias</a>
 * @version 1.0
 * 
 */
@EnableRedisRepositories(basePackages = {"com.cyxtera.calculatorapi.redis.repository"})
@Configuration
public class RedisConfig {
	
	@Value("${spring.redis.host}")
	private String redishostName;
	
	@Value("${spring.redis.port}")
	private int redisPort;
	
	@Value("${spring.redis.password}")
	private String redisPassword;
	
	@Value("${spring.cache.redis.time-to-live}")
	private long redisTimeToLive;
	
	@Autowired
	private RedisKeyspaceConfiguration redisKeyspaceConfiguration;
	
	@Bean
	public RedisConnectionFactory connectionFactory() {
		
		RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(redishostName, redisPort);
		standaloneConfig.setPassword(redisPassword);
		
		JedisConnectionFactory jedisConnectionFactory =new JedisConnectionFactory(standaloneConfig);
	    return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<?, ?> redisTemplate() {

		RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
		template.setConnectionFactory(connectionFactory());
		
		return template;
	}
	
	/**
	 * Create RedisMappingContext with custom redis keyspace configuration
	 * @return the RedisMappingContext
	 */
	@Bean
	public RedisMappingContext keyValueMappingContext() {
		redisKeyspaceConfiguration.setTimeTolive(redisTimeToLive);
		return new RedisMappingContext(new MappingConfiguration(new IndexConfiguration(), redisKeyspaceConfiguration));
	}
}
