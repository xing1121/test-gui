package com.cn.wdx.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * 描述：SwingDemo05



 * @author wdx
 * @time   2020年9月20日
 */
public class SwingDemo05 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MyButton mb = new MyButton();
	
	public SwingDemo05() throws HeadlessException {
		// JFrame和JWindow的默认布局是BorderLayout（边界布局，东西南北中）
		// JPanel默认布局是FlowLayout（流式布局，水平放置满后换行）
		super("SwingDemo05");
		this.setSize(600, 400);
        this.setLayout(null);
		this.add(mb);
		
		// 按钮添加事件
		mb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hello!");
			}
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SwingDemo05();
	}
	
}

class MyButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyButton() {
		super();
		this.setBorder(null);
		this.setSize(300, 168);
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		// Graphics为画笔
		// 设置画笔颜色
		g.setColor(new Color(220, 0, 0));
		
		// 画实心矩形
//		g.fillRect(0, 0, 300, 168);
		// 画空心矩形
//		g.drawRect(0, 0, 300, 168);
		// 画线
//		g.drawLine(10, 20, 50, 150);
		
		// 设置字体
//		g.setFont(new Font("我的字体", Font.BOLD, 26));
		// 画字符串
//		g.drawString("大家好", 20, 80);
		
		// 获取图片
		Image img = null;
		try {
			img = ImageIO.read(this.getClass().getResource("/file/1000355.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 画图
		g.drawImage(img, 0, 0, null);
		
		// 释放资源
		g.dispose();
//		super.paint(g);
	}
	
}