package Menu;

import static TinhNang.CauHinh.sc;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import TinhNang.Interface1;

public class QuanLiMenu implements Interface1{

    private ArrayList<MonAn> dsThucAn = new ArrayList<>();

    private ArrayList<MonAn> dsThucUong = new ArrayList<>();

    @Override
    public void them() {
        System.out.printf("Danh sach: \n1.Thuc an\n2.Thuc uong\nBan muon them: ");
        int chon = sc.nextInt();
        sc.nextLine();
        if (chon == 1) {
            this.dsThucAn.add(new ThucAn());
        } else if (chon == 2) {
            this.dsThucUong.add(new ThucUong());
        }
    }

    @Override
    public void them(Object obj) {
        if (obj instanceof ThucAn) {
            this.dsThucAn.add((ThucAn) obj);
        } else if (obj instanceof ThucUong) {
            this.dsThucUong.add((ThucUong) obj);
        }
    }

    public void hienThiThucAn() {
        this.dsThucAn.forEach(s->s.hienThi());
    }

    public void hienThiThucUong() {
        this.dsThucUong.forEach(s->s.hienThi());
    }

    @Override
    public void hienThi() {
        this.hienThiThucAn();
        this.hienThiThucUong();
    }

    @Override
    public void xoa() {
        System.out.printf("Xoa: \n1.Thuc an\n2.Thuc uong\n3.Xoa het\nChon(1 / 2 / 3): ");
        int chon = sc.nextInt();
        switch (chon) {
            case 1 ->
                this.xoaThucAn();
            case 2 ->
                this.xoaThucUong();
            case 3 -> {
                this.dsThucAn.clear();
                this.dsThucUong.clear();
            }
            default -> {
            }
        }
    }

    public void xoaThucAn() {
        this.hienThiThucAn();
        System.out.print("Ban muon xoa thuc an nao(Ma thuc an): ");
        int ma = sc.nextInt();
        this.dsThucAn.remove(ma - 1);
    }

    public void xoaThucUong() {
        this.hienThiThucUong();
        System.out.print("Ban muon xoa thuc uong nao(Ma thuc uong): ");
        int ma = sc.nextInt();
        this.dsThucUong.remove(ma - 1);
    }

    @Override
    public void capNhat() {
        this.hienThi();
        System.out.print("Ban muon cap nhat mon nao(ten mon): ");
        String t = sc.nextLine();
        ArrayList<MonAn> ds = new ArrayList<>();
        ds.addAll(this.dsThucAn);
        ds.addAll(this.dsThucUong);        
        ds.stream().filter(s->s.getTen().equals(t)).collect(Collectors.toList()).forEach(f->f.capNhat());
    }

    @Override
    public String hienThiTenLop() {
        return "Thuc Don.";
    }

    @Override
    public void traCuu() {
        System.out.println("Ban muon tra cuu: ");
        System.out.println("1. Thuc an");
        System.out.println("2. Thuc uong");
        int chon;      
        chon = sc.nextInt();
        sc.nextLine();
        if (chon == 1) {
            this.traCuuThucAn().forEach(s -> {
                s.hienThi();
                System.out.println();
            });
        } else if (chon == 2) {
            this.traCuuThucUong().forEach(s -> {
                s.hienThi();
                System.out.println();
            });
        }
    }

    public List<MonAn> traCuu(String kw) {
        List<MonAn> l = new ArrayList<>();
        l.addAll(this.traCuuThucAn(kw));
        l.addAll(this.traCuuThucUong(kw));
        return l.stream().filter(s->s.getTen().equals(kw)).collect(Collectors.toList());        
    }

    public List<MonAn> traCuuThucAn() {
        System.out.print("Nhap ten thuc an can tim: ");
        String ten = sc.nextLine();
        System.out.println("Danh sach tra cuu: ");
        return this.dsThucAn.stream().filter(s -> s.getTen().contains(ten)).collect(Collectors.toList());
    }
    

    public List<MonAn> traCuuThucAn(String kw) {
        return this.dsThucAn.stream().filter(s -> s.getTen().contains(kw)).collect(Collectors.toList());
    }

    public List<MonAn> traCuuThucUong() {
        System.out.print("Nhap ten thuc uong can tim: ");
        String ten = sc.nextLine();
        System.out.println("Danh sach tra cuu: ");
        return this.dsThucUong.stream().filter(s -> s.getTen().contains(ten)).collect(Collectors.toList());
    }

    public List<MonAn> traCuuThucUong(String kw) {
        return this.dsThucUong.stream().filter(s -> s.getTen().contains(kw)).collect(Collectors.toList());
    }
}
