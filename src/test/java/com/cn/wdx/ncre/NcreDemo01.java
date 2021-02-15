package com.cn.wdx.ncre;

import java.applet.Applet;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

/**
 * 
 * 描述：NcreDemo01
键盘事件的接口是KeyListener，注册键盘事件监视器的方法是addKeyListener(监视器)。实现KeyListener接口有3个：
keyReleased、keyTyped、keyPressed。

管理键盘事件的类是KeyEvent，该类提供方法：public int getKeyCode(),获得按动的键码，键码表在KeyEvent类中定义。


 * @author wdx
 * @time   2020年9月21日
 */
public class NcreDemo01 extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6788802711600891047L;
	private TextField tex = new TextField(30);
	
	@Override
	public void init() {
		this.setSize(600, 600);
		this.add(tex);
		tex.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// 特殊按键（数字、英文、符号、退格、回车等，不包含shift、ctrl等）
				// keyCode都是0，keyChar输入什么显示什么，可以是多个按键的组合
				// 比如shift+8，keyTyped侦测为按键一次，为*
				// 				keyPressed侦测为按键两次，为shift、*
				System.out.println("keyTyped:" + e.getKeyCode() + ", " + e.getKeyChar());
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// 按键松开时
				System.out.println("keyReleased:" + e.getKeyCode() + ", " + e.getKeyChar());
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// 按键按下时
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_Q) {
					JOptionPane.showMessageDialog(null, "exit!");
					System.exit(0);
				}
				System.out.println("keyPressed:" + e.getKeyCode() + ", " + e.getKeyChar());
			}
		});
	}
	
}
