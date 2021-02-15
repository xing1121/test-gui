package com.cn.wdx.applet;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * 描述：AppletDemo02



 * @author wdx
 * @time   2020年9月21日
 */
public class AppletDemo02 extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3767450949719722721L;

	@Override
	public void paint(Graphics g) {
		// 获取Applet上下文
		AppletContext context = this.getAppletContext();
		// 改变显示在浏览器状态栏的信息
		context.showStatus("连接中");
		// 请求浏览器显示一个url地址对应的html文件，只有在容器是浏览器时才生效
		try {
			context.showDocument(new URL("http://www.baidu.com"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// 从浏览器中获取url地址，这里为类路径codeBase
		// getCodeBase()得到的是applet调用的.class文件所在的目录路径
		// getDocumentBase()得到的是applet存在的html文件所在的目录
		URL codeBase = this.getCodeBase();
		g.drawString(codeBase.toString(), 10, 10);
		URL documentBase = getDocumentBase();
		g.drawString(documentBase.toString(), 10, 20);
		// 获取本包下的图片
		Image image = getImage(documentBase, "two.png");
		// 画图，最后要传this，传null画不出来
		g.drawImage(image, 10, 40, this);
		// 获取声音，只能播放一部分格式（如.au、.wav），无法播放.mp3
		AudioClip adc = getAudioClip(documentBase, "19.wav");
		g.drawString(adc.toString(), 10, 30);
		// 播放声音
		adc.play();
	}
	
}
