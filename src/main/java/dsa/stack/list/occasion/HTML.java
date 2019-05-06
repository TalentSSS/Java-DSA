package dsa.stack.list.occasion;

import dsa.stack.Stack;
import dsa.stack.list.StackList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author talent
 */
public class HTML {

    public static class Tag {
        /**
         * 标签名
         */
        String name;
        boolean opening;

        public Tag() {
            name = "";
            opening = false;
        }

        public Tag(String nm, boolean type) {
            name = nm;
            opening = type;
        }

        public boolean isOpening() {
            return opening;
        }

        public String getName() {
            return name;
        }
    }// class TAG

    private void indent(int level) {
        for (int k = 0; k < level; k++) {
            System.out.print("\t│");
        }
    }

    public boolean isHTMLMatched(Tag[] tag) {
        int level = 0;
        Stack S = new StackList();
        for (int i = 0; (i < tag.length) && (tag[i] != null); i++) {
            if(tag[i].isOpening()) {
                S.push(tag[i].getName());
                // 增加缩进级别
                indent(level++);
                System.out.println("\t┌" + tag[i].getName());
            } else {
                if (S.isEmpty()) {
                    return false;
                }
                if (!S.pop().equals(tag[i].getName())) {
                    return false;
                }
                // 减去缩进级别
                indent(--level);
                System.out.println("\t└" + tag[i].getName());
            }// else
        }// for
        if (S.isEmpty()) {
            // 若最后栈为空说明标签匹配
            return true;
        }
        else {
            // 否则不匹配
            return false;
        }
    }// isHTMLMatched

    public final static int CAPACITY = 1000;

    public Tag[] parseHTML(BufferedReader r) throws IOException {
        String line;
        boolean inTag = false;
        Tag[] tag = new Tag[CAPACITY];
        int count = 0;
        while ((line = r.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, "<> \t", true);
            while (st.hasMoreElements()) {
                String token = st.nextToken();
                // 根据在html的不同位置做处理
                if (token.equals("<")) {
                    inTag = true;
                } else if (token.equals(">")) {
                    inTag = false;
                } else if (inTag){
                    if ((token.length() == 0) || (token.charAt(0)) != '/') {
                        tag[count++] = new Tag(token, true);
                    } else {
                        tag[count++] = new Tag(token.substring(1), false);
                    }
                }
            }// while
        }// while
        return tag;
    }// parseHTML

    public static void main(String[] args) throws IOException {
        BufferedReader stdr = new BufferedReader(new InputStreamReader(System.in));
        HTML tagChecker = new HTML();
        if (tagChecker.isHTMLMatched(tagChecker.parseHTML(stdr))) {
            System.out.println("该文件符合HTML的标志匹配");
        } else {
            System.out.println("该文件不符合HTML的标志匹配");
        }
    }
}
