import javax.swing.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

	private static int attempt = 1;
	private static Window currentWindow;

	public static void main(String[] args) {
		startGame();
	}

	private static void startGame() {
		// game restart loop
		do {
			if (attempt > 1) {
				clearBoard();
			}
			//Creating the window with all its awesome snaky features
			currentWindow = new Window();

			//Setting up the window settings
			currentWindow.setTitle("Snake attempt " + attempt++);
			currentWindow.setSize(300,300);
			currentWindow.setLocationRelativeTo(null);
			currentWindow.setVisible(true);
			currentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Wait until the current game is finished
			currentWindow.waitForGameEnd();

		} while (restartRequested());
		clearBoard();
	}

	private static void clearBoard() {
		currentWindow.dispose();
	}

	private static boolean restartRequested() {

		FutureTask<Integer> restartQuestion = new FutureTask<Integer>(
				()->JOptionPane.showConfirmDialog(
						null,
						"Play again?",
						"You played yourself",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE));

		restartQuestion.run();
		try {
			int response = restartQuestion.get();
			return response == JOptionPane.YES_OPTION;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return false;
		}
	}
}
