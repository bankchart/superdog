public class IceDog extends GeneralDog {
 	private String[] listAttack;	
	public IceDog(/*int hp, int height, int weight, String sex, String breed, String hair, String eye*/){
		setName("kaew jaa");
                setHP(100);
                setHeight(20);
                setWeight(18);
                setSex("male");
                setBreed("IceDog");
                setHair("medium and gray-white be shag");
                setEye("dark brown");

                listAttack = new String[2];                             
                listAttack[0] = "ice";
                listAttack[1] = "bite";                  
                setIcePower(new IceAttack(32));
                setBitePower(new BiteAttack(10));
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

