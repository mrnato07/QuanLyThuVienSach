import java.util.Scanner;

/**
 * BÀI THỰC HÀNH TUẦN 5: CÂU LỆNH LẶP TRONG JAVA
 *
 * Đề bài: Thư viện phải xử lý nhiều sách và menu phải hoạt động liên tục.
 *
 * Bài 1: Nhập n sách bằng vòng lặp.
 * Bài 2: Tính tổng số lượng và tổng giá trị sách.
 * Bài 3: Menu lặp đến khi chọn Thoát.
 * Bài 4: Tìm sách theo mã.
 */
public class ThuVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mảng lưu các cuốn sách (được tạo ở Bài 1 sau khi biết n)
        Sach[] danhSach = null;
        int luaChon;

        // ===== Bài 3: Menu lặp đến khi chọn Thoát =====
        // Câu hỏi: Làm sao để menu hiện đi hiện lại cho đến khi người dùng chọn Thoát?
        // -> Dùng do-while: menu luôn hiện ít nhất 1 lần, lặp lại khi luaChon != 0.
        do {
            System.out.println("\n========== QUẢN LÝ THƯ VIỆN ==========");
            System.out.println("1. Nhập danh sách sách");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tính tổng số lượng và tổng giá trị");
            System.out.println("4. Tìm sách theo mã");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // bỏ ký tự xuống dòng còn sót lại sau nextInt()

            switch (luaChon) {
                case 1:
                    danhSach = nhapDanhSachSach(scanner);
                    break;
                case 2:
                    if (coDuLieu(danhSach)) {
                        hienThiDanhSach(danhSach);
                    }
                    break;
                case 3:
                    if (coDuLieu(danhSach)) {
                        tinhTong(danhSach);
                    }
                    break;
                case 4:
                    if (coDuLieu(danhSach)) {
                        timSachTheoMa(scanner, danhSach);
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 4.");
            }
        } while (luaChon != 0);

        scanner.close();
    }

    // ===================== BÀI 1: Nhập n sách bằng vòng lặp =====================
    // Câu hỏi 1: Nhập n sách bằng vòng lặp như thế nào?
    // -> Bước 1: nhập n (do-while, bắt buộc n > 0).
    //    Bước 2: dùng for chạy i từ 0 đến n - 1, mỗi lần nhập 1 cuốn.
    // Câu hỏi 2: Số lượng sách chưa biết trước thì lưu ở đâu?
    // -> Tạo mảng Sach[n] sau khi biết n (mảng sẽ học kỹ ở tuần 6).
    private static Sach[] nhapDanhSachSach(Scanner scanner) {
        int n;
        do {
            System.out.print("Nhập số lượng đầu sách n: ");
            n = scanner.nextInt();
            scanner.nextLine();
            if (n <= 0) {
                System.out.println("n phải lớn hơn 0.");
            }
        } while (n <= 0);

        Sach[] danhSach = new Sach[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập sách thứ " + (i + 1) + "/" + n + " ---");
            danhSach[i] = nhapMotSach(scanner);
        }
        return danhSach;
    }

    // Phần nhập 1 cuốn sách này chính là code tuần 4 (tách từ main ra thành phương thức).
    // Câu hỏi: Nếu người dùng nhập sai (giá <= 0, số lượng < 0, năm không hợp lệ) thì sao?
    // -> Dùng while (true): sai thì báo lỗi và nhập lại, đúng thì break để thoát vòng lặp.
    private static Sach nhapMotSach(Scanner scanner) {
        while (true) {
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
            scanner.nextLine(); // bỏ ký tự xuống dòng còn sót lại

            int luaChonLoaiSach = nhapLuaChonLoaiSach(scanner);
            scanner.nextLine(); // bỏ ký tự xuống dòng còn sót lại sau nextInt()
            String loaiSach = layTenLoaiSach(luaChonLoaiSach);

            Sach sach = new Sach(maSach, tenSach, tacGia, namXuatBan, donGia, soLuong, loaiSach);

            System.out.println("\n===== Kết quả kiểm tra =====");
            inKetQuaKiemTra(sach);

            if (sach.laSachHopLe()) {
                return sach;
            }
            System.out.println("Vui lòng nhập lại cuốn sách này!\n");
        }
    }

    // Hiển thị thông tin 1 cuốn sách (code tuần 4, tách từ main ra)
    private static void hienThiThongTin(Sach sach) {
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
    }

    // Duyệt toàn bộ mảng và hiển thị từng cuốn bằng vòng lặp for
    private static void hienThiDanhSach(Sach[] danhSach) {
        for (int i = 0; i < danhSach.length; i++) {
            System.out.println("\n===== Sách thứ " + (i + 1) + " =====");
            hienThiThongTin(danhSach[i]);
        }
    }

    // ===================== BÀI 2: Tổng số lượng và tổng giá trị =====================
    // Câu hỏi 1: Tổng số lượng = ? -> cộng dồn soLuong của từng cuốn.
    // Câu hỏi 2: Tổng giá trị = ? -> cộng dồn (donGia * soLuong) của từng cuốn.
    // Dùng for duyệt hết mảng, biến tổng khởi tạo bằng 0 trước vòng lặp.
    private static void tinhTong(Sach[] danhSach) {
        int tongSoLuong = 0;
        double tongGiaTri = 0;

        for (int i = 0; i < danhSach.length; i++) {
            tongSoLuong += danhSach[i].getSoLuong();
            tongGiaTri += danhSach[i].getDonGia() * danhSach[i].getSoLuong();
        }

        System.out.println("\n===== Thống kê =====");
        System.out.println("Số đầu sách: " + danhSach.length);
        System.out.println("Tổng số lượng: " + tongSoLuong);
        System.out.println("Tổng giá trị: " + tongGiaTri + " VND");
    }

    // ===================== BÀI 4: Tìm sách theo mã =====================
    // Câu hỏi 1: Làm sao tìm 1 cuốn sách khi biết mã?
    // -> Dùng for duyệt từng cuốn, so sánh mã bằng equalsIgnoreCase (không phân biệt hoa/thường).
    // Câu hỏi 2: Nếu không có sách nào trùng mã thì sao?
    // -> Dùng biến cờ timThay (boolean); duyệt xong mà vẫn false thì báo "không tìm thấy".
    // Câu hỏi 3: Tìm thấy rồi có cần duyệt tiếp không?
    // -> Không, dùng break để dừng sớm vì mã sách là duy nhất.
    private static void timSachTheoMa(Scanner scanner, Sach[] danhSach) {
        System.out.print("Nhập mã sách cần tìm: ");
        String ma = scanner.nextLine();
        boolean timThay = false;

        for (int i = 0; i < danhSach.length; i++) {
            if (danhSach[i].getMaSach().equalsIgnoreCase(ma)) {
                System.out.println("\n===== Tìm thấy sách =====");
                hienThiThongTin(danhSach[i]);
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sách có mã \"" + ma + "\".");
        }
    }

    private static boolean coDuLieu(Sach[] danhSach) {
        if (danhSach == null) {
            System.out.println("Chưa có dữ liệu. Vui lòng chọn 1 để nhập sách trước.");
            return false;
        }
        return true;
    }

    // ===================== CODE TUẦN 4 (giữ nguyên) =====================

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