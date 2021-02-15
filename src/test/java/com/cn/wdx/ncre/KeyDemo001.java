package com.cn.wdx.ncre;

import java.applet.Applet;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * 描述：KeyDemo001
小应用程序有一个按钮和一个文本区，按钮作为发生键盘事件的事件源，并对它实施监视。
程序运行时，先点击按钮，让按钮激活。
以后输入英文字母时，在正文区显示输入的字母。字母显示时，字母之间用空格符分隔，且满10个字母时，换行显示。


 * @author wdx
 * @time   2020年9月21日
 */
public class KeyDemo001 extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8121182095272403807L;

	private TextArea text = new TextArea(30, 30);
	
	private Button btn = new Button("OK");
	
	int count = 0;
	
	@Override
	public void init() {
		this.setSize(600, 400);
		
		this.add(text);
		this.add(btn);
		
		btn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				if (keyCode >= KeyEvent.VK_A
						&& keyCode <= KeyEvent.VK_Z) {
					
					// 全是大写
					text.append((char)keyCode + " ");
					// 大小写都存在
//					text.append(e.getKeyChar() + " ");
					
					if (count != 0 
							&&count % 10 == 0) {
						text.append("\n");
					}
					count ++;
				}
			}
		});
	}
	
}
