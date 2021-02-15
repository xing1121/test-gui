package com.cn.wdx.ncre;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

/**
 * 
 * 描述：ScrollBarDemo001
应用程序将滚动条作为值的选择。
容器有一个开/关滚动条的按钮，一个文本框和一个滚动条。
当滚动条处于打开状态时，移动滚动条上的滑块，滑块的对应值显示在文本框中。
如果滚动条处于关闭状态 ，则移动滚动条上的滑块，滑块的对应值在文本框中不显示（查看源文件）。

 * @author wdx
 * @time   2020年9月21日
 */
public class ScrollBarDemo001 extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4140599724123684396L;

	private boolean btnFlag = false;
	
	private JButton btn = new JButton("STATE:OFF");
	
	private JTextField jtf = new JTextField(20);
	
	// 方向：垂直，初始值，滑块大小，最小值，最大值
	private JScrollBar jsb = new JScrollBar(JScrollBar.VERTICAL, 0, 20, 0, 255);
	
	@Override
	public void init() {
		this.setSize(400, 300);
		
		// 设置滚动条组件的首选大小（样式）
		Dimension d = new Dimension();
		d.setSize(20, 255);
		jsb.setPreferredSize(d);

		this.add(btn);
		this.add(jtf);
		this.add(jsb);
		this.setVisible(true);
		
		// 按钮添加监听器
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnFlag) {
					btn.setText("STATE:OFF");
					btnFlag = false;
				} else {
					btn.setText("STATE:ON");
					btnFlag = true;
				}
			}
		});
		
		// 滚动条添加监听器
		jsb.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				if (btnFlag) {
					jtf.setText("" + e.getValue());
				}
			}
		});
		
	}
	
}
