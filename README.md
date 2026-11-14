# Quản Lý Thư Viện Sách – Thực Hành Lập Trình Hướng Đối Tượng (Java OOP)

Project thực hành môn **Lập trình Hướng đối tượng (Java OOP)** với chủ đề xuyên suốt là **Chương trình quản lý sách thư viện**, được phát triển liên tục qua từng tuần học từ **Tuần 3 đến Tuần 8**.

---

## 1. Cấu trúc thư mục hiện tại

```text
QuanLyThuVienSach/
├── Tuan3/
│   └── ThuVien.java              # Bài tập Tuần 3: Nhập xuất và tính toán cơ bản
├── Tuan4/
│   ├── Bai1MangSoLuong.java      # Bài tập Tuần 6 (Bài 1): Mảng 1 chiều quản lý số lượng sách
│   ├── Bai2DanhSachMaSach.java   # Bài tập Tuần 6 (Bài 2): ArrayList<String> quản lý mã sách
│   ├── ThuVien.java              # Bài tập Tuần 4, 5, 6: Menu quản lý thư viện sách
│   ├── Sach.java                 # Bài tập Tuần 7 & 8: Lớp Sach (Thuộc tính, Đóng gói, Getter/Setter, Constructor)
│   └── Test.java                 # Bài tập Tuần 7 & 8: Lớp kiểm thử đối tượng Sach và ArrayList<Sach>
├── .gitignore
└── README.md
```

---

## 2. Chi tiết các thay đổi ở Tuần 7 và Tuần 8

### Giai đoạn 1: Bài tập Tuần 7 – Lớp và Đối tượng trong Java (Commit `612a1dd`)
- **File `Tuan4/Sach.java`:**
  - Xây dựng lớp `Sach` theo đúng yêu cầu giáo trình Tuần 7 gồm 5 thuộc tính:
    - `maSach` (`String`)
    - `tieuDe` (`String`)
    - `tacGia` (`String`)
    - `namXuatBan` (`int`)
    - `soLuong` (`int`)
  - Xây dựng phương thức `hienThiThongTin()` để hiển thị đầy đủ thông tin của một cuốn sách ra màn hình.
- **File `Tuan4/Test.java` (Tạo mới):**
  - Xây dựng phương thức `main()` khởi tạo các đối tượng từ lớp `Sach` (`sach1`, `sach2`, `sach3`), gán thông tin trực tiếp và gọi `hienThiThongTin()`.
  - Khởi tạo `ArrayList<Sach>`, thêm các đối tượng sách vào danh sách bằng `add()` và duyệt danh sách để hiển thị thông tin từng cuốn sách.
- **File `Tuan4/ThuVien.java`:**
  - Tách phần xử lý chuỗi sách trong bài tập `ArrayList<String>` của Tuần 6 để hoạt động độc lập, giúp toàn bộ các file trong thư mục `Tuan4/` biên dịch đồng bộ trên VS Code mà không xung đột với lớp `Sach` 5 thuộc tính của Tuần 7.

### Giai đoạn 2: Bài tập Tuần 8 – Tính chất Đóng gói trong OOP (Commit `340b71a`)
- **File `Tuan4/Sach.java` (Phát triển tiếp từ Tuần 7):**
  - **Bài 1 (Sử dụng `private`):** Chuyển toàn bộ 5 thuộc tính (`maSach`, `tieuDe`, `tacGia`, `namXuatBan`, `soLuong`) sang phạm vi truy cập `private` để ngăn truy cập trực tiếp từ bên ngoài lớp.
  - **Bài 2 (Getter và Setter):** Tạo đầy đủ các phương thức `public` Getter và Setter cho cả 5 thuộc tính:
    - `getMaSach()` / `setMaSach(String maSach)`
    - `getTieuDe()` / `setTieuDe(String tieuDe)`
    - `getTacGia()` / `setTacGia(String tacGia)`
    - `getNamXuatBan()` / `setNamXuatBan(int namXuatBan)`
    - `getSoLuong()` / `setSoLuong(int soLuong)`
  - **Bài 3 (Kiểm tra dữ liệu trong Setter):**
    - Trong `setNamXuatBan(int namXuatBan)`: Kiểm tra điều kiện `namXuatBan > 0 && namXuatBan <= currentYear`. Nếu không hợp lệ thì giữ nguyên giá trị cũ và in thông báo lỗi.
    - Trong `setSoLuong(int soLuong)`: Kiểm tra điều kiện `soLuong >= 0` (không chấp nhận số lượng âm). Nếu không hợp lệ thì giữ nguyên giá trị cũ và in thông báo lỗi.
  - **Bài 4 (Constructor có tham số):**
    - Bổ sung constructor mặc định `Sach()` và constructor đầy đủ 5 tham số `Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong)` gọi qua các Setter để đảm bảo dữ liệu đầu vào luôn được kiểm tra hợp lệ.
- **File `Tuan4/Test.java` (Cập nhật):**
  - Khởi tạo các đối tượng `Sach` bằng constructor có tham số.
  - Sử dụng các phương thức Getter để lấy và in thông tin từng thuộc tính.
  - Sử dụng các phương thức Setter để kiểm tra cập nhật dữ liệu hợp lệ và không hợp lệ (năm xuất bản âm `-2020`, năm lớn hơn năm hiện tại `2099`, số lượng âm `-5`) trước khi cập nhật giá trị hợp lệ.
  - Hiển thị thông tin sau khi cập nhật và tiếp tục quản lý danh sách đối tượng `Sach` bằng `ArrayList<Sach>`.

---

## 3. Mối liên hệ giữa Tuần 7 – 8 và các Commit cũ (Tuần 3 → Tuần 6)

Project được phát triển nối tiếp qua từng tuần học, mỗi tuần kế thừa và nâng cấp từ tuần trước:

| Tuần | Commit | Nội dung thực hiện | Mối liên hệ với Tuần 7 & Tuần 8 |
| :--- | :--- | :--- | :--- |
| **Tuần 3** | `ac22c82`<br>`7d471fd` | **Biến, kiểu dữ liệu và nhập xuất** (`Tuan3/ThuVien.java`): Nhập thông tin 1 cuốn sách từ bàn phím, tính thành tiền, phí vận chuyển và tổng tiền nhập. | Đặt nền móng cho các thuộc tính cơ bản của sách (`maSach`, `tacGia`, `namXuatBan`, `soLuong`) được giữ nguyên cách đặt tên xuyên suốt đến Tuần 7 & 8. |
| **Tuần 4** | `fc0c408` | **Cấu trúc rẽ nhánh `if-else`, `switch-case`** (`Tuan4/Sach.java`, `Tuan4/ThuVien.java`): Kiểm tra tính hợp lệ của thông tin sách, phân loại giá và tình trạng tồn kho. | Tạo thư mục `Tuan4/` làm thư mục bài tập chính của project. Điều kiện kiểm tra năm xuất bản bằng `Year.now().getValue()` và số lượng `>= 0` ở Tuần 4 được chuẩn hóa vào `setNamXuatBan()` và `setSoLuong()` ở Tuần 8. |
| **Tuần 5** | `f8ff582` | **Câu lệnh lặp `for`, `while`, `do-while`** (`Tuan4/ThuVien.java`): Nhập danh sách `n` cuốn sách, tính tổng số lượng, tổng giá trị, tìm kiếm theo mã và tạo menu lặp. | Duy trì việc phát triển nối tiếp ngay trong thư mục `Tuan4/` thay vì tách project mới. |
| **Tuần 6** | `18d4fe4` | **Mảng 1 chiều và `ArrayList<String>`** (`Tuan4/Bai1MangSoLuong.java`, `Tuan4/Bai2DanhSachMaSach.java`, `Tuan4/ThuVien.java`): Quản lý mảng số lượng, danh sách mã sách và danh sách chuỗi thông tin sách. | Bước chuyển tiếp trực tiếp sang Tuần 7: Tuần 6 dùng `ArrayList<String>` lưu thông tin sách dạng chuỗi ghép, còn Tuần 7 & 8 nâng cấp lên quản lý danh sách đối tượng `ArrayList<Sach>` và giữ nguyên phong cách code/chú thích tiếng Việt không dấu của Tuần 6. |
| **Tuần 7** | `612a1dd` | **Lớp và Đối tượng trong Java** (`Tuan4/Sach.java`, `Tuan4/Test.java`): Xây dựng lớp `Sach` 5 thuộc tính, `hienThiThongTin()`, lớp `Test` và `ArrayList<Sach>`. | Chuyển đổi hoàn toàn sang mô hình Lập trình Hướng đối tượng (OOP) với lớp `Sach` và `ArrayList<Sach>`. |
| **Tuần 8** | `340b71a` | **Tính chất Đóng gói trong OOP** (`Tuan4/Sach.java`, `Tuan4/Test.java`): Thuộc tính `private`, Getter/Setter có kiểm tra dữ liệu và Constructor đầy đủ tham số. | Hoàn thiện tính đóng gói (Encapsulation) trực tiếp trên lớp `Sach` và `Test` của Tuần 7. |

---

## 4. Hướng dẫn biên dịch và chạy chương trình

Mở Terminal tại thư mục gốc của project (`QuanLyThuVienSach`) và chạy các lệnh sau:

### Chạy bài tập Tuần 7 & Tuần 8 (`Test.java`)
```bash
javac Tuan4/Sach.java Tuan4/Test.java
java -cp Tuan4 Test
```

### Chạy các bài tập Tuần 6 (`Bai1MangSoLuong`, `Bai2DanhSachMaSach`, `ThuVien`)
```bash
javac Tuan4/*.java
java -cp Tuan4 Bai1MangSoLuong
java -cp Tuan4 Bai2DanhSachMaSach
java -cp Tuan4 ThuVien
```
