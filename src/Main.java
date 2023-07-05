import javax.swing.JFrame;

public class Main {
	static final int WINDOWX = 700;
	static final int WINDOWY = 700;
	public static void main(String[] args) {

		//Creating the window with all its awesome snaky features
		Window f1= new Window();



		//Setting up the window settings
		f1.setTitle("Snake");
		f1.setSize(WINDOWX,WINDOWY);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             

	}
}
