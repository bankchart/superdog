public class Doctor {
	public String checkHealth(ADog dog){
		String tmp = dog.getHealth();
		if(tmp.equals("health is very good"))
			return dog.getName() + " very good.";
		else
			return dog.getName() + " very bad.";
	}
}
