package com.sf.wdx.swing;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 描述：Swing常用组件
 * @author 80002888
 * @date   2019年10月14日
 */
public class SwingDemo00 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1549796937309016668L;
	
	private JLabel jl = new JLabel("OK");
	private Icon ic = new ImageIcon(SwingDemo00.class.getResource("/6.jpg"));
	private JTextField jtf = new JTextField("jtf", 10);
	private JPasswordField jpf = new JPasswordField("jpf", 10);
	private JTextArea jta = new JTextArea(5, 25);
	private JScrollPane jsp = new JScrollPane(jta);
	private JButton jbtn = new JButton("JBTN");
	private JCheckBox jcb = new JCheckBox("数学", false);
	private JRadioButton jrb = new JRadioButton("男", true);
	private JComboBox<Object> jcbb = new JComboBox<>(new String[]{"张三", "李四", "王五"});
	private JList<Object> jlist = new JList<>(new String[]{"张三", "李四", "王五"});
	
	private JMenuBar jMenuBar = new JMenuBar();
	private JMenu file = new JMenu("文件");
	private JMenu edit = new JMenu("编辑");
	private JMenuItem save = new JMenuItem("保存");
	private JMenuItem open = new JMenuItem("打开");
	private JMenuItem sea = new JMenuItem("查找");
	
	public SwingDemo00() throws HeadlessException {
		super();
		this.setTitle("SwingDemo00");
		this.setSize(600, 400);
		this.setLocation(200, 200);
		this.setLayout(new FlowLayout());
		
		jl.setIcon(ic);
		this.add(jl);
		
		this.add(jtf);
		this.add(jpf);
		this.add(jsp);
		this.add(jbtn);
		this.add(jcb);
		this.add(jrb);
		this.add(jcbb);
		this.add(jlist);
		
		file.add(save);
		file.add(open);
		edit.add(sea);
		jMenuBar.add(file);
		jMenuBar.add(edit);
		this.add(jMenuBar);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SwingDemo00();
	}
	
}
