package com.sf.wdx.swing;

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
 * 描述：常用事件示例
 * @author 80002888
 * @date   2019年10月15日
 */
public class SwingDemo03 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4692540920243713251L;

	private JPanel pan1 = new JPanel();
	private JButton btn1 = new JButton("OK");
	private JTextField jtf = new JTextField(30);
	private JCheckBox jc = new JCheckBox("数学", true);
	private JComboBox<String> jcb = new JComboBox<>(new String[]{"张三", "李四", "王五"});
	
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
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "HELLO");
				SwingDemo03.this.setTitle(jtf.getText());
			}
		});
		// 文本框按回车事件
		jtf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingDemo03.this.setTitle(jtf.getText());
			}
		});
		// 文本框鼠标事件（出现、离开、移动、按住、放开、单击、拖拽、滚轮）
		jtf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jtf.setBackground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jtf.setBackground(new Color(255, 255, 255));
			}
		});
		// 添加按键事件
		jtf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F4) {
					System.exit(0);
				} else {
					System.out.println(e.getKeyCode());
				}
			}
		});
		// 复选框勾选/取消勾选事件
		jc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("是否选中：" + jc.isSelected());
			}
		});
		// 下拉框选中子项事件
		jcb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				jtf.setText(e.getItem().toString());
			}
		});
	}

	public static void main(String[] args) {
		new SwingDemo03();
	}
	
}
