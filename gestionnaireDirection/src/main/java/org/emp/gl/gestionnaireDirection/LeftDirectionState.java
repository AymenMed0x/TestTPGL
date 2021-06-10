package org.emp.gl.gestionnaireDirection;

public class LeftDirectionState extends DirectionState {

    public LeftDirectionState(RobotAgent rb) {
        super(rb);
    }

    @Override
    public void goDown() {
        robot.setDirection("down");
        robot.setDirectionState(new DownDirectionState(robot));
        System.out.println("LD");
    }

    @Override
    public void goUp() {
        robot.setDirection("up");
        robot.setDirectionState(new UpDirectionState(robot));
        System.out.println("LU");
    }
}
