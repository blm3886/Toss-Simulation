import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CoinSimComponent extends JComponent{
	/**
	 * Places three bar component representing the number of times two Heads, two Tails and 1 Head and 1Tail occurs
       at appropriate position within the Jframe.
     *  
	 * @param COLOR_TWO_HEADS      color of the bar representing two heads.
	 * @param COLOR_TWO_TAILS      color of the bar representing two tails.
	 * @param COLOR_HEAD_TAIL      color of the bar representing 1 head and 1 tail on coin toss.
	 * @param LABEL_TWO_HEADS      label for the bar representing two heads.
	 * @param LABEL_TWO_TAILS      label for the bar representing two tails.
	 * @param LABEL_HEADTAIL       label for the bar representing 1 head and 1 tail on coin toss.
	 * @param VERTICAL_GAP         the vertical gap between the frame and the bar.
	 * @param scale                frame height divided by number of trails (one application unit). 
	 * @param bottom               the bottom position of the bars.
	 * @param left                 the x-coordinate of the bars.
	 * @param width                the width of the bar.
	 *
	 */
	
	public final Color COLOR_TWO_HEADS = Color.RED;
    public final Color COLOR_HEAD_TAIL = Color.GREEN;
	public final Color COLOR_TWO_TAILS = Color.BLUE;
	
	public static final String LABEL_TWO_HEADS = "Two Heads: ";
    public static final String LABEL_HEAD_TAIL = "A Head and a Tail: ";
    public static final String LABEL_TWO_TAILSS = "Two Tails: ";
    
    
    public final static int VERTIAL_GAP = 30;
    private double scale;
    private int bottom;
    private int left;
    private int width;
    
    private int percentTwoHeads;
    private int percentHeadTails;
    private int percentTwoTails;
    
   CoinTossSimulator toss;
   
    /**
     * constructor for initializing the object reference to the CoinTossSimulator class.
     */
    public CoinSimComponent(CoinTossSimulator toss){
    	this.toss = toss;
    }
    
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		scale = getHeight()/(double)toss.getNumTrials(); 
		bottom = (int) (getHeight()- VERTIAL_GAP); 
        left = (getWidth()/4)/6;  // diving screen into 4 equal parts then further dividing each part into 6 equal parts.
        width = 2*left;           // each bar width is 2*equal parts.
        
        // calculating the percentage for occurance of 2 heads, 2 tails and head and tails. 
        percentTwoHeads = (int) ((toss.getTwoHeads()/(double) toss.getNumTrials())*100);
        percentHeadTails = (int) ((toss.getHeadTails()/(double) toss.getNumTrials())*100);
        percentTwoTails= (int) ((toss.getTwoTails()/(double) toss.getNumTrials())*100);
        
        Bar bar = new Bar(bottom,left*5,width,toss.getTwoHeads(),scale,COLOR_TWO_HEADS,LABEL_TWO_HEADS+toss.getTwoHeads()+" ("+percentTwoHeads+"%)");
		Bar bar1 = new Bar(bottom,left*11,width,toss.getHeadTails(),scale,COLOR_HEAD_TAIL,LABEL_HEAD_TAIL+toss.getHeadTails()+" ("+percentHeadTails+"%)");
		Bar bar2 = new Bar(bottom,left*17,width,toss.getTwoTails(),scale,COLOR_TWO_TAILS,LABEL_TWO_TAILSS+toss.getTwoTails()+" ("+percentTwoTails+"%)");
		
		bar.draw(g2);
		bar1.draw(g2);
		bar2.draw(g2);
		
	}
	
	
}



