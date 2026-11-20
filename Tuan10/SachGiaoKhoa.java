/*
 * Lop SachGiaoKhoa ke thua lop truu tuong Sach, override tinhThanhTien().
 */
public class SachGiaoKhoa extends Sach {
    private boolean tinhTrangMoiCu; // true = moi, false = cu

    public SachGiaoKhoa() {
        super();
    }

    public SachGiaoKhoa(String maSach, int ngay, int thang, int nam, double donGia, int soLuong,
            String nhaXuatBan, boolean tinhTrangMoiCu) {
        super(maSach, ngay, thang, nam, donGia, soLuong, nhaXuatBan);
        this.tinhTrangMoiCu = tinhTrangMoiCu;
    }

    public boolean isTinhTrangMoiCu() {
        return tinhTrangMoiCu;
    }

    public void setTinhTrangMoiCu(boolean tinhTrangMoiCu) {
        this.tinhTrangMoiCu = tinhTrangMoiCu;
    }

    // Sach moi: soLuong * donGia; sach cu: soLuong * donGia * 0.5
    @Override
    public void tinhThanhTien() {
        if (tinhTrangMoiCu) {
            thanhTien = getSoLuong() * getDonGia();
        } else {
            thanhTien = getSoLuong() * getDonGia() * 0.5;
        }
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("--- Sach giao khoa ---");
        super.hienThiThongTin();
        System.out.println("Tinh trang: " + (tinhTrangMoiCu ? "Moi" : "Cu"));
        System.out.println("Thanh tien: " + getThanhTien());
    }
}
