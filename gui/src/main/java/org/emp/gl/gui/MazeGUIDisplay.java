
package org.emp.gl.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;


public class MazeGUIDisplay extends JFrame implements PropertyChangeListener {
   
   private static final int ROBOT_SIZE = 18;
   private static final int CASE_SIZE = 20;
   private static final int DEC_GAUCHE = 25;
   private static final int DEC_HAUT = 50;


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("UpdateYourPosition")){
            this.x=(int) evt.getOldValue();
            this.y=(int) evt.getNewValue();
            System.out.println(x+"  "+y);
            this.repaint();
            
        }
    }
    private int[][] maze = {
         {0 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
         {1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
         {0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0},
         {0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1},
         {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0},
         {0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
         {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
         {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
         {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
         {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    
   
   private int x;
   private int y;
   private final int xd = 0;
   private final int yd = 2;
   
   
   
    public MazeGUIDisplay()
   {
      super("Maze Display");

      // Initialisation du labyrinthe
      this.x = 2;
      this.y = 2;
      setLocation(50, 50);
      setSize(295, 315);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    
    
     public void paint(Graphics g)
   {
      // Parcourt le labyrinthe.
      for(int i = 0; i < this.maze.length; i++)
      {
         for(int j = 0; j < this.maze.length; j++)
         {
            // Case libre.
            if(this.maze[i][j]==1)
            {
               g.setColor(Color.WHITE);
               g.fillRect(DEC_GAUCHE + j * CASE_SIZE, DEC_HAUT + i * CASE_SIZE, CASE_SIZE, CASE_SIZE);
               g.setColor(Color.LIGHT_GRAY);
               g.drawRect(DEC_GAUCHE + j * CASE_SIZE, DEC_HAUT + i * CASE_SIZE, CASE_SIZE, CASE_SIZE);
            }
            // Mur.
            else
            {
               g.setColor(Color.BLACK);
               g.fillRect(DEC_GAUCHE + j * CASE_SIZE, DEC_HAUT + i * CASE_SIZE, 
                     CASE_SIZE, CASE_SIZE);
            }
         }
      }
      g.setColor(Color.BLUE);
      g.fillOval(DEC_GAUCHE+1+this.x*CASE_SIZE,DEC_HAUT+1+this.y*CASE_SIZE,ROBOT_SIZE,ROBOT_SIZE);
   }
}
    
    
    
    
    
