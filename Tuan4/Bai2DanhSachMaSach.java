/*
 * Bai 2: Dung ArrayList<String> de them, hien thi, tim va xoa ma sach.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Bai2DanhSachMaSach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> danhSachMaSach = new ArrayList<>();
        int luaChon;

        // Cau hoi: Quan ly ma sach bang menu nao? -> Dung switch va lap den khi chon 0.
        do {
            System.out.println("\n1. Them");
            System.out.println("2. Hien thi");
            System.out.println("3. Tim");
            System.out.println("4. Xoa");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    String maSachThem = scanner.nextLine();
                    if (danhSachMaSach.contains(maSachThem)) {
                        System.out.println("Ma sach da ton tai.");
                    } else {
                        danhSachMaSach.add(maSachThem);
                        System.out.println("Da them ma sach.");
                    }
                    break;
                case 2:
                    if (danhSachMaSach.isEmpty()) {
                        System.out.println("Danh sach ma sach dang trong.");
                    } else {
                        for (int i = 0; i < danhSachMaSach.size(); i++) {
                            System.out.println((i + 1) + ". " + danhSachMaSach.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    String maSachTim = scanner.nextLine();
                    int viTri = danhSachMaSach.indexOf(maSachTim);
                    if (viTri == -1) {
                        System.out.println("Khong tim thay ma sach.");
                    } else {
                        System.out.println("Tim thay tai vi tri " + (viTri + 1) + ".");
                    }
                    break;
                case 4:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maSachXoa = scanner.nextLine();
                    if (danhSachMaSach.remove(maSachXoa)) {
                        System.out.println("Da xoa ma sach.");
                    } else {
                        System.out.println("Khong tim thay ma sach.");
                    }
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 0 den 4.");
            }
        } while (luaChon != 0);
        scanner.close();
    }
}
