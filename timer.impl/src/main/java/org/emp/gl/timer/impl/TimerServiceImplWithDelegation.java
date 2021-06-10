package org.emp.gl.timer.impl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;


public class TimerServiceImplWithDelegation extends TimerTask {

    public int secondes;
    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();
        LocalTime localTime = LocalTime.now();
        secondes = localTime.getSecond();
        timer.scheduleAtFixedRate(this, 100, 100);
    }

    @Override
    public void run() {
        timeChanged();
    }

    PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    
    public void addTimeChangeListener(PropertyChangeListener pl) {
        propertyChangeSupport.addPropertyChangeListener(pl);
        System.out.println(secondes);
    }

    public void removeTimeChangeListener(PropertyChangeListener pl) {
        propertyChangeSupport.removePropertyChangeListener(pl);

    }
  
    
    public int getSecondes() {
        return secondes;
    }

    private void timeChanged() {
        updateSecode();
    }

    public void updateSecode() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;
        this.propertyChangeSupport.firePropertyChange("sec", oldValue, secondes);
    }

}
