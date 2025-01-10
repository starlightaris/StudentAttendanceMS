/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.Year;

/**
 *
 * @author pavani
 */
public class Batchdto {
    private String batchName;
    private Year year;

    public Batchdto(String batchName, Year year) {
        this.batchName = batchName;
        this.year = year;
    }

    public Batchdto() {
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
    
    
}
