/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patcare_system;

/**
 *
 * @author Mathe
 */

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;


public class Archive {
    
    public Archive(){}
   
    public ArrayList<String> searchRecord(String iDnum){
       ArrayList<String> record =new ArrayList<String>();
       //
       //searches archive records for record  matched with ID#  and returns the record
       //ArrayList<String> pass = new ArrayList<String>();
        String readerline;
        ArrayList<String> rec = new ArrayList<String>();
        try{
        FileReader fr = new FileReader("archRec");
        BufferedReader br = new BufferedReader(fr);

            while( (readerline=br.readLine()) != null ){ 
                System.out.println(readerline);
                if(readerline.split(" ")[2].equalsIgnoreCase(iDnum)){
                    rec.add(readerline);
                    return rec;
                }
            }
            br.close();
        }catch(IOException e){
        e.printStackTrace();
        } 
        
       return record;
    }
    
    public void addToArchive(ArrayList<String> record){
        //Takes a record adds to archived record list (button)
        //from jelani
    }
    
    public void autoAddToArchive(File currentFile, String record){
        //looks through curent file and adds records if older than a year and not already in archibes
        //traverses through curent records
        String readerline;
        //calc for one year previous
        OffsetDateTime offset = OffsetDateTime.now();  
        OffsetDateTime value =  offset.minusYears(1);
        LocalDate offDate = value.toLocalDate();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM, yyyy");
        //DateFormat dFormat = DateFormat.getDateInstance(DateFormat.SHORT); 
        
        //can use jelanies edit class to replcae this
        try{
        FileReader fr = new FileReader(currentFile);
        BufferedReader br = new BufferedReader(fr);

        
            while( (readerline=br.readLine()) != null ){ 
                System.out.println(readerline);
                if(LocalDate.parse(readerline.split(" ")[3], format).compareTo(offDate) <= 0){
                    if (searchRecord(record.split(" ")[2]) == null ){
                    //add to file code
                    }
                    
                }
            }
            br.close();
        }catch(IOException e){
        e.printStackTrace();
        } 
    
        //if record is older than x time then add to a list
        //check if any records in that list is already in archives
        //if not then add to arcchives
    }
    
    public void deleteFromArchive(String iDnum){/// jelanies code 
        //searchfor Id in archive
        //if search != null then remove 
        //Remove from file
    }
    
    
    //public void autoAddToArchive(Report reoprt){}
    //public void addToArchive(Report reprt){}
    //public Report searchReport(String reportTimestamp, String reportname){}
}
