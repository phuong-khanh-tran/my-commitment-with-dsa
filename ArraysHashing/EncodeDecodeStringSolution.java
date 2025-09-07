import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStringSolution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return Character.toString((char) 258);
        }

        StringBuilder stringCode = new StringBuilder();
        String sep = Character.toString((char) 257);

        for (String s : strs) {
            stringCode.append(s);
            stringCode.append(sep);
        }

        stringCode.deleteCharAt(stringCode.length() - 1);

        return stringCode.toString();
    }

    public List<String> decode(String encodedString) {
        if (encodedString.equals(Character.toString((char) 258))) {
            return new ArrayList();
        }

        String sep = Character.toString((char) 257);
        return Arrays.asList(encodedString.split(sep, -1));
    }
}
