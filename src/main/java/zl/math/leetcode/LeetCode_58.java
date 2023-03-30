package zl.math.leetcode;

import java.util.Objects;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Description:
 * Length of Last Word
 * <p>
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal
 * substring
 * consisting of non-space characters only.
 *
 * @version 1.0 2023/3/29 23:19 by zl 创建
 **/
public class LeetCode_58 {
    public static void main(String[] args) {
        LeetCode_58 code58 = new LeetCode_58();
        int length = code58.lengthOfLastWord("12  moon");
        assertThat(length, equalTo(4));
    }

    /**
     * @param s 字符串
     * @return
     * @create 2023/3/29 23:40 张亮
     */
    public int lengthOfLastWord(String s) {
        if (Objects.isNull(s) || s.length() <= 0) {
            return 0;
        }
        boolean gotWorld = false;
        boolean spaceMeet = false;
        int lastWordLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char iChar = s.charAt(i);
            //第一种情况 空格 + world + 空格
            if (spaceMeet && gotWorld && iChar == ' ') {
                return lastWordLength;
            }
            //第二种情况 空格 + world
            if (spaceMeet && gotWorld && iChar != ' ') {
                return lastWordLength;
            }
            if (iChar == ' ') {
                spaceMeet = true;
            }
            if (iChar != ' ') {
                spaceMeet = false;
                gotWorld = true;
                lastWordLength++;
            }

        }
        return lastWordLength;
    }

}
