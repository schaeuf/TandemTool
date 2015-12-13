/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TandemToolbox;

import java.util.ArrayList;

/**
 *
 * @author schaeuf
 */
public class PruefungsVerteilung {
    private final Staff staff;
    ArrayList<Tandem> tandems;
    
    public class Tandem{
        final Staff.Employee prf1, prf2;
        final Staff.Pruefungsform form;
        int count;
        Tandem (Staff.Employee p1, Staff.Employee p2, Staff.Pruefungsform f, int n  ){
            prf1=p1;
            prf2=p2;
            count =n;
            form =f;
        }
        
        public Staff.Employee getPrf1(){
            return prf1;
        }
        
        public Staff.Employee getPrf2(){
            return prf1;
        }
        
        public int getCount(){
            return count;
        }
        
        public Staff.Pruefungsform getForm(){
            return form;
        }
        
        
    }
    
    PruefungsVerteilung(Staff s){
        staff = s;
        tandems=new ArrayList<>();
    }
}
