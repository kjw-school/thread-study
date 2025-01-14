package org.kjw.creation.section03;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 다음 식을 효율적으로 계산하여라.
 * result = base1 ^ power1 + base2 ^ power2
 * 숫자를 제곱하는 연산은 복잡하므로 다음 식으로 실행하여라
 * result1 = x1 ^ y1
 * result2 = x2 ^ y2
 * 둘을 동시에 실행하고, 마지막에는 다음과 같이 결과값을 더하라
 * result = result1 + result2
 * 참고( base >= 0, base2 >= 0, power1 >= 0, power2 >= 0)
 */
public class ComplexCalculation {

	public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws
		InterruptedException {
		BigInteger result = BigInteger.ZERO;

		PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
		PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);

		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch(InterruptedException ie) {
			System.out.println(ie);
		}

		result = thread1.getResult().add(thread2.getResult());

		return result;
	}

	private static class PowerCalculatingThread extends Thread {
		private BigInteger result = BigInteger.ONE;
		private BigInteger base;
		private BigInteger power;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i.add(BigInteger.ONE)) {
				result = result.multiply(base);
			}
		}

		public BigInteger getResult() { return result; }
	}
}
