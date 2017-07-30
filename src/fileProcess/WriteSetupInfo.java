package fileProcess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteSetupInfo {
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
	public WriteSetupInfo(String gautPath,String prismPath) {
		File file=new File(constants.configFile.PATH);
		if(!file.exists()){
			try {
				throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream fos=new FileOutputStream(file);
			byte gautBytes[]=gautPath.getBytes();
			byte prismBytes[]=prismPath.getBytes();
			byte[] newline="\r\n".getBytes();
			try {
				fos.write(gautBytes,0,gautBytes.length);
				fos.write(newline);
				fos.write(prismBytes);
				fos.close();
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
