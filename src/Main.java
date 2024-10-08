import javax.swing.*;
import java.awt.*;

public class Main {
	static final int WINDOWX = 700;
	static final int WINDOWY = 700;
	public static JFrame closeFrame = new JFrame("You Died!");
	public static void main(String[] args) {



		//Creating the window with all its awesome snaky features
		Window f1= new Window();

		//Setting up the window settings
		f1.setTitle("Snake");
		f1.setSize(WINDOWX,WINDOWY);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		closeFrame.setSize(400, 400);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel label = new JLabel("Oh No! You died. Your score was, " + ThreadsController.score);



		panel.add(label);


		closeFrame.add(panel);
		closeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		closeFrame.pack();

		closeFrame.setLocationRelativeTo(null);
		closeFrame.setVisible(false);
		while(true){
			label.setText("Oh No! You died. Your score was, " + ThreadsController.score);
		}

	}
}
