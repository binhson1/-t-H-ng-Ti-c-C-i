/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiecCuoi;

import static TinhNang.CauHinh.f;
import static TinhNang.CauHinh.sc;
import DichVu.DichVu;
import DichVu.QuanLiDichVu;
import Menu.MonAn;
import Menu.QuanLiMenu;
import SanhCuoi.QuanLiSanhCuoi;
import SanhCuoi.SanhCuoi;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ACER
 */
public class TiecCuoi {

    private String tenBuoiTiec;
    private SanhCuoi sanh;
    private String thoiDiem;
    private Calendar ngayThue;
    private ArrayList<DichVu> dichVu = new ArrayList<>();
    private ArrayList<MonAn> thucDon = new ArrayList<>();

    public TiecCuoi(String tenBuoiTiec, SanhCuoi sanh, String thoiDiem, String ngayThue) throws ParseException {
        this.tenBuoiTiec = tenBuoiTiec;
        this.sanh = sanh;
        this.thoiDiem = thoiDiem;
        Date d = f.parse(ngayThue);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        this.ngayThue = cal;
    }

    public TiecCuoi() throws ParseException {
        this.tenBuoiTiec = null;
        this.sanh = null;
        this.thoiDiem = null;
        this.ngayThue = null;
    }

    public void thueSanh(QuanLiSanhCuoi ds, ArrayList<TiecCuoi> sanhDaThue) throws ParseException {
        System.out.print("Nhap ten buoi tiec: ");
        tenBuoiTiec = sc.nextLine();
        System.out.println("Danh sach sanh: ");
        ds.hienThi();
        do {
            do {
                String id;
                System.out.print("Nhap ma sanh: ");
                id = sc.nextLine();
                try {
                    sanh = ds.traCuu(id);
                    break;
                } catch (Exception e) {
                    System.out.println("Khong tim thay sanh hop le!");
                }
            } while (true);
            System.out.print("Thoi diem(Sang/Chieu/Toi): ");            
            String t = sc.nextLine();
            t = t.toUpperCase();
            if ("SANG".equals(t) || "CHIEU".equals(t) || "TOI".equals(t)) {
                thoiDiem = t;
            }
            Calendar present = new GregorianCalendar();
            Calendar cal = Calendar.getInstance();
            do {
                System.out.print("Ngay thue(dd/MM/yyyy): ");
                String date = sc.next();
                Date d = f.parse(date);
                cal.setTime(d);
                if (cal.compareTo(present) > 0) {
                    ngayThue = cal;
                    break;
                }
                System.out.println("Nhap khong hop le. Xin hay nhap lai!!!");
            } while (true);

            if (!this.isRent(sanhDaThue)) {
                break;
            } else {
                System.out.println("Sanh da co nguoi thue!!!");
            }
        } while (true);        
    }

    public void thueDichVu(QuanLiDichVu ds) {
        System.out.println("Danh sach dich vu: ");
        ds.hienThi();
        do {
            System.out.print("Chon dich vu ban muon them(ten dich vu): ");
            String tenDv = sc.nextLine();
            this.dichVu.addAll((ArrayList<DichVu>) ds.traCuu(tenDv));
            if (this.dichVu.isEmpty()) {
                System.out.println("Khong tim thay dich vu ban muon them!");
            }
            System.out.print("Ban co muon tiep tuc them dich vu (Chon 1 de tiep tuc them): ");
            String chon = sc.nextLine();            
            if (!"1".equals(chon)) {
                break;
            }
        } while (true);
    }

    public void thueMenu(QuanLiMenu ds) {
        System.out.println("Danh sach thuc don: ");
        ds.hienThi();
        do {
            System.out.print("Chon mon an ban muon them(ten mon): ");
            String tenMon = sc.nextLine();
            this.thucDon.addAll((ArrayList<MonAn>) ds.traCuu(tenMon));
            System.out.print("Ban co muon tiep tuc them mon(Chon 1 de tiep tuc them): ");
            String chon;
            chon = sc.nextLine();
            if (!"1".equals(chon)) {
                break;
            }
        } while (true);
    }

    public boolean isRent(ArrayList<TiecCuoi> ds) {
        for (TiecCuoi s : ds) {
            if (this.sanh == s.getSanh() && this.thoiDiem.equals(s.getThoiDiem()) && this.ngayThue.compareTo(s.getNgayThue()) == 0) {
                return true;
            }
        }
        return false;
    }
    
    public void hienThi(){
        this.hienThiSanh();
        System.out.println();
        this.hienThiDichVu();
        System.out.println();
        this.hienThiThucDon();
        System.out.println();
    }

    public void hienThiSanh() {
        System.out.printf("Ten tiec cuoi: %s\n",this.tenBuoiTiec);
        sanh.hienThi();
        System.out.println(thoiDiem);
        System.out.println(f.format(ngayThue.getTime()));
    }

    public void hienThiDichVu() {
        System.out.println("Danh sach dich vu ban da chon: ");
        this.dichVu.forEach(s -> {
            s.hienThi();
            System.out.println();
        });
    }

    public void hienThiThucDon() {
        System.out.println("Danh sach cac mon ban da chon: ");
        this.thucDon.forEach(s -> {
            s.hienThi();
            System.out.println();
        });
    }

    public double giaSanh() {
        if (this.isWeekend()) {            
           return this.sanh.getGiaThue() + 696969;
        }
        return this.sanh.getGiaThue();
    }

     public boolean isWeekend() {
        int ngay = this.ngayThue.get(Calendar.DAY_OF_WEEK);
        return (ngay == 1 || ngay == 7);
    }
     
    public double giaDichVu() {
        double gia = 0;
        for (int i = 0; i < dichVu.size(); i++) {
            DichVu get = dichVu.get(i);
            gia += get.getGiaDichVu();
        }
        return gia;
    }

    public double giaThucDon() {
        double gia = 0;
        for (int i = 0; i < thucDon.size(); i++) {
            MonAn get = thucDon.get(i);
            gia += get.getGia();
        }
        return gia * sanh.getSucChua();
    }

    public void xuatHoaDon() {
        System.out.println("Hoa Don: ");
        System.out.printf("Gia sanh: %,.1f\n", this.giaSanh());
        System.out.println("Dich vu: ");
        this.dichVu.forEach(s -> {
            System.out.printf("%s : %,.1f\n", s.getTenDichVu(), s.getGiaDichVu());
        });
        System.out.printf("Tong gia dich vu: %,.1f\n", this.giaDichVu());
        System.out.println("Thuc Don: ");
        this.thucDon.forEach(s -> {
            System.out.printf("%s : %,.1f\n", s.getTen(), s.getGia());
        });
        System.out.printf("Tong gia thuc don: %,.1f\n", this.giaThucDon());
        System.out.printf("Tong tien: %,.1f\n", this.giaTong());
    }

    public double giaTong() {
        return this.giaSanh() + this.giaDichVu() + this.giaThucDon();
    }

   

    /**
     * @return the tenBuoiTiec
     */
    public String getTenBuoiTiec() {
        return tenBuoiTiec;
    }

    /**
     * @param tenBuoiTiec the tenBuoiTiec to set
     */
    public void setTenBuoiTiec(String tenBuoiTiec) {
        this.tenBuoiTiec = tenBuoiTiec;
    }

    /**
     * @return the sanh
     */
    public SanhCuoi getSanh() {
        return sanh;
    }

    /**
     * @param sanh the sanh to set
     */
    public void setSanh(SanhCuoi sanh) {
        this.sanh = sanh;
    }

    /**
     * @return the thoiDiem
     */
    public String getThoiDiem() {
        return thoiDiem;
    }

    /**
     * @param thoiDiem the thoiDiem to set
     */
    public void setThoiDiem(String thoiDiem) {
        this.thoiDiem = thoiDiem;
    }

    /**
     * @return the ngayThue
     */
    public Calendar getNgayThue() {
        return ngayThue;
    }

    /**
     * @param ngayThue the ngayThue to set
     */
    public void setNgayThue(Calendar ngayThue) {
        this.ngayThue = ngayThue;
    }

    /**
     * @return the dichVu
     */
    public ArrayList<DichVu> getDichVu() {
        return dichVu;
    }

    /**
     * @param dichVu the dichVu to set
     */
    public void setDichVu(ArrayList<DichVu> dichVu) {
        this.dichVu = dichVu;
    }

    /**
     * @return the thucDon
     */
    public ArrayList<MonAn> getThucDon() {
        return thucDon;
    }

    /**
     * @param thucDon the thucDon to set
     */
    public void setThucDon(ArrayList<MonAn> thucDon) {
        this.thucDon = thucDon;
    }

}
