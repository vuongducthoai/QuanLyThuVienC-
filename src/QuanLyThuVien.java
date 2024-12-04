import javax.print.Doc;
import java.text.SimpleDateFormat;
import java.util.*;

public class QuanLyThuVien {
    private static ArrayList<DocGia> danhSachDocGia = new ArrayList<>();
    private static ArrayList<Sach> danhSachSach = new ArrayList<>();
    private static ArrayList<PhieuMuon> danhSachPhieuMuon = new ArrayList<>();

    private static final int MAX_SACH_MUON = 5;
    private static final int MAX_PHIEU_MUON = 100;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\nChuong trinh Quan ly Thu vien");
            System.out.println("1. Them Doc Gia");
            System.out.println("2. Xem Danh Sach Doc Gia");
            System.out.println("3. Sua Thong Tin Doc Gia");
            System.out.println("4. Xoa Doc Gia");
            System.out.println("5. Tim Kiem Doc Gia Theo CMND");
            System.out.println("6. Tim Kiem Doc Gia Theo Ho Ten");
            System.out.println("7. Them Sach");
            System.out.println("8. Xem Danh Sach Sach");
            System.out.println("9. Sua Thong Tin Sach");
            System.out.println("10. Xoa Sach");
            System.out.println("11. Tim Kiem Sach Theo ISBN");
            System.out.println("12. Tim Kiem Sach Theo Ten");
            System.out.println("13. Lap Phieu Muon");
            System.out.println("14. Lap Phieu Tra");
            System.out.println("15. Thong Ke So Luong Sach");
            System.out.println("16. Thong Ke So Luong Sach Theo The Loai");
            System.out.println("17. Thong Ke So Luong Doc Gia");
            System.out.println("18. Thong Ke Doc Gia Theo Gioi Tinh");
            System.out.println("19. Thong Ke Sach Dang Duoc Muon");
            System.out.println("20. Thong Ke Doc Gia Tre Han");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1: themDocGia(); break;
                case 2: xemDanhSachDocGia(); break;
                case 3: suaThongTinDocGia(); break;
                case 4: xoaDocGia(); break;
                case 5: timKiemDocGiaTheoCMND(); break;
                case 6: timKiemDocGiaTheoHoTen(); break;
                case 7: themSach(); break;
                case 8: xemDanhSachSach(); break;
                case 9: suaThongTinSach(); break;
                case 10: xoaSach(); break;
                case 11: timKiemSachTheoISBN(); break;
                case 12: timKiemSachTheoTen(); break;
                case 13: lapPhieuMuon(); break;
                case 14: lapPhieuTra(); break;
                case 15: thongKeSoLuongSach(); break;
                case 16: thongKeSoLuongSachTheoTheLoai(); break;
                case 17: thongKeSoLuongDocGia(); break;
                case 18: thongKeDocGiaTheoGioiTinh(); break;
                case 19: thongKeSachDangDuocMuon(); break;
                case 20: thongKeDocGiaTreHan(); break;
                case 0: System.out.println("Thoat chuong trinh..."); break;
                default: System.out.println("Lua chon khong hop le, vui long chon lai."); break;
            }
        } while (luaChon != 0);

        scanner.close();
    }

    /*
        Doc Gia
     */
    public static void themDocGia() {
        Scanner scanner = new Scanner(System.in);

        int maDocGia;

        while (true) {
            System.out.print("Nhap Ma Doc Gia: ");
            maDocGia = scanner.nextInt();
            scanner.nextLine();

            boolean isExist = false;
            for (DocGia docGia : danhSachDocGia) {
                if (docGia.getMaDocGia() == maDocGia) {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                System.out.println("Ma Doc Gia đã tồn tại, vui lòng nhập mã độc giả khác.");
            } else {
                break;
            }
        }

        System.out.print("Nhap Ten Doc Gia: ");
        String tenDocGia = scanner.nextLine();

        System.out.print("Nhap Email Doc Gia: ");
        String emailDocGia = scanner.nextLine();

        System.out.print("Nhap CMND: ");
        String CMND = scanner.nextLine();

        System.out.print("Nhap Gioi Tinh (0 - Nam, 1 - Nu): ");
        int gioiTinh = scanner.nextInt();

        // Tạo đối tượng DocGia mới
        DocGia docGia = new DocGia(maDocGia, tenDocGia, emailDocGia, CMND, gioiTinh);

        // Thêm DocGia vào danh sách
        danhSachDocGia.add(docGia);
        System.out.println("Doc Gia da duoc them thanh cong!");
    }

    public static void xemDanhSachDocGia() {
        if (danhSachDocGia.isEmpty()) {
            System.out.println("Chua co doc gia nao.");
        } else {
            System.out.printf("%-5s %-10s %-20s %-25s %-20s %-5s %10ss\n", "STT", "MaDG", "TenDG", "Email", "CMND" , "GioiTinh", "SLSachMuon");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");

            // In từng sách trong danh sách
            int index = 1;
            for (DocGia docGia : danhSachDocGia) {
                System.out.printf("%-5s %-10s %-20s %-25s %-20s %-5s %10s\n",
                        index++,
                        docGia.getMaDocGia(),
                        docGia.getTenDocGia(),
                        docGia.getEmailDocGia(),
                        docGia.getCMND(),
                        docGia.getGioiTinh(),
                        docGia.getSoLuongSachDangMuon()
                );
            }
        }
    }


    public static void suaThongTinDocGia() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap Ma Doc Gia can chinh sua: ");
        int ma = scanner.nextInt();
        scanner.nextLine();

        boolean timThay = false;
        for (DocGia docGia : danhSachDocGia) {
            if (docGia.getMaDocGia() == ma) {
                timThay = true;

                // Hiển thị thông tin hiện tại của độc giả
                System.out.println("Thong tin hien tai cua Doc Gia:");
                docGia.hienThi();

                // Nhập thông tin mới
                System.out.println("\nNhap thong tin moi:");

                System.out.print("Nhap Ten Doc Gia moi: ");
                String tenDocGiaMoi = scanner.nextLine();
                docGia.setTenDocGia(tenDocGiaMoi);

                System.out.print("Nhap Email Doc Gia moi: ");
                String emailDocGiaMoi = scanner.nextLine();
                docGia.setEmailDocGia(emailDocGiaMoi);

                System.out.print("Nhap CMND Doc Gia moi: ");
                String CMNDMoi = scanner.nextLine();
                docGia.setCMND(CMNDMoi);

                System.out.print("Nhap Gioi Tinh Doc Gia moi (0 - Nam, 1 - Nu): ");
                int gioiTinhMoi = scanner.nextInt();
                docGia.setGioiTinh(gioiTinhMoi);

                System.out.println("Thong tin Doc Gia da duoc cap nhat.");
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay Doc Gia voi Ma " + ma + ".");
        }
    }

    public static void xoaDocGia() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap Ma Doc Gia can xoa: ");
        int ma = scanner.nextInt();
        scanner.nextLine();

        boolean timThay = false;
        for (int i = 0; i < danhSachDocGia.size(); i++) {
            if (danhSachDocGia.get(i).getMaDocGia() == ma) {
                timThay = true;

                // Hiển thị thông tin độc giả trước khi xóa
                System.out.println("Xoa thong tin cua Doc Gia:");
                danhSachDocGia.get(i).hienThi();

                // Xóa độc giả khỏi danh sách
                danhSachDocGia.remove(i);
                System.out.println("Doc Gia da duoc xoa thanh cong.");
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay Doc Gia voi Ma " + ma + ".");
        }
    }

    public static void timKiemDocGiaTheoCMND() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap CMND cua Doc Gia can tim: ");
        String cmndTimKiem = scanner.nextLine();

        boolean timThay = false;
        for (DocGia docGia : danhSachDocGia) {
            if (docGia.getCMND().equals(cmndTimKiem)) {
                timThay = true;
                // Hiển thị thông tin độc giả tìm thấy
                System.out.println("Thong tin Doc Gia tim thay:");
                docGia.hienThi();
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay Doc Gia voi CMND \"" + cmndTimKiem + "\".");
        }
    }

    public static void timKiemDocGiaTheoHoTen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap Ho Ten Doc Gia Can Tim: ");
        String hoTenTimKiem = scanner.nextLine();

        boolean timThay = false;
        for (DocGia docGia : danhSachDocGia) {
            // So sánh tên độc giả với họ tên người dùng nhập vào
            if (docGia.getTenDocGia().equals(hoTenTimKiem)) {
                timThay = true;
                // Hiển thị thông tin độc giả tìm thấy
                System.out.println("Thong tin Doc Gia tim thay:");
                docGia.hienThi();
                break;  // Nếu tìm thấy, dừng vòng lặp
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay Doc Gia voi Ho Ten \"" + hoTenTimKiem + "\".");
        }
    }

    // Thêm một cuốn sách mới
    public static void themSach() {
        Scanner scanner = new Scanner(System.in);

        if (danhSachSach.size() < 100) {
            System.out.print("Nhap Ma ISBN: ");
            String ISBN = scanner.nextLine();

            System.out.print("Nhap Ten Sach: ");
            String tenSach = scanner.nextLine();

            System.out.print("Nhap Tac Gia: ");
            String tacGia = scanner.nextLine();

            System.out.print("Nhap The Loai: ");
            String theLoai = scanner.nextLine();

            System.out.print("Nhap nam san xuat (dd/MM/yyyy): ");
            String namSanXuat = scanner.nextLine();


            Sach sach = new Sach(ISBN, tenSach, tacGia, theLoai, parseDate(namSanXuat));
            danhSachSach.add(sach);

            System.out.println("Da them Sach thanh cong.");
        } else {
            System.out.println("Khong the them sach, da dat gioi han.");
        }
    }

    public static void xemDanhSachSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Chua co sach nao.");
        } else {
            System.out.printf("%-5s %-30s %-35s %-20s %-35s %-20s\n", "STT", "Ma ISBN", "Ten Sach", "Tac Gia", "The Loai", "Nam San Xuat");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");

            // In từng sách trong danh sách
            int index = 1;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Sach sach : danhSachSach) {
                System.out.printf("%-5s %-30s %-35s %-20s %-35s %-20s\n",
                        index++,
                        sach.getISBN(),
                        sach.getTenSach(),
                        sach.getTacGia(),
                        sach.getTheLoai(),
                        sdf.format(sach.getNamSanXuat())
                );
            }
        }
    }

    public static void suaThongTinSach() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap Ma ISBN can chinh sua: ");
        String ma = scanner.nextLine();

        boolean timThay = false;
        for (Sach sach : danhSachSach) {
            if (sach.getISBN().equals(ma)) {
                timThay = true;
                System.out.println(sach.toString());
                System.out.println("\nNhập thông tin mới:");

                System.out.print("Nhập tên sách mới: ");
                String tenSachMoi = scanner.nextLine();
                sach.setTenSach(tenSachMoi);

                System.out.print("Nhap tác giả mới: ");
                String tacGiaMoi = scanner.nextLine();
                sach.setTacGia(tacGiaMoi);

                System.out.print("Nhap thể loại mới: ");
                String theLoaiMoi = scanner.nextLine();
                sach.setTheLoai(theLoaiMoi);

                System.out.print("Nhập năm sản xuất mới(dd/MM/yyyy): ");
                String namSanXuat = scanner.nextLine();
                sach.setNamSanXuat(parseDate(namSanXuat));

                System.out.println("Thong tin sách đã được cập nhật.");
                break;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sách với mã ISBN " + ma + ".");
        }
    }

    public static void xoaSach() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã ISBN can xoa: ");
        String ma = scanner.nextLine();

        boolean timThay = false;
        Iterator<Sach> iterator = danhSachSach.iterator();

        while (iterator.hasNext()) {
            Sach sach = iterator.next();
            if (sach.getISBN().equals(ma)) {
                timThay = true;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println(sach.toString());

                iterator.remove();
                System.out.println("Sach da duoc xoa thanh cong.");
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay Sach voi Ma ISBN " + ma + ".");
        }
    }

    public static void timKiemSachTheoISBN() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma ISBN cua sach can tim: ");
        String ISBN_TimKiem = scanner.nextLine();

        boolean timThay = false;
        for (Sach sach : danhSachSach) {
            if (sach.getISBN().equals(ISBN_TimKiem)) {
                timThay = true;
                // Hiển thị thông tin sách tìm thấy
                System.out.println("Thong tin Sach tim thay:");
                System.out.println(sach.toString());
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay Sach voi ma ISBN \"" + ISBN_TimKiem + "\".");
        }
    }

    public static void timKiemSachTheoTen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ten sach can tim: ");
        String tenSachTimKiem = scanner.nextLine();

        boolean timThay = false;
        for (Sach sach : danhSachSach) {
            if (sach.getTenSach().contains(tenSachTimKiem)) {
                timThay = true;

                System.out.println("Thong tin Sach tim thay:");
                System.out.println(sach.toString());
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay Sach voi ten \"" + tenSachTimKiem + "\".");
        }
    }

    // Hàm thống kê số lượng sách trong thư viện
    public static void thongKeSoLuongSach() {
        System.out.println("Tong so luong sach trong thu vien: " + danhSachSach.size());
    }


    // Hàm thống kê số lượng độc giả hiện có
    public static void thongKeSoLuongDocGia() {
        System.out.println("So luong doc gia hien co: " + danhSachDocGia.size());
    }

    // Hàm thống kê số lượng sách đang được mượn
    public static void thongKeSachDangDuocMuon() {
        int soLuongMuon = 0;
        for (Sach sach  : danhSachSach) {
            if (sach.isAvailable() == false) {  // Giả sử phương thức `isTrangThai()` kiểm tra trạng thái mượn
                soLuongMuon++;
            }
        }
        System.out.println("So luong sach dang duoc muon: " + soLuongMuon);
    }


    // Hàm thống kê số lượng sách theo thể loại
    public static void thongKeSoLuongSachTheoTheLoai() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Chua co sach nao trong thu vien.");
            return;
        }

        // Lưu trữ thể loại và số lượng sách theo thể loại
        Map<String, Integer> thongKeTheLoai = new HashMap<>();

        // Duyệt qua danh sách sách và thống kê theo thể loại
        for (Sach sach : danhSachSach) {
            String theLoai = sach.getTheLoai();
            thongKeTheLoai.put(theLoai, thongKeTheLoai.getOrDefault(theLoai, 0) + 1);
        }

        System.out.println("Thong ke so luong sach theo the loai:");
        for (Map.Entry<String, Integer> entry : thongKeTheLoai.entrySet()) {
            System.out.println("The loai: " + entry.getKey() + ", So luong: " + entry.getValue());
        }
    }

    // Hàm thống kê độc giả theo giới tính
    public static void thongKeDocGiaTheoGioiTinh() {
        int soNam = 0, soNu = 0;

        for (DocGia docGia : danhSachDocGia) {
            if (docGia.getGioiTinh() == 0) {  // 0: Nam
                soNam++;
            } else if (docGia.getGioiTinh() == 1) {  // 1: Nữ
                soNu++;
            }
        }

        System.out.println("So luong Doc Gia Nam: " + soNam);
        System.out.println("So luong Doc Gia Nu: " + soNu);
    }

    // Hàm lập phiếu mượn
    public static void lapPhieuMuon() {
        if (danhSachPhieuMuon.size() >= MAX_PHIEU_MUON) {
            System.out.println("Khong the lap phieu muon moi, da dat gioi han phieu muon.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Ma Doc Gia muon sach: ");
        int docGiaID = scanner.nextInt();

        DocGia docGia = timDocGia(docGiaID);
        if (docGia == null) {
            System.out.println("Ma Doc Gia khong ton tai.");
            return;
        }

        if (docGia.getSoLuongSachDangMuon() >= MAX_SACH_MUON) {
            System.out.println("Doc Gia nay da muon toi da so luong sach cho phep.");
            return;
        }

        System.out.print("Nhap so luong sach muon (toi da " + MAX_SACH_MUON + "): ");
        int numBooks = scanner.nextInt();
        if (numBooks > MAX_SACH_MUON) {
            System.out.println("So luong sach muon vuot qua gioi han cho phep.");
            return;
        }

        ArrayList<Sach> sachMuon = new ArrayList<>();
        for (int i = 0; i < numBooks; i++) {
            System.out.print("Nhap Ma ISBN cua sach thu " + (i + 1) + ": ");
            String isbn = scanner.next();

            Sach sach = timSachTheoISBN(isbn);
            if (sach == null) {
                System.out.println("Ma ISBN khong ton tai hoac sach da duoc muon");
                return;
            }
            sach.setAvailable(false);
            sachMuon.add(sach);
        }

        System.out.print("Nhap Ngay Muon (dd/MM/yyyy): ");
        String ngayMuonStr = scanner.next();
        Date ngayMuon = parseDate(ngayMuonStr);

        PhieuMuon phieuMuon = new PhieuMuon(docGiaID, sachMuon, ngayMuon, null);
        danhSachPhieuMuon.add(phieuMuon);
        docGia.setSoLuongSachDangMuon(docGia.getSoLuongSachDangMuon() + numBooks);

        System.out.println("Phieu muon da duoc lap thanh cong.");
    }

    // Hàm lập phiếu trả
    public static void lapPhieuTra() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Ma Doc Gia tra sach: ");
        int docGiaID = scanner.nextInt();

        DocGia docGia = timDocGia(docGiaID);
        if (docGia == null) {
            System.out.println("Ma Doc Gia khong ton tai.");
            return;
        }

        PhieuMuon phieuMuon = null;
        for (PhieuMuon pm : danhSachPhieuMuon) {
            if (pm.getMaDocGia() == docGiaID) {
                phieuMuon = pm;
                break;
            }
        }

        if (phieuMuon == null) {
            System.out.println("Doc Gia nay chua muon sach nao.");
            return;
        }

        System.out.println("Danh sach sach da muon:");
        for (Sach sach : phieuMuon.getSachMuon()) {
            System.out.println("Ma ISBN: " + sach.getISBN() + ", Ten Sach: " + sach.getTenSach());
        }

        System.out.print("Nhap so luong sach tra: ");
        int numBooksToReturn = scanner.nextInt();

        if (numBooksToReturn > phieuMuon.getSachMuon().size()) {
            System.out.println("So luong sach tra vuot qua so sach da muon.");
            return;
        }

        for (int i = 0; i < numBooksToReturn; i++) {
            System.out.print("Nhap Ma ISBN cua sach tra thu " + (i + 1) + ": ");
            String isbnToReturn = scanner.next();

            Sach sachToReturn = null;
            for (Sach sach : phieuMuon.getSachMuon()) {
                if (sach.getISBN().equals(isbnToReturn)) {
                    sachToReturn = sach;
                    break;
                }
            }

            if (sachToReturn != null) {
                sachToReturn.setAvailable(true);
                phieuMuon.getSachMuon().remove(sachToReturn);
                docGia.setSoLuongSachDangMuon(docGia.getSoLuongSachDangMuon() - 1);
                System.out.println("Sach " + sachToReturn.getTenSach() + " da duoc tra.");
            } else {
                System.out.println("Ma ISBN khong ton tai trong danh sach muon.");
            }
        }

        // If all books are returned, remove the borrow receipt
        if (phieuMuon.getSachMuon().isEmpty()) {
            danhSachPhieuMuon.remove(phieuMuon);
            System.out.println("Phieu Tra da duoc cap nhat.");
        }

        System.out.println("Phieu tra sach hoan thanh.");
    }


    // Hàm kiểm tra sách quá hạn
    public static boolean kiemTraTreHan(Date ngayTraDuKien) {
        Date currentDate = new Date();
        return currentDate.after(ngayTraDuKien); // Kiểm tra nếu ngày hiện tại muộn hơn ngày trả
    }


    // Hàm thống kê độc giả quá hạn
    public static void thongKeDocGiaTreHan() {
        int soLuongTreHan = 0;
        System.out.println("Danh sach doc gia tre hen:");

        for (PhieuMuon phieuMuon : danhSachPhieuMuon) {
            if (kiemTraTreHan(phieuMuon.getNgayTra())) {
                soLuongTreHan++;
                DocGia docGia = timDocGia(phieuMuon.getMaDocGia());
                System.out.println("Ma Doc Gia: " + phieuMuon.getMaDocGia() + ", Ten Doc Gia: " + docGia.getTenDocGia());
            }
        }
    }


    // Tìm độc giả theo MaDocGia
    private static DocGia timDocGia(int maDocGia) {
        for (DocGia docGia : danhSachDocGia) {
            if (docGia.getMaDocGia() == maDocGia) {
                return docGia;
            }
        }
        return null;
    }

    // Tìm sách theo ISBN
    private static Sach timSachTheoISBN(String isbn) {
        for (Sach sach : danhSachSach) {
            if (sach.getISBN() .equals(isbn) && sach.isAvailable()) {
                return sach;
            }
        }
        return null;
    }

    // Chuyển đổi String sang Date
    private static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(dateStr);
        } catch (Exception e) {
            System.out.println("Loi dinh dang ngay.");
            return null;
        }
    }
}
