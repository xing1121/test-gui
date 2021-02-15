package com.cn.wdx.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;

public class HelloAWT extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 776341199607270838L;

	public HelloAWT() throws HeadlessException {
		// 继承了Frame，所以也是个窗口
		super("Hello AWT");
		
		this.setSize(600, 400);
		this.setLocation(200, 200);
		
		this.add(new Button("BTN01"));
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new HelloAWT();
	}
}
