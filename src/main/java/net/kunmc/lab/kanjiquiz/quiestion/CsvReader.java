package net.kunmc.lab.kanjiquiz.quiestion;

import net.kunmc.lab.kanjiquiz.KanjiQuiz;
import net.kunmc.lab.kanjiquiz.util.MessageUtil;
import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    /**
     * 漢字csvを読み込み
     */
    static List<String[]> readCsv(String filePath) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(KanjiQuiz.plugin.getResource(filePath), StandardCharsets.UTF_8));

            List<String[]> csvInput = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                csvInput.add(data);
            }

            return csvInput;

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
