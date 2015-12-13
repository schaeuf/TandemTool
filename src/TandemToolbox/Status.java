/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TandemToolbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author schaeuf
 */
public class Status extends JLabel implements ChangeListener, TableModelListener{
    private final Staff staff;
    private final PruefungsVerteilung pruefungen;
    
    private String text(){
        return "Jobs: " + ((Integer) staff.JobsCountM() + staff.JobsCountS())  ;
    }
    
    Status(Staff s, PruefungsVerteilung p){
        super();
        staff = s;
        pruefungen = p;
        setText(text());
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        
         setText(text());
    }

    @Override
    public void tableChanged(TableModelEvent e) {
         setText(text());
    }
}
