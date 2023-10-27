package DichVu;

import static TinhNang.CauHinh.sc;

public class Karaoke extends DichVu {

    private double thoiGianThue;
    
    public Karaoke(){
        super();
        System.out.print("Nhap thoi gian thue: ");
        thoiGianThue = sc.nextDouble();
    }

    public Karaoke(int maDichVu, String tenDichVu, double giaDichVu, double thoiGianThue) {
        super(maDichVu, tenDichVu, giaDichVu);
        this.thoiGianThue = thoiGianThue;
    }

    @Override
    public void hienThi() {
        super.hienThi(); 
        System.out.printf("Thoi gian thue: %s\n", this.thoiGianThue);
    }

    @Override
    public void capNhat() {
        super.capNhat(); 
        System.out.print("Nhap thoi gian thue: ");
        thoiGianThue = sc.nextDouble();
    }
    

    /**
     * @return the thoiGianThue
     */
    public double getThoiGianThue() {
        return thoiGianThue;
    }

    /**
     * @param thoiGianThue the thoiGianThue to set
     */
    public void setThoiGianThue(double thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

}
