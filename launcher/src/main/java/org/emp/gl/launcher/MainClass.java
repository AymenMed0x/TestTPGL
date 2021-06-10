/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.launcher;

import org.emp.gl.gestionnaireDirection.RobotAgent;
import org.emp.gl.timer.impl.TimerServiceImplWithDelegation;
import org.emp.gl.environnement.Environnement;
import org.emp.gl.gui.MazeGUIDisplay;
import org.emp.gl.gui.MazeGUIControl;


/**
 *
 * @author LENOVO
 */
public class MainClass {
    
     public static void main(String[] args) {
        
         RobotAgent robot = new RobotAgent();
         TimerServiceImplWithDelegation timeEvent = new TimerServiceImplWithDelegation();
         timeEvent.addTimeChangeListener(robot);
         Environnement environnement = new Environnement();
         robot.addPositionChangeListener(environnement);
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               MazeGUIDisplay mazeDisplay = new MazeGUIDisplay();
               environnement.addListener(mazeDisplay);
               new MazeGUIControl().setVisible(true);
            }
        });
         
}
}
