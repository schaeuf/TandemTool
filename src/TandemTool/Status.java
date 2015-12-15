/* 
 * Copyright (C) 2015 Christian Schäufler <christian.schaeufler@web.de>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package TandemTool;

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
        return "Jobs: " + ((Integer) staff.sollJobsM()+ staff.sollJobsS())  ;
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
