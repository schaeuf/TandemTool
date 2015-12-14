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
