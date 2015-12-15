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

import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author schaeuf
 */
public class StaffTableModel extends AbstractTableModel {
    //public ArrayList<TableModelListener> listeners = new ArrayList<>();
    Staff staff;
    StaffTableModel(Staff s){
        staff = s;
    }
    
    @Override
    public int getRowCount() {
        return staff.members.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0: return "Name";
            case 1: return "SWS";
            case 2: return "Form";
            case 3: return "Soll-Jobs";
            case 4: return "Haben-Jobs";
            default: return "N.N.";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0: return java.lang.String.class;
            case 1: return java.lang.Integer.class;
            case 2: return java.lang.String.class;
            case 3: return java.lang.Float.class;
            case 4: return java.lang.Integer.class;
            default: return Object.class;
        }        
    }

    @Override
    public boolean isCellEditable(int row, int col) {
           switch (col){
            case 0: return true;
            case 1: return true;
            case 2: return true;
            default: return false;
        }        
    }

    @Override
    public Object getValueAt(int row, int col) {        
        Staff.Employee emp;
        emp = staff.members.get(row);
           switch (col){
            case 0: return emp.getName();
            case 1: return emp.getSws();
            case 2: {
                switch(emp.getForm()){
                    case MUENDLICH : return "mündlich";
                    case  SCHRIFTLICH: return "schriftlich";
                    default: return "beides";
                }
            }
            case 3: return emp.sollJobCount();
            case 4: return emp.getJobs();
            default: return null;
        }        
        
    }

    @Override
    public void setValueAt(Object arg0, int row, int col) {
        Staff.Employee emp;
        System.out.print(arg0);
        emp = staff.members.get(row);
           switch (col){
            case 0: emp.setName((String) arg0);break;
            case 1: {
                emp.setSws((Integer) arg0);
                fireTableRowsUpdated(3,3);
                break;
                }
            case 2:
                if (((String) arg0).equals("schriftlich"))
                        emp.setForm(Staff.Pruefungsform.SCHRIFTLICH);
                else{
                    if (((String) arg0).equals("mündlich"))
                        emp.setForm(Staff.Pruefungsform.MUENDLICH);
                    else
                        emp.setForm(Staff.Pruefungsform.BEIDES);}
                
        }
        fireTableCellUpdated(row,col);
    }

    void remove() {
        staff.remove();
        fireTableRowsDeleted(staff.membersCount(),staff.membersCount());
        
    }

    void add() {
        staff.add();
        fireTableRowsInserted(staff.membersCount()-1,staff.membersCount()-1);
    }

   
}
    
  
    
    
  