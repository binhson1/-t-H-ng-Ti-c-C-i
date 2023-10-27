package DichVu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static TinhNang.CauHinh.sc;
import TinhNang.Interface1;

public class QuanLiDichVu implements Interface1 {

    private ArrayList<DichVu> ds = new ArrayList<>();

    @Override
    public void them() {
        System.out.println("Danh sach dich vu: ");
        System.out.println("1. Karaoke");
        System.out.println("2. Thue ca si");
        System.out.println("3. Trang tri phoi canh");
        System.out.print("Chon: ");
        int chon = sc.nextInt();
        sc.nextLine();
        switch (chon) {
            case 1 -> {
                this.ds.add(new Karaoke());
            }
            case 2 ->  {
                this.ds.add(new ThueCaSi());
            }
            case 3 -> {
                this.ds.add(new TrangTriPhoiCanh());
            }
            }
        sc.nextLine();
    }

    @Override
    public void them(Object obj) {
        if (obj instanceof DichVu)
            this.ds.add((DichVu) obj);        
    }

    @Override
    public void hienThi() {
        this.ds.forEach(s->s.hienThi());
    }

    @Override
    public void capNhat() {
        this.hienThi();
        System.out.print("Ban muon cap nhat dich vu nao(ten dich vu): ");
        String kw = sc.nextLine();        
        this.ds.stream().filter(s->s.getTenDichVu().equals(kw)).collect(Collectors.toList()).forEach(f->f.capNhat());            
    }
    

    @Override
    public void xoa() {
        System.out.print("Ban muon xoa dich vu nao(Nhap ten dich vu): ");
        String t = sc.nextLine();        
        this.ds.removeAll(this.ds.stream().filter(s->s.getTenDichVu().equals(t)).collect(Collectors.toList()));
    }

    public List<DichVu> traCuu(String kw) {
        return this.ds.stream().filter(s -> s.getTenDichVu().contains(kw)).collect(Collectors.toList());
    }

    @Override
    public void traCuu() {
        System.out.print("Nhap ten ban muon tra cuu: ");
        String kw = sc.nextLine();        
        this.ds.stream().filter(s -> s.getTenDichVu().contains(kw)).collect(Collectors.toList()).forEach(f->f.hienThi());
    }

    @Override
    public String hienThiTenLop() {
        return "Dich Vu.";
    }

}
