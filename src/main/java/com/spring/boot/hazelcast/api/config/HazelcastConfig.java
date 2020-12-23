package com.spring.boot.hazelcast.api.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;

@Configuration
public class HazelcastConfig {
	
	@Bean
	public Config getHazelConfig() {
		return new Config("hazelcast-instance").addMapConfig(new MapConfig().setName("employees-cache").setTimeToLiveSeconds(600).setEvictionConfig(new EvictionConfig().setEvictionPolicy(EvictionPolicy.LRU).setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)));
	}
	

}
