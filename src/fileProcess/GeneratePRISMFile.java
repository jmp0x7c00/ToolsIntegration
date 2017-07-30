package fileProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GeneratePRISMFile {

	public GeneratePRISMFile(String a,String m,String c,String i) throws IOException{
		File file1=new File(constants.configFile.PRIRMFILE_BK);
		File file2=new File(constants.configFile.PRISMFILE);
		if(!file1.exists()){
			System.out.println("not exist");
		}
		if(!file2.exists()){
			System.out.println("not exist");
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos=new FileOutputStream(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
		try {
			for (String line = br.readLine(); line != null; line = br.readLine()) {  
			    line=line.replaceAll("VALUE_OF_A", a);
			    line=line.replaceAll("VALUE_OF_M", m);
			    line=line.replaceAll("VALUE_OF_C", c);
			    line=line.replaceAll("VALUE_OF_I", i);
			    bw.write(line);
			    bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		bw.close();
		fis.close();
	}
	
}
