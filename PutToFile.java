import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class PutToFile {
	private File file;
	private FileWriter fileWriter;
	private BufferedWriter buf;
	private String fileName;	

	public PutToFile(){}
	public PutToFile(String fileName){
		this.fileName = fileName;
		file = new File(fileName);
	}
	public void setFileName(String fileName){
		this.fileName = fileName;
		file = new File(fileName);
	}
	public void isExistFile() {
		if(!file.exists()){
			try{
			file.createNewFile();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}	
	public void appendData(boolean w){
		try{
		fileWriter = new FileWriter(file.getName(), w);
		buf = new BufferedWriter(fileWriter);
		}catch(IOException ex){
			ex.printStackTrace();	
		}
	}	
	public void writeData(String data){
		try{
			buf.write(data + "\n");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	} 
	public void fileClose(){
		try{
			buf.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}	
	}
}
