package com.snake.game;

public class Tuple {
    public  int x;
    public  int y;

    public Tuple() {
        this.x = -1;
        this.y = -1;
    }

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void ChangeData(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Tuple other){
        return this.x == other.getX() && this.y == other.getY();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}