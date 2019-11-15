package com.sf.wdx.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 描述：AppletLifeCycle
 * 	生命周期
 * 	init()：初始化时调用一次
 * 	stop()：每次将applet最小化时调用
 * 	start()：init()方法执行后调用一次，每次将applet弹出时调用
 * 	paint()：每次applet消失再显示时调用
 * 	destroy()：关闭applet时调用一次
 * @author 80002888
 * @date   2019年11月15日
 */
public class AppletLifeCycle extends Applet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4151540271187141644L;

	int a = 0;
	
	@Override
    public void init(){
        a++;
        System.out.println("init" + a);
    }
	
	@Override
	public void stop(){
		a++;
		System.out.println("stop" + a);
	}
	
	@Override
    public void start(){
        a++;
        System.out.println("start" + a);
        this.repaint();
    }
	
	@Override
    public void destroy(){
        a++;
        System.out.println("destroy" + a);
    }
	
	@Override
    public void paint(Graphics g){
        a++;
        System.out.println("paint" + a);
        // 设置画笔颜色
        g.setColor(Color.BLUE);
        // 设置字体
        g.setFont(new Font("华文彩云", Font.BOLD, 20));
        // 画字符串
        g.drawString("囫囵吞枣" + a + "次", 30, 30);
    }
	
}
