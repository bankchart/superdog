import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class MyTestUnit{
	private ADog d = new ADog();
	private Doctor dt = new Doctor();
	@Test
	public void createNameDog(){
		d.setName("coco");	
		d.setHealth("health is very good");
		dogGoToDoctor();
	}
	//@Test
	public void dogGoToDoctor(){
		//d.setName("coco");
		//d.setHealth("xxx");
		String x = dt.checkHealth(d);	
		System.out.println(x);
	}
}

