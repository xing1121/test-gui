package com.sf.wdx.applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.net.URL;
 
/**
 * 描述：HelloApplet
 * 	如果启动发现中文都显示为小框框，这是乱码，要把文件编码格式设置为GBK
 * 	Run Configurations->Arguments->VM arguments，添加-Dfile.encoding=GB18030
 * @author 80002888
 * @date   2019年11月14日
 */
public class HelloWorldApplet extends Applet {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = -8589283437957365289L;

	@Override
	public void init() {
		// 获取页面传的参数
		String value = this.getParameter("key");
		System.out.println(value);
		// 获取类路径
		URL url = getCodeBase();
		System.out.println(url);
	}
	
	public void paint (Graphics g) {
		g.drawString ("Hello World Applet", 25, 50);
	}
	
}