package example2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses={CDPlayer.class})
public class CDPlayerConfig {
	
	/*@Bean
	public CompactDisc sgtPeppers(){
		return new SgtPeppersNew();
	}
	
	@Bean(name="cdPlayer")
	public CDPlayer cdPlayer(){
		return new CDPlayer(sgtPeppers());
	}
	
	@Bean
	public CDPlayer anotherCDPlayer(){
		return new CDPlayer(sgtPeppers());
	}*/
}
