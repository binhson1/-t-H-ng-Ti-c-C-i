package DichVu;

import static TinhNang.CauHinh.sc;

public abstract class DichVu {

    private int maDichVu;

    private String tenDichVu;

    private double giaDichVu;
    
    public DichVu(){
        System.out.print("Nhap ma dich vu: ");
        maDichVu = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap ten dich vu: ");
        tenDichVu = sc.nextLine();
        System.out.print("Nhap gia dich vu: ");
        giaDichVu = sc.nextDouble();
        sc.nextLine();
    }

    public DichVu(int maDichVu, String tenDichVu, double giaDichVu) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.giaDichVu = giaDichVu;
    }
    
    public void hienThi(){
        System.out.printf("\nMa dich vu: %d\n", this.maDichVu);
        System.out.printf("Ten dich vu: %s\n", this.tenDichVu);
        System.out.printf("Gia dich vu: %.1f\n" , this.giaDichVu);
    }

    public void capNhat() {
        System.out.print("Nhap ma dich vu: ");
        maDichVu = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap ten dich vu: ");
        tenDichVu = sc.nextLine();
        System.out.print("Nhap gia dich vu: ");
        giaDichVu = sc.nextDouble();
        sc.nextLine();
    }

    /**
     * @return the maDichVu
     */
    public int getMaDichVu() {
        return maDichVu;
    }

    /**
     * @param maDichVu the maDichVu to set
     */
    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    /**
     * @return the tenDichVu
     */
    public String getTenDichVu() {
        return tenDichVu;
    }

    /**
     * @param tenDichVu the tenDichVu to set
     */
    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    /**
     * @return the giaDichVu
     */
    public double getGiaDichVu() {
        return giaDichVu;
    }

    /**
     * @param giaDichVu the giaDichVu to set
     */
    public void setGiaDichVu(double giaDichVu) {
        this.giaDichVu = giaDichVu;
    }

}
