import java.time.Year;

/*
 * Bai tap tuan 8: Tinh chat dong goi trong OOP
 * Bai 1: Chuyen tat ca 5 thuoc tinh sang private.
 * Bai 2: Tao day du cac phuong thuc public getter va setter.
 * Bai 3: Kiem tra du lieu hop le trong setNamXuatBan() va setSoLuong().
 * Bai 4: Them constructor day du tham so cho lop Sach.
 */
public class Sach {
    // Bai 1: Khai bao 5 thuoc tinh voi pham vi truy cap private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Constructor mac dinh
    public Sach() {
    }

    // Bai 4: Constructor co day du tham so (su dung setter de kiem tra du lieu hop le)
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        setMaSach(maSach);
        setTieuDe(tieuDe);
        setTacGia(tacGia);
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    // Bai 2: Cac phuong thuc Getter va Setter cho 5 thuoc tinh
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    // Bai 3: Kiem tra nam xuat ban phai > 0 va <= nam hien tai
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Loi: Nam xuat ban khong hop le (" + namXuatBan
                    + "). Nam xuat ban phai > 0 va <= " + currentYear + ".");
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Bai 3: Kiem tra so luong phai >= 0 (khong chap nhan so luong am)
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Loi: So luong khong hop le (" + soLuong + "). So luong phai >= 0.");
        }
    }

    // Phuong thuc hien thi day du thong tin cua mot cuon sach
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
    }
}
