package com.alextsokov.kotolist.models;

public enum CatBreed {
    SCOTLAND("Шотландская вислоухая"),
    MAINCUN("Мейн-кун"),
    BRITAIN("Британская короткошерстная"),
    BENGAL("Бенгальская"),
    SFINKS("Канадский сфинкс"),
    ORIENTAL("Ориентальная короткошерстная"),
    SIAM("Сиамская"),
    SIBERIAN("Сибирская"),
    BURMAN("Бурманская"),
    ABISSIN("Абиссинская"),
    SOMALI("Сомалийская");

    private final String title;

    CatBreed(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
