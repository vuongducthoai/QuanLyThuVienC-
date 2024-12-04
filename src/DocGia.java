public class DocGia {
    private int maDocGia;
    private String tenDocGia;
    private String emailDocGia;
    private String CMND;
    private int gioiTinh;
    private int soLuongSachDangMuon;

    public DocGia(int maDocGia, String tenDocGia, String emailDocGia, String CMND, int gioiTinh) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.emailDocGia = emailDocGia;
        this.CMND = CMND;
        this.gioiTinh = gioiTinh;
    }

    public void hienThi() {
        System.out.println("Ma Doc Gia: " + maDocGia + ", Ten: " + tenDocGia + ", Email: " + emailDocGia +
                ", CMND: " + CMND + ", GioiTinh: " + (gioiTinh == 0 ? "Nam" : "Nu"));
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getEmailDocGia() {
        return emailDocGia;
    }

    public void setEmailDocGia(String emailDocGia) {
        this.emailDocGia = emailDocGia;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoLuongSachDangMuon() {
        return soLuongSachDangMuon;
    }

    public void setSoLuongSachDangMuon(int soLuongSachDangMuon) {
        this.soLuongSachDangMuon = soLuongSachDangMuon;
    }
}
