
import java.util.Random;


public class CoinTossSimulator {
    private int twoheadsCount;
	private int twoTailsCount;
	private int headTailsCount;
	private int totalTrialCount;

	/**
	 * Creates a coin toss simulator with no trials done yet.
	 */
	public CoinTossSimulator() {
		twoheadsCount = 0;
		twoTailsCount = 0;
		headTailsCount = 0;
		totalTrialCount = 0;
	}

	/**
	 * Runs the simulation for numTrials more trials. Multiple calls to this method
	 * without a reset() between them *add* these trials to the current simulation.
	 * 
	 * @param numTrials number of trials to for simulation; must be >= 1
	 */
	public void run(int numTrials) {
		printConstructorStatus(); // checking the constructor status
		setTotalTrials(numTrials);
		Random rand1 = new Random();
		Random rand2 = new Random();
		for (int i = 1; i <= numTrials; i++) {
			// getting random value 0 or 1 (0 = HEADS, 1= TAILS)
			int coin1Side = rand1.nextInt(2);
			int coin2Side = rand2.nextInt(2);
			
			if (coin1Side == 0 && coin2Side == 0) {
				twoheadsCount++;
			} else if (coin1Side == 1 && coin2Side == 1) {
				twoTailsCount++;
			} else {
				headTailsCount++;
			}

		}
		printRunStatus(numTrials);
	}

	/**
	 * Sets the total number of trial performed since last reset.
	 */
	public void setTotalTrials(int numTrials) {
		totalTrialCount = totalTrialCount + numTrials;
	}

   
	/**
	 * Get number of trials performed since last reset.
	 */
	public int getNumTrials() {
		return getTwoHeads() + getTwoTails() + getHeadTails();
	}

   
	/**
	 * Get number of trials that came up two heads since last reset.
	 */
	public int getTwoHeads() {
		return twoheadsCount; 
	}

   
	/**
	 * Get number of trials that came up two tails since last reset.
	 */
	public int getTwoTails() {
		return twoTailsCount; 
	}

   
	/**
	 * Get number of trials that came up one head and one tail since last reset.
	 */
	public int getHeadTails() {
		return headTailsCount; 
	}

   
	/**
	 * Resets the simulation, so that subsequent runs start from 0 trials done.
	 */
	public void reset() {
		twoheadsCount = 0;
		twoTailsCount = 0;
		headTailsCount = 0;
		totalTrialCount = 0;
		printResetStatus();

	}

   
	/**
	 * Displays information after each call to the constructor
	 */
	private void printConstructorStatus() {
		System.out.println("\nAfter constructor");
		System.out.println("Number of trails[exp:0]:" + getNumTrials());
		System.out.println("Two-head tosses:" + getTwoHeads());
		System.out.println("Two-tail tosses:" + getTwoTails());
		System.out.println("One-head one tail toss:" + getHeadTails());
		System.out.println("Tosses add up correctly?" + tossAddCorrectly());

	}

	/**
	 * Displays information after each call to Run
	 * 
	 * @param numTrials Current number of trials.
	 */
	private void printRunStatus(int numTrials) {
		System.out.println("\nAfter run(" + numTrials + ")");
		System.out.println("Number of trails[exp:" + totalTrialCount + "]:" + getNumTrials());
		System.out.println("Two-head tosses:" + getTwoHeads());
		System.out.println("Two-tail tosses:" + getTwoTails());
		System.out.println("One-head one tail toss:" + getHeadTails());
		System.out.println("Tosses add up correctly?" + tossAddCorrectly());
	}
   
   /**
	 * Displays information after each call to Reset
	 *  
	 */

	private void printResetStatus() {
		System.out.println("\nAfter reset:");
		System.out.println("Number of trails[exp:0]:" + getNumTrials());
		System.out.println("Two-head tosses:" + getTwoHeads());
		System.out.println("Two-tail tosses:" + getTwoTails());
		System.out.println("One-head one tail toss:" + getHeadTails());
		System.out.println("Tosses add up correctly?" + tossAddCorrectly());
	}
   
    /**
	 * Returns true when the number of trials add up correctly.
	 *  
	 */
   
	private boolean tossAddCorrectly() {
		if (getNumTrials() == getTwoHeads() + getTwoTails() + getHeadTails())
			return true;
		else
			return false;
	}

}
