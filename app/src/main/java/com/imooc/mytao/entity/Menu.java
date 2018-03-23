package com.imooc.mytao.entity;

public class Menu {
    public int icon;
    public String name;

    public Menu(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }
}
