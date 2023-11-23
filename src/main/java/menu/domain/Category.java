package menu.domain;

public enum Category {
    Japanese("일식"), Korean("한식"), Chinese("중식"), Asian("아시안"), Western("양식");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
