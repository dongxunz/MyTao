package com.imooc.mytao.objects;

public class FindListItem {
    private String title_name;
    private int image;
    private String context;
    private int look_people;
    private int good_people;

    public FindListItem(String title_name, int image, String context, int look_people, int good_people) {
        this.title_name = title_name;
        this.image = image;
        this.context = context;
        this.look_people = look_people;
        this.good_people = good_people;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setLook_people(int look_people) {
        this.look_people = look_people;
    }

    public void setGood_people(int good_people) {
        this.good_people = good_people;
    }

    public String getTitle_name() {
        return title_name;
    }

    public int getImage() {
        return image;
    }

    public String getContext() {
        return context;
    }

    public int getLook_people() {
        return look_people;
    }

    public int getGood_people() {
        return good_people;
    }
}
