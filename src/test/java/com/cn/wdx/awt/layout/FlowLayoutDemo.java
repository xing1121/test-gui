package com.cn.wdx.awt.layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;

public class FlowLayoutDemo extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2090115671980170706L;

	public FlowLayoutDemo() throws HeadlessException {
		super("FlowLayoutDemo ");
		
		this.setSize(400, 300);
		this.setVisible(true);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
		
		Button btn01 = new Button("btn01");
		Button btn02 = new Button("btn02");
		Button btn03 = new Button("btn03");
		Button btn04 = new Button("btn04");
		Button btn05 = new Button("btn05");
		Button btn06 = new Button("btn06");
		Button btn07 = new Button("btn07");
		Button btn08 = new Button("btn08");
		
		this.add(btn01);
		this.add(btn02);
		this.add(btn03);
		this.add(btn04);
		this.add(btn05);
		this.add(btn06);
		this.add(btn07);
		this.add(btn08);
	}

	public static void main(String[] args) {
		new FlowLayoutDemo();
	}
	
}
