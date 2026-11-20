import java.util.ArrayList;
import java.util.Scanner;

/*
 * Lop DSSach quan ly danh sach sach trong thu vien bang ArrayList<Sach>.
 */
public class DSSach {
    private ArrayList<Sach> danhSach = new ArrayList<>();
    private Scanner sc;

    // Dung chung 1 Scanner voi lop Test de tranh doc tranh du lieu tu ban phim
    public DSSach(Scanner sc) {
        this.sc = sc;
    }

    public ArrayList<Sach> getDanhSach() {
        return danhSach;
    }

    // Tim sach theo ma, tra ve null neu khong co
    public Sach timSach(String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    // Them san mot doi tuong sach (dung cho kiem thu)
    public boolean themSach(Sach s) {
        if (timSach(s.getMaSach()) != null) {
            System.out.println("Loi: Ma sach " + s.getMaSach() + " da ton tai, khong them.");
            return false;
        }
        danhSach.add(s);
        return true;
    }

    // Them sach moi bang cach nhap tu ban phim
    public void themSach() {
        System.out.print("Loai sach (1 = Giao khoa, 2 = Tham khao): ");
        String loai = sc.nextLine().trim();
        if (!loai.equals("1") && !loai.equals("2")) {
            System.out.println("Loai sach khong hop le!");
            return;
        }
        System.out.print("Ma sach: ");
        String ma = sc.nextLine().trim();
        if (timSach(ma) != null) {
            System.out.println("Loi: Ma sach da ton tai!");
            return;
        }
        int ngay = docSoNguyen("Ngay nhap: ");
        int thang = docSoNguyen("Thang nhap: ");
        int nam = docSoNguyen("Nam nhap: ");
        double donGia = docSoThuc("Don gia: ");
        int soLuong = docSoNguyen("So luong: ");
        System.out.print("Nha xuat ban: ");
        String nxb = sc.nextLine();
        if (loai.equals("1")) {
            System.out.print("Tinh trang (1 = moi, 0 = cu): ");
            boolean moi = sc.nextLine().trim().equals("1");
            danhSach.add(new SachGiaoKhoa(ma, ngay, thang, nam, donGia, soLuong, nxb, moi));
        } else {
            double thue = docSoThuc("Thue: ");
            danhSach.add(new SachThamKhao(ma, ngay, thang, nam, donGia, soLuong, nxb, thue));
        }
        System.out.println("Da them sach " + ma);
    }

    // Xoa sach theo ma
    public boolean xoaSach(String maSach) {
        Sach s = timSach(maSach);
        if (s == null) {
            System.out.println("Khong tim thay sach co ma " + maSach);
            return false;
        }
        danhSach.remove(s);
        System.out.println("Da xoa sach " + maSach);
        return true;
    }

    // Cap nhat thong tin sach theo ma (nhap gia tri moi tu ban phim)
    public void capNhatSach(String maSach) {
        Sach s = timSach(maSach);
        if (s == null) {
            System.out.println("Khong tim thay sach co ma " + maSach);
            return;
        }
        System.out.println("Nhap thong tin moi (ma sach giu nguyen):");
        s.setNgay(docSoNguyen("Ngay nhap: "));
        s.setThang(docSoNguyen("Thang nhap: "));
        s.setNam(docSoNguyen("Nam nhap: "));
        s.setDonGia(docSoThuc("Don gia: "));
        s.setSoLuong(docSoNguyen("So luong: "));
        System.out.print("Nha xuat ban: ");
        s.setNhaXuatBan(sc.nextLine());
        if (s instanceof SachGiaoKhoa) {
            System.out.print("Tinh trang (1 = moi, 0 = cu): ");
            ((SachGiaoKhoa) s).setTinhTrangMoiCu(sc.nextLine().trim().equals("1"));
        } else if (s instanceof SachThamKhao) {
            ((SachThamKhao) s).setThue(docSoThuc("Thue: "));
        }
        System.out.println("Da cap nhat sach " + maSach);
    }

    // Hien thi toan bo danh sach
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("(Danh sach trong)");
            return;
        }
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
    }

    // Thong ke so luong va thanh tien theo tung loai (dung instanceof)
    public void thongKeTheoLoai() {
        int demGiaoKhoa = 0;
        int demThamKhao = 0;
        double tienGiaoKhoa = 0;
        double tienThamKhao = 0;
        for (Sach s : danhSach) {
            if (s instanceof SachGiaoKhoa) {
                demGiaoKhoa++;
                tienGiaoKhoa += s.getThanhTien();
            } else if (s instanceof SachThamKhao) {
                demThamKhao++;
                tienThamKhao += s.getThanhTien();
            }
        }
        System.out.println("Sach giao khoa: " + demGiaoKhoa + " cuon, tong thanh tien = " + tienGiaoKhoa);
        System.out.println("Sach tham khao: " + demThamKhao + " cuon, tong thanh tien = " + tienThamKhao);
    }

    private int docSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
            }
        }
    }

    private double docSoThuc(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }
    }
}
