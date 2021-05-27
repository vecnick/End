package com.example.end;

public class Present {
    private String name = "";
    private int pic;
    private String url ="";

    public Present(String name, int pic, String url) {
        setName(name);
        setUrl(url);
        setPic(pic);
    }

    public String getName() {
        return name;
    }

    public int getPic() {
        return pic;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
