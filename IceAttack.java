public class IceAttack implements IcePower {
	private int iceDamage;
	public IceAttack(int iceDamage){
		this.iceDamage = iceDamage;
	}
	public String ice(){
		return "ICE ATTACK !!!";
	}
	public int getIceDamage(){
		return iceDamage;
	}
}
