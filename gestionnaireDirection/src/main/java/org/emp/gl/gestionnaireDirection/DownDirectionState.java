package org.emp.gl.gestionnaireDirection;

public class DownDirectionState extends  DirectionState{

    public DownDirectionState(RobotAgent robot) {
        super(robot);
    }

 @Override
    public void goLeft() {
        robot.setDirection("left");
        robot.setDirectionState(new LeftDirectionState(robot));
        System.out.println("DL");
    }

    @Override
    public void goRight() {
        robot.setDirection("right");
        robot.setDirectionState(new RightDirectionState(robot));
        System.out.println("DR");
    }
}
