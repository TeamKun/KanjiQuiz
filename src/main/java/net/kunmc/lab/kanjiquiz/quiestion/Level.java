package net.kunmc.lab.kanjiquiz.quiestion;

public enum Level {
    SEMI_FIRST("準１級", "kanji_01z.csv"),
    SECOND("２級", "kanji_02.csv"),
    SEMI_SECOND("準２級", "kanji_02z.csv"),
    THIRD("3級", "kanji_03.csv"),
    FORCE("4級", "kanji_04.csv"),
    FIFTH("5級", "kanji_05.csv");

    private String value;
    private String filePath;

    Level(String value, String filePath) {
        this.value = value;
        this.filePath = filePath;
    }

    public String value() {
        return value;
    }

    public String filePath() {
        return filePath;
    }
}
