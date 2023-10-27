package Menu;

import static TinhNang.CauHinh.sc;

/**
 *
 * @author ACER
 */
public abstract class MonAn {

    private String ten;
    private double gia;

    public MonAn() {
        System.out.print("Ten : ");
        ten = sc.nextLine();
        System.out.print("Gia : ");
        gia = sc.nextDouble();
    }

    public MonAn(String ten, double gia) {
        this.ten = ten;
        this.gia = gia;
    }
    
    public void capNhat(){
        System.out.print("Ten : ");
        ten = sc.nextLine();
        System.out.print("Gia : ");
        gia = sc.nextDouble();
    }
    
    public void hienThi(){
        System.out.printf("Ten: %s\n",this.ten);
        System.out.printf("Gia: %.1f\n",this.gia);
    }

    /**
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the gia
     */
    public double getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(double gia) {
        this.gia = gia;
    }

}
