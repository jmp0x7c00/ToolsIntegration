package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import fileProcess.ReadSetupInfo;
import fileProcess.WriteSetupInfo;

public class Setup extends JFrame implements ActionListener{
	private JPanel jPanel1,jPanel2,jPanel3,jPanel4;
	private JButton jButton1,jButton2;
	private JLabel jLabel1,jLabel2;
	private JMenu jMenu1,jMenu2;
	private JMenuBar jMenuBar;
	private Image image;
	private JTextField jTextField1,jTextField2;
	private ReadSetupInfo readSetupInfo;
	private String gautPath,prismPath;
	private WriteSetupInfo writeSetupInfo;
	public Setup(String gautPath,String prismPath){
		readSetupInfo=new ReadSetupInfo();
		Font font=new Font("微软雅黑", 0, 12);
		UIManager.put("Button.font",font);
		UIManager.put("Menu.font",font);
		UIManager.put("MenuItem", font);
		//jMenuBar=new JMenuBar();
		//jMenu1=new JMenu("选项");
		//jMenu2=new JMenu("关于");
		//jMenuBar.add(jMenu1);
		//jMenuBar.add(jMenu2);
		jPanel1=new JPanel();
		jPanel2=new JPanel();
		jPanel3=new JPanel();
		jLabel1=new JLabel("GAUT执行路径：");
		jLabel1.setFont(new Font("微软雅黑", 0, 12));
		jLabel2=new JLabel("PRISM执行路径：");
		jLabel2.setFont(new Font("微软雅黑", 0, 12));
		jTextField1=new JTextField(10);
		jTextField1.setText(gautPath);
		jTextField2=new JTextField(10);
		jTextField2.setText(prismPath);
		jButton1=new JButton("确定");
		jButton1.setBackground(Color.lightGray);
		jButton1.setPreferredSize(new Dimension(30,20));
		jButton1.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton2=new JButton("返回");
		jButton2.setBackground(Color.lightGray);
		jButton2.setPreferredSize(new Dimension(30,20));
		jButton2.setBorder(BorderFactory.createLineBorder(Color.black));
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		jPanel1.add(jLabel1);
		jPanel1.add(jTextField1);
		jPanel2.add(jLabel2);
		jPanel2.add(jTextField2);
		jPanel3.add(jButton1);
		jPanel3.add(jButton2);
		//this.setJMenuBar(jMenuBar);
		this.add(jPanel1);
		this.add(jPanel2);
		this.add(jButton1);
		this.add(jButton2);
		this.setLayout(new FlowLayout());
		this.setTitle("设置");
		this.setSize(270,470);
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		if("确定".equals(e.getActionCommand())){
			writeSetupInfo=new WriteSetupInfo(jTextField1.getText(),jTextField2.getText());
			super.dispose();
		}
		else if("返回".equals(e.getActionCommand()))super.dispose();
	}
	
}
