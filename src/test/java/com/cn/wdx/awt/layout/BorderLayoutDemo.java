package com.cn.wdx.awt.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;

public class BorderLayoutDemo extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4745550482435485081L;

	public BorderLayoutDemo() throws HeadlessException {
		super("BorderLayoutDemo");
		this.setSize(400, 300);
		this.setLayout(new BorderLayout());
		
		Button btn01 = new Button("btn01");
		Button btn02 = new Button("btn02");
		Button btn03 = new Button("btn03");
		Button btn04 = new Button("btn04");
		Button btn05 = new Button("btn05");
		
		this.add(btn01, BorderLayout.NORTH);
		this.add(btn02, BorderLayout.EAST);
		this.add(btn03, BorderLayout.SOUTH);
		this.add(btn04, BorderLayout.WEST);
		this.add(btn05, BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutDemo();
	}
	
}
