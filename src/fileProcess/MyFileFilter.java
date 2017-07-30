package fileProcess;

import java.io.File;
import java.util.ArrayList;

public class MyFileFilter extends javax.swing.filechooser.FileFilter{
	
	private ArrayList<String> suffixList;
	
	public ArrayList<String> getSuffixList() {
		return suffixList;
	}

	public void setSuffixList(ArrayList<String> suffixList) {
		this.suffixList = suffixList;
	}

	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		if (f.isDirectory())return true;
	    if(suffixList!=null){
	    	int i=0;
	    	for(;i<suffixList.size();i++){
	    		if(f.getName().endsWith(suffixList.get(i)))return true;
	    	}
	    	return false;
	    }
	    return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String description="";
		int i=0;
		for(;i<suffixList.size()-1;i++){
			description=description+suffixList.get(i)+",";
		}
		description=description+suffixList.get(suffixList.size()-1);
		return description;
	}

}
