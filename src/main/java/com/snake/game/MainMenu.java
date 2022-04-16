package com.snake.game;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainMenu extends JFrame{
    private JLabel title;
    private JButton onePlayerButton;
    private JButton twoPlayerButton;
    private JPanel panel;

    public MainMenu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        title = new JLabel("Snake");
        onePlayerButton = new JButton();
        twoPlayerButton = new JButton();

        onePlayerButton.setText("One Player");
        onePlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(e, "one");
            }
        });

        twoPlayerButton.setText("Two Players");
        twoPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(e, "two");
            }
        });

        panel.add(title);
        panel.add(onePlayerButton);
        panel.add(twoPlayerButton);
        this.add(panel);
    }

    private void startGame(ActionEvent e, String gamemode){
        Window.gamemode = gamemode;
        Window game = new Window();

        game.setTitle("Snake");
        game.setSize(300,300);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
        this.setVisible(false);
    }
}
