package net.kunmc.lab.kanjiquiz.quiestion;

public class Kanji {
    /** 漢字 */
    private String kanji;
    /** 読み */
    private String reading;

    public Kanji(String kanji, String reading) {
        this.kanji = kanji;
        this.reading = reading;
    }

    /**
     * 漢字を取得
     * */
    public String getKanji() {
        return kanji;
    }

    /**
     * 読みを取得
     * */
    public String getReading() {
        return reading;
    }

    /**
     * 読みが一致しているか判定
     * */
    public boolean isCorrect(String answer) {
        return this.reading.equals(answer);
    }
}
