package DichVu;

import static TinhNang.CauHinh.sc;

public class ThueCaSi extends DichVu {

    private String tenCaSi;

    private int soBai;
    
    public ThueCaSi(){
        super(); 
        System.out.print("Nhap ten ca si: ");
        this.tenCaSi = sc.nextLine();
        System.out.print("Nhap so bai: ");
        this.soBai = sc.nextInt();
    }

    public ThueCaSi(int maDichVu, String tenDichVu, double giaDichVu, String tenCaSi, int soBai) {
        super(maDichVu, tenDichVu, giaDichVu);
        this.tenCaSi = tenCaSi;
        this.soBai = soBai;
    }

    @Override
    public void hienThi() {
        super.hienThi(); 
        System.out.printf("Ten ca si: %s\n",this.tenCaSi);
        System.out.printf("So bai: %d\n",this.soBai);
        
    }

    @Override
    public void capNhat() {
        super.capNhat(); 
        System.out.print("Nhap ten ca si: ");
        this.tenCaSi = sc.nextLine();
        System.out.print("Nhap so bai: ");
        this.soBai = sc.nextInt();
    }
    
    

    /**
     * @return the caSi
     */
    public String getCaSi() {
        return tenCaSi;
    }

    /**
     * @param caSi the caSi to set
     */
    public void setCaSi(String caSi) {
        this.tenCaSi = caSi;
    }

    /**
     * @return the soBai
     */
    public int getSoBai() {
        return soBai;
    }

    /**
     * @param soBai the soBai to set
     */
    public void setSoBai(int soBai) {
        this.soBai = soBai;
    }

}
