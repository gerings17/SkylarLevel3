import java.util.List;

/**
 * Created by skylargering on 5/23/15.
 */
public class Algorithms {
    public static int findBrokenEgg(List<String> eggs) {
        int index = 0;
        for (int x = 0; x < eggs.size(); x++) {
            if (eggs.get(x).equals("cracked")) {
                index = x;
                break;
            }
        }
        return index;
    }

    public static int countPearls(List<Boolean> oysters) {
        int pearls = 0;
        for (int x = 0; x < oysters.size(); x++) {
            if (oysters.get(x) == true) {
                pearls++;
            }
        }
        return pearls;
    }

    public static double findTallest(List<Double> peeps) {
        double height = 0;
        for (int x = 0; x < peeps.size(); x++) {
            if (peeps.get(x) > height) {
                height = peeps.get(x);
            }
        }
        return height;
    }

    public static String findLongestWord(List<String> words) {
        String longestWord = words.get(0);
        for (int x = 0; x < words.size(); x++) {
            if (words.get(x).length() > longestWord.length()){
                longestWord = words.get(x);
            }
        }
        return longestWord;
    }

    public static boolean containsSOS(List<String> message) {
        return false;
    }
}

