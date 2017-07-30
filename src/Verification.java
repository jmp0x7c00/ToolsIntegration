import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import fileProcess.GeneratePRISMFile;
import fileProcess.GeneratePropertyFile;
import fileProcess.ReadSetupInfo;

//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.SequenceInputStream;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//
//import javax.imageio.ImageIO;
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
//
//import tools.MyFileFilter;
//
//import configurationFile.ReadSetupInfo;
//
//
//public class Verification extends JFrame implements ActionListener{
//	private JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel5;
//	private JLabel jLabel1,jLabel2,jLabel3,jLabel4;
//	private JFileChooser jFileChooser;
//	private JTextArea jTextArea;
//	private JTextField jTextField1,jTextField2;
//	private Font font;
//	private Image image;
//	private JButton jButton1,jButton2,jButton3;
//	private String path1,path2;
//	private ReadSetupInfo readSetupInfo;
//	public Verification() {
//
//		font=new Font("微软雅黑", 0, 12);
//		UIManager.put("Button.font",font);
//		UIManager.put("Label.font",font);
//		jLabel4=new JLabel("PRISM模型验证");
//		jLabel4.setFont(new Font("楷体", 1, 15));
//		jPanel4=new JPanel();
//		jPanel4.add(jLabel4);
//		
//		jLabel1=new JLabel("模型文件:");
//		jTextField1=new JTextField(10);
//		jTextField1.setEditable(false);
//		jButton1=new JButton("选择");
//		jButton1.setBackground(Color.lightGray);
//		jButton1.setPreferredSize(new Dimension(30,20));
//		jButton1.setBorder(BorderFactory.createLineBorder(Color.black));
//		jButton1.addActionListener(this);
//		jButton1.setActionCommand("model");
//		jPanel1=new JPanel();
//		jPanel1.add(jLabel1);
//		jPanel1.add(jTextField1);
//		jPanel1.add(jButton1);
//		
//		
//		jLabel2=new JLabel("特性文件:");
//		jTextField2=new JTextField(10);
//		jTextField2.setEditable(false);
//		jButton2=new JButton("选择");
//		jButton2.setBackground(Color.lightGray);
//		jButton2.setPreferredSize(new Dimension(30,20));
//		jButton2.setBorder(BorderFactory.createLineBorder(Color.black));
//		jButton2.addActionListener(this);
//		jButton2.setActionCommand("property");
//		jPanel2=new JPanel();
//		jPanel2.add(jLabel2);
//		jPanel2.add(jTextField2);
//		jPanel2.add(jButton2);
//		
//		jButton3=new JButton("验证");
//		jButton3.setBackground(Color.lightGray);
//		jButton3.setPreferredSize(new Dimension(200,20));
//		jButton3.setBorder(BorderFactory.createLineBorder(Color.black));
//		jButton3.addActionListener(this);
//		jButton3.setActionCommand("verify");
//		jPanel3=new JPanel();
//		jPanel3.add(jButton3);
//		
//		jTextArea=new JTextArea(18,20);
//		jTextArea.setEditable(false);
//		jTextArea.setBackground(Color.white);
//		jTextArea.setLineWrap(true);
//		jPanel5=new JPanel();
//		jPanel5.add(new JScrollPane(jTextArea));
//		
//		
//		this.add(jPanel4);
//		this.add(jPanel1);
//		this.add(jPanel2);
//		this.add(jPanel3);
//		this.add(jPanel5);
//		this.setLayout(new FlowLayout());
//		this.setTitle("设置");
//		this.setSize(270,470);
//		this.setLocationRelativeTo(null);
//		this.setVisible(true);
//		this.setResizable(false);
//		try {
//			 image= ImageIO.read(this.getClass().getResource("/img/1.png"));
//			this.setIconImage(image);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if("model".equals(e.getActionCommand())){
//			try {
//				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			} catch (ClassNotFoundException | InstantiationException
//					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			MyFileFilter myfileFilter=new MyFileFilter();
//			ArrayList<String> suffix=new ArrayList<String>();
//			suffix.add(".prism");
//			suffix.add(".pm");
//			suffix.add(".nm");
//			suffix.add(".sm");
//			myfileFilter.setSuffixList(suffix);
//			JFileChooser jFileChooser = new JFileChooser(); 
//			jFileChooser.setFileFilter(myfileFilter);
//			jFileChooser.showOpenDialog(null); 
//			File file=jFileChooser.getSelectedFile();
//			if(file!=null){
//				jTextField1.setText(file.getPath());
//				path1=file.getPath();
//			}
//		}
//		
//		else if("property".equals(e.getActionCommand())){
//			try {
//				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			} catch (ClassNotFoundException | InstantiationException
//					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			MyFileFilter myfileFilter=new MyFileFilter();
//			ArrayList<String> suffix=new ArrayList<String>();
//			suffix.add(".props");
//			suffix.add(".pctl");
//			suffix.add(".csl");
//			myfileFilter.setSuffixList(suffix);
//			JFileChooser jFileChooser = new JFileChooser(); 
//			jFileChooser.setFileFilter(myfileFilter);
//			jFileChooser.showOpenDialog(null); 
//			File file=jFileChooser.getSelectedFile();
//			if(file!=null){
//				jTextField2.setText(file.getPath());
//				path2=file.getPath();
//			}
//		}
//		else if("verify".equals(e.getActionCommand())){
//			readSetupInfo=new ReadSetupInfo();
//			if("".equals(jTextField1.getText())){
//				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>请选择模型文件</p></html>"), "注意", JOptionPane.WARNING_MESSAGE);
//			}
//			else if("".equals(jTextField2.getText())){
//				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>请选择特性文件</p></html>"), "注意", JOptionPane.WARNING_MESSAGE);
//			}
//			else{
//				Process process=null;
//				String cmd=readSetupInfo.getPrismPath()+"\\prism.bat "+path1+" "+path2;
//				process = Runtime.getRuntime().exec(cmd,null,new File(readSetupInfo.getPrismPath()));
//				SequenceInputStream sis = new SequenceInputStream (process.getInputStream (), process.getErrorStream ());
//				InputStreamReader isr = null;
//				isr = new InputStreamReader (sis, "gbk");
//				BufferedReader br1 = new BufferedReader (isr);
//	            String line = null;
//	            int linenum=1;
//				while (null != ( line = br1.readLine () ))
//				{
//						        jTextArea.append("["+linenum+"] "+line);
//						        jTextArea.append("\r\n");
//						        jTextArea.append("\r\n");
//						        linenum++;
//				}
//					process.destroy ();
//						isr.close ();
//						br1.close();
//			}
//			
//		}
//		
//		
//	}
//	
//}
public class Verification extends JFrame implements ActionListener{
	private JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel5,jPanel6,jPanel7;
	private JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5;
	private JTextField jTextField1,jTextField2,jTextField3,jTextField4,jTextField5;
	private JButton jButton1;
	private JTextArea jTextArea1;
	private Font font;
	private Image image;
	public Verification() {
		font=new Font("微软雅黑", 0, 12);
		UIManager.put("Button.font",font);
		UIManager.put("Label.font",font);
		jLabel1=new JLabel("加法器个数：");
		jLabel2=new JLabel("乘法器个数：");
		jLabel3=new JLabel("故障检测覆盖率：");
		jLabel4=new JLabel("内存刷新间隔：");
		jLabel5=new JLabel("属性：");
		jTextField1=new JTextField(10);
		jTextField2=new JTextField(10);
		jTextField3=new JTextField(10);
		jTextField4=new JTextField(10);
		jTextField5=new JTextField(10);
		jButton1=new JButton("验证");
		jButton1.addActionListener(this);
		jTextArea1=new JTextArea(13,18);
		jTextArea1.setEditable(false);
		jTextArea1.setLineWrap(true);
		jPanel1=new JPanel();
		jPanel2=new JPanel();
		jPanel3=new JPanel();
		jPanel4=new JPanel();
		jPanel5=new JPanel();
		jPanel6=new JPanel();
		jPanel7=new JPanel();
		jPanel1.add(jLabel1);
		jPanel1.add(jTextField1);
		jPanel2.add(jLabel2);
		jPanel2.add(jTextField2);
		jPanel3.add(jLabel3);
		jPanel3.add(jTextField3);
		jPanel4.add(jLabel4);
		jPanel4.add(jTextField4);
		jPanel5.add(jLabel5);
		jPanel5.add(jTextField5);
		jPanel6.add(jButton1);
		jPanel7.add(new JScrollPane(jTextArea1));
		jButton1.setBackground(Color.lightGray);
		jButton1.setPreferredSize(new Dimension(200,20));
		jButton1.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(jPanel1);
		this.add(jPanel2);
		this.add(jPanel3);
		this.add(jPanel4);
		this.add(jPanel5);
		this.add(jPanel6);
		this.add(jPanel7);
		FlowLayout flowLayout=new FlowLayout(FlowLayout.RIGHT);
		flowLayout.setHgap(25);
		this.setLayout(flowLayout);
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
		if("验证".equals(e.getActionCommand())){
			if("".equals(jTextField1.getText())){
				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>请填写加法器个数</p></html>"), "注意", JOptionPane.WARNING_MESSAGE);
			}
			else if("".equals(jTextField2.getText())){
				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>请填写乘法器个数</p></html>"), "注意", JOptionPane.WARNING_MESSAGE);
			}
			else if("".equals(jTextField3.getText())){
				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>请填写故障检测覆盖率</p></html>"), "注意", JOptionPane.WARNING_MESSAGE);
			}
			else if("".equals(jTextField4.getText())){
				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>请填写内存刷新间隔</p></html>"), "注意", JOptionPane.WARNING_MESSAGE);
			}
			else if("".equals(jTextField5.getText())){
				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>请填写属性表达式</p></html>"), "注意", JOptionPane.WARNING_MESSAGE);
			}else{
					try {
						new GeneratePRISMFile(jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText());
						new GeneratePropertyFile(jTextField5.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String path1="E:\\workspace\\ToolsIntegration\\1.prism ";
					String path2="E:\\workspace\\ToolsIntegration\\design_option_anaysis.pctl ";
					try {
						Runtime.getRuntime().exec("cmd start /c copy "+path1+(new ReadSetupInfo()).getPrismPath());
						Runtime.getRuntime().exec("cmd start /c copy "+path2+(new ReadSetupInfo()).getPrismPath());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					Process process=null;
					String cmd=(new ReadSetupInfo()).getPrismPath()+"\\prism.bat "+constants.configFile.PRISMFILE+" "+constants.configFile.PROPERTY;
					try {
						System.out.println(cmd);
						process = Runtime.getRuntime().exec(cmd,null,new File((new ReadSetupInfo()).getPrismPath()));
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
						while (null != ( line = br1.readLine () )){
							        jTextArea1.append("["+linenum+"] "+line);
							        jTextArea1.append("\r\n");
							        jTextArea1.append("\r\n");
							        linenum++;
							        System.out.println(line);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				}
			}
		}
}
