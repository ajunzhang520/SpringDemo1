package example3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import example3.one.Fruit;
import example3.two.Apple;

@Configuration
@ComponentScan(basePackages="example3")
public class Config {
	
	@Bean
	public Fruit setFruit(){
		return new Apple();
	}

}
