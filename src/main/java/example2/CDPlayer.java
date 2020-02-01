package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlay{
	@Autowired
	private CompactDisc cd;
	
	/*@Autowired
	public CDPlayer(CompactDisc cd){
		this.cd = cd;
	}
	
	@Autowired
	public void setCompactDisc(CompactDisc cd){
		this.cd = cd;
	}*/

	public void goodPlay(){
		System.out.println("位于CDPlayer类下面");
		cd.play();
	}
}
