import java.util.Scanner;
public class Dog_UI {
	private Scanner input;	
	private PitbullTerrier apb;	
	private BangKaew bk;
	private ChowChow chw;
	private StBernard sb;
	private Rottweilers rott;	
	private GeneralDog[] dogs;
	private String[] listBehavior = {"run", "walk", "bark", "jump", "eat", "sleep",
					"wake up", "fawning", "defecate", "urinate"};
	public Dog_UI(){
		input = new Scanner(System.in);
		apb = new PitbullTerrier();
		bk = new BangKaew();
		chw = new ChowChow();
		sb = new StBernard();
		rott = new Rottweilers();
	}
	public void actionDog(){
		int select = 0;	
		dogs = new GeneralDog[5];
		dogs[0] = apb;
		dogs[1] = bk;
		dogs[2] = chw;
		dogs[3] = sb;
		dogs[4] = rott;
		while(true){
			String detailTmp = "";
			for(int i=0;i<dogs.length;i++){
				detailTmp += (i + 1) + ".name is " + dogs[i].getName() + "\n"; 
				detailTmp += "  breed is " + dogs[i].getBreed() + "\n"; 	
				detailTmp += "  height is " + dogs[i].getHeight() + " cm.\n";
				detailTmp += "  weight is " + dogs[i].getWeight() + " kg.\n";
				detailTmp += "  hair is " + dogs[i].getHair() + "\n";
				detailTmp += "  eye is " + dogs[i].getEye() + "\n";	
				detailTmp += "  sex is " + dogs[i].getSex() + "\n";
				detailTmp += "  HP is " + dogs[i].getHP() + "\n";
				detailTmp += "  attack detail : ";
				String[]listTemp = dogs[i].getListAttack();
				for(int j=0;j<listTemp.length;j++){
					detailTmp += listTemp[j];
					if(j<listTemp.length-1)
						detailTmp += ", ";
				}	
				if(i == dogs.length - 1)
					detailTmp += "\n\n" + (i + 2) + ".exit";	
				detailTmp += "\n\n";
			}
			
			print(detailTmp);
			select = inputMode(1, dogs.length + 1);	
			if(select == dogs.length + 1){
				exitProgram();		
			}else{
				if(dogs[select - 1].getHP() > 0){
					selectBehavior(select - 1);
				}else{
					println(dogs[select - 1].getName() + " dead.....select again please.");
				}
			}	
		}		
	}
	public boolean counterAttackRandom(int dogAttk, int dogDef){
		int range = dogs[dogDef].getListAttack().length;	
		int attk = (int)(Math.random()*range);
		int result = 0, damage = 0;	
		String attkTmp = "";
		switch(dogs[dogDef].getListAttack()[attk]){
			case "fire": damage = dogs[dogDef].getFireDetail().getFireDamage();
					attkTmp = dogs[dogDef].performFire();
				break;
			case "ice": damage = dogs[dogDef].getIceDetail().getIceDamage();
					attkTmp = dogs[dogDef].performIce();
				break;
			case "bite": damage = dogs[dogDef].getBiteDetail().getBiteDamage();
					attkTmp = dogs[dogDef].performBite();
				break;
			case "hit": damage = dogs[dogDef].getHitDetail().getHitDamage();
					attkTmp = dogs[dogDef].performHit();
				break;
		}
		result = dogs[dogAttk].getHP() - damage;
		println(dogs[dogDef].getName() + " counterattrack " + dogs[dogAttk].getName() +
               			          " with " +  attkTmp + " effect : -" + damage);
		if(result < 0){
			result = 0;	
			dogs[dogAttk].setHP(result);
			println(dogs[dogAttk].getName() + " dead.....");
			return false;	
		}else{	
			dogs[dogAttk].setHP(result);	
			println(dogs[dogAttk].getName() + " HP Remain : " + dogs[dogAttk].getHP());
		}
		return true;
	}
	public boolean fightMode(int dog){
		int select = 0;	
		int selAttk = 0;	
		int damage = 0;
		boolean isLife = true;	
		while(true){
			int realNo[] = new int[4];
			int no = 1;	
			for(int i=0;i<dogs.length;i++){
				if(!dogs[dog].getName().equals(dogs[i].getName())){
					println(no + ".Name : " + dogs[i].getName());	
					println("  HP : " + dogs[i].getHP());
					println("  Height : " + dogs[i].getHeight());
					println("  Weight : " + dogs[i].getWeight());
					println("  Breed : " + dogs[i].getBreed());
					println("  Sex : " + dogs[i].getSex());	
					realNo[no - 1] = i;
					no++;
				}
			}
			println(dogs.length + ".undo");
			select = inputMode(1, dogs.length);
			if(select != dogs.length && dogs[realNo[select - 1]].getHP() <= 0){
				println(dogs[realNo[select - 1]].getName() + " dead.....");
				println("select fight match again please.");	
				continue;
			}	
			if(select == dogs.length)
				break;
			else{
				String[] listTmp = dogs[dog].getListAttack();
				for(int i=0;i<listTmp.length;i++){
					println((i + 1) + "." + listTmp[i]);
				}		
				selAttk = inputMode(1, listTmp.length);
				
				switch(listTmp[selAttk -1]){
					case "fire":
							println("\n" + dogs[dog].getName() +
							 " attack " + dogs[realNo[select - 1]].getName()
							 + " with " + dogs[dog].performFire() + 
							" effect : -" + dogs[dog].getFireDetail().getFireDamage());
							damage = dogs[dog].getFireDetail().getFireDamage();				
						break;
					case "ice":
                                                        println("\n" + dogs[dog].getName() +
                                                         " attack " + dogs[realNo[select - 1]].getName()
                                                         + " with " + dogs[dog].performIce() + 
                                                        " effect : -" + dogs[dog].getIceDetail().getIceDamage());
                                                        damage = dogs[dog].getIceDetail().getIceDamage();							
						break;
					case "bite":
                                                        println("\n" + dogs[dog].getName() +
                                                         " attack " + dogs[realNo[select - 1]].getName()
                                                         + " with " + dogs[dog].performBite() + 
                                                        " effect : -" + dogs[dog].getBiteDetail().getBiteDamage());
                                                        damage = dogs[dog].getBiteDetail().getBiteDamage();
						break;
					case "hit":
                                                        println("\n" + dogs[dog].getName() +
                                                         " attack " + dogs[realNo[select - 1]].getName()
                                                         + " with " + dogs[dog].performHit() + 
                                                        " effect : -" + dogs[dog].getHitDetail().getHitDamage());
                                                        damage = dogs[dog].getHitDetail().getHitDamage();
						break;			
				}	
				
			}
			int hpTmp = dogs[realNo[select - 1]].getHP() - damage;
			if(hpTmp < 0)
				hpTmp = 0;	
			dogs[realNo[select - 1]].setHP(hpTmp);
			println(dogs[realNo[select - 1]].getName() + " HP Remain : " + dogs[realNo[select - 1]].getHP());
			if(hpTmp > 0){
				isLife = counterAttackRandom(dog, realNo[select - 1]);
			}else{
				println(dogs[realNo[select - 1]].getName() + " dead.....");
			}	
			println("");
			if(!isLife) 
				break;
		}	
		return isLife;	
	}
	public void selectBehavior(int dog){
		int select = 0;
		boolean isLife = true;
		while(true){
			String detailTmp = "";
			println("name is " + dogs[dog].getName() + " [breed is " + dogs[dog].getBreed()  + "]");	
			for(int i=0;i<listBehavior.length + 1;i++){
				if(i < listBehavior.length){
					detailTmp += (i + 1) + "." + listBehavior[i] + "\n";
				}else{
					detailTmp += (i + 1) + ".fight\n";
					detailTmp += (i + 2) + ".undo";
				}
			}	
			println(detailTmp);
			select = inputMode(1, listBehavior.length + 2);
			if(select < listBehavior.length + 2){		
			println("====================================");
			switch(select){
				case 1:
					println(dogs[dog].run()); 
					break;
				case 2:
					println(dogs[dog].walk());
					break;
				case 3: 
					println(dogs[dog].bark());
					break;
				case 4:
					println(dogs[dog].jump());
					break;
				case 5:
					println(dogs[dog].eat());
					break;
				case 6:
					println(dogs[dog].sleep());
					break;
				case 7:
					println(dogs[dog].wakeUp());
					break;
				case 8:
					println(dogs[dog].fawning());
					break;
				case 9:
					println(dogs[dog].defecate());
					break;
				case 10: 
					println(dogs[dog].urinate());
					break;
				case 11:
					println(">>>select match [" + dogs[dog].getName() + " | " + dogs[dog].getBreed() + "]<<<");
					isLife = fightMode(dog);	
					break;
			}	
			println("====================================");
			}else{
				break;
			}
			if(!isLife)
				break;
		}
	}
	public void startProgram(){
		println("1.start a dog life");
		println("2.exit");
		if(inputMode(1, 2) == 2)
			exitProgram();		
	}
	public void exitProgram(){
		println("\n>>>> BYE <<<<\n");
		System.exit(0);
	}	
	public boolean isNumber(String tmp){
		try{
			Integer.parseInt(tmp);
		}catch(Exception ex){
			return false;
		}
		return true;
	}
	public int inputMode(int begin, int end){
		int select = 0;
		String str = "";		
		while(true){
			print("select : ");
			str = input.nextLine();
			if(isNumber(str)){
				select = Integer.parseInt(str);
				if(select < begin || select > end){
					println("*****your select without of range*****");
				}else{
					break;	
				}	
			}else{
				println("*****your select isn't number*****");	
			}
		}		
		return select;
	}
	public void print(String str){
		System.out.print(str);
	}
	public void println(String str){
		System.out.println(str);
	}
}
