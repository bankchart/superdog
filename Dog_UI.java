import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

// import -- servlet
public class Dog_UI extends HttpServlet {
	Logger log = Logger.getLogger(Dog_UI.class.getName());	


	private DogThread apdThread, idThread, fdThread, sbThread, rottThread;
	private boolean fightBusy = false;
	private String updateData = "";	

	private Scanner input;	
	private PitbullTerrier apb;	
	private IceDog id;
	private FireyerDog fd;
	private StBernard sb;
	private Rottweilers rott;	
	private GeneralDog[] dogs;
	private Date date;
	private SimpleDateFormat dateFormat;
	private PutToFile putFile;
	private String[] listBehavior = {"run", "walk", "bark", "jump", "eat", "sleep",
					"wake up", "fawning", "defecate", "urinate"};

	public void init() throws ServletException{
                input = new Scanner(System.in);

		apb = new PitbullTerrier();
                apb.setActionTime(2);

                id = new IceDog();
                id.setActionTime(4);

                fd = new FireyerDog();
                fd.setActionTime(6);

                sb = new StBernard();
                sb.setActionTime(8);

                rott = new Rottweilers();
                rott.setActionTime(10);

                dogs = new GeneralDog[5];
                dogs[0] = apb;
                dogs[1] = id;
                dogs[2] = fd;
                dogs[3] = sb;
                dogs[4] = rott;

                date = new Date();
                putFile = new PutToFile("Super Dog History");
                putFile.isExistFile();
                putFile.appendData(true);
                dateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a");
                putFile.writeData(dateFormat.format(date) + "\n");

                apdThread = new DogThread(apb);
                apdThread.start();
                idThread = new DogThread(id);
                idThread.start();
                fdThread = new DogThread(fd);
                fdThread.start();
                sbThread = new DogThread(sb);
                sbThread.start();
                rottThread = new DogThread(rott);

	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();		
		out.println(updateData);	
	}
	public class DogThread extends Thread {
		public GeneralDog dogTmp;	
		public DogThread(){}

		public DogThread(GeneralDog tmp){
			dogTmp = tmp;
		}
		@Override	
		public void run(){
			actionDog(dogTmp);		
		}
	

	public void actionDog(GeneralDog dog){
		while(true){
			selectBehavior(dog);	
			
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
		updateData += println(dogs[dogDef].getName() + " counterattrack " + dogs[dogAttk].getName() +
               			          " with " +  attkTmp + " effect : -" + damage);
		if(result < 0){
			result = 0;	
			dogs[dogAttk].setHP(result);
			updateData += println(dogs[dogAttk].getName() + " dead.....");
			return false;	
		}else{	
			dogs[dogAttk].setHP(result);	
			updateData += println(dogs[dogAttk].getName() + " HP Remain : " + dogs[dogAttk].getHP());
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
					updateData += println(no + ".Name : " + dogs[i].getName());	
					updateData += println("  HP : " + dogs[i].getHP());
					updateData += println("  Height : " + dogs[i].getHeight());
					updateData += println("  Weight : " + dogs[i].getWeight());
					updateData += println("  Breed : " + dogs[i].getBreed());
					updateData += println("  Sex : " + dogs[i].getSex());	
					realNo[no - 1] = i;
					no++;
				}
			}
			updateData += println(dogs.length + ".undo");
			select = inputMode(1, dogs.length);
			if(select != dogs.length && dogs[realNo[select - 1]].getHP() <= 0){
				updateData += println(dogs[realNo[select - 1]].getName() + " dead.....");
				updateData += println("select fight match again please. \n[enter to continue]");	
				input.nextLine();
				continue;
			}	
			if(select == dogs.length)
				return true;
			else{
				
				String[] listTmp = dogs[dog].getListAttack();
		//		for(int i=0;i<listTmp.length;i++){
		//			updateData += println((i + 1) + "." + listTmp[i]);
		//		}		
			//	selAttk = inputMode(1, listTmp.length);
			while(true){	
				selAttk = (int)(Math.random()*listTmp.length + 1 );
				switch(listTmp[selAttk -1]){
					case "fire":
							updateData += println("\n" + dogs[dog].getName() +
							 " attack " + dogs[realNo[select - 1]].getName()
							 + " with " + dogs[dog].performFire() + 
							" effect : -" + dogs[dog].getFireDetail().getFireDamage());
							damage = dogs[dog].getFireDetail().getFireDamage();				
						break;
					case "ice":
                                                        updateData += println("\n" + dogs[dog].getName() +
                                                         " attack " + dogs[realNo[select - 1]].getName()
                                                         + " with " + dogs[dog].performIce() + 
                                                        " effect : -" + dogs[dog].getIceDetail().getIceDamage());
                                                        damage = dogs[dog].getIceDetail().getIceDamage();							
						break;
					case "bite":
                                                        updateData += println("\n" + dogs[dog].getName() +
                                                         " attack " + dogs[realNo[select - 1]].getName()
                                                         + " with " + dogs[dog].performBite() + 
                                                        " effect : -" + dogs[dog].getBiteDetail().getBiteDamage());
                                                        damage = dogs[dog].getBiteDetail().getBiteDamage();
						break;
					case "hit":
                                                        updateData += println("\n" + dogs[dog].getName() +
                                                         " attack " + dogs[realNo[select - 1]].getName()
                                                         + " with " + dogs[dog].performHit() + 
                                                        " effect : -" + dogs[dog].getHitDetail().getHitDamage());
                                                        damage = dogs[dog].getHitDetail().getHitDamage();
						break;			
				}	
                        int hpTmp = dogs[realNo[select - 1]].getHP() - damage;
                        if(hpTmp < 0)
                                hpTmp = 0;    
                        dogs[realNo[select - 1]].setHP(hpTmp);
                        updateData += println(dogs[realNo[select - 1]].getName() + " HP Remain : " + dogs[realNo[select - 1]].getHP());
                        if(hpTmp > 0){ 
                                isLife = counterAttackRandom(dog, realNo[select - 1]);
                        }else{
                                updateData += println(dogs[realNo[select - 1]].getName() + " dead..... ");
				//input.nextLine();
                       		isLife = false; 
			}    
                        updateData += println("");
                        if(!isLife) 
                                break;
			}// end inside while
			} // endif
	/*		int hpTmp = dogs[realNo[select - 1]].getHP() - damage;
			if(hpTmp < 0)
				hpTmp = 0;	
			dogs[realNo[select - 1]].setHP(hpTmp);
			updateData += println(dogs[realNo[select - 1]].getName() + " HP Remain : " + dogs[realNo[select - 1]].getHP());
			if(hpTmp > 0){
				isLife = counterAttackRandom(dog, realNo[select - 1]);
			}else{
				updateData += println(dogs[realNo[select - 1]].getName() + " dead.....");
			}	
			updateData += println("");
			if(!isLife) 
				break;
	*/
			if(!isLife)
				break;	
		}	
		return isLife;	
	}
	public void selectBehavior(GeneralDog dog){
		int select = 0;
		boolean isLife = true;
		while(true){
			 try{
                                Thread.sleep(dog.getActionTime() * 1000);
                        }catch(InterruptedException ex){
                                updateData += println(ex.toString());
                        }
			/*
			String detailTmp = "";
			updateData += println("name is " + dogs[dog].getName() + " [breed is " + dogs[dog].getBreed()  + "]");	
			for(int i=0;i<listBehavior.length + 1;i++){
				if(i < listBehavior.length){
					detailTmp += (i + 1) + "." + listBehavior[i] + "\n";
				}else{
					detailTmp += (i + 1) + ".fight\n";
					detailTmp += (i + 2) + ".undo";
				}
			}	
			updateData += println(detailTmp);
			select = inputMode(1, listBehavior.length + 2);
			*/
			//if(select < listBehavior.length + 2){		
			select = (int)(Math.random()*listBehavior.length + 1);
			switch(select){
				case 1:
					updateData = println("name is " + dog.getName() + " >>> "  + dog.run())  + updateData; 
					break;
				case 2:
					updateData = println("name is " + dog.getName() + " >>> "  + dog.walk()) + updateData;
					break;
				case 3: 
					updateData = println("name is " + dog.getName() + " >>> "  + dog.bark())  + updateData;
					break;
				case 4:
					updateData = println("name is " + dog.getName() + " >>> "  + dog.jump()) + updateData;
					break;
				case 5:
					updateData = println("name is " + dog.getName() + " >>> "  + dog.eat()) + updateData;
					break; 
				case 6:
					updateData = println("name is " + dog.getName() + " >>> "  + dog.sleep()) + updateData;
					break;
				case 7:
					updateData = println("name is " + dog.getName() + " >>> "  + dog.wakeUp()) + updateData;
					break;
				case 8:
					updateData = println("name is " + dog.getName() + " >>> "  + dog.fawning()) + updateData;
					break;
				case 9:
					updateData = println("name is " + dog.getName() + " >>> "  + dog.defecate()) + updateData;
					break;
				case 10: 
					updateData = println("name is " + dog.getName() + " >>> "  + dog.urinate()) + updateData;
					break;
				case 11:
					updateData += println("name is " + dog.getName() + " >>> FIGHTING MODE !!!");
					isLife = fightMode(dog);	
					break;
			}	
			//	if(!isLife){
			//		updateData += print("\n[enter to continue]");	
			//		input.nextLine();	
			//	}
		//	}else{
		//		break;
		//	}
			if(!isLife)
				break;
		}
	}
	public void startProgram(){
		updateData += println("1.start a dog life");
		updateData += println("2.exit");
		if(inputMode(1, 2) == 2)
			exitProgram();		
	}
	public void exitProgram(){
		updateData += println("\n>>>> BYE <<<<\n");
		putFile.fileClose();
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
			updateData += println("select : ");
			str = input.nextLine();
			putFile.writeData(str + "\n");
			log.info(str);	
			if(isNumber(str)){
				select = Integer.parseInt(str);
				if(select < begin || select > end){
					updateData += println("*****your select without of range*****");
				}else{
					break;	
				}	
			}else{
				updateData += println("*****your select isn't number*****");	
			}
		}	
		return select;
	}
	public String print(String str){
		System.out.print(str);
		putFile.writeData(str);
		log.info(str);
		return str;
	}
	public String println(String str){
		System.out.println(str);
		putFile.writeData(str);
		log.info(str);	
		return str + "<br/>";
	}
	public void putToFile(String str){
		try{	
			File file = new File("Super Dog history");	
			if(!file.exists()){
				file.createNewFile();	
			}
			// true for append
			FileWriter fileWriter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			//if(!keyAppend)
				str += "\n";
			bufferWriter.write(str);	
			bufferWriter.close();
		}catch(IOException ex){
			updateData += println(ex.toString());
		}
	}
}// End DogThread
}
