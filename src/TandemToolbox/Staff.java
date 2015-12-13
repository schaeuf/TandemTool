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
        private Pruefungsform form = Pruefungsform.SCHRIFTLICH;

        
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
            return (gesamtPruefungenS+gesamtPruefungenM==0)?(float)0:sws/gesamtSws*(gesamtPruefungenS+gesamtPruefungenM);
        }
        
        public void incJobs(int i){
            jobs += i;
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
        members.add(new Employee());
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
    
    public int JobsCountS(){
        return gesamtPruefungenS*2;
        
    }
    
    public void setGesamtPruefungenM(int n){
        gesamtPruefungenM = n;
    }
    
    public int getGesamtPruefungenM(){
        return gesamtPruefungenM;
    }
    
    public int JobsCountM(){
        return gesamtPruefungenM*2;
        
        
    }
}
