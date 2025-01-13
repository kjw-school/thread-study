package org.kjw.creation.section03.thread_termination_example;

public class Practice {

	public static void main(String[] args) {

		Thread thread = new Thread(new BlockingTask());

		thread.start();
		thread.interrupt();

	}

	private static class BlockingTask implements Runnable{

		@Override
		public void run() {

			try {
				Thread.sleep(500000);
			} catch(InterruptedException ie) {
				System.out.println("Exiting blocking thread");
			}

		}
	}

}
