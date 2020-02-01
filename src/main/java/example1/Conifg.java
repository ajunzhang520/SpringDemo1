package example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conifg {
	
	@Bean(name="ConifgBean")
	public CompactDisc setCompactDisc(){
		return new SgtPeppersNew();
	}

}
