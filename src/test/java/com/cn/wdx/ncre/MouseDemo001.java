package com.cn.wdx.ncre;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 
 * 描述：MouseDemo001
 * 
 * 
 * 
 * @author wdx
 * @time 2020年9月21日
 */
public class MouseDemo001 extends Applet implements MouseListener,
		MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3133688220597114852L;

	private TextArea textArea = new TextArea(10, 20);
	private TextArea textArea2 = new TextArea(10, 20);

	int r = 10;

	@Override
	public void init() {
		this.setSize(800, 600);
		this.add(textArea);
		this.add(textArea2);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(200, 200, r, r);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// 鼠标拖拽
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// 鼠标移动
		textArea2.setText(getXY(e));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 鼠标点击
		int count = e.getClickCount();
		int btn = e.getButton();
		if (btn == MouseEvent.BUTTON1) {
			// 左键
			textArea.setText("点击左键" + count);
		} else if (btn == MouseEvent.BUTTON2) {
			// 滚轮
			textArea.setText("点击滚轮" + count);
		} else if (btn == MouseEvent.BUTTON3) {
			// 右键
			textArea.setText("点击右键" + count);
		}
		r++;
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// 鼠标进入
		textArea.setText("鼠标进入");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// 鼠标退出
		textArea.setText("鼠标退出");
	}

	private String getXY(MouseEvent e) {
		return "[" + e.getX() + ", " + e.getY() + "]";
	}

}
