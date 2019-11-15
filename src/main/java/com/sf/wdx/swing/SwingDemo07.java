package com.sf.wdx.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 描述：画图并输出到文件
 * @author 80002888
 * @date   2019年11月8日
 */
public class SwingDemo07 {

	public static void main(String[] args) throws Exception {
		// 在内存创建图形缓存区
		BufferedImage img = new BufferedImage(400, 400, BufferedImage.TYPE_INT_BGR);
		// 获取图形缓存区的画笔
		Graphics graphics = img.getGraphics();
		
		// 画个背景
		graphics.setColor(new Color(220, 220, 220));
		graphics.fillRect(0, 0, 400, 400);
		
		// 画个图片（引入图片到图形缓存区）
		BufferedImage jpg1000355 = ImageIO.read(SwingDemo07.class.getResource("/file/1000355.jpg"));
		graphics.drawImage(jpg1000355, 0, 0, null);
		
		// 画个字体
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("楷体", Font.BOLD, 30));
		graphics.drawString("你好张三，Hello ZhangSan", 50, 50);
		
		// 画一堆字
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			String str= String.valueOf((char)(ran.nextInt(26) + 65));
			int x = 50 + 30*i;
			int y = ran.nextInt(300) + 50;
			int r = ran.nextInt(100) + 50;
			int g = ran.nextInt(100) + 50;
			int b = ran.nextInt(100) + 50;
			graphics.setColor(new Color(r, g, b));
			graphics.drawString(str, x, y);
		}
		
		// 画一堆线
		for (int i = 0; i < 100; i++) {
			int x1 = ran.nextInt(400);
			int y1 = ran.nextInt(400);
			int x2 = ran.nextInt(400);
			int y2 = ran.nextInt(400);
			
			int r = ran.nextInt(200);
			int g = ran.nextInt(200);
			int b = ran.nextInt(200);
			graphics.setColor(new Color(r, g, b));
			graphics.drawLine(x1, y1, x2, y2);
		}
		// 把图形缓存区输出到文件
		ImageIO.write(img, "jpg", new File("src/main/resources/file/output.jpg"));
	}
	
}
