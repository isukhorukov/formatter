import java.io.*;

/**
*is a simple version of the program code formatting
 * static final int SPACE         = 32;   // space
* static final int TRANSFER      = 10;   // enter
* static final int OPEN_BRACKET  = 123;  // {
* static final int CLOSE_BRACKET = 125;  // }
* static final int SEMICOLON     = 59;   // ;
 */

public class Formatter {
    
    static final int SPACE         = 32;   // space
    static final int TRANSFER      = 10;   // enter
    static final int OPEN_BRACKET  = 123;  // {
    static final int CLOSE_BRACKET = 125;  // }
    static final int SEMICOLON     = 59;   // ;
    
    public static void main(final String[] args) {
        
        String s = "public Class A { static int a = 5; static int b = 2; static class B { int s = 3; boolean z = true; } }";
        StringBuilder from = new StringBuilder(s);
        int i       = 0;
        int depth   = 0;

          
        while (i < from.length()) {
            //open bracket case
            if ((int) from.charAt(i) == OPEN_BRACKET) {
                depth++;
                i++;
                while ((int) from.charAt(i) == SPACE || (int) from.charAt(i) == TRANSFER) {
                    from.deleteCharAt(i);
                }
                from.insert(i, (char) TRANSFER);
                i++;
                for (int j = 0; j < depth; j++) {
                    from.insert(i, (char) SPACE).insert(i, (char) SPACE).insert(i, (char) SPACE).insert(i, (char) SPACE);
                
                }
            }
            //semicolon case
            if ((int) from.charAt(i) == SEMICOLON) {
                i++;
                while ((int) from.charAt(i) == SPACE || (int) from.charAt(i) == TRANSFER) {
                    from.deleteCharAt(i);
                }
               if ((int) from.charAt(i) == CLOSE_BRACKET) {
                 
                    depth--;

                } else { 
                    
                    from.insert(i, (char) TRANSFER);
                    i++;
                    for (int j = 0; j < depth; j++) {
                        from.insert(i, (char) SPACE).insert(i, (char) SPACE).insert(i, (char) SPACE).insert(i, (char) SPACE);
                      
                    }
                }
            }
            //close bracket case
            if (((int) from.charAt(i) == CLOSE_BRACKET)) {

                from.insert(i, (char) TRANSFER);
                    i++;
                    for (int j = 0; j < depth; j++) {
                        from.insert(i, (char) SPACE).insert(i, (char) SPACE).insert(i, (char) SPACE).insert(i, (char) SPACE);
                      
                    }     
                    depth--;
                    i += 5;
             //   System.out.println(i);
            }
            i++;
        }        
   //     System.out.println(i);
        System.out.println(from);
        
    }
}
