import java.util.HashSet;
import java.util.Set;

/**
 * @author 此间凉汐
 * @date 2022/4/18 8:35
 */
public class WordDictionary {
    private Set<String> set;

    public WordDictionary() {
        this.set = new HashSet<>();
    }

    public void addWord(String word) {
        set.add(word);
    }

    public boolean search(String word) {

    }
}
