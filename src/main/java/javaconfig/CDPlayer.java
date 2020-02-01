package javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:往CDPlayer类里通过Autowired注解注入一个CompactDisc实例
 * @author zsj
 * @date 2017年4月8日 下午5:08:57
 */
@Component
public class CDPlayer implements MediaPlay{
	
	private CompactDisc cd;
	
	@Autowired
	public CDPlayer(CompactDisc cd){
		this.cd = cd;
	}

	public void goodPlay(){
		System.out.println("位于CDPlyer类下面");
		cd.play();
	}
}
