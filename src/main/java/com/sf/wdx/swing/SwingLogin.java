package com.sf.wdx.swing;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 * 描述：登录框
 * @author 80002888
 * @date   2019年10月14日
 */
public class SwingLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4589416651149700730L;

	private Box box1 = Box.createHorizontalBox();
	private JLabel jLabel = new JLabel();
	private Icon icon;
	
	private Box box2 = Box.createHorizontalBox();
	private JLabel jUsername = new JLabel("用户名：");
	private TextField username = new TextField();
	
	private Box box3 = Box.createHorizontalBox();
	private JLabel jPassword = new JLabel("密   码：");
	private JPasswordField password = new JPasswordField();
	
	private Box box4 = Box.createHorizontalBox();
	private JButton submit = new JButton("Submit");
	private JButton cancel = new JButton("Cancel");
	
	private Box box5 = Box.createVerticalBox();
	
	public SwingLogin() throws HeadlessException {
		super();
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = defaultToolkit.getScreenSize();
		int h = (int)screenSize.getHeight();
		int w = (int)screenSize.getWidth();
		
		this.setTitle("SwingLogin");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocation((w - 400)/2, (h - 300)/2);
		
		init();
		
		// 这句话的顺序可能会影响是否显示组件
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void init() {
		icon = new ImageIcon(this.getClass().getResource("/file/top.jpg"));
		jLabel.setIcon(icon);
		box1.add(jLabel);
		
		box2.add(Box.createHorizontalStrut(30));
		box2.add(jUsername);
		box2.add(username);
		box2.add(Box.createHorizontalStrut(30));
		
		box3.add(Box.createHorizontalStrut(30));
		box3.add(jPassword);
		box3.add(password);
		box3.add(Box.createHorizontalStrut(30));
		
		box4.add(submit);
		box4.add(Box.createHorizontalStrut(30));
		box4.add(cancel);
		
		box5.add(box1);
		box5.add(Box.createVerticalStrut(30));
		box5.add(box2);
		box5.add(Box.createVerticalStrut(30));
		box5.add(box3);
		box5.add(Box.createVerticalStrut(30));
		box5.add(box4);
		box5.add(Box.createVerticalStrut(30));
		this.add(box5);
	}

	public static void main(String[] args) {
		new SwingLogin();
	}
}
