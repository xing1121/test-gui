package com.sf.wdx.swing.migong;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * 描述：MainFrame
 * @author 80002888
 * @date   2019年11月11日
 */
public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1408813769725712036L;

	private GamePanel gamePanel = new GamePanel();
	
	public MainFrame() throws HeadlessException {
		super("迷宫v1.0");
		this.setSize(Config.swidth + 15, Config.sheight + 35);
		this.setLocation(100, 100);
		// 添加游戏面板
		this.add(gamePanel);
		// 上下左右按键监听器
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					gamePanel.setDirect(Config.left);
					gamePanel.playGame();
					break;
				case KeyEvent.VK_RIGHT:
					gamePanel.setDirect(Config.right);
					gamePanel.playGame();
					break;
				case KeyEvent.VK_UP:
					gamePanel.setDirect(Config.up);
					gamePanel.playGame();
					break;
				case KeyEvent.VK_DOWN:
					gamePanel.setDirect(Config.down);
					gamePanel.playGame();
					break;
				default:
					break;
				}
			}
		});
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
}
