import org.junit.Test;
public class GeneralDog_Test extends GeneralDog {
	String[] listAttack;
	@Test
	public void test(){
                setName("coco_junit_test");
                setHP(100);
                setHeight(70);
                setWeight(100);
                setSex("male");
                setBreed("junit breed");
                setHair("medium and brown-white be spotted");
                setEye("dark brown");

                listAttack = new String[1];
                listAttack[0] = "bite";
                setBitePower(new BiteAttack(15));
	
	}
	public GeneralDog_Test(){
		test();
	}
	@Override
	public String run(){
		return "It's run.";
	}
	@Override
	public String walk(){
		return "It's walk.";
	}
	@Override	
	public String bark(){
		return "It's bark.";	
	}
	@Override
	public String jump(){
		return "It's jump.";	
	}	
	@Override
	public String eat(){
		return "It's eat.";
	}
	@Override
	public String sleep(){
		return "It's sleep.";
	}
	@Override
	public String wakeUp(){
		return "It's wakeup.";
	}
	@Override
	public String fawning(){
		return "It's fawning.";
	}
	@Override
	public String defecate(){
		return "It's defecate.";
	}
	@Override
	public String urinate(){
		return "It's urinate";
	}
	@Override
	public String[] getListAttack(){
		return listAttack;	
	}
}
