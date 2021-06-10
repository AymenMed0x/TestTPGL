package org.emp.gl.gestionnaireDirection;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.emp.gl.environnement.Position;
import java.beans.PropertyChangeSupport;
import org.emp.gl.Lookup;


public class RobotAgent implements RobotService, PropertyChangeListener {
    
    
    

    private Position position;
    private DirectionState ds = null;
    PropertyChangeSupport pcs = null;
    String direction="left";
   

    public Position getPosition() {
        return position;
    }
    
    public DirectionState getDirectionState() {
        return ds;
    }
    
    
    public String getDirection() {
        return direction;
    }
    public void setDirection(String d) {
        this.direction = d;
    }
    
    public void setPosition(Position p) {
        this.position = p;
    }
    
    public void setDirectionState(DirectionState directionState) {
        this.ds = directionState;
    }
    
     public RobotAgent() {
        
        Lookup.getInstance().register(RobotService.class,this);
        this.ds = new LeftDirectionState(this);
        this.pcs =new PropertyChangeSupport(this);
    }
    
    @Override
    public void goRight() {

    }

    @Override
    public void goLeft() {
    }

    @Override
    public void goUp() {
    }

    @Override
    public void goDown() {
    }
    
    int positionX=0;
    int positionY=0;
    
   
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("sec")) {
            int oldY = position.getY();
            int oldX = position.getX();
            switch (direction) {
                case "up":
                    positionY--;
                    break;
                case "down":
                    positionY++;
                    break;
                case "right":
                   positionX++;
                    break;
                case "left":
                    positionX--;
                    break;
                default:
                    break;
            }
            pcs.firePropertyChange("PositionChanged",positionY,positionX);
        }
    }
    
    public void addPositionChangeListener(PropertyChangeListener propertyChange) {
        pcs.addPropertyChangeListener(propertyChange);
    }

    
    public void removePositionChangeListener(PropertyChangeListener propertyChange) {
        pcs.removePropertyChangeListener(propertyChange);
    }
}
