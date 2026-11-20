/*
 * Lop SachThamKhao ke thua lop truu tuong Sach, override tinhThanhTien().
 */
public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
        super();
    }

    public SachThamKhao(String maSach, int ngay, int thang, int nam, double donGia, int soLuong,
            String nhaXuatBan, double thue) {
        super(maSach, ngay, thang, nam, donGia, soLuong, nhaXuatBan);
        setThue(thue);
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        if (thue >= 0) {
            this.thue = thue;
        } else {
            System.out.println("Loi: Thue khong hop le (" + thue + "). Thue phai >= 0.");
        }
    }

    // thanhTien = soLuong * donGia + thue
    @Override
    public void tinhThanhTien() {
        thanhTien = getSoLuong() * getDonGia() + thue;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("--- Sach tham khao ---");
        super.hienThiThongTin();
        System.out.println("Thue: " + thue);
        System.out.println("Thanh tien: " + getThanhTien());
    }
}
