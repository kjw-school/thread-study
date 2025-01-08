package org.kjw.creation.section02;

import java.util.ArrayList;
import java.util.List;

/**
 * 이 클래스의 클라이언트는 {@code Runnable}작업의 목록을 생성해서 해당 목록을 {@code MultiExecutor}의 생성자에게 제공할 것입니다.<br>
 * 클라이언트가 {@code executeALl()}을 실행하면, {@code MultiExecutor}가 주어진 모든작업을 실행하게 됩니다.<br>
 * 멀티코어 CPU를 최대한 활용하기 위해, 우리는 각 작업을 서로 다른 스레드로 전달해서 {@code MultiExecutor}가 모든 작업을 동시에 진행하게 하려고합니다.
 */
public class MultiExecutor {

	private final List<Runnable> tasks;

	public MultiExecutor(List<Runnable> tasks) {
		this.tasks = tasks;
	}

	public void executeAll() {

		List<Thread> threads = new ArrayList<>(tasks.size());

		for(Runnable task : tasks) {
			Thread thread = new Thread(task);
			threads.add(thread);
		}

		for(Thread thread : threads) {
			thread.start();
		}

	}

}
