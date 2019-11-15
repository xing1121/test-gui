package com.sf.wdx.swing.migong;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 描述：GamePanel
 * @author 80002888
 * @date   2019年11月11日
 */
public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5130377547597000409L;

	/**
	 * 墙素材
	 */
	private BufferedImage wall;
	
	/**
	 * 存储人物上下左右素材
	 */
	private BufferedImage left[] = new BufferedImage[4];
	private BufferedImage right[] = new BufferedImage[4];
	private BufferedImage up[] = new BufferedImage[4];
	private BufferedImage down[] = new BufferedImage[4];
	
	/**
	 * 小人的行和列
	 */
	private int row = 0;
	private int col = 0;
	
	/**
	 * 小人的方向
	 */
	private int direct = 0;
	
	/**
	 * 动画索引0123
	 */
	private int index = 0;
	
	public GamePanel() throws HeadlessException {
		super();
		this.setSize(Config.swidth, Config.sheight);
		// 加载图片，放入类属性
		this.initImage();
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		// 画地图
		this.initMap(g);
		// 获取类路径下19.wav声频文件
		AudioClip adc = Applet.newAudioClip(Object.class.getResource("/19.wav"));
		// 播放声音
		adc.play();
	}

	@Override
	public Dimension getPreferredSize() {
		// 初始化组件的宽高
		return new Dimension(Config.swidth, Config.sheight);
	}
	
	/**
	 * 初始化图片
	 *	@ReturnType	void 
	 *	@Date	2019年11月11日	下午5:01:44
	 *  @Param
	 */
	public void initImage() {
		 try {
			wall = ImageIO.read(this.getClass().getResourceAsStream("/pic/wall.png"));
			for (int i = 1; i <= 4; i++) {
				left[i-1] = ImageIO.read(this.getClass().getResourceAsStream("/pic/1." + i + ".png"));
				right[i-1] = ImageIO.read(this.getClass().getResourceAsStream("/pic/2." + i + ".png"));
				up[i-1] = ImageIO.read(this.getClass().getResourceAsStream("/pic/3." + i + ".png"));
				down[i-1] = ImageIO.read(this.getClass().getResourceAsStream("/pic/4." + i + ".png"));
			}
		} catch (IOException e) {
			System.out.println("EEEOR_001加载图片出错");
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化地图
	 *	@ReturnType	void 
	 *	@Date	2019年11月11日	下午5:16:31
	 *  @Param  @param g
	 */
	public void initMap(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Config.swidth, Config.sheight);
		for (int i = 0; i < Config.map.length; i++) {
			for (int j = 0; j < Config.map[i].length; j++) {
				int val = Config.map[i][j];
				// 画入口，将入口坐标放到row和col，人物的x坐标和列col有关，y坐标和行row有关
				if (val == Config.enter) {
					row = i;
					col = j;
					this.initEnter(g);
				}
				// 画出口
				if (val == Config.exit) {
					g.setColor(Color.RED);
					g.fillRect(j*Config.width, i*Config.width, Config.width, Config.width);
					g.setColor(Color.YELLOW);
					g.fillOval(j*Config.width + 15, i*Config.width + 20, 10, 10);
					g.drawLine(j*Config.width + 30, 0, j*Config.width + 30, 66);
					g.fillOval(j*Config.width + 40, i*Config.width + 20, 10, 10);
				}
				// 画墙
				if (val == Config.wall) {
					g.drawImage(wall, Config.width*j, Config.width*i, null);
				}
			}
		}
	}
	
	/**
	 * 初始化入口小人
	 *	@ReturnType	void 
	 *	@Date	2019年11月13日	下午3:18:33
	 *  @Param  @param g
	 */
	public void initEnter(Graphics g) {
		if (col > 0 && Config.map[row][col-1] == Config.road) {
			// 向左
			direct = Config.left;
			g.drawImage(left[0], col * Config.width, row * Config.width, null);
		} else if (col < 9 && Config.map[row][col+1] == Config.road) {
			// 向右
			direct = Config.right;
			g.drawImage(right[0], col * Config.width, row * Config.width, null);
		} else if (row > 0 && Config.map[row-1][col] == Config.road) {
			// 向上
			direct = Config.up;
			g.drawImage(up[0], col * Config.width, row * Config.width, null);
		} else if (row < 9 && Config.map[row+1][col] == Config.road) {
			// 向下
			direct = Config.down;
			g.drawImage(down[0], col * Config.width, row * Config.width, null);
		}
	}
	
	/**
	 * 游戏动作
	 *	@ReturnType	void 
	 *	@Date	2019年11月13日	下午4:33:43
	 *  @Param
	 */
	public void playGame(){
		Graphics g = this.getGraphics();
		if (index == 4) {
			index = 0;
		}
		if (direct == Config.left) {
			// 向左
			Image ig = left[index++];
			if (col > 0 && Config.map[row][col-1] == Config.road 
					|| col > 0 && Config.map[row][col-1] == Config.enter
					|| col > 0 && Config.map[row][col-1] == Config.exit) {
				// 有路可走
				g.drawImage(ig, (col-1)*Config.width, row*Config.width, null);
				g.setColor(Color.WHITE);
				g.fillRect(col*Config.width, row*Config.width, Config.width, Config.width);
				col --;
			} else {
				// 无路可走
				g.drawImage(ig, col*Config.width, row*Config.width, null);
			}
		} else if (direct == Config.right) {
			// 向右
			Image ig = right[index++];
			if (col < 9 && Config.map[row][col+1] == Config.road 
					|| col < 9 && Config.map[row][col+1] == Config.enter
					|| col < 9 && Config.map[row][col+1] == Config.exit) {
				// 有路可走
				g.drawImage(ig, (col+1)*Config.width, row*Config.width, null);
				g.setColor(Color.WHITE);
				g.fillRect(col*Config.width, row*Config.width, Config.width, Config.width);
				col ++;
			} else {
				// 无路可走
				g.drawImage(ig, col*Config.width, row*Config.width, null);
			}
		} else if (direct == Config.up) {
			// 向上
			Image ig = up[index++];
			if (row > 0 && Config.map[row-1][col] == Config.road
					|| row > 0 && Config.map[row-1][col] == Config.enter
					|| row > 0 && Config.map[row-1][col] == Config.exit) {
				// 有路可走
				g.drawImage(ig, col*Config.width, (row-1)*Config.width, null);
				g.setColor(Color.WHITE);
				g.fillRect(col*Config.width, row*Config.width, Config.width, Config.width);
				row --;
			} else {
				// 无路可走
				g.drawImage(ig, col*Config.width, row*Config.width, null);
			}
		} else if (direct == Config.down) {
			// 向下
			Image ig = down[index++];
			if (row < 9 && Config.map[row+1][col] == Config.road 
					|| row < 9 && Config.map[row+1][col] == Config.enter
					|| row < 9 && Config.map[row+1][col] == Config.exit) {
				// 有路可走
				g.drawImage(ig, col*Config.width, (row+1)*Config.width, null);
				g.setColor(Color.WHITE);
				g.fillRect(col*Config.width, row*Config.width, Config.width, Config.width);
				row ++;
			} else {
				// 无路可走
				g.drawImage(ig, col*Config.width, row*Config.width, null);
			}
		}
		if (Config.map[row][col] == Config.exit) {
			JOptionPane.showMessageDialog(null, "You win!");
			System.exit(0);
		}
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}
	
}
