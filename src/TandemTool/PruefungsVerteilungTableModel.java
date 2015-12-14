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
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author schaeuf
 */
public class PruefungsVerteilungTableModel extends PruefungsVerteilung
    implements TableModel
    
{
    ArrayList<TableModelListener> listeners;

    public PruefungsVerteilungTableModel(Staff s) {
        super(s);
        listeners = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return tandems.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0: return "Prüfer 1";
            case 1: return "Prüfer 2";
            case 2: return "Form";
            case 3: return "Anzahl";
            default: return "N.N.";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0: return java.lang.String.class;
            case 1: return java.lang.String.class;
            case 2: return java.lang.String.class;
            case 3: return java.lang.Integer.class;
            default: return Object.class;
        }                
    }

    @Override
    public boolean isCellEditable(int arg0, int arg1) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Tandem tandem;
        tandem = tandems.get(row);
           switch (col){
            case 0: return tandem.getPrf1().getName();
            case 1: return tandem.getPrf2().getName();
            case 2: {
                switch(tandem.getForm()){
                    case MUENDLICH : return "mündlich";
                    case  SCHRIFTLICH: return "schriftlich";
                    default: return "beides";
                }
            }
            case 3: return tandem.getCount();
            default: return null;
        }        
    }

    @Override
    public void setValueAt(Object arg0, int arg1, int arg2) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
    
}
