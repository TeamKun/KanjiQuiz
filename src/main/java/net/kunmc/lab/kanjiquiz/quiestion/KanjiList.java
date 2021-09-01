package net.kunmc.lab.kanjiquiz.quiestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KanjiList {
    private Level level;
    private List<Kanji> kanjiList = new ArrayList<>();

    KanjiList(Level level, List<String[]> input) {
        // レベルをセット
        this.level = level;
        // csvインプットを取り込み
        input.forEach(row -> {
            String kanji = row[0];
            String reading = row[1];

            this.kanjiList.add(new Kanji(kanji, reading));
        });

        // リストをシャッフル
        Collections.shuffle(this.kanjiList);
    }

    /**
     * 指定されたレベルと一致しているか判定
     * */
    boolean isLevelMatch(Level level) {
        return level.equals(level);
    }
}
