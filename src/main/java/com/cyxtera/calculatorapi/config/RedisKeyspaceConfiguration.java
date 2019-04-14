/**
 * Joseph Rubio - Copyright (c) 2019
 * https://github.com/josephfmj/
 * Date: 13/04/2019
 */
package com.cyxtera.calculatorapi.config;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.convert.KeyspaceConfiguration;

import com.cyxtera.calculatorapi.redis.model.OperationContext;

/**
*
* @author <a href="mailto:josephfmj@gmail.com"> Joseph Alexander Rubio Tapias</a>
* @version 1.0
* 
*/
@Configuration
public class RedisKeyspaceConfiguration extends KeyspaceConfiguration {
	
	private long timeTolive;
	
	private KeyspaceSettings keyspaceSettings;
	
	@Override
	protected Iterable<KeyspaceSettings> initialConfiguration() {
		keyspaceSettings = new KeyspaceSettings(OperationContext.class,OperationContext.class.getName());
		keyspaceSettings.setTimeToLive(timeTolive);
		return Collections.singleton(keyspaceSettings);
	}

	public long getTimeTolive() {
		return timeTolive;
	}

	public void setTimeTolive(long timeTolive) {
		this.timeTolive = timeTolive;
	}
	
}