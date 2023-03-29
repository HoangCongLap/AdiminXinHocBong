package xinhocbong.users;

public class UsersStatistical {
    float overallScore;
    String mssv, name, gender, brithDate, familySituation;


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

        public UsersStatistical(String mssv, String name, String gender, String brithDate, float overallScore, String familySituation) {
        this.overallScore = overallScore;
        this.mssv = mssv;
        this.name = name;
        this.gender = gender;
        this.brithDate = brithDate;
        this.familySituation = familySituation;
    }

}
