package org.kjw.creation.section03.thread_termination_example;

import java.math.BigInteger;

public class Practice2 {

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(new LongComputationTask(new BigInteger("2"), new BigInteger("10")));
		thread.setDaemon(true);
		thread.start();
		thread.sleep(100);
		thread.interrupt();

	}

	private static class LongComputationTask implements Runnable{

		private BigInteger base;
		private BigInteger power;

		public LongComputationTask(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() { System.out.println(base+"*"+power+" = "+pow(base,power)); }

		private BigInteger pow(BigInteger base, BigInteger power) {
			BigInteger result = BigInteger.ONE;

			for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i.add(BigInteger.ONE)) {
				result = result.multiply(base);
			}

			return result;

		}

	}

}
