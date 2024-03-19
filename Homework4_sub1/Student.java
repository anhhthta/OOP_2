package Homework4_sub1;

public class Student {
    private String id;
    private String name;
    private String gender;
    private String mP;
    private String mJ;

    private Double avg;

    private Boolean rsl;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getmP() {
        return mP;
    }

    public void setmP(String mP) {
        this.mP = mP;
    }

    public String getmJ() {
        return mJ;
    }

    public void setmJ(String mJ) {
        this.mJ = mJ;
    }

    public void setAll(String id, String name, String gender, String mp, String mj){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.mP = mp;
        this.mJ = mj;
    }

    public Double getAvg() {
        return (Double.parseDouble(mJ)*2 + Double.parseDouble(mP))/3;
    }


    public String getRsl() {
        rsl = getAvg() >= 5 || (getAvg() < 5 && (!getGender().equals("Nam") && !getGender().equals("nam")));
        return rsl ? "dau" : "truot";
    }

    @Override
    public String toString() {
        return "Student: " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", mP= " + mP  +
                " , mJ= " + mJ;
    }
}
