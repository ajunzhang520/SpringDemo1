package example3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import example3.one.Fruit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class FruitTest {
	
	@Autowired
	private Fruit fruit;
	
	@Test
	public void test(){
		fruit.fruitName();
	}

}
