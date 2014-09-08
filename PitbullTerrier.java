public class PitbullTerrier extends GeneralDog {
     	private String[] listAttack; 
	public PitbullTerrier(/*int hp, int height, int weight, String sex, String breed, String hair, String eye*/){	
		setName("jack");
		setHP(100);
		setHeight(20);
		setWeight(16);
		setSex("female");
		setBreed("American Pit Bull Terrier");
		setHair("short and brown-white be spotted");
		setEye("amber");	
				
		listAttack = new String[1];
		listAttack[0] = "bite";
		setBitePower(new BiteAttack(21));
	}	 
	public String run(){
		return "It's run.";
	}
        public String walk(){
		return "It's walk.";
	}
        public String bark(){
		return "It's bark.";
	}
        public String jump(){
		return "It's jump.";
	}
        public String eat(){
		return "It's eat.";
	}
        public String sleep(){
		return "It's sleep.";
	}
	public String wakeUp(){
		return "It's wake up.";
	}
        public String fawning(){
		return "It's fawning.";
	}
        public String defecate(){
		return "It's defecate.";
	}
        public String urinate(){
		return "It's urinate.";
	}
	public String[] getListAttack(){
		return listAttack;
	}
}
