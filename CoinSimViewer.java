
import java.util.Scanner;
import javax.swing.JFrame;
//import javax.swing.JTextArea;

/**
 * class CoinSimViewer
 * @param BAR_WIDTH  Sets the width of the frame.
 * @param BAR_HEIGHT Sets the height of the frame.
 */

public class CoinSimViewer {
	final static int BAR_WIDTH = 800;
	final static int BAR_HEIGHT = 500;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of trials:");
		int numTrials = sc.nextInt();

		if (numTrials <= 0) {
			System.out.println("\"ERROR: Number entered must be greater than 0\"");
		} 
       else {
			CoinTossSimulator toss = new CoinTossSimulator();
			toss.run(numTrials);
			
			JFrame frame = new JFrame();
			frame.setSize(BAR_WIDTH, BAR_HEIGHT);
			frame.setTitle("Coin toss result");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			CoinSimComponent component1 = new CoinSimComponent(toss);
			
			frame.add(component1);
			frame.setVisible(true);
			
		}
	}

}
