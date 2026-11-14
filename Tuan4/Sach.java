/*
 * Bai tap tuan 7: Lop va Doi tuong trong Java
 * Bai 1: Xay dung lop Sach gom 5 thuoc tinh: maSach, tieuDe, tacGia, namXuatBan, soLuong.
 * Bai 2: Xay dung phuong thuc hienThiThongTin() de hien thi thong tin sach.
 */
public class Sach {
    // Bai 1: Khai bao 5 thuoc tinh cua lop Sach
    String maSach;
    String tieuDe;
    String tacGia;
    int namXuatBan;
    int soLuong;

    // Bai 2: Phuong thuc hien thi day du thong tin cua mot cuon sach
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
    }
}
