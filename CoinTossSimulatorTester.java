/**
 * Tester class for coinTossSimulator.
 * 
 *
 */

public class CoinTossSimulatorTester {

	public static void main(String[] args) {
		CoinTossSimulator toss = new CoinTossSimulator();
		toss.run(1);
		toss.run(10);
		toss.run(100);
		toss.reset();
		toss.run(1000);
	}

	
}