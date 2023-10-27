package DichVu;

import static TinhNang.CauHinh.sc;

public class TrangTriPhoiCanh extends DichVu{
    private String yeuCau;

    public TrangTriPhoiCanh(int maDichVu, String tenDichVu, double giaDichVu, String yeuCau) {
        super(maDichVu, tenDichVu, giaDichVu);
        this.yeuCau = yeuCau;
    }

    public TrangTriPhoiCanh() {
        super();
        System.out.println("Nhap yeu cau: ");
        this.yeuCau = sc.nextLine();
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("Yeu cau: %s\n", this.yeuCau);
    }

    @Override
    public void capNhat() {
        super.capNhat();
        System.out.println("Nhap yeu cau: ");
        this.yeuCau = sc.nextLine();
    }
    
    
    /**
     * @return the yeuCau
     */
    public String getYeuCau() {
        return yeuCau;
    }

    /**
     * @param yeuCau the yeuCau to set
     */
    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }
}
