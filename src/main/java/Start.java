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

        HashSet<String> result = new HashSet<>();
        for (Future<Set<String>> task : tasks) {
            result.addAll(task.get());
        }

        System.out.println("共" + result.size() + "条数据");

        File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
        File output = new File(desktop, "wow_dict.txt");
        if (output.exists()){
            output.delete();
        }

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(output));

        HashMap<String, Integer> priority = new HashMap<>();
        for (String text : result) {
            String pinyin = PinyinUtil.toPinyin(text).toLowerCase();
            Integer p = priority.get(pinyin);
            if (p == null){
                p = DEFAULT_PRIORITY;
            }else {
                p = p + 1;
            }
            priority.put(text, p);
            String s = text + " " + DEFAULT_PRIORITY;
            writer.write(pinyin + " " + s);
            writer.write("\r\n");
        }

        writer.close();
        System.out.println("输出完成");

        System.exit(1);
    }
}
