import com.github.promeg.pinyinhelper.Pinyin;

public class PinyinUtil {
    public static boolean isChinese(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }

        int count = 0;
        for (char c : text.toCharArray()) {
            if (Pinyin.isChinese(c)) {
                count++;
            }
        }

        return count >= 2;
    }

    public static boolean isAllChinese(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }

        for (char c : text.toCharArray()) {
            if (!Pinyin.isChinese(c)) {
                return false;
            }
        }

        return true;
    }

    public static String toPinyin(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Pinyin.isChinese(c)) {
                result.append(Pinyin.toPinyin(c)).append(",");
            }
        }
        return result.toString();
    }

    public static String toPinyinWithFirstLetter(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Pinyin.isChinese(c)) {
                result.append(Pinyin.toPinyin(c).charAt(0)).append(",");
            }
        }
        return result.toString();
    }
}
