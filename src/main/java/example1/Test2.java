package example1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Conifg.class)
public class Test2 {
	
	@Autowired
	@Qualifier("ConifgBean")
	private CompactDisc cd;
	
	
	@Test
	public void test(){
		Assert.assertNotNull(cd);
		cd.play();
	}
	

}
