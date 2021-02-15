package com.cn.wdx.swing;

import java.awt.Button;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * 描述：SwingDemo01



 * @author wdx
 * @time   2020年9月19日
 */
public class SwingDemo01 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1247945675780239212L;

	private Panel p = new Panel();
	
	private Button btn1 = new Button("OK");
	
	private Button btn2 = new Button("Cancel");

	public SwingDemo01() throws HeadlessException {
		super("SwingDemo01");
		
		// 按钮添加点击事件
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("click " + e.getSource());
				JOptionPane.showMessageDialog(null, "你单击了：" + e.getActionCommand());
			}
		});
		
		// 按钮添加焦点事件
		btn2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("focusLost");
				JOptionPane.showMessageDialog(null, "你失去了Cancel焦点");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("focusGained");
				SwingDemo01.this.setTitle(e.getSource() + "获得Cancel焦点");
			}
		});
		
		// Panel默认布局为Flow流式布局
		this.setSize(600, 400);
		p.add(btn1);
		p.add(btn2);
		this.add(p);
		
		// 添加窗口事件监听器
		this.addWindowListener(new MyListener());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new SwingDemo01();
	}
	
}

class MyListener extends WindowAdapter {

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
	}

}