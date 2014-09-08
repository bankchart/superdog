public abstract class GeneralDog {
	private int hp;
	private int height;
	private int weight;
	private String name;
	private	String sex;
	private String breed;
	private String hair;
	private String eye;
	private FirePower firePower;
	private IcePower icePower;
	private BitePower bitePower;
	private HitPower hitPower;

	public abstract String run();
	public abstract String walk();
	public abstract String bark(); 
	public abstract String jump();
	public abstract String eat();
	public abstract String sleep();
	public abstract String wakeUp();
	public abstract String fawning();
	public abstract String defecate();
	public abstract String urinate();
	public abstract String[] getListAttack();
		
	public FirePower getFireDetail(){
		return firePower;
	}
	public IcePower getIceDetail(){
		return icePower;
	}
	public BitePower getBiteDetail(){
		return bitePower;
	}
	public HitPower getHitDetail(){
		return hitPower;
	}	
	public void setFirePower(FirePower f){
		firePower = f;
	}
	public void setIcePower(IcePower i){
		icePower = i;
	}
	public void setBitePower(BitePower b){
		bitePower = b;
	}
	public void setHitPower(HitPower h){
		hitPower = h;
	}
	public String performFire(){
		return firePower.fire();
	}
	public String performIce(){
		return icePower.ice();	
	}
	public String performBite(){
		return bitePower.bite();
	}
	public String performHit(){
		return hitPower.hit();
	}
	
	public void setHP(int hp){
		this.hp = hp;
	}
	public int getHP(){
		return hp;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public int getHeight(){
		return height;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
	public int getWeight(){	
		return weight;
	}
	public void setName(String name){
		this.name = name;
	}	
	public String getName(){
		return name;
	}
	public void setSex(String sex){
		this.sex = sex;	
	}
	public String getSex(){
		return sex;
	}
	public void setBreed(String breed){
		this.breed = breed;
	}
	public String getBreed(){
		return breed;
	}
	public void setHair(String hair){
		this.hair = hair;
	}
	public String getHair(){
		return hair;
	}
	public void setEye(String eye){
		this.eye = eye;
	}
	public String getEye(){
		return eye;	
	}
}
