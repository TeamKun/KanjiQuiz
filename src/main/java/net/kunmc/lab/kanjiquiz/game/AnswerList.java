package net.kunmc.lab.kanjiquiz.game;

import net.kunmc.lab.kanjiquiz.quiestion.Kanji;

import java.util.ArrayList;
import java.util.List;

public class AnswerList {
    private List<Answer> list = new ArrayList<>();

     void add(Answer answer) {
         for (int i = 0; i < this.list.size(); i++) {
             if (list.get(i).uuid().equals(answer.uuid())) {
                 list.remove(i);
                 return;
             }
         }

         this.list.add(answer);
    }

    void judge(Kanji kanji) {
        for (Answer answer : this.list) {
            answer.judge(kanji);
        }
    }
}
