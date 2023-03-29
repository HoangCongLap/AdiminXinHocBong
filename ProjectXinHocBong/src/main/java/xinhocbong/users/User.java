package xinhocbong.users;

public class User {
    float overallScore;
    private String mssv, name, gender, brithDate, familySituation, idHocBong, ngayNhan, soTien, tenToChuc;

    public void setOverallScore(float overallScore) {
        this.overallScore = overallScore;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBrithDate(String brithDate) {
        this.brithDate = brithDate;
    }

    public void setFamilySituation(String familySituation) {
        this.familySituation = familySituation;
    }

    public float getOverallScore() {
        return overallScore;
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBrithDate() {
        return brithDate;
    }

    public String getFamilySituation() {
        return familySituation;
    }

    public void setIdHocBong(String idHocBong) {
        this.idHocBong = idHocBong;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    public void setTenToChuc(String tenToChuc) {
        this.tenToChuc = tenToChuc;
    }

    public String getIdHocBong() {
        return idHocBong;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public String getSoTien() {
        return soTien;
    }

    public String getTenToChuc() {
        return tenToChuc;
    }
    //========================================================================

    public User(String mssv, String name, String gender, String brithDate, float overallScore, String familySituation, String idHocBong, String ngayNhan, String soTien, String tenToChuc) {
        this.overallScore = overallScore;
        this.mssv = mssv;
        this.name = name;
        this.gender = gender;
        this.brithDate = brithDate;
        this.familySituation = familySituation;
        this.idHocBong = idHocBong;
        this.ngayNhan = ngayNhan;
        this.soTien = soTien;
        this.tenToChuc = tenToChuc;
    }

    @Override
    public String toString() {
        return "User{" +
                "overallScore=" + overallScore +
                ", mssv='" + mssv + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", brithDate='" + brithDate + '\'' +
                ", familySituation='" + familySituation + '\'' +
                ", idHocBong='" + idHocBong + '\'' +
                ", ngayNhan='" + ngayNhan + '\'' +
                ", soTien='" + soTien + '\'' +
                ", tenToChuc='" + tenToChuc + '\'' +
                '}';
    }
}
