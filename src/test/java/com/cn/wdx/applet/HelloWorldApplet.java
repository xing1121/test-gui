package com.cn.wdx.applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.JOptionPane;

 
/**
 * 
 * 描述：HelloWorldApplet
如果启动发现中文都显示为小框框，这是乱码，要把文件编码格式设置为GBK
Run Configurations->Arguments->VM arguments，添加-Dfile.encoding=GB18030
Applet默认布局管理器为FlowLayout
JApplet默认布局管理器为BorderLayout

 * @author wdx
 * @time   2020年9月20日
 */
public class HelloWorldApplet extends Applet {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = -8589283437957365289L;

	@Override
	public void init() {
		this.setSize(600, 400);
		System.out.println("init");
		// 获取类路径
		URL url = this.getCodeBase();
		System.out.println(url);
		// 获取页面传的参数
		String value = this.getParameter("key");
		System.out.println(value);
		// 添加组件
		Button okBtn = new Button("OK");
		okBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "你单击了：" + e.getSource());
		});
		this.add(okBtn);
	}

	@Override
	public void start() {
		System.out.println("start");
	}
	
	@Override
	public void stop() {
		System.out.println("stop");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	int paintCount = 0;
	
	@Override
	public void paint (Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(new Font("华为彩云", Font.BOLD, 20));
		g.drawString("Hello World Applet:" + ++paintCount, 25, 50);
	}
	
}