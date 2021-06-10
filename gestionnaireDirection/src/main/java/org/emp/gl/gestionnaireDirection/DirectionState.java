package org.emp.gl.gestionnaireDirection;

public abstract class DirectionState {

    
   
    public  RobotAgent robot ;
    private DirectionState(){}
    public DirectionState(RobotAgent rb)
    {
        if (robot==null) {
            robot=rb;
        }
        
    }

    public void goDown() {
    }

    ;
    public void goUp() {
    }

    ;
    public void goLeft() {
    }

    ;
    public void goRight() {
    }
;
}
