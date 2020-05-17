/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Khanh Vo
 */
public class BanSachController {
    private JButton btnSubmit;
    private JTextField jtfMaSach;
    private JTextField jtfTenSach;
    private JTextField jtfTacGia;
    private JTextField jtfGia;
    private JTextField jtfSoLuong;
    private JLabel  jlbMsg;
    
    private BanSach banSach = null;
    
    private BanSachService banSachService = null;

    public BanSachController(JButton btnSubmit, JTextField jtfMaSach,
            JTextField jtfTenSach, JTextField jtfTacGia, JTextField jtfGia,
            JTextField jtfSoLuong, JLabel  jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaSach = jtfMaSach;
        this.jtfTenSach = jtfTenSach;
        this.jtfTacGia = jtfTacGia;
        this.jtfGia = jtfGia;
        this.jtfSoLuong = jtfSoLuong;
        this.jlbMsg = jlbMsg;
        
        this.banSachService = new BanSachServiceImpl();
    }
    
    public void setView(BanSach banSach){
        this.banSach = banSach;
        
        jtfMaSach.setText("#"+banSach.getMasach());
        jtfTenSach.setText(banSach.getTensach());
        jtfTacGia.setText(banSach.getTacgia());
        jtfGia.setText(banSach.getGia());
        jtfSoLuong.setText(banSach.getSoluong());   
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {   
                if(jtfTenSach.getText().length()== 0 ||jtfGia.getText().length() == 0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }else{
                    banSach.setTensach(jtfTenSach.getText());
                    banSach.setTacgia(jtfTacGia.getText());
                    banSach.setGia(jtfGia.getText());
                    banSach.setSoluong(jtfSoLuong.getText());
                    int lastId =   banSachService.CreateOrUpdate(banSach);
                    if(lastId > 0){
                    banSach.setMasach(lastId);
                    jtfMaSach.setText("#"+lastId);
                    jlbMsg.setText("Cập nhật dữ liệu thành công!");
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                btnSubmit.setBackground(new Color(0,200,83));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnSubmit.setBackground(new Color(100,221,23));

            }
            
            
        });
        
    }
}
