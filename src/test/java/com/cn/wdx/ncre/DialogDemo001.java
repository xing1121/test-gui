package com.cn.wdx.ncre;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * 
 * 描述：DialogDemo001
小应用程序声明一个用户窗口类和对话框类，用户窗口有两个按钮和两个文本框，当点击某个按钮时，对应的对话框被激活。
在对话框中输入相应信息，按对话框的确定按钮。
确定按钮的监视方法，将对话框中输入的信息传送给用户窗口，并在用户窗口的相应文本框中显示选择信息（查看源文件）。

上述例子创建的是强制型对话框，改为非强制型对话框就允许用户在对话过程中暂停，与程序的其他部分进行交互。
这样，在界面中可以看到部分对话的效果。
将上述例子改为非强制型对话框只要作少量的改动即可。
首先是将对话框构造方法中的代码“super(F,s,true);”改为 “super(F,s,false);”。

第二个变化：原来是响应确定按钮事件时，才调用方法returnName()，将对话框得到的字符串返回给程序。
现在当文本框输入选择字符串结束后，就应该立即调用该方法。
为此，需要对文本框的输入事件作监视，为文本注册监视器

 * @author wdx
 * @time   2020年9月21日
 */
public class DialogDemo001 extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4217829855347417292L;

	private JButton showDialog = new JButton("Show Dialog");
	private JButton showJOptionPane = new JButton("Show JOptionPane");
	private JButton ok = new JButton("OK");
	
	private JTextField jtf = new JTextField(20);
	private JTextField jtf2 = new JTextField(10);

	private JDialog d2 = new JDialog();
	
	@Override
	public void init() {
		this.setSize(400, 300);
		
		d2.setSize(200, 100);
		d2.setTitle("输入信息");
		d2.setLocation(100, 200);
		// 设置为强制性对话框，默认为false
		d2.setModal(true);
		d2.add(ok, BorderLayout.SOUTH);
		d2.add(jtf2, BorderLayout.NORTH);
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText("over:" + jtf2.getText());
				d2.setVisible(false);
			}
		});
		
		showJOptionPane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hello");
				
				int res = JOptionPane.showConfirmDialog(null, "是否确认");
				jtf.setText("flag : " + res);
				
				String msg = JOptionPane.showInputDialog("输入");
				jtf.setText(msg);
			}
		});
		
		showDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				d2.setVisible(true);
			}
		});
		
		// 文本框添加插入符监听器，同步变化文本内容
		jtf2.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				jtf.setText(jtf2.getText());
			}
		});
		
        this.add(showDialog);
        this.add(showJOptionPane);
        this.add(jtf);
		
	}
	
}
