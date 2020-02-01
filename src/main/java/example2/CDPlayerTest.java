package example2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private MediaPlay mp;
	
	@Test
	public void test1(){
		Assert.assertNotNull(cd);
	}
	
	@Test
	public void test2(){
		Assert.assertNotNull(mp);
	}
	
	@Test
	public void play1(){
		cd.play();
		System.out.println("我是分割线+++++++++++++++++++++++++++++++++++++++我是分割线");
		mp.goodPlay();
	}
}
