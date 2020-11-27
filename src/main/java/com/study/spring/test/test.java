package com.study.spring.test;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String val = "ab";
		//String sVal =val.substring(0, 100);
		System.out.println(val.length());
		String content7bit= "fsdaffs sdfs sdfsfsa sdfs sdfsd sfsf";
		
        int parts = (int)Math.ceil(content7bit.length() / 10);
        int free_chars = content7bit.length() - (int)Math.floor(content7bit.length() / 10)*10;
        System.out.println(String.format("parts: %s, free_char: %s", parts, free_chars));
        
	}

}
