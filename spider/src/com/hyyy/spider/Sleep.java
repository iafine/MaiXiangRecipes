package com.hyyy.spider;

import java.util.Random;

public class Sleep {
	public static void main(String args[]){
		for(int i=1; i<200; i++){
			System.out.println(i) ;
			
			try {
				Random random = new Random() ;
				int rank = random.nextInt(10) * 1000 ;
				Thread.sleep(rank);
				System.out.println(rank);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
