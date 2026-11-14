import java.util.ArrayList;

/*
 * Bai tap tuan 8: Tinh chat dong goi trong OOP
 * Bai 5: Cap nhat lop Test de minh hoa tinh dong goi (Constructor, Getter, Setter, ArrayList).
 */
public class Test {
    public static void main(String[] args) {
        // 1. Khoi tao cac doi tuong Sach bang constructor co tham so
        System.out.println("===== 1. KHOI TAO DOI TUONG SACH BANG CONSTRUCTOR =====");
        Sach sach1 = new Sach("S001", "Lap trinh huong doi tuong Java", "Nguyen Van A", 2023, 15);
        Sach sach2 = new Sach("S002", "Cau truc du lieu va giai thuat", "Tran Thi B", 2022, 10);
        Sach sach3 = new Sach("S003", "Co so du lieu", "Le Van C", 2024, 20);

        System.out.println("\n--- Thong tin sach 1 ban dau ---");
        sach1.hienThiThongTin();

        // 2. Su dung getter de lay thong tin cua doi tuong
        System.out.println("\n===== 2. SU DUNG GETTER DE LAY THONG TIN SACH 1 =====");
        System.out.println("Lay ma sach (getMaSach): " + sach1.getMaSach());
        System.out.println("Lay tieu de (getTieuDe): " + sach1.getTieuDe());
        System.out.println("Lay tac gia (getTacGia): " + sach1.getTacGia());
        System.out.println("Lay nam xuat ban (getNamXuatBan): " + sach1.getNamXuatBan());
        System.out.println("Lay so luong (getSoLuong): " + sach1.getSoLuong());

        // 3. Su dung setter de cap nhat thong tin va kiem tra du lieu hop le / khong hop le
        System.out.println("\n===== 3. KIEM TRA SETTER VA DIEU KIEN DU LIEU =====");

        // Thu nhap nam xuat ban khong hop le (<= 0 va > nam hien tai)
        System.out.println("-> Thu cap nhat nam xuat ban am (-2020):");
        sach1.setNamXuatBan(-2020);
        System.out.println("-> Thu cap nhat nam xuat ban lon hon nam hien tai (2099):");
        sach1.setNamXuatBan(2099);
        System.out.println("Nam xuat ban hien tai cua sach 1 van la: " + sach1.getNamXuatBan());

        // Thu nhap nam xuat ban hop le
        System.out.println("-> Cap nhat nam xuat ban hop le (2025):");
        sach1.setNamXuatBan(2025);
        System.out.println("Nam xuat ban cua sach 1 sau khi cap nhat: " + sach1.getNamXuatBan());

        // Thu nhap so luong am (khong hop le)
        System.out.println("\n-> Thu cap nhat so luong am (-5):");
        sach1.setSoLuong(-5);
        System.out.println("So luong hien tai cua sach 1 van la: " + sach1.getSoLuong());

        // Thu nhap so luong hop le
        System.out.println("-> Cap nhat so luong hop le (25):");
        sach1.setSoLuong(25);
        System.out.println("So luong cua sach 1 sau khi cap nhat: " + sach1.getSoLuong());

        // Cap nhat tieu de va tac gia bang setter
        sach1.setTieuDe("Lap trinh Java nang cao");
        sach1.setTacGia("Nguyen Van A (Chu bien)");

        // 4. Hien thi thong tin sau khi cap nhat
        System.out.println("\n===== 4. THONG TIN SACH 1 SAU KHI CAP NHAT =====");
        sach1.hienThiThongTin();

        // 5. Tiep tuc quan ly danh sach doi tuong Sach bang ArrayList
        System.out.println("\n===== 5. DANH SACH SACH TRONG ARRAYLIST =====");
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        danhSachSach.add(sach1);
        danhSachSach.add(sach2);
        danhSachSach.add(sach3);

        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.println("\nSach thu " + (i + 1) + ":");
            danhSachSach.get(i).hienThiThongTin();
        }
    }
}
