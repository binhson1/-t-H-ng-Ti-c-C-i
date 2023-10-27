package Menu;

import static TinhNang.CauHinh.sc;

public class ThucAn extends MonAn{

    private static int dem;

    private int id = ++dem;

    private boolean anChay;

    public ThucAn() {
        super();
        sc.nextLine();
        System.out.print("Mon an chay(co / khong): ");
        String s = sc.nextLine();
        s = s.toLowerCase();
        if ("co".equals(s)) {
            anChay = true;
        } else if ("khong".equals(s)) {
            anChay = false;
        }
    }

    public ThucAn(String ten, double gia, boolean anChay) {
        super(ten, gia);
        this.anChay = anChay;
    }


    @Override
    public void capNhat() {
        super.capNhat();
        sc.nextLine();
        System.out.print("Mon an chay(co / khong): ");
        String s = sc.nextLine();
        s = s.toLowerCase();
        if ("co".equals(s)) {
            anChay = true;
        } else if ("khong".equals(s)) {
            anChay = false;
        }
    }

    @Override
    public void hienThi() {
        System.out.printf("\nMa mon an: %d\n", this.id);
        super.hienThi();
        String s;
        if (true == anChay) {
            s = "Co";
        } else {
            s = "Khong";
        }
        System.out.printf("Mon an chay: %s\n", s);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the anChay
     */
    public boolean isAnChay() {
        return anChay;
    }

    /**
     * @param anChay the anChay to set
     */
    public void setAnChay(boolean anChay) {
        this.anChay = anChay;
    }

}
