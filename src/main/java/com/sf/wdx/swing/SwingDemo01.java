package com.sf.wdx.swing;

import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

/**
 * 描述：第一个事件程序
 * @author 80002888
 * @date   2019年10月15日
 */
public class SwingDemo01 extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5237217761922406524L;

	private Panel p = new Panel();
	private Button okBtn = new Button("OK");
	private Button cancelBtn = new Button("Cancel");
	
	public SwingDemo01() throws HeadlessException {
		super("SwingDemo01");
		this.setSize(600, 400);
		// 按钮添加点击事件
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("click");
				Object source = e.getSource();
				System.out.println(source);
				JOptionPane.showMessageDialog(null, "你单击了" + e.getActionCommand());
			}
		});
		// 按钮添加焦点事件
		cancelBtn.addFocusListener(new FocusListener() {
			
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
		p.add(okBtn);
		p.add(cancelBtn);
		this.add(p);
		
		// 添加窗口事件监听器
		this.addWindowListener(new MyListener());
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new SwingDemo01();
	}
	
}

/**
 * 描述：窗口事件监听器
 * 1.给事件源注册事件监听器
 * 2.当用户在事件源发生动作，JVM生产一个WindowEvent对象we
 * 3.取出we中的事件源，找到事件源中的事件监听器
 * 4.判断事件的类型，调用对应的方法
 * @author 80002888
 * @date   2019年10月15日
 */
class MyListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 关闭事件
		System.out.println("关闭");
		// 0正常退出，1非正常退出
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
}