package com.sf.wdx.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;

/**
 * 描述：HelloAWT
 * @author 80002888
 * @date   2019年10月11日
 */
public class HelloAWT extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5237217761922406524L;
	
	public HelloAWT() throws HeadlessException {
		// 继承了Frame，所以也是个窗口
		super("HelloAWT");
		// 设置窗口大小
		this.setSize(600, 400);
		// 窗口出现在离屏幕左上角的距离
		this.setLocation(200, 200);
		// 窗口可见
		this.setVisible(true);
		
		// 新增按钮
		Button button = new Button("Hello AWT");
		// 按钮可见
		button.setVisible(true);
		// 按钮添加到窗口
		this.add(button);
	}

	public static void main(String[] args) {
		new HelloAWT();
	}
	
}
