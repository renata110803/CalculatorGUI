/* Renata Gabdrakhmanova
 * pd 2
 * 3/24/21
 * Calculator- creates a GUI calculator with a picture on the background, buttons, and the space to write
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GabdrakhmanovaRenata_Calculator extends JFrame {

	public GabdrakhmanovaRenata_Calculator() {

		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 415);

		// creates a panel with buttons and adds them to the window
		//the panel is resized and replaced
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 4, 30, 26));
		String array[] = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "+", ".", "0", "=", "-" };

		int i = 0;
		
		//creates buttons and names based on the array
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {

				panel1.add(new JButton(array[i]));
				i++;

			}
		}

	
		panel1.setBounds(35, 85, 300, 200);
		panel1.setOpaque(false);
		add(panel1);

		// creates and adds a panel with text input
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JTextField input = new JTextField(20);
		panel2.add(input);
		panel2.setBounds(36, 26, 300, 100);
		panel2.setOpaque(false);
		add(panel2);

		// creates and adds a panel with picture
		PicPanel panel = new PicPanel("math.jpg");
		add(panel);

		setVisible(true);
	}

	public class PicPanel extends JPanel {
		private BufferedImage image;

		public PicPanel(String fname) {

			try {
				image = ImageIO.read(new File(fname));
			} catch (IOException ioe) {
				System.out.println("Could not read in the pic");
				System.exit(0);
			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}

	public static void main(String[] args) {
		GabdrakhmanovaRenata_Calculator calculator = new GabdrakhmanovaRenata_Calculator();
	}
}
