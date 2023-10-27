/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TiecCuoi;

import static TinhNang.CauHinh.sc;
import SanhCuoi.SanhCuoi;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ACER
 */
public class QuanLiTiecCuoi {

    private ArrayList<TiecCuoi> ds = new ArrayList<>();

    public QuanLiTiecCuoi() {
    }

    public void them(TiecCuoi t) {
        if (t.isRent(ds)) {
            System.out.println("Sanh da co nguoi khac thue!!!");
        } else {
            this.ds.add(t);
        }
    }

    public void hienThi() {
        this.ds.forEach(s -> {
            s.hienThi();
        });
    }

    public List<SanhCuoi> tanSuatTheoNam() {
        System.out.print("Nhap nam ban muon tim: ");
        int year = sc.nextInt();
        List<SanhCuoi> list = new ArrayList<>();
        this.ds.forEach(s -> {
            if (s.getNgayThue().get(Calendar.YEAR) == year) {
                list.add(s.getSanh());
            }
        });
        return list;
    }

    public void sapXepTheoTanSuat(ArrayList<SanhCuoi> dsSanhGoc) {
        List<SanhCuoi> dsSanhDaThue = this.tanSuatTheoNam();
        for (SanhCuoi a : dsSanhGoc) {
            for (SanhCuoi b : dsSanhDaThue) {
                if (b.equals(a)) {
                    a.setSoLanThue(a.getSoLanThue() + 1);
                }
            }
        }
        Collections.sort(dsSanhGoc);
        for (SanhCuoi s : dsSanhGoc) {
            System.out.println(s.getTenSanh() + ": " + s.getSoLanThue());
        }

    }

    public void baoCaoDoanhThu() {
        System.out.println("1. Bao cao theo thang.");
        System.out.println("2. Bao cao theo quy.");
        System.out.print("Chon: ");
        int chon = sc.nextInt();
        switch (chon) {
            case 1 ->
                this.baoCaoDoanhThuTheoThang();
            case 2 ->
                this.baoCaoDoanhThuTheoQuy();
        }
    }

    public void baoCaoDoanhThuTheoThang() {
        System.out.print("Nhap thang: ");
        int month = sc.nextInt();
        System.out.print("Nhap nam: ");
        int year = sc.nextInt();
        double tong = 0;
        for (TiecCuoi s : ds) {
            int MONTH = s.getNgayThue().get(Calendar.MONTH) + 1;
            int YEAR = s.getNgayThue().get(Calendar.YEAR);
            if (MONTH == month && YEAR == year) {
                s.xuatHoaDon();
                tong += s.giaTong();
            }
        }
        System.out.printf("Tong doanh thu: %,.1f\n", tong);
    }

    public void baoCaoDoanhThuTheoQuy() {
        int quy;
        int nam;
        try {
            System.out.print("Nhap quy ");
            quy = sc.nextInt();
            System.out.print("Nhap nam: ");
            nam = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            return;
        }
         
        double tong = 0;
        for (TiecCuoi s : ds) {
            int MONTH = s.getNgayThue().get(Calendar.MONTH) + 1;
            int YEAR = s.getNgayThue().get(Calendar.YEAR);
            for (int i = 3 * quy - 2; i < 3 * quy + 1; i++) {              
                if (YEAR == nam && MONTH == i) {
                    s.xuatHoaDon();
                    tong += s.giaTong();
                }                
            }
        }
        System.out.printf("Tong doanh thu: %,.1f\n", tong);
    }

    public void baoCaoDoanhThuTheoNam() {
        System.out.print("Nhap nam: ");
        int year = sc.nextInt();
        double tong = 0;
        for (TiecCuoi s : ds) {
            int YEAR = s.getNgayThue().get(Calendar.YEAR);
            if (YEAR == year) {
                s.xuatHoaDon();
                tong += s.giaTong();
            }
        }
        System.out.printf("Tong doanh thu: %,.1f\n", tong);
    }

    public void xuatHoaDon() {
        System.out.println("Chon tiec cuoi ban muon xuat hoa don.");
        this.hienThi();
        System.out.print("Nhap ten tiec cuoi: ");
        String ten = sc.nextLine();
        for (TiecCuoi s : ds) {
            if (s.getTenBuoiTiec().equals(ten)) {
                s.xuatHoaDon();
            }
        }
    }

    /**
     * @return the ds
     */
    public ArrayList<TiecCuoi> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(ArrayList<TiecCuoi> ds) {
        this.ds = ds;
    }
}
