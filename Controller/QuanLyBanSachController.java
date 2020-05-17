/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Ulity.ClassTableModel;
import View.BanSachJFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javafx.scene.control.TableRow;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Khanh Vo
 */
public class QuanLyBanSachController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private BanSachService banSachService = null;
    private String[] listColumn = {"Mã sách","Tên sách","Tác giả","Giá","Số lượng"};
    private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLyBanSachController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.banSachService = new BanSachServiceImpl();
    }
    
    public void setDateToTable(){
        List<BanSach> listItem = banSachService.getList();
        DefaultTableModel model = new ClassTableModel().setTableBanSach(listItem,listColumn);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                String text =jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                } else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                    }
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String text =jtfSearch.getText();
                if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                } else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                    }
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
               //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getClickCount()== 2 && table.getSelectedRow() != -1 )
                {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //System.out.println(selectedRowIndex);
                    BanSach banSach = new BanSach();
                    banSach.setMasach(model.getValueAt(selectedRowIndex, 0));
                    banSach.setTensach(model.getValueAt(selectedRowIndex, 2).toString());
                    banSach.setTacgia(model.getValueAt(selectedRowIndex, 3).toString());
                    banSach.setGia(model.getValueAt(selectedRowIndex, 4).toString());
                    banSach.setSoluong(model.getValueAt(selectedRowIndex, 5).toString());
                    BanSachJFrame frame = new BanSachJFrame(banSach);
                    frame.setTitle("Thông tin sách");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
                }
            
        });
        
        
        table.getTableHeader().setFont(new Font("Arrival",Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(100,50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300,400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
        
    }
        public void setEvent(){
            btnAdd.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent me) {
                    BanSachJFrame frame = new BanSachJFrame(new BanSach());
                    frame.setTitle("Thông tin sách");
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setVisible(true);
                }
                @Override
            public void mouseEntered(MouseEvent me) {
                btnAdd.setBackground(new Color(0,200,83));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnAdd.setBackground(new Color(100,221,23));

            }
                
            });
        }
    
}
