/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import static TinhNang.CauHinh.sc;
import DichVu.DichVu;
import DichVu.Karaoke;
import DichVu.QuanLiDichVu;
import DichVu.ThueCaSi;
import DichVu.TrangTriPhoiCanh;
import Menu.MonAn;
import Menu.ThucAn;
import Menu.QuanLiMenu;
import Menu.ThucUong;
import SanhCuoi.QuanLiSanhCuoi;
import SanhCuoi.SanhCuoi;
import TiecCuoi.QuanLiTiecCuoi;
import TiecCuoi.TiecCuoi;
import java.text.ParseException;

/**
 *
 * @author ACER
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        QuanLiSanhCuoi dsSanh = new QuanLiSanhCuoi();
        Main.themSanh(dsSanh);
        QuanLiDichVu dsDv = new QuanLiDichVu();
        Main.themDichVu(dsDv);
        QuanLiMenu dsThucDon = new QuanLiMenu();
        Main.themMon(dsThucDon);
        QuanLiTiecCuoi dsTiec = new QuanLiTiecCuoi();
        int chon = 0;
        do {
            System.out.println("Menu chuong trinh: ");
            System.out.println("1. Quan ly thong tin sanh cuoi");
            System.out.println("2. Quan ly thong tin dich vu");
            System.out.println("3. Quan ly thong tin thuc an, thuc uong");
            System.out.println("4. Thue Tiec Cuoi");
            System.out.println("5. Sap xep danh sach sanh giam dan theo tan so duoc thue su dung, tra cuu theo nam.");
            System.out.println("6. Xuat hoa don thanh toan.");
            System.out.println("7. Bao cao doanh thu theo thang va quy.");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();
            System.out.printf("\n\n\n");
            switch (chon) {
                case 1 ->
                    dsSanh.dieuKhien();
                case 2 ->
                    dsDv.dieuKhien();
                case 3 ->
                    dsThucDon.dieuKhien();
                case 4 ->
                {
                    TiecCuoi t = new TiecCuoi();
                    t.thueSanh(dsSanh, dsTiec.getDs());
                    t.thueDichVu(dsDv);
                    t.thueMenu(dsThucDon);
                    dsTiec.them(t);
                }
                case 5 -> 
                {
                    dsTiec.sapXepTheoTanSuat(dsSanh.getDs());
                }
                case 6 ->
                {
                    dsTiec.xuatHoaDon();
                }
                
                case 7 ->
                    dsTiec.baoCaoDoanhThu();
                    
            }
            System.out.println("=================");
        } while (chon > 0 && chon < 8);
    }
    public static void themSanh(QuanLiSanhCuoi ds){
        SanhCuoi s1 = new SanhCuoi("Bayby", 2, 100, 3);
        SanhCuoi s2 = new SanhCuoi("Hi", 1, 200, 5);
        SanhCuoi s3 = new SanhCuoi("How", 2, 50, 3);
        SanhCuoi s4 = new SanhCuoi("Shit", 3, 50, 8);
        ds.them(s1);
        ds.them(s2);
        ds.them(s3);
        ds.them(s4);
    }
    
    public static void themDichVu(QuanLiDichVu listDv){
        DichVu d1 = new Karaoke(1, "NonStop", 10000, 6);
        DichVu d2 = new ThueCaSi(2, "DemCuaVau", 20000, "DenVau", 5);
        DichVu d3 = new TrangTriPhoiCanh(3,"TrangTriDenCuoi",30000,"TrangTriCoDau");
        listDv.them(d1);
        listDv.them(d2);
        listDv.them(d3);
    }
    
    public static void themMon(QuanLiMenu dsThucDon){
        MonAn a1 = new ThucAn("GaKhongLoiThoat", 1, false);
        MonAn a2 = new ThucAn("LauThaiChuaCay", 3, true);
        MonAn u1 = new ThucUong("BiaTiger", 5, "VN");
        MonAn u2 = new ThucUong("Bia333", 7, "VN");
        dsThucDon.them(a1);
        dsThucDon.them(a2);
        dsThucDon.them(u1);
        dsThucDon.them(u2);
    }
    
    public static void thue(TiecCuoi t, QuanLiSanhCuoi ds, QuanLiTiecCuoi danhSach, QuanLiDichVu listDv, QuanLiMenu dsThucDon) throws ParseException{
        t.thueSanh(ds, danhSach.getDs());
        t.thueDichVu(listDv);
        t.thueMenu(dsThucDon);
        danhSach.them(t);
    }
}


