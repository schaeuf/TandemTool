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
import java.util.Iterator;

/**
 *
 * @author schaeuf
 */
 
public class Staff {
    public static enum Pruefungsform{
        MUENDLICH, SCHRIFTLICH, BEIDES
    }
    
    protected ArrayList<Employee> members=new ArrayList<>();
    private int gesamtPruefungenS = 0;  // Gesamtanzahl schriftlicher Prüfungen
    private int gesamtPruefungenM = 0;  // Gesamtanzahl mündlicher Prüfungen
    private int gesamtSws=0; // Schattengröße der Summe aller Employees.

    
    public class Employee {
        private String name;
        private int sws = 0;
        private int jobs = 0;
        private Pruefungsform form = Pruefungsform.BEIDES;

        Employee(){}
        
        Employee(String s){
           name = s;
        }
        
        public void setForm(Pruefungsform f){
            form=f;
        }
        
        public Pruefungsform getForm(){
            return form;
        }
        
        public void setName(String s){
            name = s;
        }
        
        public String getName(){
            return name;
        }
        
        
        public void setSws(int n){
            incGesamtSws(n-sws); //Verwalten der Schatten-Größe
            sws = n;
        }
        
        public int getSws(){
            return sws;
        }
        
        public float sollJobCount(){
            if((getGesamtPruefungenS()+getGesamtPruefungenM())==0)
                return 0;
            if(getGesamtSws()==0)
                return 0;
            return (float) 2*sws/gesamtSws  *(gesamtPruefungenS+gesamtPruefungenM);
        }
        
        public void incJobs(int i){
            jobs += i;
        }
        
        public void resetJobs(){
            jobs = 0;
        }
                
        
        public int getJobs(){
            return jobs;
        }
        
    }

        
    private void incGesamtSws(int diff){
        gesamtSws += diff;
    }

    public int membersCount(){
        return members.size();
    }
    
    public int getGesamtSws(){
        return gesamtSws;
    }
    
    protected void add(){
        members.add(new Employee("N.N."));
    }
    
    protected void remove(){
        if (membersCount()>0)
           members.remove(membersCount()-1);
    }
    
    public void setGesamtPruefungenS(int n){
        gesamtPruefungenS = n;
    }
    
    public int getGesamtPruefungenS(){
        return gesamtPruefungenS;
    }
    
    public int sollJobsS(){
        return gesamtPruefungenS*2;
        
    }
    
    public void setGesamtPruefungenM(int n){
        gesamtPruefungenM = n;
    }
    
    public int getGesamtPruefungenM(){
        return gesamtPruefungenM;
    }
    
    public int sollJobsM(){
        return gesamtPruefungenM*2;
                
    }
    
    public Employee[] EmployeesMostOpenJobs(Pruefungsform form){
        Employee first=null,second=null;
        for (Employee e : members)
            if (e.getForm()==form||e.getForm()==Pruefungsform.BEIDES){
               if (first == null)
                   first = e;
               else{
                   if(second == null)
                      second = e;
                   else{
                      if(e.sollJobCount()>first.sollJobCount()){
                        second=first;
                        first=e;
                      }
                      else{
                        if(e.sollJobCount()>second.sollJobCount())
                            second=e;
                      }
                   }
               }
            }
        
        if (second==null)
            return null;
        return new Employee[] {first,second};
    }
    
    public void resetJobCounts(){
        for(Employee e: members)
            e.resetJobs();
    }
}
