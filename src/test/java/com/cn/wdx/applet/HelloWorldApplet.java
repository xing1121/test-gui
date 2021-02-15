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
 * ������HelloWorldApplet
��������������Ķ���ʾΪС����������룬Ҫ���ļ������ʽ����ΪGBK
Run Configurations->Arguments->VM arguments�����-Dfile.encoding=GB18030
AppletĬ�ϲ��ֹ�����ΪFlowLayout
JAppletĬ�ϲ��ֹ�����ΪBorderLayout

 * @author wdx
 * @time   2020��9��20��
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
		// ��ȡ��·��
		URL url = this.getCodeBase();
		System.out.println(url);
		// ��ȡҳ�洫�Ĳ���
		String value = this.getParameter("key");
		System.out.println(value);
		// ������
		Button okBtn = new Button("OK");
		okBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "�㵥���ˣ�" + e.getSource());
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
		g.setFont(new Font("��Ϊ����", Font.BOLD, 20));
		g.drawString("Hello World Applet:" + ++paintCount, 25, 50);
	}
	
}