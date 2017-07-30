import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import menu.Setup;
import fileProcess.ReadSetupInfo;


public class ToolsIntegration extends JFrame implements ActionListener{
	JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel5,jPanel6;
	JButton jButton1,jButton2,jButton3,jButton4,jButton5;
	JLabel jLabel;
	JMenu jMenu1,jMenu2;
	JMenuItem jMenuItem1,jMenuItem2;
	JMenuBar jMenuBar;
	Font font;
	Image image;
	ReadSetupInfo readSetupInfo;
	public static void main(String[] args){
		ToolsIntegration toolsIntegration=new ToolsIntegration();
		//Setup setup=new Setup();
	}
	public ToolsIntegration(){
		font=new Font("微软雅黑", 0, 12);
		UIManager.put("Button.font",font);
		UIManager.put("Menu.font",font);
		UIManager.put("MenuItem.font", font);
		jMenuBar=new JMenuBar();
		jMenu1=new JMenu("选项");
		jMenuItem1=new JMenuItem("设置");
		jMenuItem1.addActionListener(this);
		jMenu1.add(jMenuItem1);
		jMenu2=new JMenu("关于");
		jMenuItem2=new JMenuItem("帮助");
		jMenu2.add(jMenuItem2);
		jMenu1.addActionListener(this);
		jMenuBar.add(jMenu1);
		jMenuBar.add(jMenu2);
		jLabel=new JLabel("系统可靠性模型检验集成工具");
		jLabel.setFont(new Font("楷体", 1, 15));
		jPanel4=new JPanel();
		jPanel5=new JPanel();
		jPanel1=new JPanel();
		jPanel2=new JPanel();
		jPanel3=new JPanel();
		jPanel6=new JPanel();
		jButton1=new JButton("GAUT(GUI)");
		jButton1.setBackground(Color.lightGray);
		jButton1.setPreferredSize(new Dimension(200,30));
		jButton1.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton1.addActionListener(this);
		jButton4=new JButton("生成CDFG");
		jButton4.setBackground(Color.lightGray);
		jButton4.setPreferredSize(new Dimension(200,30));
		jButton4.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton4.addActionListener(this);
		jButton2=new JButton("PRISM(GUI)");
		jButton2.setBackground(Color.lightGray);
		jButton2.setPreferredSize(new Dimension(200,30));
		jButton2.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton2.addActionListener(this);
		jButton3=new JButton("PRISM(console)");
		jButton3.setBackground(Color.lightGray);
		jButton3.setPreferredSize(new Dimension(200,30));
		jButton3.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton3.addActionListener(this);
		
		jButton5=new JButton("验证PRISM模型");
		jButton5.setBackground(Color.lightGray);
		jButton5.setPreferredSize(new Dimension(200,30));
		jButton5.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton5.addActionListener(this);
		
		this.setLayout(new FlowLayout());
		jPanel4.add(jLabel);
		jPanel5.add(jButton1);
		jPanel1.add(jButton4);
		jPanel2.add(jButton2);
		jPanel3.add(jButton3);
		jPanel6.add(jButton5);
		this.setJMenuBar(jMenuBar);
		this.add(jPanel4);
		this.add(jPanel1);
		this.add(jPanel6);
		this.add(jPanel5);
		this.add(jPanel2);
		this.add(jPanel3);
		this.setTitle("集成工具");
		this.setSize(270,470);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public void actionPerformed(ActionEvent e){
		if("设置".equals(e.getActionCommand())){
			readSetupInfo=new ReadSetupInfo();
			Setup setup=new Setup(readSetupInfo.getGautPath(),readSetupInfo.getPrismPath());
		}
		/*else if("GAUT(console)".equals(e.getActionCommand())){
			readSetupInfo=new ReadSetupInfo();
			try {
				Process process=Runtime.getRuntime().exec("cmd /c start",null,new File("D:\\GAUT\\GautC\\cdfgcompiler"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>GAUT路径配置错误</p></html>"), "错误", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}*/
		else if("GAUT(GUI)".equals(e.getActionCommand())){
			readSetupInfo=new ReadSetupInfo();
			try {
				Process process=Runtime.getRuntime().exec(readSetupInfo.getGautPath());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>GAUT路径配置错误</p></html>"), "错误", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
		else if("PRISM(GUI)".equals(e.getActionCommand())){
			readSetupInfo=new ReadSetupInfo();
			try {
				Runtime.getRuntime().exec(readSetupInfo.getPrismPath()+"\\xprism.bat",null,new File(readSetupInfo.getPrismPath()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null,new JLabel("<html><p style='font-family:微软雅黑'>PRISM路径配置错误</p></html>"), "错误", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if("生成CDFG".equals(e.getActionCommand())){
			GenerateCDFG generateCDFG=new GenerateCDFG();
			
		}
		else if("PRISM(console)".equals(e.getActionCommand())){	
			readSetupInfo=new ReadSetupInfo();
			try {
				Runtime.getRuntime().exec("cmd /c start prism.bat",null,new File(readSetupInfo.getPrismPath()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if("验证PRISM模型".equals(e.getActionCommand())){	
			Verification verification=new Verification();
		}
	}
	
}
