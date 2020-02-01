package javaconfig;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayConfig.class)
public class CDPlayerTest {

	@Autowired
	private MediaPlay mp;
	
	@Autowired
	private CompactDisc cd;
	
	@Test
	public void test1(){
		Assert.assertNotNull(mp);
	}
	
	@Test
	public void test2(){
		Assert.assertNotNull(cd);
	}
	
	@Test
	public void play(){
		mp.goodPlay();
		System.out.println("我是分割线+++++++++++++++++++++++++++++++");
		cd.play();
	}
}
