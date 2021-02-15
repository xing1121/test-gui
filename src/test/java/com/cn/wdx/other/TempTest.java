package com.cn.wdx.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * 描述：体温生成



 * @author wdx
 * @time   2020年9月10日
 */
public class TempTest {

	private static int min = 364;
	
	public static void main(String[] args) {
		List<Integer> res = random(18);
		res.stream().forEach(System.out::println);
	}
	
	public static List<Integer> random(int size){
		List<Integer> res = new ArrayList<>(size);
		
		Random r = new Random();
		
		for (int j = 0; j < size; j++) {
			int i = r.nextInt(8);
			res.add(min + i);
		}
		
		return res;
	}
	
}
