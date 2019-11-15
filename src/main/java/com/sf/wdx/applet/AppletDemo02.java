package com.sf.wdx.applet;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 描述：AppletDemo02
 * @author 80002888
 * @date   2019年11月15日
 */
public class AppletDemo02 extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4362078170466595434L;
	
	@Override
	public void paint(Graphics g) {
		// 获取Applect上下文
		AppletContext context = getAppletContext();
		// 改变显示在浏览器状态栏的信息
		context.showStatus("连接中");
		// 请求浏览器显示一个URL地址对应的HTML文件，只有在容器是浏览器时才生效
		try {
			context.showDocument(new URL("http://www.baidu.com"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// 从浏览器获取applet的URL地址
		// 这里为类路径 file:/D:/DevSoft/mars-workspace/test-gui/target/classes/
		URL codeBase = this.getCodeBase();
		g.drawString(codeBase.toString(), 10, 10);
		// 从浏览器获得applet所嵌入的HTML文件的URL地址
		// 这里为HTML文件路径 file:/D:/DevSoft/mars-workspace/test-gui/target/classes/com/sf/wdx/applet/HelloWorldApplet.html
		URL documentBase = this.getDocumentBase();
		g.drawString(documentBase.toString(), 10, 20);
		// 获取图片，图片和HTML页面放在同一路径下
		Image im = getImage(getDocumentBase(),"two.png");
		// 画图，最后参数要传this，如果null则画不出来
		g.drawImage(im, 10, 40, this);
		// 获取声音，只能播放一部分格式（如.au、.wav），无法播放.mp3
		AudioClip adc = getAudioClip(getDocumentBase(), "19.wav");
		g.drawString(adc.toString(), 10, 30);
		// 播放声音
		adc.play();
	}
	
}
