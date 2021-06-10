package org.emp.gl.gestionnaireDirection;


public class UpDirectionState extends DirectionState{

    public UpDirectionState(RobotAgent rb) {
        super(rb);
    }

    @Override
    public void goLeft() {
        robot.setDirection("left");
        robot.setDirectionState(new LeftDirectionState(robot));
        System.out.println("UL");
    }

    @Override
    public void goRight() {
        robot.setDirection("right");
        robot.setDirectionState(new RightDirectionState(robot));
        System.out.println("UR");
    }
}
