import javax.swing.JFrame;

public class Main {

	static Window f1;
	public static void main(String[] args) {

		//Creating the window with all its awesome snaky features
		f1= new Window();
		
		//Setting up the window settings
		f1.setTitle("Snake");
		f1.setSize(300,300);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             

	}

	public static Window getWindow() {
		return f1;
	}
	public static void setWindow(Window window) {
		f1 = window;
	}
}
