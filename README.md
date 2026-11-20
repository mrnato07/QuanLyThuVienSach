# Quản lý thư viện sách bằng Java

## Mục lục

1. [Giới thiệu](#1-giới-thiệu)
2. [Công nghệ sử dụng](#2-công-nghệ-sử-dụng)
3. [Cấu trúc thư mục](#3-cấu-trúc-thư-mục)
4. [Nội dung đã thực hiện từ tuần 3 đến tuần 10](#4-nội-dung-đã-thực-hiện-từ-tuần-3-đến-tuần-10)
5. [Mô tả các lớp và chức năng chính](#5-mô-tả-các-lớp-và-chức-năng-chính)
6. [Kiến thức OOP đã áp dụng](#6-kiến-thức-oop-đã-áp-dụng)
7. [Hướng dẫn mở project và chạy chương trình](#7-hướng-dẫn-mở-project-và-chạy-chương-trình)
8. [Biên dịch và chạy bằng terminal](#8-biên-dịch-và-chạy-bằng-terminal)
9. [Thông tin tác giả](#9-thông-tin-tác-giả)

---

## 1. Giới thiệu

Đây là dự án bài tập thực hành môn **Lập trình Hướng đối tượng (Java)** theo giáo trình của Trường Đại học Sư phạm Kỹ thuật – Đại học Đà Nẵng. Chủ đề xuyên suốt là **chương trình quản lý thư viện sách**, được phát triển dần qua từng tuần.

**Mục tiêu học tập:** nắm vững cú pháp Java cơ bản (biến, rẽ nhánh, vòng lặp, mảng, `ArrayList`) và bốn tính chất của OOP: lớp/đối tượng, đóng gói, kế thừa, trừu tượng (cùng với interface).

## 2. Công nghệ sử dụng

- **Java** (ngôn ngữ lập trình)
- **JDK** 17 trở lên (đã kiểm tra bằng JDK 21)
- **IDE:** Visual Studio Code (hoặc IntelliJ IDEA, Eclipse, NetBeans)
- **Git và GitHub** để quản lý mã nguồn

## 3. Cấu trúc thư mục

```text
QuanLyThuVienSach/
├── Tuan3/
│   └── ThuVien.java              # Tuần 3: nhập/xuất và tính toán cơ bản
├── Tuan4/
│   ├── Bai1MangSoLuong.java      # Tuần 6: mảng 1 chiều quản lý số lượng sách
│   ├── Bai2DanhSachMaSach.java   # Tuần 6: ArrayList<String> quản lý mã sách
│   ├── ThuVien.java              # Tuần 4, 5, 6: menu quản lý thư viện
│   ├── Sach.java                 # Tuần 7, 8: lớp Sach (5 thuộc tính, đóng gói)
│   └── Test.java                 # Tuần 7, 8: kiểm thử lớp Sach và ArrayList<Sach>
├── Tuan9/
│   ├── Sach.java                 # Lớp cha Sach
│   ├── SachGiaoKhoa.java         # Lớp con kế thừa Sach
│   ├── SachThamKhao.java         # Lớp con kế thừa Sach
│   └── QuanLySach.java           # Menu quản lý (có hàm main)
├── Tuan10/
│   ├── IThanhtien.java           # Interface
│   ├── Sach.java                 # Lớp trừu tượng, implements IThanhtien
│   ├── SachGiaoKhoa.java
│   ├── SachThamKhao.java
│   ├── DSSach.java               # Quản lý danh sách sách bằng ArrayList
│   └── Test.java                 # Kiểm thử + menu (có hàm main)
├── .gitignore
└── README.md
```

> Mỗi thư mục tuần được biên dịch độc lập, nên các lớp trùng tên `Sach` ở `Tuan4`, `Tuan9`, `Tuan10` không xung đột. Lớp `Sach` ở `Tuan4` (tuần 8) có thuộc tính `tieuDe`, `tacGia`, `namXuatBan`; lớp `Sach` ở tuần 9–10 theo đề bài mới (`maSach`, `ngayNhap`, `donGia`, `soLuong`, `nhaXuatBan`) nên được viết trong thư mục riêng để không ghi đè bài tuần trước.

## 4. Nội dung đã thực hiện từ tuần 3 đến tuần 10

| Tuần | Nội dung | Vị trí |
| :--- | :--- | :--- |
| 3 | Biến, kiểu dữ liệu, nhập xuất: nhập thông tin sách, tính thành tiền | `Tuan3/ThuVien.java` |
| 4 | Cấu trúc rẽ nhánh `if-else`, `switch-case` | `Tuan4/ThuVien.java` |
| 5 | Vòng lặp `for`, `while`, `do-while`, menu lặp | `Tuan4/ThuVien.java` |
| 6 | Mảng 1 chiều và `ArrayList<String>` | `Tuan4/Bai1MangSoLuong.java`, `Bai2DanhSachMaSach.java`, `ThuVien.java` |
| 7 | Lớp và đối tượng: lớp `Sach`, `hienThiThongTin()`, `ArrayList<Sach>` | `Tuan4/Sach.java`, `Tuan4/Test.java` |
| 8 | Đóng gói: thuộc tính `private`, getter/setter có kiểm tra dữ liệu, constructor đầy đủ tham số | `Tuan4/Sach.java`, `Tuan4/Test.java` |
| 9 | Kế thừa: `SachGiaoKhoa`, `SachThamKhao` kế thừa `Sach` | `Tuan9/` |
| 10 | Trừu tượng: interface `IThanhtien`, abstract class `Sach`, lớp `DSSach` | `Tuan10/` |

### Tuần 9 – Tính chất kế thừa

- Lớp `Sach`: `maSach`, `ngayNhap` (ngày, tháng, năm), `donGia`, `soLuong`, `nhaXuatBan` (private, có constructor, getter/setter có kiểm tra dữ liệu như tuần 8).
- `SachGiaoKhoa` (thêm `tinhTrangMoiCu`): sách mới `thanhTien = soLuong * donGia`, sách cũ `thanhTien = soLuong * donGia * 0.5`.
- `SachThamKhao` (thêm `thue`): `thanhTien = soLuong * donGia + thue`.
- `QuanLySach` (menu): nhập danh sách sách giáo khoa và tham khảo; xuất danh sách; tổng thành tiền sách giáo khoa; tổng thành tiền sách tham khảo; trung bình cộng đơn giá sách tham khảo; xuất sách giáo khoa theo nhà xuất bản X; nạp dữ liệu mẫu để chạy thử nhanh.

### Tuần 10 – Tính chất trừu tượng

- Interface `IThanhtien` khai báo `public void tinhThanhTien();`.
- `Sach` là `abstract class`, `implements IThanhtien`, giữ các thuộc tính chung, constructor, getter/setter; `tinhThanhTien()` là phương thức trừu tượng.
- `SachGiaoKhoa`, `SachThamKhao` kế thừa `Sach` và `@Override tinhThanhTien()` đúng công thức (kết quả lưu vào thuộc tính `thanhTien`, lấy bằng `getThanhTien()`).
- `DSSach` dùng `ArrayList<Sach>` với `themSach()`, `xoaSach(String maSach)`, `capNhatSach(String maSach)`, `thongKeTheoLoai()` (dùng `instanceof`), ngoài ra có `timSach()` và `hienThiDanhSach()`.
- `Test`: chạy tự động phần kiểm thử (thêm, hiển thị, kiểm tra công thức, thống kê, xóa, cập nhật) rồi vào menu console.

## 5. Mô tả các lớp và chức năng chính

| Lớp | Mô tả |
| :--- | :--- |
| `IThanhtien` | Interface với phương thức `tinhThanhTien()` |
| `Sach` (Tuan10) | Lớp trừu tượng chứa thuộc tính chung của sách |
| `SachGiaoKhoa` | Sách giáo khoa, tính thành tiền theo tình trạng mới/cũ |
| `SachThamKhao` | Sách tham khảo, thành tiền có cộng thuế |
| `DSSach` | Thêm, xóa, cập nhật, hiển thị, thống kê theo loại |
| `Test` | Kiểm thử tự động và menu console (tuần 10) |
| `QuanLySach` | Menu quản lý các loại sách (tuần 9) |

## 6. Kiến thức OOP đã áp dụng

- **Lớp và đối tượng:** `Sach`, `SachGiaoKhoa`, `SachThamKhao`, `DSSach` là các lớp; mỗi cuốn sách là một đối tượng.
- **Đóng gói:** thuộc tính `private`, truy cập qua getter/setter; setter kiểm tra dữ liệu hợp lệ (số lượng, đơn giá, ngày, tháng, năm).
- **Kế thừa:** `SachGiaoKhoa` và `SachThamKhao` dùng `extends Sach`, gọi constructor cha bằng `super(...)`, dùng lại `hienThiThongTin()` của cha qua `super.hienThiThongTin()`.
- **Trừu tượng:** `abstract class Sach` có phương thức trừu tượng `tinhThanhTien()`; không thể tạo trực tiếp đối tượng `Sach`, lớp con bắt buộc phải cài đặt.
- **Interface:** `IThanhtien` quy định hành vi tính thành tiền; `Sach` thực thi interface này.
- **Đa hình:** `ArrayList<Sach>` chứa cả hai loại sách, gọi `tinhThanhTien()` sẽ chạy đúng công thức của từng lớp con.

## 7. Hướng dẫn mở project và chạy chương trình

1. Cài JDK và IDE (ví dụ VS Code + Extension Pack for Java).
2. Clone repository:
   ```bash
   git clone https://github.com/mrnato07/QuanLyThuVienSach.git
   ```
3. Mở thư mục `QuanLyThuVienSach` trong IDE.
4. Mở file có hàm `main` (`Tuan9/QuanLySach.java` hoặc `Tuan10/Test.java`) và nhấn **Run**.

## 8. Biên dịch và chạy bằng terminal

Chạy các lệnh sau tại thư mục gốc của repository.

**Tuần 9:**
```bash
javac Tuan9/*.java
java -cp Tuan9 QuanLySach
```

**Tuần 10:**
```bash
javac Tuan10/*.java
java -cp Tuan10 Test
```

**Tuần 7 và 8:**
```bash
javac Tuan4/Sach.java Tuan4/Test.java
java -cp Tuan4 Test
```

**Tuần 4, 5, 6:**
```bash
javac Tuan4/*.java
java -cp Tuan4 ThuVien
java -cp Tuan4 Bai1MangSoLuong
java -cp Tuan4 Bai2DanhSachMaSach
```

**Tuần 3:** file `Tuan3/ThuVien.java` được lưu bằng mã hóa UTF-16 nên cần chỉ rõ encoding:
```bash
javac -encoding UTF-16 Tuan3/ThuVien.java
java -cp Tuan3 ThuVien
```

> File `.class` sinh ra sau khi biên dịch đã được bỏ qua bởi `.gitignore`.

## 9. Thông tin tác giả

- **GitHub:** [mrnato07](https://github.com/mrnato07)
- **Repository:** [QuanLyThuVienSach](https://github.com/mrnato07/QuanLyThuVienSach)
