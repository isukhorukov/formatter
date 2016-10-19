package formatter;

import java.io.*;

public class Formatter {
    
    static final int SPACE         = 32;   // space
    static final int TRANSFER      = 10;   // enter
    static final int OPEN_BRACKET  = 123;  // {
    static final int CLOSE_BRACKET = 125;  // }
    static final int SEMICOLON     = 59;   // ;
    
    public static void main(String[] args) {
        
        String s = "public Class A { static int a = 5; static int b = 2; }";
        StringBuilder from = new StringBuilder(s);
        int i = 0;
        
//        int ch;    
//        String charCode = "}";
//        System.out.println((int)charCode.charAt(0));
      
        while (i < from.length()) {
            if ((int)from.charAt(i) == OPEN_BRACKET) {
                i++;
                while ((int)from.charAt(i) == SPACE || (int)from.charAt(i) == TRANSFER) {
                    from.deleteCharAt(i);
                }
                from.insert(i, (char)TRANSFER);
                i++;
                from.insert(i, (char)SPACE).insert(i, (char)SPACE).insert(i, (char)SPACE).insert(i, (char)SPACE);
                i++;
            }
            if ((int)from.charAt(i) == SEMICOLON) {
                i++;
                while ((int)from.charAt(i) == SPACE || (int)from.charAt(i) == TRANSFER) {
                    from.deleteCharAt(i);
                }
                if ((int)from.charAt(i) == CLOSE_BRACKET) {
                    from.insert(i, (char)TRANSFER);
                    i++;
                } else {
                    from.insert(i, (char)TRANSFER);
                    i++;
                    from.insert(i, (char)SPACE).insert(i, (char)SPACE).insert(i, (char)SPACE).insert(i, (char)SPACE);
                    i++;
                }
            }
            i++;
        }        
        
        System.out.println(from);
        
    }
}
