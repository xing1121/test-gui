package com.sf.wdx.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;

import javax.swing.Box;

/**
 * 描述：盒子Box，盒子可以互相嵌套，盒子之间可以添加粘合剂（间距可变）、空隙（间距不可变）
 * @author 80002888
 * @date   2019年10月11日
 */
public class BoxDemo extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6017826900747723355L;
	
	public BoxDemo() throws HeadlessException {
		super("BoxDemo");
		this.setSize(600, 400);
		this.setLocation(200, 200);
		
		Button bt1 = new Button("BT1");
		Button bt2 = new Button("BT2");
		Button bt3 = new Button("BT3");
		Button bt4 = new Button("BT4");
		
		// 水平盒子
		Box box1 = Box.createHorizontalBox();
		Box box3 = Box.createHorizontalBox();
		
		// 垂直盒子
		Box box2 = Box.createVerticalBox();
		
		box1.add(bt1);
		// 添加水平粘合剂，间距可变
		box1.add(Box.createHorizontalGlue());
		box1.add(bt2);
		
		box2.add(bt3);
		// 添加垂直空隙，垂直间距30不变
		box2.add(Box.createVerticalStrut(30));
		box2.add(bt4);
		
		box3.add(box1);
		box3.add(box2);
		this.add(box3);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BoxDemo();
	}
	
}
