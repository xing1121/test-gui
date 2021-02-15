package com.cn.wdx.swing;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 * 
 * 描述：SwingDemo04



 * @author wdx
 * @time   2020年9月20日
 */
public class SwingDemo04 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7375842746722565531L;

	/**
	 * 选项卡
	 */
	private JTabbedPane top = new JTabbedPane();
	private JPanel pan = new JPanel();
	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("CANCEL");
	
	private DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
	private JComboBox<String> jcb = new JComboBox<String>(dcbm);
	private JTextField jtf = new JTextField(30);
	
	public SwingDemo04() throws HeadlessException {
		super("SwingDemo04");
		this.setSize(600, 400);
		this.setLocation(200, 200);
	
		// 获取contentPane，设置颜色
		this.getContentPane().setBackground(Color.RED);
		dcbm.addElement("张三");
		
		// 按钮添加事件
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dcbm.addElement(jtf.getText());
			}
		});
		
		// 面板pan中添加元素
		pan.add(jcb);
		pan.add(jtf);
		pan.add(ok);
		
		top.add("第1卡", pan);
		top.add("第2卡", cancel);		
		this.add(top);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SwingDemo04();
	}
	
}
