package com.sf.wdx.applet;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 描述：JAppletDemo01
 * 	默认布局为BorderLayout
 * @author 80002888
 * @date   2019年11月15日
 */
public class JAppletDemo01 extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7433534879737871862L;
	
	private JButton jButton = new JButton("点我");

	@Override
	public void init() {
		test1();
		test2();
		test3();
		test4();
	}

	public void test1(){
		Container p1 = this.getRootPane().getContentPane();
		Container p2 = this.getContentPane();
		// true
		System.out.println(p1 == p2);
		// BorderLayout
		p1.add(jButton, BorderLayout.SOUTH);
	}
	
	public void test2(){
		JPanel jPanel = new JPanel();
		this.setContentPane(jPanel);
		// 自己创建的JPanel，FlowLayout
		jPanel.add(jButton);
	}
	
	public void test3(){
		JPanel jPanel = new JPanel();
		this.getRootPane().setContentPane(jPanel);
		// 自己创建的JPanel，FlowLayout
		jPanel.add(jButton, BorderLayout.SOUTH);
	}
	
	public void test4(){
		// BorderLayout
		this.add(jButton, BorderLayout.SOUTH);
	}
	
}
