package com.netmind.ejercicio2;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Principal {
	public static void main(String[] args) {
		Instant start = Instant.now();
		try {
			ExecutorService servicio = Executors.newFixedThreadPool(1);

			Future<Integer> resultado = servicio.submit(new MiCallable());
			// https://gustavopeiretti.com/java-executorservice/
			// https://www.arquitecturajava.com/java-parallel-stream-y-rendimiento/
			while (!resultado.isDone()) {
				System.out.println("Running Long Work");
			}

			System.out.println("Get executed: " + resultado.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis(); // in
																		// millis
		System.out.println(
				"The method duration time in millis is:" + timeElapsed);

	}
}
