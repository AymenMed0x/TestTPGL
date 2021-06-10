package org.emp.gl.environnement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Environnement implements PropertyChangeListener{
    public Environnement (){
        pcs=new PropertyChangeSupport(this);
    }
    
    private int[][] maze = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, },
            { 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, },
            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, },
            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, },
            { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, },
            { 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, },
            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, } };

    public int getValue(int x,int y){
        return maze[x][y];
    }
    public void setValue(int x,int y,int val){
        maze[x][y] = val;
    }
    public boolean estObstacle(int x,int y){
        return (maze[x][y]==1);
    }
    private PropertyChangeSupport pcs =null;
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("PositionChanged")){
           pcs.firePropertyChange("UpdateYourPosition",(int)evt.getNewValue(),(int)evt.getOldValue());            
        }
    }
    public void addListener(PropertyChangeListener pl) {
        pcs.addPropertyChangeListener(pl);
    }

    
    public void removeListener(PropertyChangeListener pl) {
        pcs.removePropertyChangeListener(pl);
    }



}
