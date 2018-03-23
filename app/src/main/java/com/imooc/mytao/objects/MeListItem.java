package com.imooc.mytao.objects;

public class MeListItem {
    private String name;
    private int imageId;

    public MeListItem(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
