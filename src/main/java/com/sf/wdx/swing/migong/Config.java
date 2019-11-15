package com.sf.wdx.swing.migong;

/**
 * 描述：配置
 * @author 80002888
 * @date   2019年11月11日
 */
public class Config {

	/**
	 * 屏幕宽
	 */
	public static int swidth = 660;
	
	/**
	 * 屏幕高
	 */
	public static int sheight = 660;
	
	/**
	 * 墙宽
	 */
	public static int width = 66;
	
	/**
	 * 四个方向
	 */
	public static int left = 1;
	public static int right = 2;
	public static int up = 3;
	public static int down = 4;
	
	/**
	 * 0是路
	 * 1是墙
	 * 2是入口
	 * 3是出口
	 */
	public static int road = 0;
	public static int wall = 1;
	public static int enter = 2;
	public static int exit = 3;
	
	
	
	/**
	 * 地图
	 */
	public static int[][] map = new int[][]{
		{1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
		{1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
		{1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
		{1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
		{1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
		{1, 0, 1, 1, 1, 1, 0, 0, 0, 1},
		{1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
		{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		{1, 2, 1, 1, 1, 1, 1, 1, 1, 1}
	};
	
}
