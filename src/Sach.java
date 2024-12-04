import java.text.SimpleDateFormat;
import java.util.Date;

public class Sach {
    private String ISBN;
    private String tenSach;
    private String tacGia;
    private String theLoai;
    private Date namSanXuat;
    private boolean isAvailable;

    public Sach(String ISBN, String tenSach, String tacGia, String theLoai, Date namSanXuat) {
        this.ISBN = ISBN;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.namSanXuat = namSanXuat;
        this.isAvailable = true;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public Date getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(Date namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Ma ISBN: " + ISBN + ", Ten Sach: " + tenSach + ", Tac Gia: " + tacGia +
                ", The Loai: " + theLoai + ", Nam San Xuat: " + sdf.format(namSanXuat) + ", Trang Thai: " + (isAvailable? "Co San": "Dang Duoc Muon");
    }
}
