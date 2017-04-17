package com.hlbb.frm.kit;

import java.util.Random;


public class RandomKit {
	public static String randomStr(){
		Random random = new Random();
		int num = random.nextInt(100);
		long time = System.currentTimeMillis();
		return HashKit.md5(num+""+time);
	}
}
