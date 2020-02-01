package example4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Loader.class)
public class LoaderTest {
	
	@Test
	public void test1(){
		System.out.println("test");
		
	}
	

}
