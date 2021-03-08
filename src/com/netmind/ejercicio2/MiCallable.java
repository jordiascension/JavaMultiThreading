package com.netmind.ejercicio2;

import java.util.concurrent.Callable;

public class MiCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		int total = 0;
		for (int i = 0; i < 5; i++) {

			total += i;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println(Thread.currentThread().getName());

		return total;
	}

}
