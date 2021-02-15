package com.cn.wdx.swing;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * 描述：SwingDemo03



 * @author wdx
 * @time   2020年9月20日
 */
public class SwingDemo03 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2582043214957224962L;

	private JPanel pan1 = new JPanel();
	private JTextField jtf = new JTextField(30);
	private JButton btn1 = new JButton("OK");
	private JCheckBox jc = new JCheckBox("数学", true);
	private JComboBox<String> jcb = new JComboBox<String>(
			new String[]{"张三", "李四", "王五"});
	
	public SwingDemo03() throws HeadlessException {
		super("SwingDemo03");
		this.setSize(600, 400);
		this.setLocation(200, 200);
		
		pan1.add(jtf);
		pan1.add(btn1);
		pan1.add(jc);
		pan1.add(jcb);
		this.add(pan1);
		
		// 初始化监听器
		initListener();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initListener() {
		// 按钮点击事件
		ActionListener btn1Pressed = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "HELLO");
				SwingDemo03.this.setTitle(jtf.getText());
			}
		};
		btn1.addActionListener(btn1Pressed);
		// 文本框中按回车事件
		jtf.addActionListener(btn1Pressed);
		
		// 文本框鼠标事件（出现、离开、移动、按住、放开、单击、拖拽、滚轮）
		jtf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				jtf.setBackground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				jtf.setBackground(new Color(255, 255, 255));
			}
		});
		
		// 文本框按键事件
		jtf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_F4) {
					System.exit(0);
				} else {
					System.out.println(keyCode);
				}
			}
		});
		
		// 复选框勾选/取消事件
		jc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("复选框【" + jc.getText() + "】是否被选中：" + jc.isSelected());
			}
		});
		
		// 下拉框选中子项改变事件
//		jcb.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				jtf.setText("下拉框选中：" + e.getItem().toString());
//			}
//		});
		
		// 下拉框选中子项事件
		jcb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("下拉框选中：" + jcb.getSelectedItem().toString());
			}
		});
		
	}

	public static void main(String[] args) {
		new SwingDemo03();
	}
	
}
