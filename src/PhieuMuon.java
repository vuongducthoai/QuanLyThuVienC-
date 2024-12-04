import java.util.ArrayList;
import java.util.Date;

public class PhieuMuon {
    private int maDocGia;
    private ArrayList<Sach> sachMuon;
    private boolean trangThaiPhieu; // True - đã mượn, False - đã trả
    private Date ngayMuon;
    private Date ngayTra;

    public PhieuMuon(int maDocGia,ArrayList<Sach>  sachMuon, int soLuongSachMuon, boolean trangThaiPhieu, Date ngayMuon, Date ngayTra) {
        this.maDocGia = maDocGia;
        this.sachMuon = sachMuon;
        this.trangThaiPhieu = trangThaiPhieu;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    // Muong Sach
    public PhieuMuon(int maDocGia,ArrayList<Sach>  sachMuon, Date ngayMuon, Date ngayTra) {
        this.maDocGia = maDocGia;
        this.sachMuon = sachMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public boolean isTrangThai() {
        return trangThaiPhieu;  // Trả về true nếu sách đang mượn, false nếu đã trả
    }


    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public ArrayList<Sach> getSachMuon() {
        return sachMuon;
    }

    public void setSachMuon(ArrayList<Sach> sachMuon) {
        this.sachMuon = sachMuon;
    }

    public boolean isTrangThaiPhieu() {
        return trangThaiPhieu;
    }

    public void setTrangThaiPhieu(boolean trangThaiPhieu) {
        this.trangThaiPhieu = trangThaiPhieu;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
}
