import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class Bar {
	
	/**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param applicationHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
	private String label;
	private int bottom;
	private int left;
	private int width;
	private int applicationHeight;
    private double scale;
	Color color;
	
   public Bar(int bottom, int left, int width, int applicationHeight,
              double scale, Color color, String label) {
	   this.bottom=bottom;
	   this.left=left;
	   this.width=width;
	   this.applicationHeight = applicationHeight;
	   this.scale = scale;
	   this.color=color;
	   this.label = label;
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   
   //draw a bar with label in a given graph.
   public void draw(Graphics2D g2) {
	   Font font = g2.getFont();
	   FontRenderContext context = g2.getFontRenderContext();
	   Rectangle2D labelBounds = font.getStringBounds(label, context);
	   
	   int widthOfLabel = (int) labelBounds.getWidth();
	   int heightOfLabel = (int) labelBounds.getHeight();
	   g2.setColor(color);
	   g2.fillRect(left,(bottom-(int)Math.round(applicationHeight*scale)), width, (int)Math.round(applicationHeight*scale));
	   g2.setColor(Color.black);
	   g2.drawString(label,left - ((widthOfLabel - width)/2), heightOfLabel + bottom);
   }
}