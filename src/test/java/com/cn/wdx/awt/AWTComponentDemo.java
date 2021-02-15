package com.cn.wdx.awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;

public class AWTComponentDemo extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5826414372857169654L;

	public AWTComponentDemo() throws HeadlessException {
		super();
		this.setSize(800, 400);
		this.setLocation(200, 200);

		this.setLayout(new FlowLayout());
		
		Button but = new Button("OK");
		TextField tx = new TextField("input", 25);
		TextField pw = new TextField("pw", 25);
		Label lab = new Label("Hello");
		Choice coe = new Choice();
	
		this.add(but);
		this.add(tx);
		
		pw.setEchoChar('*');
		this.add(pw);
		
		this.add(lab);
		
		this.add(new Checkbox("cb01", false, null));
		this.add(new Checkbox("cb02", false, null));
		this.add(new Checkbox("cb03", false, null));
		
		CheckboxGroup g = new CheckboxGroup();
		this.add(new Checkbox("r1", true, g));
		this.add(new Checkbox("r2", false, g));
		
		coe.add("Green");
		coe.add("Red");
		coe.add("Blue");
		this.add(coe);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWTComponentDemo();
	}
	
}
