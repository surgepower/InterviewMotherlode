import java.util.*;

public class WhitePages {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("app");
        dict.add("apple");
        dict.add("pie");
        dict.add("pi");
        dict.add("be");
        dict.add("bar");
        dict.add("bear");
        dict.add("rapple"); 
        dict.add("rap"); 
        
        System.out.println(split("applepie", dict));
        System.out.println(split("applepiebear", dict));
        
        System.out.println(splitMultiple("applepiebear", dict));
        System.out.println(splitMultiple("piebearapple", dict));
        System.out.println(splitMultiple("apple", dict));
        System.out.println(splitMultiple("pipipi", dict));
        System.out.println(splitMultiple("appappleapp", dict));
        System.out.println(splitMultiple("", dict));
        System.out.println(splitMultiple("a", dict));
        System.out.println(splitMultiple("piebearappl", dict));
    }
    
    public static List<String> split(String s, Set<String> dict) {
        List<String> result = null;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            String word1 = s.substring(0, i);
            String word2 = s.substring(i, size);
            if (dict.contains(word1) && dict.contains(word2)) {
                result = new ArrayList<String>();
                result.add(word1);
                result.add(word2);
                break;
            }
        }
        return result;
    }
    
    public static List<String> splitMultiple(String s, Set<String> dict) {
        List<String> result = null;
        
        if (s.isEmpty()) {
            return result;
        }
        
        int size = s.length();
        int[] splits = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            splits[i] = -1;
        }
        
        List<Integer> cuts = new ArrayList<Integer>();
        cuts.add(0);
        for (int i = 1; i <= size; i++) {
            for (int j = cuts.size() - 1; j >= 0; j--) {
                int cut = cuts.get(j);
                if (dict.contains(s.substring(cut, i))) {
                    cuts.add(i);
                    splits[i] = cut;
                    break;
                }
            }
        }
        
        if (splits[size] >= 0) {
            result = new ArrayList<String>();
            
            int start = splits[size];
            int end = size;
            
            while (end != 0) {
                result.add(s.substring(start, end));
                end = start;
                start = splits[start];
            }
        }
        return result;
    }
}
