/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLBS;

/**
 *
 * @author Khanh Vo
 */
public class BanSachBean {
    private String ngayBanSach;
    private int soLuongSach;

    public BanSachBean() {
    }

    public BanSachBean(String ngayBanSach, int soLuongSach) {
        this.ngayBanSach = ngayBanSach;
        this.soLuongSach = soLuongSach;
    }

    public String getNgayBanSach() {
        return ngayBanSach;
    }

    public void setNgayBanSach(String ngayBanSach) {
        this.ngayBanSach = ngayBanSach;
    }

    public int getSoLuongSach() {
        return soLuongSach;
    }

    public void setSoLuongSach(int soLuongSach) {
        this.soLuongSach = soLuongSach;
    }
    
}
