/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author pavani
 */
public enum GenderType {
    Male(1), Female(2);
    final int state;
    
    GenderType(int state){
        this.state=state;
    }
}
