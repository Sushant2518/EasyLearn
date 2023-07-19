package com.masai.utility;

public class IdGeneration {
	public  static long generateID() {
		long l = Math.round(Math.random()*1000000000L);
		return l;
	}
	public static void main(String[] args) {
		System.out.println(generateID());;
	}
}
