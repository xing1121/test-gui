package com.cn.wdx.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 
 * 描述：SwingDemo07



 * @author wdx
 * @time   2020年9月20日
 */
public class SwingDemo07 {

	public static void main(String[] args) throws Exception {
		// 在内存区创建图形缓存区
		BufferedImage bufferedImage = 
				new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
		
		// 获取图形缓存区的画笔
		Graphics graphics = bufferedImage.getGraphics();
		
		// 画个背景
		graphics.setColor(new Color(220, 220, 220));
		graphics.fillRect(0, 0, 400, 400);
		
		// 画个图片（引入图片到图形缓存区）
		BufferedImage jpg = ImageIO.read(Object.class.getResource("/file/1000355.jpg"));
		graphics.drawImage(jpg, 0, 0, null);
		
		// 画个字体
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("楷体", Font.BOLD, 30));
		
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
		ImageIO.write(bufferedImage, 
				"jpg", 
				new File("src/main/resources/file/output.jpg"));
	}
	
}
