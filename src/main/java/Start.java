import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Start {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<Set<String>>> tasks = new ArrayList<>();
        for (Data data : Data.values()) {
            tasks.add(executor.submit(new CSVProcessor(data)));
        }

        HashSet<String> result = new HashSet<>();
        for (Future<Set<String>> task : tasks) {
            result.addAll(task.get());
        }

        for (String s : result) {
            System.out.println(s + " " + PinyinUtil.toPinyinWithFirstLetter(s));
        }
    }
}
