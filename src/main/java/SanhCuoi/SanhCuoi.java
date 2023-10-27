package SanhCuoi;

import static TinhNang.CauHinh.sc;

public class SanhCuoi implements Comparable<SanhCuoi> {

    private static int dem;

    private String id;

    private String tenSanh;

    private int viTri, sucChua;

    private double giaThue;

    private int soLanThue;

    {
        id = "S" + String.format("%03d", ++dem);
    }
    public SanhCuoi() {
        this.capNhat();
    }

    public SanhCuoi(String tenSanh, int viTri, int sucChua, double giaThue) {
        this.tenSanh = tenSanh;
        this.viTri = viTri;
        this.sucChua = sucChua;
        this.giaThue = giaThue;
    }

    public void hienThi() {
        System.out.printf("\nMa Sanh: %s\n", this.id);
        System.out.printf("Ten Sanh: %s\n",this.tenSanh);
        System.out.printf("Vi Tri: %d\n", this.viTri);
        System.out.printf("Suc Chua: %d\n",this.sucChua);
        System.out.printf("Gia Thue: %.1f VND\n", this.giaThue);
    }

    public void capNhat() {
        System.out.print("Nhap ten sanh: ");
        tenSanh = sc.nextLine();
        System.out.print("Nhap vi tri sanh(Tang 1/2): ");
        viTri = sc.nextInt();
        System.out.print("Nhap suc chua sanh: ");
        sucChua = sc.nextInt();
        System.out.print("Nhap gia thue sanh: ");
        giaThue = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    public int compareTo(SanhCuoi o) {
        return -(this.soLanThue - o.soLanThue);
    }
    
    public String getTenSanh() {
        return tenSanh;
    }

    /**
     * @param tenSanh the tenSanh to set
     */
    public void setTenSanh(String tenSanh) {
        this.tenSanh = tenSanh;
    }

    /**
     * @return the viTri
     */
    public int getViTri() {
        return viTri;
    }

    /**
     * @param viTri the viTri to set
     */
    public void setViTri(int viTri) {
        this.viTri = viTri;
    }

    /**
     * @return the sucChua
     */
    public int getSucChua() {
        return sucChua;
    }

    /**
     * @param sucChua the sucChua to set
     */
    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    /**
     * @return the giaThue
     */
    public double getGiaThue() {
        return giaThue;
    }

    /**
     * @param giaThue the giaThue to set
     */
    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the soLanThue
     */
    public int getSoLanThue() {
        return soLanThue;
    }

    /**
     * @param soLanThue the soLanThue to set
     */
    public void setSoLanThue(int soLanThue) {
        this.soLanThue = soLanThue;
    }

}
