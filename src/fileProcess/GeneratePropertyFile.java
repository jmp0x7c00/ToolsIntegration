package fileProcess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GeneratePropertyFile {
	private String property;

	public GeneratePropertyFile(String property) throws IOException {
		this.property = property;
		File file=new File(constants.configFile.PROPERTY);
		if(!file.exists()){
			System.out.println("not exist");
			try {
				throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileOutputStream fos = null;
		try {
			fos=new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
		 bw.write(property);
		 bw.close();
	}
	
	
}
