import com.github.promeg.pinyinhelper.Pinyin;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.Callable;

public class CSVProcessor implements Callable<Set<String>> {

    public static final String DIRECTORY = "wow_csv";

    private Data data;

    public CSVProcessor(Data data) {
        this.data = data;
    }

    @Override
    public Set<String> call() throws Exception {
        File file = new File(DIRECTORY, data.path);
        if (!file.exists()) {
            return Collections.emptySet();
        }

        HashSet<String> csvData = new HashSet<>();
        try {
            for (final CsvRow csvRow : CsvReader.builder().build(Path.of(file.getAbsolutePath()))) {
                if (csvRow.getOriginalLineNumber() != 1) {
                    String csvColumnData = csvRow.getField(data.columnIndex);
                    if (csvColumnData != null && csvColumnData.length() > 0 && PinyinUtil.hasChineseChar(csvColumnData)) {
                        csvData.add(csvColumnData);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvData;
    }
}
