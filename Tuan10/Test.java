import java.util.Scanner;

/*
 * Bai tap tuan 10: Chuong trinh kiem thu DSSach, abstract class Sach va interface IThanhtien.
 * Chay: javac Tuan10/*.java  ->  java -cp Tuan10 Test
 * Chuong trinh chay phan kiem thu tu dong truoc, sau do vao menu console.
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSSach ds = new DSSach(sc);

        // 1. Tao sach giao khoa va sach tham khao, them vao danh sach
        System.out.println("===== 1. THEM SACH =====");
        ds.themSach(new SachGiaoKhoa("GK01", 1, 9, 2024, 50000, 10, "Giao Duc", true));
        ds.themSach(new SachGiaoKhoa("GK02", 5, 9, 2024, 40000, 10, "Giao Duc", false));
        ds.themSach(new SachThamKhao("TK01", 2, 9, 2024, 100000, 3, "Tre", 20000));
        ds.themSach(new SachThamKhao("TK02", 3, 10, 2024, 200000, 2, "Kim Dong", 30000));
        ds.themSach(new SachThamKhao("TK01", 1, 1, 2024, 1, 1, "Trung ma", 0)); // trung ma -> bi tu choi

        // 2. Hien thi danh sach
        System.out.println("\n===== 2. DANH SACH SACH =====");
        ds.hienThiDanhSach();

        // 3. Kiem tra tinhThanhTien() dung cong thuc cua tung lop con
        System.out.println("\n===== 3. KIEM TRA tinhThanhTien() =====");
        kiemTra("GK01 (moi) = 10 * 50000", ds.timSach("GK01").getThanhTien(), 500000);
        kiemTra("GK02 (cu)  = 10 * 40000 * 0.5", ds.timSach("GK02").getThanhTien(), 200000);
        kiemTra("TK01 = 3 * 100000 + 20000", ds.timSach("TK01").getThanhTien(), 320000);
        kiemTra("TK02 = 2 * 200000 + 30000", ds.timSach("TK02").getThanhTien(), 430000);

        // 4. Thong ke theo loai
        System.out.println("\n===== 4. THONG KE THEO LOAI =====");
        ds.thongKeTheoLoai();

        // 5. Xoa sach
        System.out.println("\n===== 5. XOA SACH =====");
        ds.xoaSach("GK02");
        ds.xoaSach("XXXX"); // ma khong ton tai
        System.out.println("So sach con lai: " + ds.getDanhSach().size());

        // 6. Cap nhat sach (dung truc tiep setter, khong can nhap ban phim)
        System.out.println("\n===== 6. CAP NHAT SACH TK01 =====");
        SachThamKhao tk = (SachThamKhao) ds.timSach("TK01");
        tk.setSoLuong(5);
        tk.setThue(50000);
        tk.hienThiThongTin();
        kiemTra("TK01 sau cap nhat = 5 * 100000 + 50000", tk.getThanhTien(), 550000);

        System.out.println("\n===== 7. THONG KE SAU KHI XOA VA CAP NHAT =====");
        ds.thongKeTheoLoai();

        // Menu console
        menu(ds, sc);
    }

    static void kiemTra(String moTa, double thucTe, double kyVong) {
        String ketQua = (thucTe == kyVong) ? "DUNG" : "SAI";
        System.out.println(moTa + " -> " + thucTe + " [" + ketQua + "]");
    }

    static void menu(DSSach ds, Scanner sc) {
        int chon;
        do {
            System.out.println("\n===== QUAN LY SACH - TUAN 10 =====");
            System.out.println("1. Them sach");
            System.out.println("2. Xoa sach theo ma");
            System.out.println("3. Cap nhat sach theo ma");
            System.out.println("4. Hien thi danh sach");
            System.out.println("5. Thong ke theo loai");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                chon = -1;
            }
            switch (chon) {
                case 1:
                    ds.themSach();
                    break;
                case 2:
                    System.out.print("Nhap ma sach can xoa: ");
                    ds.xoaSach(sc.nextLine().trim());
                    break;
                case 3:
                    System.out.print("Nhap ma sach can cap nhat: ");
                    ds.capNhatSach(sc.nextLine().trim());
                    break;
                case 4:
                    ds.hienThiDanhSach();
                    break;
                case 5:
                    ds.thongKeTheoLoai();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le!");
            }
        } while (chon != 0);
    }
}
