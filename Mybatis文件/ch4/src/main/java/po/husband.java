package po;

public class husband {
    private Integer hid;
    private String hname;
    private wife wife;

    public po.wife getWife() {
        return wife;
    }

    public void setWife(po.wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "husband{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", wife=" + wife +
                '}';
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }
}
