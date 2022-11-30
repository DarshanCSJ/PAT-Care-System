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
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;



public class Report {
    
    
    private Dictionary CatNvals = new Hashtable();
    
    public Report(){}
    
    public Report(String date, int zone){
    //complie
    //generate
    }
    
    public String[] sortByColumNames(String cat1, String cat2){ 
        
    }
    
    public String[] complie(String[] truthvals){
    
    String readerline;
    int maleCount = 0;
    int femaleCount =0;
    int ageRange1Count=0;
    int ageRange2Count=0;
    int disability1Count=0;
    int disability2Count=0;
    int operation1Count=0;
    int operation2Count=0;
    int regVisitcount=0;
    int irregularVisits=0;
    
    int primCa1Total = 0;
    int primCa2Total = 0;
    int secondCa11Total= 0;
    int secondCa12Total= 0;
    int secondCa21Total= 0;
    int secondCa22Total= 0;
    
    String[] categories = {"M","F","over18","under18","frequent","infrequent","D1Y","D2Y","Op1Y","OP2Y"} ;
            
    int[] nonTotals11 = {0,0,0,0,0,0};
    int[] nonTotals12 = {0,0,0,0,0,0};
    int[] nonTotals21 = {0,0,0,0,0,0};
    int[] nonTotals22 = {0,0,0,0,0,0};
    
   
    
    OffsetDateTime offset = OffsetDateTime.now();
    //OffsetDateTime monthLess= offset.minusYears(1);
    int month =offset.getMonthValue();
    //LocalDate offDate = value.toLocalDate();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM, yyyy");
    
        
    try{
        FileReader fr = new FileReader("CurrentPatientRecords.txt");
        BufferedReader br = new BufferedReader(fr);
            while( (readerline=br.readLine()) != null  ){ //best to read from bottom
                String[] record =readerline.split(" ");
                //System.out.println(record);
                LocalDate timestamp = LocalDate.parse(record[3], format);
                LocalDate op1time = LocalDate.parse(record[11], format);
                int op1month= op1time.getMonthValue() ;
                
                LocalDate op2time = LocalDate.parse(record[14], format);
                int op2month= op2time.getMonthValue() ;
                
                int timeStampMonth = timestamp.getDayOfMonth();
                
                if(!(timeStampMonth == month)){
                 
                } else {
                   for (int i =4; i<15 ;i++){
                    if ( record[i]== categories[0]  ){ 
                     primCa1Total++;
                     for (int x=4; x<15; x++){
                      if (( record[x] == categories[2]) ){
                       secondCa11Total++;
                       for (int y =4; y<6 ; y++){
                        for (int m =4; m<15 ;m++){
                         if(record[m] == categories[y]){
                            nonTotals11[y]++;
                             
                         }
                        }}
                      }else if(record[x] == categories[3]){
                       for (int y =4; y<6 ; y++){
                        for (int m =4; m<15 ;m++){
                         if(record[m] == categories[y]){
                             nonTotals12[y]++;
                             
                         } 
                        }}
                      }
                     }
                    }else if (record[i] == categories[1]){
                      primCa2Total++;
                     for (int x=4; x<15; x++){
                      if (( record[x] == categories[2]) ){
                       secondCa21Total++;
                       for (int y =4; y<6 ; y++){
                        for (int m =4; m<15 ;m++){
                         if(record[m] == categories[y]){
                            nonTotals21[y]++;
                             
                         }
                        }}
                      }else if(record[x] == categories[3]){
                       for (int y =4; y<6 ; y++){
                        for (int m =4; m<15 ;m++){
                         if(record[m] == categories[y]){
                            nonTotals22[y]++;
                            
                         } 
                        }}
                      }
                     }
                      }
                    
                   //add
                     
                }
            }
            br.close();
        }catch(IOException e){
        e.printStackTrace();
        } 
        
    }
      
    
}
