package com.snake.game;

import java.util.ArrayList;


//Controls all the game logic .. most important class in this project.
public class ThreadsController extends Thread {
    ArrayList<ArrayList<DataOfSquare>> Squares= new ArrayList<ArrayList<DataOfSquare>>();
    Tuple snakeHeadPos1;
    Tuple snakeHeadPos2;
    int snakeSize1=3;
    int snakeSize2=3;
    long speed = 50;
    public static int snakeDirection1;
    public static int snakeDirection2;

    ArrayList<Tuple> positions1 = new ArrayList<Tuple>();
    ArrayList<Tuple> positions2 = new ArrayList<Tuple>();
    Tuple foodPosition;

    //Singleplayer Constructor
    ThreadsController(Tuple initPos){
        //Get all the threads
        Squares=Window.Grid;

        snakeHeadPos1=new Tuple(initPos.x, initPos.y);
        snakeHeadPos2=new Tuple();
        snakeDirection1 = 1;

        //!!! Pointer !!!!
        Tuple headPos = new Tuple(snakeHeadPos1.getX(),snakeHeadPos1.getY());
        positions1.add(headPos);

        foodPosition= new Tuple(Window.height-1,Window.width-1);
        spawnFood(foodPosition);

    }

    //Multiplayer Constructor
    ThreadsController(Tuple initPos1, Tuple initPos2){
        //Get all the threads
        Squares=Window.Grid;

        snakeHeadPos1=new Tuple(initPos1.x, initPos1.y);
        snakeHeadPos2=new Tuple(initPos2.x, initPos2.y);
        snakeDirection1 = 1;
        snakeDirection2 = 1;

        //!!! Pointer !!!!
        Tuple headPos1 = new Tuple(snakeHeadPos1.getX(),snakeHeadPos1.getY());
        Tuple headPos2 = new Tuple(snakeHeadPos2.getX(),snakeHeadPos2.getY());
        positions1.add(headPos1);
        positions2.add(headPos2);

        foodPosition= new Tuple(Window.height-1,Window.width-1);
        spawnFood(foodPosition);

    }

    //Important part :
    public void run() {
        if (Window.gamemode == "one"){
            while(true){
                moveInternal(snakeDirection1, 1);
                checkCollision(1);
                moveExternal();
                deleteTail(snakeSize1, positions1);
                pauser();
            }
        } else if (Window.gamemode == "two"){
            while(true){
                moveInternal(snakeDirection1, 1);
                moveInternal(snakeDirection2, 2);
                checkCollision(2);
                moveExternal();
                deleteTail(snakeSize1, positions1);
                deleteTail(snakeSize2, positions2);
                pauser();
            }
        }
    }

    //delay between each move of the snake
    private void pauser(){
        try {
            sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean checkPosCollides(Tuple pos){
        for(int i = 0;i<=positions1.size()-2;i++){
            if (pos.equals(positions1.get(i))){
                return true;
            }
        }
        for(int i = 0;i<=positions2.size()-2;i++){
            if (pos.equals(positions2.get(i))){
                return true;
            }
        }
        return false;
    }

    //Checking if the snake bites itself or is eating
    private void checkCollision(int players) {
        Tuple nextPos1 = snakeHeadPos1;
        Tuple nextPos2 = new Tuple();
        boolean player1Collision = checkPosCollides(nextPos1);
        boolean player2Collision = false;

        if (Window.gamemode == "two") {
            nextPos2 = snakeHeadPos2;
            player2Collision = checkPosCollides(nextPos2);
        }

        if (nextPos1.equals(nextPos2) || player1Collision && player2Collision){
            stopTheGame("Tie");
        }
        if (player1Collision){
            stopTheGame("Player1 died");
        }
        if (player2Collision){
            stopTheGame("Player2 died");
        }

        boolean eatingFood1 = nextPos1.equals(foodPosition);
        boolean eatingFood2 = false;
        if (Window.gamemode == "two") {
            eatingFood2 = nextPos2.equals(foodPosition);
        }
        if(eatingFood1){
            snakeSize1=snakeSize1+1;
        }else if (eatingFood2){
            snakeSize2=snakeSize2+1;
        }
        if(eatingFood1 || eatingFood2){
            foodPosition = getPosNotInSnake();
            spawnFood(foodPosition);
        }
    }

    //Stops The Game
    private void stopTheGame(String result){
        System.out.println(result+"\n");
        while(true){
            pauser();
        }
    }

    //Put food in a position and displays it
    private void spawnFood(Tuple foodPositionIn){
        Squares.get(foodPositionIn.getY()).get(foodPositionIn.getX()).lightMeUp(1);
    }

    //return a position not occupied by the snake
    private Tuple getPosNotInSnake(){
        Tuple p = new Tuple();
        do{
            p.ChangeData((int)(Math.random()*19),(int)(Math.random()*19));
        }while (checkPosCollides(p) || p.equals(snakeHeadPos1) || p.equals(snakeHeadPos2));
        return p;
    }

    //Moves the head of the snake and refreshes the positions in the arraylist
    //1:right 2:left 3:top 4:bottom 0:nothing
    private void moveInternal(int dir, int player){
        Tuple headPos;
        ArrayList<Tuple> positions;
        if (player == 1){
            headPos = snakeHeadPos1;
            positions = positions1;
        }else{
            headPos = snakeHeadPos2;
            positions = positions2;
        }

        switch(dir){
            case 4:
                headPos.ChangeData(headPos.x,(headPos.y+1)%20);
                positions.add(new Tuple(headPos.x,headPos.y));
                break;
            case 3:
                if(headPos.y-1<0){
                    headPos.ChangeData(headPos.x,19);
                }
                else{
                    headPos.ChangeData(headPos.x,Math.abs(headPos.y-1)%20);
                }
                positions.add(new Tuple(headPos.x,headPos.y));
                break;
            case 2:
                if(headPos.x-1<0){
                    headPos.ChangeData(19,headPos.y);
                }
                else{
                    headPos.ChangeData(Math.abs(headPos.x-1)%20,headPos.y);
                }
                positions.add(new Tuple(headPos.x,headPos.y));

                break;
            case 1:
                headPos.ChangeData(Math.abs(headPos.x+1)%20,headPos.y);
                positions.add(new Tuple(headPos.x,headPos.y));
                break;
        }
    }

    //Refresh the squares that needs to be
    private void moveExternal(){
        for(Tuple t : positions1){
            int x = t.getX();
            int y = t.getY();
            Squares.get(y).get(x).lightMeUp(0);
        }
        for(Tuple t : positions2){
            int x = t.getX();
            int y = t.getY();
            Squares.get(y).get(x).lightMeUp(0);
        }
    }

    //Refreshes the tail of the snake, by removing the superfluous data in positions arraylist
    //and refreshing the display of the things that is removed
    private void deleteTail(int size, ArrayList<Tuple> positions){
        int cmpt = size;
        for(int i = positions.size()-1;i>=0;i--){
            if(cmpt==0){
                Tuple t = positions.get(i);
                Squares.get(t.y).get(t.x).lightMeUp(2);
            }
            else{
                cmpt--;
            }
        }
        cmpt = size;
        for(int i = positions.size()-1;i>=0;i--){
            if(cmpt==0){
                positions.remove(i);
            }
            else{
                cmpt--;
            }
        }
    }
}
