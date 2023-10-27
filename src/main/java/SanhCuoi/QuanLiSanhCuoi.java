package SanhCuoi;

import static TinhNang.CauHinh.sc;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import TinhNang.Interface1;

public class QuanLiSanhCuoi implements Interface1{

    private ArrayList<SanhCuoi> ds = new ArrayList<>();

    @Override
    public void them() {
        this.getDs().add(new SanhCuoi());
    }

    @Override
    public void them(Object obj) {
        if (obj instanceof SanhCuoi ) {
            this.getDs().add((SanhCuoi) obj);
        }        
    }    

    @Override
    public void hienThi() {
        this.getDs().forEach(s -> s.hienThi());
    }

    @Override
    public void capNhat() {
        System.out.print("Ban muon cap nhat sanh nao(ten sanh): ");
        String kw = sc.nextLine();
        this.ds.stream().filter(s->s.getTenSanh().equals(kw)).collect(Collectors.toList()).forEach(f->f.capNhat());
    }

    @Override
    public void xoa() {
        System.out.print("Ban muon xoa sanh nao(ten sanh): ");
        String kw = sc.nextLine();
        this.ds.removeAll(this.ds.stream().filter(s->s.getTenSanh().equals(kw)).collect(Collectors.toList()));
    }

    public List<SanhCuoi> traCuuTheoTen() {
        System.out.print("Nhap ten ban muon tra cuu: ");
        String ten = sc.nextLine();
        return this.ds.stream().filter(s -> s.getTenSanh().contains(ten)).collect(Collectors.toList());
    }

    public List<SanhCuoi> traCuuTheoTen(String ten) {
        return this.ds.stream().filter(s -> s.getTenSanh().contains(ten)).collect(Collectors.toList());
    }

    public List<SanhCuoi> traCuuTheoSucChua() {
        System.out.print("Nhap suc chua ban muon tra cuu: ");
        int sucChua = sc.nextInt();
        return this.ds.stream().filter(s -> s.getSucChua() == sucChua).collect(Collectors.toList());
    }

    public List<SanhCuoi> traCuuTheoSucChua(int sucChua) {
        return this.ds.stream().filter(s -> s.getSucChua() == sucChua).collect(Collectors.toList());
    }

    public List<SanhCuoi> traCuuTheoViTri() {
        System.out.print("Nhap vi tri ban muon tra cuu: ");
        int viTri = sc.nextInt();
        return this.ds.stream().filter(s -> s.getViTri() == viTri).collect(Collectors.toList());
    }

    public List<SanhCuoi> traCuuTheoViTri(int viTri) {
        return this.ds.stream().filter(s -> s.getViTri() == viTri).collect(Collectors.toList());
    }

    public SanhCuoi traCuu(String id) {
        return this.ds.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    @Override
    public void traCuu() {
        System.out.println("1. Tra cuu theo ten");
        System.out.println("2. Tra cuu theo suc chua");
        System.out.println("3. Tra cuu theo vi tri");
        System.out.print("CHON: ");
        int chon = sc.nextInt();
        sc.nextLine();
        switch (chon) {
            case 1 -> {
                this.traCuuTheoTen().forEach(s -> {
                    s.hienThi();
                    System.out.println();
                });
            }
            case 2 -> {
                this.traCuuTheoSucChua().forEach(s -> {
                    s.hienThi();
                    System.out.println();
                });
            }
            case 3 -> {
                this.traCuuTheoViTri().forEach(s -> {
                    s.hienThi();
                    System.out.println();
                });
            }
        }
    }

    /**
     * @return the ds
     */
    public ArrayList<SanhCuoi> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(ArrayList<SanhCuoi> ds) {
        this.ds = ds;
    }

    @Override
    public String hienThiTenLop() {
        return "Sanh Cuoi.";
    }

}
