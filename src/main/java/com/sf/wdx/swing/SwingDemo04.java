package com.sf.wdx.swing;

import java.awt.Color;
import java.awt.Container;
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
 * 描述：高级组件
 * @author 80002888
 * @date   2019年10月15日
 */
public class SwingDemo04 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4023641730666202069L;
	
	/**
	 * 选项卡
	 */
	private JTabbedPane top = new JTabbedPane();
	private JPanel pan = new JPanel();
	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("CANCEL");
	
	private DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
	private JComboBox<String> jcb = new JComboBox<>(dcbm);
	private JTextField jtf = new JTextField(30);
	
	public SwingDemo04() throws HeadlessException {
		super("SwingDemo04");
		this.setSize(600, 400);
		this.setLocation(200, 200);
		
		// 直接设置颜色，不生效
		this.setBackground(Color.RED);
		// 获取顶层容器，设置颜色可以生效
		Container c = this.getContentPane();
		c.setBackground(Color.BLUE);
		
		// 默认值
		dcbm.addElement("张三");
		
		// 按钮添加事件
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dcbm.addElement(jtf.getText());
			}
		});
		
		pan.add(jcb);
		pan.add(jtf);
		pan.add(ok);
		top.add("第一卡", pan);
		top.add("第二卡", cancel);
		this.add(top);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SwingDemo04();
	}

}
