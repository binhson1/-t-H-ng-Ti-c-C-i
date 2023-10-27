/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TinhNang;

import static TinhNang.CauHinh.sc;
/**
 *
 * @author ACER
 */
public interface Interface1 {
    void them();

    void them(Object obj);

    void capNhat();

    void xoa();

    void traCuu();

    void hienThi();

    String hienThiTenLop();

    default void dieuKhien() {

        int chon = 0;
        do {
            do {
                System.out.println("Menu: ");
                System.out.println("1. Them " + this.hienThiTenLop());
                System.out.println("2. Cap nhat " + this.hienThiTenLop());
                System.out.println("3. Xoa " + this.hienThiTenLop());
                System.out.println("4. Tra cuu " + this.hienThiTenLop());
                System.out.println("5. Hien thi danh sach " + this.hienThiTenLop());
                System.out.print("Chon: ");
                try {
                    chon = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Nhap sai!!!");
                }
                sc.nextLine();
            } while (chon < 1 || chon > 5);
            System.out.println("=================");
            sc.nextLine();
            switch (chon) {
                case 1 ->
                    this.them();
                case 2 ->
                    this.capNhat();
                case 3 ->
                    this.xoa();
                case 4 ->
                    this.traCuu();
                case 5 ->
                    this.hienThi();
            }
            System.out.println("=================");
        } while (chon > 0 && chon < 6);
    }

}
