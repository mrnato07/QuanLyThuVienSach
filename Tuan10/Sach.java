/*
 * Bai tap tuan 10: Tinh chat truu tuong trong OOP
 * Sach la lop truu tuong (abstract), implements interface IThanhtien.
 * Phuong thuc tinhThanhTien() chua duoc dinh nghia o day, lop con bat buoc phai override.
 */
public abstract class Sach implements IThanhtien {
    private String maSach;
    private int ngay;      // ngay nhap
    private int thang;     // thang nhap
    private int nam;       // nam nhap
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;
    protected double thanhTien; // ket qua cua tinhThanhTien(), lop con duoc gan truc tiep

    // Constructor mac dinh
    public Sach() {
    }

    // Constructor day du tham so
    public Sach(String maSach, int ngay, int thang, int nam, double donGia, int soLuong, String nhaXuatBan) {
        setMaSach(maSach);
        setNgay(ngay);
        setThang(thang);
        setNam(nam);
        setDonGia(donGia);
        setSoLuong(soLuong);
        setNhaXuatBan(nhaXuatBan);
    }

    // Phuong thuc truu tuong: lop con phai override
    @Override
    public abstract void tinhThanhTien();

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        if (ngay >= 1 && ngay <= 31) {
            this.ngay = ngay;
        } else {
            System.out.println("Loi: Ngay nhap khong hop le (" + ngay + ").");
        }
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        if (thang >= 1 && thang <= 12) {
            this.thang = thang;
        } else {
            System.out.println("Loi: Thang nhap khong hop le (" + thang + ").");
        }
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        if (nam > 0) {
            this.nam = nam;
        } else {
            System.out.println("Loi: Nam nhap khong hop le (" + nam + ").");
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia >= 0) {
            this.donGia = donGia;
        } else {
            System.out.println("Loi: Don gia khong hop le (" + donGia + "). Don gia phai >= 0.");
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Loi: So luong khong hop le (" + soLuong + "). So luong phai >= 0.");
        }
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    // Tinh lai thanh tien roi tra ve (dam bao luon dung voi du lieu hien tai)
    public double getThanhTien() {
        tinhThanhTien();
        return thanhTien;
    }

    // Hien thi thong tin chung cua sach
    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + ngay + "/" + thang + "/" + nam);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Nha xuat ban: " + nhaXuatBan);
    }
}
