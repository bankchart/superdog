public class FireAttack implements FirePower {
	private int fireDamage;
	public FireAttack(int fireDamage){
		this.fireDamage = fireDamage;
	}
	public String fire(){
		return "FIRE ATTACK !!!";
	}
	public int getFireDamage(){
		return fireDamage;
	}
}
