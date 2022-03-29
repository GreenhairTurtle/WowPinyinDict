import com.github.promeg.pinyinhelper.Pinyin;

public class PinyinUtil {
    public static boolean hasChineseChar(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }
        for (char c : text.toCharArray()) {
            if (Pinyin.isChinese(c)) {
                return true;
            }
        }

        return false;
    }

    public static String toPinyin(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Pinyin.isChinese(c)) {
                result.append(Pinyin.toPinyin(c));
            }
        }
        return result.toString();
    }

    public static String toPinyinWithFirstLetter(String text){
        if (text == null || text.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Pinyin.isChinese(c)) {
                result.append(Pinyin.toPinyin(c).charAt(0));
            }
        }
        return result.toString();
    }
}
