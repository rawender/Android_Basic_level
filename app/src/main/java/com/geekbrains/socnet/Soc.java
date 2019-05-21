package com.geekbrains.socnet;

// данные для карточки
class Soc {
    private String description; // описание
    private int picture;        // изображение
    private boolean like;       // флажок

    Soc(String description, int picture, boolean like){
        this.description=description;
        this.picture=picture;
        this.like=like;
    }

    // геттеры
    String getDescription(){
        return description;
    }

    int getPicture(){
        return picture;
    }

    boolean getLike(){
        return like;
    }

    void setLike(boolean like) {
        this.like = like;
    }
}