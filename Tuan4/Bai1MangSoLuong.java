/*
 * Bai 1: Nhap so luong cua 5 cuon sach, hien thi, tinh tong va tim so luong lon nhat.
 */
import java.util.Scanner;

public class Bai1MangSoLuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] soLuong = new int[5];

        // Cau hoi: Nhap 5 so luong khong am nhu the nao? -> Dung for va nhap lai den khi gia tri >= 0.
        for (int i = 0; i < soLuong.length; i++) {
            while (true) {
                System.out.print("Nhap so luong sach thu " + (i + 1) + ": ");
                soLuong[i] = scanner.nextInt();
                scanner.nextLine();
                if (soLuong[i] >= 0) {
                    break;
                }
                System.out.println("So luong phai >= 0.");
            }
        }

        // Cau hoi: Hien thi va tinh tong so luong the nao? -> Duyet mang mot lan bang vong for.
        int tongSoLuong = 0;
        System.out.println("So luong 5 cuon sach:");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);
            tongSoLuong += soLuong[i];
        }

        // Cau hoi: Tim so luong lon nhat the nao? -> Gan max bang phan tu dau roi so tu i = 1.
        int max = soLuong[0];
        for (int i = 1; i < soLuong.length; i++) {
            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }
        System.out.println("Tong so luong: " + tongSoLuong);
        System.out.println("So luong lon nhat: " + max);
        scanner.close();
    }
}
