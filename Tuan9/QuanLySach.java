import java.util.ArrayList;
import java.util.Scanner;

/*
 * Bai tap tuan 9: Quan ly sach giao khoa va sach tham khao (tinh ke thua).
 * Chay: javac Tuan9/*.java  ->  java -cp Tuan9 QuanLySach
 */
public class QuanLySach {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<SachGiaoKhoa> dsGiaoKhoa = new ArrayList<>();
    static ArrayList<SachThamKhao> dsThamKhao = new ArrayList<>();

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n===== QUAN LY SACH - TUAN 9 =====");
            System.out.println("1. Nhap danh sach sach giao khoa va sach tham khao");
            System.out.println("2. Xuat danh sach cac loai sach");
            System.out.println("3. Tong thanh tien sach giao khoa");
            System.out.println("4. Tong thanh tien sach tham khao");
            System.out.println("5. Trung binh cong don gia sach tham khao");
            System.out.println("6. Xuat sach giao khoa cua nha xuat ban X");
            System.out.println("7. Nap du lieu mau");
            System.out.println("0. Thoat");
            chon = docSoNguyen("Chon chuc nang: ");
            switch (chon) {
                case 1:
                    nhapDanhSach();
                    break;
                case 2:
                    xuatDanhSach();
                    break;
                case 3:
                    System.out.println("Tong thanh tien sach giao khoa: " + tongThanhTienGiaoKhoa());
                    break;
                case 4:
                    System.out.println("Tong thanh tien sach tham khao: " + tongThanhTienThamKhao());
                    break;
                case 5:
                    System.out.println("Trung binh cong don gia sach tham khao: " + trungBinhDonGiaThamKhao());
                    break;
                case 6:
                    System.out.print("Nhap nha xuat ban X: ");
                    xuatGiaoKhoaTheoNXB(sc.nextLine());
                    break;
                case 7:
                    napDuLieuMau();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le!");
            }
        } while (chon != 0);
    }

    static int docSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
            }
        }
    }

    static double docSoThuc(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }
    }

    // Nhap cac thuoc tinh chung roi tao doi tuong
    static void nhapDanhSach() {
        int n = docSoNguyen("Nhap so luong sach giao khoa: ");
        for (int i = 1; i <= n; i++) {
            System.out.println("-- Sach giao khoa thu " + i);
            System.out.print("Ma sach: ");
            String ma = sc.nextLine();
            int ngay = docSoNguyen("Ngay nhap: ");
            int thang = docSoNguyen("Thang nhap: ");
            int nam = docSoNguyen("Nam nhap: ");
            double donGia = docSoThuc("Don gia: ");
            int soLuong = docSoNguyen("So luong: ");
            System.out.print("Nha xuat ban: ");
            String nxb = sc.nextLine();
            System.out.print("Tinh trang (1 = moi, 0 = cu): ");
            boolean moi = sc.nextLine().trim().equals("1");
            dsGiaoKhoa.add(new SachGiaoKhoa(ma, ngay, thang, nam, donGia, soLuong, nxb, moi));
        }

        n = docSoNguyen("Nhap so luong sach tham khao: ");
        for (int i = 1; i <= n; i++) {
            System.out.println("-- Sach tham khao thu " + i);
            System.out.print("Ma sach: ");
            String ma = sc.nextLine();
            int ngay = docSoNguyen("Ngay nhap: ");
            int thang = docSoNguyen("Thang nhap: ");
            int nam = docSoNguyen("Nam nhap: ");
            double donGia = docSoThuc("Don gia: ");
            int soLuong = docSoNguyen("So luong: ");
            System.out.print("Nha xuat ban: ");
            String nxb = sc.nextLine();
            double thue = docSoThuc("Thue: ");
            dsThamKhao.add(new SachThamKhao(ma, ngay, thang, nam, donGia, soLuong, nxb, thue));
        }
    }

    static void xuatDanhSach() {
        System.out.println("\n===== DANH SACH SACH GIAO KHOA =====");
        if (dsGiaoKhoa.isEmpty()) {
            System.out.println("(Danh sach trong)");
        }
        for (SachGiaoKhoa s : dsGiaoKhoa) {
            s.hienThiThongTin();
        }
        System.out.println("\n===== DANH SACH SACH THAM KHAO =====");
        if (dsThamKhao.isEmpty()) {
            System.out.println("(Danh sach trong)");
        }
        for (SachThamKhao s : dsThamKhao) {
            s.hienThiThongTin();
        }
    }

    static double tongThanhTienGiaoKhoa() {
        double tong = 0;
        for (SachGiaoKhoa s : dsGiaoKhoa) {
            tong += s.tinhThanhTien();
        }
        return tong;
    }

    static double tongThanhTienThamKhao() {
        double tong = 0;
        for (SachThamKhao s : dsThamKhao) {
            tong += s.tinhThanhTien();
        }
        return tong;
    }

    static double trungBinhDonGiaThamKhao() {
        if (dsThamKhao.isEmpty()) {
            return 0;
        }
        double tong = 0;
        for (SachThamKhao s : dsThamKhao) {
            tong += s.getDonGia();
        }
        return tong / dsThamKhao.size();
    }

    static void xuatGiaoKhoaTheoNXB(String nxb) {
        boolean coKetQua = false;
        for (SachGiaoKhoa s : dsGiaoKhoa) {
            if (s.getNhaXuatBan().equalsIgnoreCase(nxb)) {
                s.hienThiThongTin();
                coKetQua = true;
            }
        }
        if (!coKetQua) {
            System.out.println("Khong co sach giao khoa cua nha xuat ban " + nxb);
        }
    }

    static void napDuLieuMau() {
        dsGiaoKhoa.add(new SachGiaoKhoa("GK01", 1, 9, 2024, 50000, 10, "Giao Duc", true));
        dsGiaoKhoa.add(new SachGiaoKhoa("GK02", 5, 9, 2024, 40000, 10, "Giao Duc", false));
        dsGiaoKhoa.add(new SachGiaoKhoa("GK03", 10, 10, 2024, 30000, 4, "Kim Dong", true));
        dsThamKhao.add(new SachThamKhao("TK01", 2, 9, 2024, 100000, 3, "Tre", 20000));
        dsThamKhao.add(new SachThamKhao("TK02", 3, 10, 2024, 200000, 2, "Kim Dong", 30000));
        System.out.println("Da nap du lieu mau (3 sach giao khoa, 2 sach tham khao).");
    }
}
