package RandomPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class HTMLTagChallenge {

    String encodedElement(String s) {

        List<String> tags = new ArrayList<>();
        Stack<String> opens = new Stack<>();

        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == '<') {
                int j = s.indexOf('>', i);

                if (j != -1) {
                    tags.add(s.substring(i, j + 1));
                    i = j + 1;

                } else {
                    break;
                }

            } else {
                i++;
            }
        }

        String wrongEl = "";

        for (String tag : tags) {
            if (!tag.contains("/")) {
                opens.push(tag);
            } else {
                if (opens.isEmpty()) {
                    wrongEl = tag.replaceAll("[</>]", "");
                    break;
                }

                String closingTagName = tag.replaceAll("[</>]", "");
                String openingTagName = opens.pop().replaceAll("[</>]", "");
                if (!closingTagName.equals(openingTagName)) {
                    wrongEl = closingTagName;
                    break;
                }

            }
        }

        String token = "a123jd934";
        String result = wrongEl + token;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < result.length(); i++) {
            res.append((i + 1) % 4 == 0 ? "_" : result.charAt(i));
        }

        return res.toString();
    }
}
