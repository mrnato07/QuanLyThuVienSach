import java.util.Scanner;

public class ThuVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Nhập thông tin sách =====");
        System.out.print("Nhập mã sách: ");
        String maSach = scanner.nextLine();

        System.out.print("Nhập tên sách: ");
        String tenSach = scanner.nextLine();

        System.out.print("Nhập tác giả: ");
        String tacGia = scanner.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int namXuatBan = scanner.nextInt();

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = scanner.nextInt();

        int luaChonLoaiSach = nhapLuaChonLoaiSach(scanner);
        String loaiSach = layTenLoaiSach(luaChonLoaiSach);

        Sach sach = new Sach(maSach, tenSach, tacGia, namXuatBan, donGia, soLuong, loaiSach);

        System.out.println("\n===== Kết quả kiểm tra =====");
        inKetQuaKiemTra(sach);

        System.out.println("\n===== Thông tin sách =====");
        System.out.println("Mã sách: " + sach.getMaSach());
        System.out.println("Tên sách: " + sach.getTenSach());
        System.out.println("Tác giả: " + sach.getTacGia());
        System.out.println("Năm xuất bản: " + sach.getNamXuatBan());
        System.out.println("Đơn giá: " + sach.getDonGia() + " VND");
        System.out.println("Số lượng: " + sach.getSoLuong());
        System.out.println("Loại sách: " + sach.getLoaiSach());

        if (sach.laSachHopLe()) {
            double thanhTien = sach.getDonGia() * sach.getSoLuong();
            double phiVanChuyen = thanhTien * 0.05;
            double tongTienNhap = thanhTien + phiVanChuyen;

            System.out.println("Phân loại giá: " + sach.phanLoaiGia());
            System.out.println("Tình trạng tồn kho: " + sach.phanLoaiTonKho());
            System.out.println("Thành tiền: " + thanhTien + " VND");
            System.out.println("Phí vận chuyển: " + phiVanChuyen + " VND");
            System.out.println("Tổng tiền nhập: " + tongTienNhap + " VND");
        }

        scanner.close();
    }

    private static int nhapLuaChonLoaiSach(Scanner scanner) {
        int luaChon;

        do {
            System.out.println("\nChọn loại sách:");
            System.out.println("1. Sách giáo khoa");
            System.out.println("2. Sách tham khảo");
            System.out.println("3. Sách chuyên ngành");
            System.out.println("4. Sách khác");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = scanner.nextInt();

            if (luaChon < 1 || luaChon > 4) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 4.");
            }
        } while (luaChon < 1 || luaChon > 4);

        return luaChon;
    }

    private static String layTenLoaiSach(int luaChon) {
        switch (luaChon) {
            case 1:
                return "Sách giáo khoa";
            case 2:
                return "Sách tham khảo";
            case 3:
                return "Sách chuyên ngành";
            case 4:
                return "Sách khác";
            default:
                return "Không xác định";
        }
    }

    private static void inKetQuaKiemTra(Sach sach) {
        if (sach.giaHopLe()) {
            System.out.println("Giá sách hợp lệ.");
        } else {
            System.out.println("Giá sách không hợp lệ: đơn giá phải lớn hơn 0.");
        }

        if (sach.soLuongHopLe()) {
            System.out.println("Số lượng hợp lệ.");
        } else {
            System.out.println("Số lượng không hợp lệ: số lượng phải từ 0 trở lên.");
        }

        if (sach.namXuatBanHopLe()) {
            System.out.println("Năm xuất bản hợp lệ.");
        } else {
            System.out.println("Năm xuất bản không hợp lệ: năm phải từ 1 đến năm hiện tại.");
        }

        if (sach.laSachHopLe()) {
            System.out.println("Thông tin sách hợp lệ.");
        } else {
            System.out.println("Thông tin sách không hợp lệ.");
        }
    }
}
