public class HitAttack implements HitPower {
	private int hitDamage;
	public HitAttack(int hitDamage){
		this.hitDamage = hitDamage;
	}
	public String hit(){
		return "HIT ATTACK !!!";
	}
	public int getHitDamage(){
		return hitDamage;	
	}
} 
