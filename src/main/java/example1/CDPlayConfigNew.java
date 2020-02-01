package example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayConfigNew {
	
	@Bean
	public CompactDisc sgtPeppers(){
		return new SgtPeppersNew();
	}
	
	@Bean(name="cdPlayer")
	public CDPlayer cdPlayer(){
		return new CDPlayer(sgtPeppers());
	}
	
	@Bean(name="anothercdPlayer")
	public CDPlayer anotherCDPlayer(){
		return new CDPlayer(sgtPeppers());
	}
	
	@Bean(name="thirdcdPlayer")
	public CDPlayer thirdCDPlayer(CompactDisc cd){
		return new CDPlayer(cd);
	}
	
	

}
