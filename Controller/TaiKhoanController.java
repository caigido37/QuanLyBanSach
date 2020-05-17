/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MainJFrame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Khanh Vo
 */
public class TaiKhoanController {
    private JDialog dialog;
    private JButton btnSubmit;
    private JTextField jTextField_username;
    private JPasswordField jPasswordField_password;
    private JLabel jlbMsg;
    private TaiKhoanService taiKhoanService = null;
    public TaiKhoanController(JDialog dialog, JButton btnSubmit, JTextField jTextField_username, JPasswordField jPasswordField_password, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jTextField_username = jTextField_username;
        this.jPasswordField_password = jPasswordField_password;
        this.jlbMsg = jlbMsg;
        
        taiKhoanService = new TaiKhoanServiceImpl();
    }

  
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {   
                if(jTextField_username.getText().length()== 0 ||jPasswordField_password.getText().length()==0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }else{
                    TaiKhoan taiKhoan = taiKhoanService.login(jTextField_username.getText(),jPasswordField_password.getText());
                    if(taiKhoan == null){
                        jlbMsg.setText("Tên đăng nhập/mật khẩu sai");
                    } else
                    {
                        
                        MainJFrame frame = new MainJFrame();
                        frame.setTitle("Quản lý bán sách");
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame.setVisible(true);
                        dialog.dispose();
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
