package com.sf.wdx.applet;

import java.applet.Applet;
import java.awt.Button;

/**
 * 描述：AppletDemo01
 * 	默认布局为FlowLayout
 * @author 80002888
 * @date   2019年11月15日
 */
public class AppletDemo01 extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7433534879737871862L;

	@Override
	public void init() {
		Button button = new Button("点我");
		add(button);
	}

}
