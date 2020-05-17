/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ulity;


import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khanh Vo
 */
public class ClassTableModel {
   public DefaultTableModel setTableBanSach(List<BanSach> listItem, String[] listColumn)
   {
       DefaultTableModel dtm = new DefaultTableModel(){
           @Override
           public boolean isCellEditable(int row, int column) {
               return false; //To change body of generated methods, choose Tools | Templates.
           }

          /* @Override
           public Class<?> getColumnClass(int i) {
               return i == ? ? Boolean.class : String.class ; 
           }*/
           
          
           
           
       };
       dtm.setColumnIdentifiers(listColumn);
       int columns = listColumn.length;
       Object[] obj = null;
       int rows = listItem.size();
       if(rows > 0){
           for(int i = 0; i<rows; i++){
               BanSach banSach = listItem.get(i);
               obj = new Object[columns];
               obj[0] = banSach.getmasach();
               obj[1] = (i+1);
              
               obj[2] = banSach.getTensach();
               obj[3] = banSach.getTacgia();
               obj[4] = banSach.getGia();
               obj[5] = banSach.getSoluong();
                dtm.addRow(obj);
            }
       }
       return dtm;
   }
}
