public class Rottweilers extends GeneralDog {
	private String[] listAttack;
       	public Rottweilers(/*int hp, int height, int weight, String sex, String breed, String hair, String eye*/){
		setName("coco");
                setHP(100);
                setHeight(69);
                setWeight(59);
                setSex("male");
                setBreed("Rottweilers");
                setHair("short and black be shiny");
                setEye("brown");

                listAttack = new String[2];                             
                listAttack[0] = "bite";
                listAttack[1] = "hit";                  
                setBitePower(new BiteAttack(35));
                setHitPower(new HitAttack(14));
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

