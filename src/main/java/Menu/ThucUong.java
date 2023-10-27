package Menu;

import static TinhNang.CauHinh.sc;

public class ThucUong extends MonAn {

    private static int dem;

    private int id = ++dem;

    private String hang;

    public ThucUong() {
        super();
        System.out.print("Nhap hang: ");
        sc.nextLine();
        hang = sc.nextLine();
    }

    public ThucUong(String ten, double gia, String hang) {
        super(ten, gia);
        this.hang = hang;
    }

    @Override
    public void capNhat(){
        super.capNhat();
        System.out.print("Nhap hang: ");
        sc.nextLine();
        hang = sc.nextLine();
    }
    
    @Override
    public void hienThi(){
        System.out.printf("\nMa thuc uong: %d\n", this.id);
        super.hienThi();
        System.out.printf("Hang thuc uong %s: \n",this.hang);
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

 
    /**
     * @return the hang
     */
    public String getHang() {
        return hang;
    }

    /**
     * @param hang the hang to set
     */
    public void setHang(String hang) {
        this.hang = hang;
    }
}
