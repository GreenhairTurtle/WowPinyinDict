import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Start {

    public static final int DEFAULT_PRIORITY = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<Set<String>>> tasks = new ArrayList<>();
        for (Data data : Data.values()) {
            tasks.add(executor.submit(new CSVProcessor(data)));
        }
//        tasks.add(executor.submit(new CSVProcessor(Data.SPELLNAME)));

        HashSet<String> result = new HashSet<>();
        for (Future<Set<String>> task : tasks) {
            result.addAll(task.get());
        }

        checkText(result);

        System.out.println("共" + result.size() + "条数据");

        writeWithPinyin(result);
        write(result);
        writeAll(result);
        System.out.println("输出完成");

        System.exit(1);
    }

    private static void writeWithPinyin(HashSet<String> result) throws IOException {
        File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
        HashMap<String, Integer> priority = new HashMap<>();

        File output = new File(desktop, "wow_dict_pinyin.txt");
        if (output.exists()) {
            output.delete();
        }

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output));
        for (String text : result) {
            if (PinyinUtil.isAllChinese(text)) {
                continue;
            }
            String pinyin;
            if (text.length() > 3) {
                pinyin = PinyinUtil.toPinyinWithFirstLetter(text).toLowerCase();
            } else {
                pinyin = PinyinUtil.toPinyin(text).toLowerCase();
            }
            Integer p = priority.get(pinyin);
            if (p == null) {
                p = DEFAULT_PRIORITY;
            } else {
                p = p + 1;
            }
            priority.put(text, p);
            String s = text + " " + DEFAULT_PRIORITY;
            writer.write(pinyin + " " + s);
            writer.write("\r\n");
        }

        writer.close();
    }

    private static void write(HashSet<String> result) throws IOException {
        File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
        File output = null;

        OutputStreamWriter writer = null;

        int index = 1;
        int count = 0;
        for (String text : result) {
            if (output == null) {
                output = new File(desktop, "wow_dict" + index + ".txt");
                if (output.exists()) {
                    output.delete();
                }
                writer = new OutputStreamWriter(new FileOutputStream(output));
            }
            if (PinyinUtil.isAllChinese(text)) {
                writer.write(text);
                writer.write("\r\n");
                count++;
            }
            if (count > 10000) {
                writer.close();
                output = null;
                count = 0;
                index++;
            }
        }

        if (writer != null) {
            writer.close();
        }
    }

    private static void writeAll(HashSet<String> result) throws IOException {
        File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
        File output = new File(desktop, "wow_dict_all.txt");
        ;
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output));

        for (String text : result) {
            if (PinyinUtil.isAllChinese(text)) {
                writer.write(text);
                writer.write("\r\n");
            }
        }

        writer.close();
    }

    public static void checkText(HashSet<String> text) {
        for (String s : text) {
            if (s.matches(".*[0-9].*")) {
                System.out.println(s);
            }
        }
    }
}
