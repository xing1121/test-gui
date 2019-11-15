package com.sf.wdx.awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

/**
 * 描述：AWT常用组件
 * @author 80002888
 * @date   2019年10月14日
 */
public class AWTComponentDemo extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4023641730666202069L;

	private Button but = new Button("OK");
	private TextField tx = new TextField("input", 25);
	private TextField pw = new TextField("pw", 25);
	private Label lab = new Label("Hello");
	private Choice coe = new Choice();
	
	public AWTComponentDemo() {
		super("AWTComponentDemo");
		this.setSize(800, 400);
		this.setLocation(200, 200);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		// 添加按钮
		this.add(but);
		// 添加文本输入框
		this.add(tx);
		// 添加密码输入框（加密*）
		pw.setEchoChar('*');
		this.add(pw);
		// 添加标签
		this.add(lab);
		// 添加复选框
		this.add(new Checkbox("cb01", false, null));
		this.add(new Checkbox("cb02", false, null));
		this.add(new Checkbox("cb03", false, null));
		// 添加单选框，单选按钮是一种特殊的复选框，使用一个CheckboxGroup将他们组成一组，组内只有一个可以被选择
		CheckboxGroup g = new CheckboxGroup();
		this.add(new Checkbox("r1", true, g));
		this.add(new Checkbox("r2", false, g));
		// 添加下拉框
		coe.add("Green");
		coe.add("Red");
		coe.add("Blue");
		this.add(coe);
	}

	public static void main(String[] args) {
		new AWTComponentDemo();
	}
	
}
