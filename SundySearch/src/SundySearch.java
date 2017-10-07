import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SundySearch {
    String text = null;
    String pattern = null;
    int currentPos = 0;
    /**
     * ƥ�����Ӵ���һ���ַ�λ���б�
     */
    List<Integer> matchedPosList = new LinkedList<Integer>();

    /**
     * ƥ���ַ���Map,��¼��ƥ���ַ�������Щchar����ÿ��char�����ֵ�λ��
     */
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    public SundySearch(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.initMap();
    };
    /**
     * Sundayƥ��ʱ�������洢Pattern��ÿ���ַ����һ�γ��ֵ�λ�ã������ҵ�˳��
     */
    private void initMap() {
        for (int i = 0; i < pattern.length(); i++) {
            this.map.put(pattern.charAt(i), i);
        }
    }
    /**
     * ��ͨ���ַ����ݹ�ƥ�䣬ƥ��ʧ�ܾ�ǰ��һλ
     */
    public List<Integer> normalMatch() {
        //ƥ��ʧ�ܣ�����������
        if (!matchFromSpecialPos(currentPos)) {
            currentPos += 1;
            if ((text.length() - currentPos) < pattern.length()) {
                return matchedPosList;
            }
            normalMatch();
        } else {
            //ƥ��ɹ�����¼λ��
            matchedPosList.add(currentPos);
            currentPos += 1;
            normalMatch();
        }

        return matchedPosList;
    }
    /**
     * Sundayƥ�䣬�ٶ�Text�е�K�ַ���λ��Ϊ����ǰƫ����+Pattern�ַ�������+1
     */
    public List<Integer> sundayMatch() {
        // ���û��ƥ��ɹ�
        if (!matchFromSpecialPos(currentPos)) {
            // ���Text��K�ַ�û����Pattern�ַ����г��֣�����������Pattern�ַ�������
            if ((currentPos + pattern.length() + 1) < text.length()
                    && !map.containsKey(text.charAt(currentPos + pattern.length() + 1))) {
                currentPos += pattern.length();
            }else {
                // ���Text��K�ַ���Pattern�ַ����г��֣���Text��K�ַ���λ�ú�Pattern�ַ����е����һ�γ���K�ַ���λ�ö���
                if ((currentPos + pattern.length() + 1) > text.length()) {
                    currentPos += 1;
                } else {
                    currentPos += pattern.length() - (Integer) map.get(text.charAt(currentPos + pattern.length()));
                }
            }

            // ƥ����ɣ�����ȫ��ƥ��ɹ��ĳ�ʼλ��
            if ((text.length() - currentPos) < pattern.length()) {
                return matchedPosList;
            }

            sundayMatch();
        }else {
            // ƥ��ɹ�ǰ��һλȻ���ٴ�ƥ��
            matchedPosList.add(currentPos);
            currentPos += 1;
            sundayMatch();
        }
        return matchedPosList;
    }
    /**
     * ����Text��ָ��ƫ������ʼ���Ӵ��Ƿ��Patternƥ��
     */
    public boolean matchFromSpecialPos(int pos) {
        if ((text.length()-pos) < pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(pos + i) == pattern.charAt(i)) {
                if (i == (pattern.length()-1)) {
                    return true;
                }
                continue;
            } else {
                break;
            }
        }

        return false;
    }
  
}