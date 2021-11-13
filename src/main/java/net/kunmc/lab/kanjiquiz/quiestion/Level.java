package net.kunmc.lab.kanjiquiz.quiestion;

public enum Level {
    SEMI_FIRST("準１級", "level1semi", "kanji_01z.csv"),
    SECOND("２級", "level2", "kanji_02.csv"),
    SEMI_SECOND("準２級", "level2semi","kanji_02z.csv"),
    THIRD("3級", "level3","kanji_03.csv"),
    FORCE("4級", "level4","kanji_04.csv"),
    FIFTH("5級", "level5","kanji_05.csv");

    private String value;
    private String level;
    private String filePath;

    Level(String value, String level, String filePath) {
        this.value = value;
        this.level = level;
        this.filePath = filePath;
    }

    public String value() {
        return value;
    }

    public String level() {
        return this.level;
    }

    public String filePath() {
        return "kanji/" + filePath;
    }
}
