package com.abc.pojo;

import java.util.List;

public class Newslabel {
    private Integer ID;
    private Integer pid;
    private String label_name;
    private String label_content;
    private Newslabel parent;
    private List<Newslabel> child;

    public List<Newslabel> getChild() {
        return child;
    }

    public void setChild(List<Newslabel> child) {
        this.child = child;
    }

    public Newslabel() {
    }

    public Newslabel(Integer pid,String label_name, String label_content, Newslabel parent, List<Newslabel> child) {
        this.pid = pid;
        this.label_name = label_name;
        this.label_content = label_content;
        this.parent = parent;
        this.child = child;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public String getLabel_content() {
        return label_content;
    }

    public void setLabel_content(String label_content) {
        this.label_content = label_content;
    }

    public Newslabel getParent() {
        return parent;
    }

    public void setParent(Newslabel parent) {
        this.parent = parent;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Newslabel{" +
                "ID=" + ID +
                ", pid=" + pid +
                ", label_name='" + label_name + '\'' +
                ", label_content='" + label_content + '\'' +
                ", parent=" + parent +
                ", child=" + child +
                '}';
    }
}
