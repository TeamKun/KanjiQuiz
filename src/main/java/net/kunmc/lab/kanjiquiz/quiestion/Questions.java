package net.kunmc.lab.kanjiquiz.quiestion;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    private static List<KanjiList> list = new ArrayList<>();

    /**
     * 初期化処理
     * */
    public static void init() {
        for (Level value : Level.values()) {
            list.add(readCsv(value));
        }
    }

    /**
     * 指定されたレベルのcsvを読み込み
     */
    private static KanjiList readCsv(Level level) {

        return new KanjiList(level, CsvReader.readCsv(level.filePath()));
    }

    /**
     * 選択したレベルの漢字リストを取得
     * */
    public static KanjiList selectLevel(Level level) {
        for (KanjiList kanjiList : list) {
            if (kanjiList.isLevelMatch(level)) {
                return kanjiList;
            }
        }

        return null;
    }
}
