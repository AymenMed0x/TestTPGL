package org.emp.gl.environnement;




public class Position{
    private int x;
    private int y;
    public Position(int xVal,int yVal) {
        this.x = xVal;
        this.y = yVal;
    }
    
    public int getY(){
        return y;
    }
    
    public int getX(){
        return x;
    }
    
    public void setY(int newY){
        y = newY;
    }
    
    public void setX(int newX){
        x = newX;
    }

}