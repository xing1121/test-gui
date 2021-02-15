package com.cn.wdx.awt.layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutDemo extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1856173176937160698L;

	public GridLayoutDemo() {
		super("GridLayoutDemo");
		this.setSize(400, 300);
		// 表格布局，3行3列，水平间距10，垂直间距20
		this.setLayout(new GridLayout(3, 3, 10, 20));
	
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
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutDemo();
	}
}
