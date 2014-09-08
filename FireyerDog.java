public class FireyerDog  extends GeneralDog {
	private String[] listAttack;
       	public FireyerDog(/*int hp, int height, int weight, String sex, String breed, String hair, String eye*/){
		setName("domita");
                setHP(100);
                setHeight(51);
                setWeight(27);
                setSex("male");
                setBreed("FireyerDog");
                setHair("long and orange-brown be shag");
                setEye("dark brown");

                listAttack = new String[2];                             
                listAttack[0] = "fire";                  
		listAttack[1] = "hit";
                setFirePower(new FireAttack(30));
		setHitPower(new HitAttack(12));
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

