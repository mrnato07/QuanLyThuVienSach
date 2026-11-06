import java.util.ArrayList;
import java.util.Scanner;

/*
 * Bai 3: Quan ly sach bang ArrayList<String>.
 * Bai 4: Tao menu quan ly sach gom 8 chuc nang.
 */
public class ThuVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> danhSachSach = new ArrayList<>();
        int luaChon;

        // Cau hoi: Menu can co nhung chuc nang nao? -> Dung switch trong do-while, lap den lua chon 8.
        do {
            System.out.println("\n========== QUAN LY THU VIEN ==========");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.print("Lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    themSach(scanner, danhSachSach);
                    break;
                case 2:
                    hienThiDanhSach(danhSachSach);
                    break;
                case 3:
                    timSach(scanner, danhSachSach);
                    break;
                case 4:
                    xoaSach(scanner, danhSachSach);
                    break;
                case 5:
                    suaSach(scanner, danhSachSach);
                    break;
                case 6:
                    tinhTongSoLuong(danhSachSach);
                    break;
                case 7:
                    tinhTongGiaTri(danhSachSach);
                    break;
                case 8:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 1 den 8.");
            }
        } while (luaChon != 8);
        scanner.close();
    }

    // Cau hoi: Lam sao doi Sach thanh mot chuoi? -> Noi cac truong theo thu tu, ngan cach bang dau cham phay.
    private static String sachThanhChuoi(Sach sach) {
        String maSach = sach.getMaSach().replace(';', ',');
        String tenSach = sach.getTenSach().replace(';', ',');
        String tacGia = sach.getTacGia().replace(';', ',');
        String loaiSach = sach.getLoaiSach().replace(';', ',');
        return maSach + ";" + tenSach + ";" + tacGia + ";" + sach.getNamXuatBan()
                + ";" + sach.getDonGia() + ";" + sach.getSoLuong() + ";" + loaiSach;
    }

    // Cau hoi: Lam sao doc Sach tu chuoi? -> Tach du 7 truong va chuyen cac truong so ve kieu so.
    private static Sach chuoiThanhSach(String chuoi) {
        String[] thongTin = chuoi.split(";", -1);
        return new Sach(thongTin[0], thongTin[1], thongTin[2],
                Integer.parseInt(thongTin[3]), Double.parseDouble(thongTin[4]),
                Integer.parseInt(thongTin[5]), thongTin[6]);
    }

    // Cau hoi: Tim ma sach nhu the nao? -> Duyet danh sach va so sanh khong phan biet hoa thuong.
    private static int timViTri(ArrayList<String> danhSachSach, String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            Sach sach = chuoiThanhSach(danhSachSach.get(i));
            if (sach.getMaSach().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    // Cau hoi: Them sach va chan ma trung nhu the nao? -> Kiem tra ma truoc, sau do nhap lai thong tin khong hop le.
    private static void themSach(Scanner scanner, ArrayList<String> danhSachSach) {
        System.out.print("Nhap ma sach: ");
        String maSach = scanner.nextLine().replace(';', ',');
        if (timViTri(danhSachSach, maSach) != -1) {
            System.out.println("Ma sach da ton tai.");
            return;
        }
        nhapThongTinSach(scanner, danhSachSach, maSach, null, -1);
    }

    // Cau hoi: Sua sach va giu ma nhu the nao? -> Dung set tai vi tri tim duoc va giu ma cu.
    private static void suaSach(Scanner scanner, ArrayList<String> danhSachSach) {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }
        System.out.print("Nhap ma sach can sua: ");
        String ma = scanner.nextLine();
        int viTri = timViTri(danhSachSach, ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma " + ma + ".");
            return;
        }
        Sach sachCu = chuoiThanhSach(danhSachSach.get(viTri));
        nhapThongTinSach(scanner, danhSachSach, sachCu.getMaSach(), sachCu, viTri);
    }

    private static void nhapThongTinSach(Scanner scanner, ArrayList<String> danhSachSach,
                                         String maSach, Sach sachCu, int viTri) {
        while (true) {
            System.out.print("Nhap ten sach: ");
            String tenSach = scanner.nextLine().replace(';', ',');
            System.out.print("Nhap tac gia: ");
            String tacGia = scanner.nextLine().replace(';', ',');
            System.out.print("Nhap nam xuat ban: ");
            int namXuatBan = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nhap don gia: ");
            double donGia = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Nhap so luong: ");
            int soLuong = scanner.nextInt();
            scanner.nextLine();
            int luaChonLoaiSach = nhapLuaChonLoaiSach(scanner);
            scanner.nextLine();
            String loaiSach = layTenLoaiSach(luaChonLoaiSach);

            Sach sach = new Sach(maSach, tenSach, tacGia, namXuatBan, donGia, soLuong, loaiSach);
            System.out.println("\n===== Ket qua kiem tra =====");
            inKetQuaKiemTra(sach);
            if (sach.laSachHopLe()) {
                if (viTri == -1) {
                    danhSachSach.add(sachThanhChuoi(sach));
                    System.out.println("Da them sach.");
                } else {
                    danhSachSach.set(viTri, sachThanhChuoi(sach));
                    System.out.println("Da cap nhat sach.");
                }
                return;
            }
            System.out.println("Vui long nhap lai thong tin cuon sach nay.\n");
        }
    }

    // Cau hoi: Hien thi danh sach the nao? -> Bao danh sach trong hoac duyet tung chuoi sach.
    private static void hienThiDanhSach(ArrayList<String> danhSachSach) {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.println("\n===== Sach thu " + (i + 1) + " =====");
            hienThiThongTin(chuoiThanhSach(danhSachSach.get(i)));
        }
    }

    // Cau hoi: Tim sach theo ma the nao? -> Goi timViTri de tim, sau do hien thi sach neu thay.
    private static void timSach(Scanner scanner, ArrayList<String> danhSachSach) {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }
        System.out.print("Nhap ma sach can tim: ");
        String ma = scanner.nextLine();
        int viTri = timViTri(danhSachSach, ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma \"" + ma + "\".");
        } else {
            hienThiThongTin(chuoiThanhSach(danhSachSach.get(viTri)));
        }
    }

    // Cau hoi: Xoa sach theo ma nhu the nao? -> Tim vi tri roi goi remove(viTri).
    private static void xoaSach(Scanner scanner, ArrayList<String> danhSachSach) {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }
        System.out.print("Nhap ma sach can xoa: ");
        String ma = scanner.nextLine();
        int viTri = timViTri(danhSachSach, ma);
        if (viTri == -1) {
            System.out.println("Khong tim thay sach co ma " + ma + ".");
        } else {
            danhSachSach.remove(viTri);
            System.out.println("Da xoa sach.");
        }
    }

    // Cau hoi: In thong tin sach nhu the nao? -> Doc tung thuoc tinh va in them phan loai, tinh trang kho.
    private static void hienThiThongTin(Sach sach) {
        System.out.println("Ma sach: " + sach.getMaSach());
        System.out.println("Ten sach: " + sach.getTenSach());
        System.out.println("Tac gia: " + sach.getTacGia());
        System.out.println("Nam xuat ban: " + sach.getNamXuatBan());
        System.out.println("Don gia: " + sach.getDonGia() + " VND");
        System.out.println("So luong: " + sach.getSoLuong());
        System.out.println("Loai sach: " + sach.getLoaiSach());
        if (sach.laSachHopLe()) {
            double thanhTien = sach.getDonGia() * sach.getSoLuong();
            double phiVanChuyen = thanhTien * 0.05;
            double tongTienNhap = thanhTien + phiVanChuyen;
            System.out.println("Phan loai gia: " + sach.phanLoaiGia());
            System.out.println("Tinh trang ton kho: " + sach.phanLoaiTonKho());
            System.out.println("Thanh tien: " + thanhTien + " VND");
            System.out.println("Phi van chuyen: " + phiVanChuyen + " VND");
            System.out.println("Tong tien nhap: " + tongTienNhap + " VND");
        }
    }

    // Cau hoi: Tong so luong tinh the nao? -> Cong so luong cua tung sach bang vong for.
    private static void tinhTongSoLuong(ArrayList<String> danhSachSach) {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }
        int tongSoLuong = 0;
        for (int i = 0; i < danhSachSach.size(); i++) {
            tongSoLuong += chuoiThanhSach(danhSachSach.get(i)).getSoLuong();
        }
        System.out.println("Tong so luong: " + tongSoLuong);
    }

    // Cau hoi: Tong gia tri tinh the nao? -> Cong donGia nhan soLuong cua tung sach bang vong for.
    private static void tinhTongGiaTri(ArrayList<String> danhSachSach) {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }
        double tongGiaTri = 0;
        for (int i = 0; i < danhSachSach.size(); i++) {
            Sach sach = chuoiThanhSach(danhSachSach.get(i));
            tongGiaTri += sach.getDonGia() * sach.getSoLuong();
        }
        System.out.println("Tong gia tri: " + tongGiaTri + " VND");
    }

    // Cau hoi: Chon loai sach the nao? -> Tra ve so tu 1 den 4 de lay ten loai sach.
    private static int nhapLuaChonLoaiSach(Scanner scanner) {
        int luaChon;
        do {
            System.out.println("\nChon loai sach:");
            System.out.println("1. Sach giao khoa");
            System.out.println("2. Sach tham khao");
            System.out.println("3. Sach chuyen nganh");
            System.out.println("4. Sach khac");
            System.out.print("Lua chon cua ban: ");
            luaChon = scanner.nextInt();
            if (luaChon < 1 || luaChon > 4) {
                System.out.println("Lua chon khong hop le. Vui long chon tu 1 den 4.");
            }
        } while (luaChon < 1 || luaChon > 4);
        return luaChon;
    }

    private static String layTenLoaiSach(int luaChon) {
        switch (luaChon) {
            case 1: return "Sach giao khoa";
            case 2: return "Sach tham khao";
            case 3: return "Sach chuyen nganh";
            case 4: return "Sach khac";
            default: return "Khong xac dinh";
        }
    }

    // Cau hoi: Kiem tra sach the nao? -> Goi cac ham hop le trong Sach va thong bao ket qua.
    private static void inKetQuaKiemTra(Sach sach) {
        if (sach.giaHopLe()) {
            System.out.println("Gia sach hop le.");
        } else {
            System.out.println("Gia sach khong hop le. Don gia phai lon hon 0.");
        }
        if (sach.soLuongHopLe()) {
            System.out.println("So luong hop le.");
        } else {
            System.out.println("So luong khong hop le. So luong phai tu 0 tro len.");
        }
        if (sach.namXuatBanHopLe()) {
            System.out.println("Nam xuat ban hop le.");
        } else {
            System.out.println("Nam xuat ban khong hop le.");
        }
        if (sach.laSachHopLe()) {
            System.out.println("Thong tin sach hop le.");
        } else {
            System.out.println("Thong tin sach khong hop le.");
        }
    }
}
