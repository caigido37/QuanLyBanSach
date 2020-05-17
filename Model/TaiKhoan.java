/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Khanh Vo
 */
public class TaiKhoan {
    private int MaTK;
    private String Username;
    private String Password;
    private boolean Tinhtrang;

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int MaTK) {
        this.MaTK = MaTK;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(boolean Tinhtrang) {
        this.Tinhtrang = Tinhtrang;
    }
    
}
