import java.time.Year;

public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
    private String loaiSach;

    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan,
                double donGia, int soLuong, String loaiSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.loaiSach = loaiSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public boolean giaHopLe() {
        return donGia > 0;
    }

    public boolean soLuongHopLe() {
        return soLuong >= 0;
    }

    public boolean namXuatBanHopLe() {
        int namHienTai = Year.now().getValue();
        return namXuatBan >= 1 && namXuatBan <= namHienTai;
    }

    public boolean laSachHopLe() {
        return giaHopLe() && soLuongHopLe() && namXuatBanHopLe();
    }

    public String phanLoaiGia() {
        if (donGia < 50000) {
            return "Sách giá thấp";
        } else if (donGia <= 100000) {
            // Mốc 100.000 được xếp vào mức trung bình để các khoảng giá không bị chồng lấn.
            return "Sách giá trung bình";
        } else if (donGia <= 200000) {
            return "Sách giá cao";
        } else {
            return "Sách giá đặc biệt";
        }
    }

    public String phanLoaiTonKho() {
        if (soLuong == 0) {
            return "Hết sách";
        } else if (soLuong <= 5) {
            return "Sắp hết";
        } else if (soLuong <= 20) {
            return "Còn ít";
        } else {
            return "Còn nhiều";
        }
    }
}
