package org.emp.gl.timer.service;


import java.beans.PropertyChangeListener;

public interface TimerChangeListener extends PropertyChangeListener {

        final static String SECOND_PROP = "seconde" ;
       

        void propertyChange (String propertyName, Object oldValue, Object newValue);

}

