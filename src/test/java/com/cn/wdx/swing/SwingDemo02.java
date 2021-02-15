package com.cn.wdx.swing;

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
 * 
 * 描述：SwingDemo02



 * @author wdx
 * @time   2020年9月20日
 */
public class SwingDemo02 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6065545995051341662L;

	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	
	private JLabel jUser = new JLabel("用户名：");
	private JTextField username = new JTextField(30);
	
	private JLabel jPwd = new JLabel("密码：");
	private JPasswordField password = new JPasswordField(30);
	
	private JButton ok = new JButton("OK");
	private JButton reset = new JButton("Reset");
	
	public static void main(String[] args) {
		new SwingDemo02();
	}
	
	public SwingDemo02() throws HeadlessException {
		super("SwingDemo02");
		this.setSize(600, 400);
		this.setLocation(200, 200);
		this.setLayout(new GridLayout(3, 1));
		
		p1.add(jUser);
		p1.add(username);
		
		p2.add(jPwd);
		p2.add(password);
		
		p3.add(ok);
		p3.add(reset);
		
		// ok添加点击事件
		ok.addActionListener(createOKActionListener());
		
		// reset添加点击事件
		reset.addActionListener(createResetActionListener());
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 定义事件监听器
	 * @return
	 */
	private ActionListener createResetActionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				username.setText(null);
				password.setText(null);
			}
		};
	}
	
	/**
	 * 定义事件监听器
	 * @return
	 */
	private ActionListener createOKActionListener(){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = username.getText();
				String pwd = new String(password.getPassword());
				if ("admin".equals(name) 
						&& "123".equals(pwd)) {
					// 用户名密码正确，释放资源（关闭当前窗口）
					SwingDemo02.this.dispose();
					// 新展示一个窗口
					JFrame newJFrame = new JFrame("欢迎：" + name);
					newJFrame.setSize(300, 168);
					newJFrame.setLocation(200, 200);
					// 为新窗口添加一张图片
					JLabel newJLabel = new JLabel();
					newJLabel.setIcon(
							new ImageIcon(this.getClass().getResource("/file/1000355.jpg"))
							);
					newJFrame.add(newJLabel);
					newJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					newJFrame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误！");
				}
			}
		};
	}
	
}
