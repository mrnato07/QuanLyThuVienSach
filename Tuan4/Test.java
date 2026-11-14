import java.util.ArrayList;

/*
 * Bai tap tuan 7: Lop va Doi tuong trong Java
 * Bai 3: Xay dung lop Test co phuong thuc main() de tao doi tuong Sach, gan thong tin va hien thi.
 * Bai 4: Quan ly danh sach Sach bang ArrayList<Sach>.
 */
public class Test {
    public static void main(String[] args) {
        // ===== Bai 3: Tao cac doi tuong tu lop Sach, gan thong tin va hien thi =====
        System.out.println("===== HIEN THI THONG TIN TUNG CUON SACH =====");

        // Tao doi tuong sach thu nhat va gan thong tin
        Sach sach1 = new Sach();
        sach1.maSach = "S001";
        sach1.tieuDe = "Lap trinh huong doi tuong Java";
        sach1.tacGia = "Nguyen Van A";
        sach1.namXuatBan = 2023;
        sach1.soLuong = 15;

        // Tao doi tuong sach thu hai va gan thong tin
        Sach sach2 = new Sach();
        sach2.maSach = "S002";
        sach2.tieuDe = "Cau truc du lieu va giai thuat";
        sach2.tacGia = "Tran Thi B";
        sach2.namXuatBan = 2022;
        sach2.soLuong = 10;

        // Tao doi tuong sach thu ba va gan thong tin
        Sach sach3 = new Sach();
        sach3.maSach = "S003";
        sach3.tieuDe = "Co so du lieu";
        sach3.tacGia = "Le Van C";
        sach3.namXuatBan = 2024;
        sach3.soLuong = 20;

        // Goi phuong thuc hienThiThongTin() cho tung doi tuong
        System.out.println("\n--- Thong tin sach 1 ---");
        sach1.hienThiThongTin();

        System.out.println("\n--- Thong tin sach 2 ---");
        sach2.hienThiThongTin();

        System.out.println("\n--- Thong tin sach 3 ---");
        sach3.hienThiThongTin();

        // ===== Bai 4: Quan ly danh sach Sach bang ArrayList =====
        System.out.println("\n===== DANH SACH SACH TRONG ARRAYLIST =====");

        // Khoi tao danh sach sach
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        // Them nhieu doi tuong Sach vao danh sach bang phuong thuc add()
        danhSachSach.add(sach1);
        danhSachSach.add(sach2);
        danhSachSach.add(sach3);

        // Duyet danh sach va hien thi thong tin tung cuon sach
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.println("\nSach thu " + (i + 1) + ":");
            danhSachSach.get(i).hienThiThongTin();
        }
    }
}
