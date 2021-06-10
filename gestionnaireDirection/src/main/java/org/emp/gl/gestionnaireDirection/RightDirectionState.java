package org.emp.gl.gestionnaireDirection;

public class RightDirectionState extends DirectionState{

    public RightDirectionState(RobotAgent rb) {
        super(rb);
    }
    @Override
    public void goDown() {
        robot.setDirection("down");
        robot.setDirectionState(new DownDirectionState(robot));
        System.out.println("RD");
    }

    @Override
    public void goUp(){
        robot.setDirection("up");
        robot.setDirectionState(new UpDirectionState(robot));
        System.out.println("RU");
    }
}