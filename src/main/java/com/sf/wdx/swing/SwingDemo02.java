package com.sf.wdx.swing;


import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 描述：事件编程示例（登录）
 * @author 80002888
 * @date   2019年10月15日
 */
public class SwingDemo02 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7892417736198983875L;

	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	
	private JLabel lUsr = new JLabel("用户名：");
	private JTextField username = new JTextField(30);
	
	private JLabel lPwd = new JLabel("密   码：");
	private JPasswordField password = new JPasswordField(30);
	
	private JButton ok = new JButton("OK");
	private JButton reset = new JButton("Reset");
	
	public SwingDemo02() throws HeadlessException {
		super("SwingDemo02");
		this.setSize(600, 400);
		this.setLocation(200, 200);
		
		p1.add(lUsr);
		p1.add(username);
		
		p2.add(lPwd);
		p2.add(password);
		
		// ok的点击事件
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = username.getText();
				String pwd = new String(password.getPassword());
				if ("admin".equals(name) && "123".equals(pwd)) {
					// 关闭当前窗口（释放内存资源）
					SwingDemo02.this.dispose();
					// 跳转新窗口
					JFrame n = new JFrame("欢迎：" + name);
					n.setSize(300, 168);
					n.setLocation(200, 200);
					// 为新窗口添加一张图片
					JLabel jl = new JLabel();
					ImageIcon icon = new ImageIcon(this.getClass().getResource("/file/1000355.jpg"));
					jl.setIcon(icon);
					n.add(jl);
					n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					n.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
					username.setText("");
					password.setText("");
				}
			}
		});
		// reset的点击事件
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		
		p3.add(ok);
		p3.add(reset);
		
		this.setLayout(new GridLayout(3, 1));
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SwingDemo02();
	}
	
}
