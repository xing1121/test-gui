package com.cn.wdx.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * 描述：SwingDemo06



 * @author wdx
 * @time   2020年9月20日
 */
public class SwingDemo06 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3936119306902450676L;

	public SwingDemo06() throws HeadlessException {
		super("SwingDemo06");
		this.setSize(600, 400);
		
		
		this.add(new MyPanel());
		this.add(new MyButton());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SwingDemo06();
	}
	
}

class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5460234282893378896L;

	public MyPanel() {
		this.setSize(400, 400);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 400, 400);
		g.setColor(Color.RED);
		g.drawLine(0, 0, 400, 400);
		g.drawLine(400, 0, 0, 400);
		g.dispose();
		super.paint(g);
	}
}
