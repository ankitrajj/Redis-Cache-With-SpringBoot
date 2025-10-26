package in.ankit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.ankit.bind.Users;

@Configuration
public class UserConfig {
     
	@Bean
	public JedisConnectionFactory getConnection( ) {
		JedisConnectionFactory factory = new JedisConnectionFactory();
	//	factory.setHostName(null);
	//	factory.setPassword(null);
	//	factory.setPort(0);		
		return factory;
	}
	
	@Bean
	@Primary
	public RedisTemplate<String, in.ankit.bind.Users> getRedisTemplate(JedisConnectionFactory factory){		
		RedisTemplate<String, Users> rt = new RedisTemplate<>();
		rt.setConnectionFactory(factory);
		return rt;
	}
}
