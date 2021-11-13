package net.kunmc.lab.kanjiquiz.quiestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KanjiList {
    private Level level;
    private List<Kanji> kanjiList = new ArrayList<>();
    private List<Kanji> finishedList = new ArrayList<>();

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

    /**
     * 漢字を取得
     * */
    public Kanji getQuestion() {
        if (this.kanjiList.size() == 0) {
            Collections.shuffle(this.finishedList);
            this.kanjiList = this.finishedList;
            this.finishedList = new ArrayList<>();
        }

        Kanji question = this.kanjiList.remove(0);
        finishedList.add(question);
        return question;
    }
}
