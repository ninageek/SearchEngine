

public class HtmlParser {
    private static final String BEGIN_SCRIPT = "<script>";
    private static final String END_SCRIPT = "</script>";

    String parseHtml(String html) {
        return removeScript(html).replaceAll("<.*?>", " ").replaceAll(" +", " ").trim();
    }

    String removeScript(String html) {
        StringBuilder ret = new StringBuilder();
        boolean writeFlag = true;
        for (int i = 0; i < html.length(); i++) {
            char current = html.charAt(i);
            if (current == '<') {
                if (isScriptBeginOrEnd(html, i, BEGIN_SCRIPT)) {
                    writeFlag = false;
                }
                if (isScriptBeginOrEnd(html, i, END_SCRIPT)) {
                    writeFlag = true;
                }
            }
            if (writeFlag) {
                ret.append(current);
            }
        }

//        CharacterIterator it = new StringCharacterIterator(html);
//        while (it.current() != CharacterIterator.DONE){
//            if(it.current() == '<'){
//                it.current()
//            }
//        }
        return ret.toString();
    }

    boolean isScriptBeginOrEnd(String html, int i, String beginOrEnd) {
        for (int j = 0; j < beginOrEnd.length(); j++) {


            if (html.charAt(i + j) != beginOrEnd.charAt(j)) {
                return false;
            }
        }
        return true;
    }


}
