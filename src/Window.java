import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.File;

class Window extends JFrame {
    private static final long serialVersionUID = -2542001418764869760L;
    public static ArrayList<ArrayList<DataOfSquare>> Grid;
    public static int width = 20;
    public static int height = 20;

    private ThreadsController controller;

    public Window() {
        // Set modern Look and Feel (Nimbus)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // Fallback to default
        }

        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Creates the arraylist that'll contain the threads
        Grid = new ArrayList<ArrayList<DataOfSquare>>();
        ArrayList<DataOfSquare> data;

        // Creates Threads and its data and adds it to the arrayList
        for (int i = 0; i < width; i++) {
            data = new ArrayList<DataOfSquare>();
            for (int j = 0; j < height; j++) {
                DataOfSquare c = new DataOfSquare(2);
                data.add(c);
            }
            Grid.add(data);
        }

        // Use a JPanel for padding and modern border
        JPanel mainPanel = new JPanel(new GridLayout(width, height, 2, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(getBackground());

        // Add every square of each thread to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                mainPanel.add(Grid.get(i).get(j).square);
            }
        }

        setContentPane(mainPanel);

        // Set preferred size and center the window
        setPreferredSize(new Dimension(width * 30, height * 30));
        pack();
        setLocationRelativeTo(null);

        // initial position of the snake
        Tuple position = new Tuple(10, 10);
        // passing this value to the controller
        controller = new ThreadsController(position, this); // Pass Window as observer
        // Let's start the game now..
        controller.start();

        // Links the window to the keyboard listener.
        this.addKeyListener((KeyListener) new KeyboardListener());

        // setVisible should be called after everything is set up
        setVisible(true);
    }

    // Call this method when the snake eats a point
    public static void playEatSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                new File("eat.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error playing sound: " + ex.getMessage());
        }
    }

    // Call this method when the game is over
    public static void playGameOverSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                new File("gameover.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error playing game over sound: " + ex.getMessage());
        }
    }

    // Call this method when the game is over
    public void onGameOver() {
        playGameOverSound(); // Play sound effect
        int option = JOptionPane.showConfirmDialog(
            this,
            "Game Over! Do you want to restart?",
            "Game Over",
            JOptionPane.YES_NO_OPTION
        );
        if (option == JOptionPane.YES_OPTION) {
            restartGame();
        } else {
            System.exit(0);
        }
    }

    private void restartGame() {
        // Remove old content
        getContentPane().removeAll();
        // Re-initialize grid and controller
        Grid.clear();
        ArrayList<DataOfSquare> data;
        for (int i = 0; i < width; i++) {
            data = new ArrayList<DataOfSquare>();
            for (int j = 0; j < height; j++) {
                DataOfSquare c = new DataOfSquare(2);
                data.add(c);
            }
            Grid.add(data);
        }
        JPanel mainPanel = new JPanel(new GridLayout(width, height, 2, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(getBackground());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                mainPanel.add(Grid.get(i).get(j).square);
            }
        }
        setContentPane(mainPanel);
        revalidate();
        repaint();

        // Restart controller
        Tuple position = new Tuple(10, 10);
        controller = new ThreadsController(position, this);
        controller.start();
    }
}
