package com.snake.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter{

    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case 39:	// -> Right
                //if it's not the opposite direction
                if(ThreadsController.snakeDirection1!=2)
                    ThreadsController.snakeDirection1=1;
                break;
            case 38:	// -> Top
                if(ThreadsController.snakeDirection1!=4)
                    ThreadsController.snakeDirection1=3;
                break;

            case 37: 	// -> Left
                if(ThreadsController.snakeDirection1!=1)
                    ThreadsController.snakeDirection1=2;
                break;

            case 40:	// -> Bottom
                if(ThreadsController.snakeDirection1!=3)
                    ThreadsController.snakeDirection1=4;
                break;

            default: 	break;
        }
        if (Window.gamemode == "two"){
            switch(e.getKeyCode()){
                case 68:	// -> Right
                    //if it's not the opposite direction
                    if(ThreadsController.snakeDirection2!=2)
                        ThreadsController.snakeDirection2=1;
                    break;
                case 87:	// -> Top
                    if(ThreadsController.snakeDirection2!=4)
                        ThreadsController.snakeDirection2=3;
                    break;
    
                case 65: 	// -> Left
                    if(ThreadsController.snakeDirection2!=1)
                        ThreadsController.snakeDirection2=2;
                    break;
    
                case 83:	// -> Bottom
                    if(ThreadsController.snakeDirection2!=3)
                        ThreadsController.snakeDirection2=4;
                    break;
    
                default: 	break;
            }
        }
    }

}
