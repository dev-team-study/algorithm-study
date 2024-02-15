package tommy;

import java.util.Stack;

public class PRO_올바른괄호 {

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (c == '('){
                stack.push(c);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()){
            return false;
        }

        return true;
    }
}
