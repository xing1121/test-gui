package com.cn.wdx.awt;

import java.awt.Button;
import java.awt.Frame;

/**
 * 描述：绝对定位
 * @author 80002888
 * @date   2019年11月8日
 */
public class AWTBounds extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3611292968932919196L;

	public AWTBounds() {
		super("AWTBounds");
		
		this.setSize(600, 400);
		this.setLocation(200, 200);
		this.setLayout(null);
		
		Button bt1 = new Button("BT1");
//		bt1.setLocation(200, 100);
//		bt1.setSize(50, 100);
		bt1.setBounds(200, 100, 50, 100);
		
		this.add(bt1);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new AWTBounds();
	}
	
}