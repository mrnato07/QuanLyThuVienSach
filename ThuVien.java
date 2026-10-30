import java.util.Scanner;

public class ThuVien {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Nhập thông tin sách
        System.out.println("=====Nhập thông tin sách=======");
        System.out.println("Nhập mã sách: ");
        String maSach = sc.nextLine();
        System.out.println("Nhập tên sách: ");
        String tenSach = sc.nextLine();
        System.out.println("Nhập tác giả: ");
        String tacGia = sc.nextLine();
        System.out.println("Nhập năm xuất bản: ");
        int namXuatBan = sc.nextInt();
        System.out.println("Nhập đơn giá: ");
        double donGia = sc.nextDouble();
        System.out.println("Nhập số lượng: ");
        int soLuong = sc.nextInt();
        // Tính thành tiền
        double thanhTien = donGia * soLuong;
        // Tính phí vận chuyển
        double phiVanChuyen = thanhTien * 0.05;
        // Tính tổng tiền nhập
        double tongTienNhap = thanhTien + phiVanChuyen;
        // Xuất thông tin sách
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tên sách: " + tenSach);
        System.out.println("Tác giả : " + tacGia);
        System.out.println("Năm xuất bản: " + namXuatBan);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Số lượng: " + soLuong);
        // Xuất kết quả tính tiền
        System.out.println("Kết quả tính tiền: ");
        System.out.println("Thành tiền: " + thanhTien + "VND");
        System.out.println("Phí vận chuyển: " + phiVanChuyen + "VND");
        System.out.println("Tổng tiền nhập: " + tongTienNhap + "VND");
        sc.close();
    }
}
