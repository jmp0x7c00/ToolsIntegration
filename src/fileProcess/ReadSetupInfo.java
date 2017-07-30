package fileProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadSetupInfo {
	private String gautPath;
	private String prismPath;
	public String getGautPath() {
		return gautPath;
	}
	public void setGautPath(String gautPath) {
		this.gautPath = gautPath;
	}
	public String getPrismPath() {
		return prismPath;
	}
	public void setPrismPath(String prismPath) {
		this.prismPath = prismPath;
	}
	public ReadSetupInfo() {
		File file=new File(constants.configFile.PATH);
		if(!file.exists()){
			System.out.println("not exist");
		}
		try {
			FileInputStream fis=new FileInputStream(file);
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			String tempstr=null;
			 try {
				/*while((tempstr=br.readLine())!=null){
					 System.out.println(tempstr);
				 }*/
				 tempstr=br.readLine();
				 if(tempstr!=null)this.gautPath=tempstr;
				 tempstr=br.readLine();
				 if(tempstr!=null)this.prismPath=tempstr;
				 br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
