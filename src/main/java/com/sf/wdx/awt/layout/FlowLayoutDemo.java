package com.sf.wdx.awt.layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * 描述：水平布局，Panel、JPanel、Applet的默认布局
 * @author 80002888
 * @date   2019年11月8日
 */
public class FlowLayoutDemo extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1856173176937160698L;

	public FlowLayoutDemo() {
		super("FlowLayoutDemo");
		this.setSize(400, 300);
		// 水平布局，水平间距20，垂直间距30
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
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutDemo();
	}
	
}
