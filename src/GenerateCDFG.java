import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

import fileProcess.MyFileFilter;
import fileProcess.ReadSetupInfo;


public class GenerateCDFG extends JFrame implements ActionListener{
	private JPanel jPanel1,jPanel2,jPanel3;
	private JLabel jLabel1,jLabel2,jLabel3;
	private JFileChooser jFileChooser;
	private JTextArea jTextArea;
	private JTextField jTextField;
	private Font font;
	private Image image;
	private JButton jButton1,jButton2,jButton3;
	private String path;
	private ReadSetupInfo readSetupInfo;
	private String cdfgFileName;
	public GenerateCDFG(){
		font=new Font("微软雅黑", 0, 12);
		UIManager.put("Button.font",font);
		jLabel1=new JLabel("选择文件生成CDFG");
		jLabel1.setFont(new Font("楷体", 1, 15));
		jPanel1=new JPanel();
		jPanel1.add(jLabel1);
		jTextField=new JTextField(10);
		jTextField.setEditable(false);
		jButton1=new JButton("选择");
		jButton1.setBackground(Color.lightGray);
		jButton1.setPreferredSize(new Dimension(30,20));
		jButton1.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton1.addActionListener(this);
		
		jButton2=new JButton("生成");
		jButton2.setBackground(Color.lightGray);
		jButton2.setPreferredSize(new Dimension(30,20));
		jButton2.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton2.addActionListener(this);
		
		
		jButton3=new JButton("查看");
		jButton3.setBackground(Color.lightGray);
		jButton3.setPreferredSize(new Dimension(30,20));
		jButton3.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton3.addActionListener(this);
		//jFileChooser=new JFileChooser();
		//jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//jFileChooser.showDialog(new JLabel(), "选择");
		//File file=jFileChooser.getSelectedFile();
		jPanel2=new JPanel();
		jPanel2.add(jTextField);
		jPanel2.add(jButton1);
		jPanel2.add(jButton2);
		jPanel2.add(jButton3);
		//jPanel1.add(jFileChooser);
		
		
		jTextArea=new JTextArea(20,20);
		jTextArea.setEditable(false);
		jTextArea.setBackground(Color.white);
		jTextArea.setLineWrap(true);
		jPanel3=new JPanel();
		jPanel3.add(new JScrollPane(jTextArea));
		
		this.add(jPanel1);
		this.add(jPanel2);
		this.add(jPanel3);
		this.setLayout(new FlowLayout());
		this.setTitle("设置");
		this.setSize(270,470);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		try {
			 image= ImageIO.read(this.getClass().getResource("/img/1.png"));
			this.setIconImage(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("选择".equals(e.getActionCommand())){
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MyFileFilter myfileFilter=new MyFileFilter();
			ArrayList<String> suffix=new ArrayList<String>();
			suffix.add(".c");
			suffix.add(".cpp");
			myfileFilter.setSuffixList(suffix);
			JFileChooser jFileChooser = new JFileChooser(); 
			jFileChooser.setFileFilter(myfileFilter);
			jFileChooser.showOpenDialog(null); 
			File file=jFileChooser.getSelectedFile();
			if(file!=null){
				jTextField.setText(file.getPath());
				path=file.getPath();
				cdfgFileName=(file.getName().split("\\."))[0]+".cdfg";
			}
			
		}
		else if("生成".equals(e.getActionCommand())){
			jTextArea.setText(null);
			readSetupInfo=new ReadSetupInfo();
			if("".equals(jTextField.getText())){
				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>请选择文件</p></html>"), "注意", JOptionPane.WARNING_MESSAGE);
			}else{
					File file=new File(readSetupInfo.getGautPath());
					String cdfgcompilerPath=file.getParent()+"\\GautC\\cdfgcompiler\\bin";
					String cmd="cdfgcompiler.exe -S -c2dfg -O2 "+path;
					Process process = null;
					try {
						process = Runtime.getRuntime().exec(cmd,null,new File(cdfgcompilerPath));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					SequenceInputStream sis = new SequenceInputStream (process.getInputStream (), process.getErrorStream ());
					InputStreamReader isr = null;
					try {
						isr = new InputStreamReader (sis, "gbk");
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					BufferedReader br1 = new BufferedReader (isr);
		            String line = null;
		            int linenum=1;
		            try {
						while (null != ( line = br1.readLine () ))
						{
						        jTextArea.append("["+linenum+"] "+line);
						        jTextArea.append("\r\n");
						        jTextArea.append("\r\n");
						        linenum++;
						 }
						process.destroy ();
			            isr.close ();
			            br1.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		}
		else if("查看".equals(e.getActionCommand())){
			try {
				Runtime.getRuntime().exec("ViewGraph.exe "+cdfgFileName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
