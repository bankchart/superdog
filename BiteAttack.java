public class BiteAttack implements BitePower {
	private int biteDamage;
	public BiteAttack(int biteDamage){
		this.biteDamage = biteDamage;
	}
	public String bite(){
		return "BITE ATTACK !!!";
	}
	public int getBiteDamage(){
		return biteDamage;	
	}
}
