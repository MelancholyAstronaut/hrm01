package po;

public class wife {
    private Integer wid;
    private String wname;

    @Override
    public String toString() {
        return "wife{" +
                "wid=" + wid +
                ", wname='" + wname + '\'' +
                '}';
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }
}
