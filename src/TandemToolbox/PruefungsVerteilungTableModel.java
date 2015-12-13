/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TandemToolbox;

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
