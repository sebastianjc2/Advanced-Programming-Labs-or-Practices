import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/*
 * Koch class that draws a koch fractal
 * Remember to add your name and repo.
 * Name: Caballero Diaz, Sebastian J.
 * Repo: https://github.com/uprm-ciic4010-s20/lab-8-recursion-lab-sebastianjc2
 */
public class Koch extends JComponent {

	private static ArrayList<Line2D.Double> lines = new ArrayList<Line2D.Double>();
	private static int count = 0;
	private static final long serialVersionUID = -8623858390198173330L;

	public void paintComponent(Graphics g) {

		g.setColor(Color.RED);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));

		for (int i = 0; i < count; i++) {
			g2.draw(lines.get(i));
		}

		if (count < lines.size()) {
			count++;
		}

	}

	public static void main(String[] args){

		JFrame mainFrame = new JFrame("Recursion");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        //Display the window.
        mainFrame.pack();
		mainFrame.setSize(900, 1000);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(new Koch());
		mainFrame.setVisible(true);

		// This is the starting point of the recursion.
		// The first parameter indicate the level of the fractal.
		// The other are the three points of the initial triangle.

		shape(4, new Flake(new Point2D.Double(33.0, 245.0), new Point2D.Double(833.0, 245.0)));
		shape(4, new Flake(new Point2D.Double(833.0, 245.0), new Point2D.Double(448.0, 967.0)));
		shape(4, new Flake(new Point2D.Double(448.0, 967.0), new Point2D.Double(33.0, 245.0)));

		while (count < lines.size()) {

			try {

				Thread.sleep(1000 / 30);

			} catch (Exception e) {

				// DO Nothing

			}

			mainFrame.getContentPane().getComponent(0).repaint();
		}
        
		try {
			// Capture and save frame image
			// parent component of the dialog
			 
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setSelectedFile(new File("koch.png"));
			fileChooser.setDialogTitle("Specify a file to save");   
			 
			int userSelection = fileChooser.showSaveDialog(mainFrame);
			 
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    File fileToSave = fileChooser.getSelectedFile();
				getSaveSnapShot(mainFrame, fileToSave);
			    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
     * EXERCISE 3
     * This is the recursive method that you will submit.
     * Follow the sample line given and complete the next 3
     * lines of code that are missing.
     */

	public static void shape(double n, Flake flake) {
		
		if (n <= 0) {
			// This is used to later animate the recursion. DO NOT REMOVE!
			 lines.add((Double) flake.getLine2D());
			return;
		}
		
		shape(n - 1, new Flake(flake.getA(), flake.getB()));
		// Add your code here.
		shape(n - 1, new Flake(flake.getB(), flake.getC()));
		shape(n - 1, new Flake(flake.getC(), flake.getD()));
		shape(n - 1, new Flake(flake.getD(), flake.getE()));
	
	}
	
    public static BufferedImage getScreenShot(Component component) {

        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        return image;
    }

    public static void getSaveSnapShot(Component component, File fileName) throws Exception {
        BufferedImage img = getScreenShot(component);
        // write the captured image as a PNG
        ImageIO.write(img, getExtension(fileName), fileName);
    }
    
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
