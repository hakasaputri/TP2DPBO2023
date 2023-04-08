/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5_2;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;


public class theModel extends AbstractTableModel{

    private String[] kolom;
    private Object[][] baris;
    
    public theModel(){
        
    }
    
    public theModel(Object[][] data, String[] columnName){
        this.baris = data;
        this.kolom = columnName;
        
    }
    
    public Class getColumnClass (int columns){
        if(columns == 3 || columns == 4){
            return Icon.class;
        }else{
            return getValueAt(0, columns).getClass();
        }
    }

    public int getRowCount() {
        return this.baris.length;
    }


    public int getColumnCount() {
        return this.kolom.length;
    }

   
    public Object getValueAt(int rowIndex, int columnIndex) {
    
         return this.baris[rowIndex][columnIndex];
    }
    
    public String getColumnName(int col){
        return this.kolom[col];
    }
    
}
