class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentStr = "";
        int currentNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(currentNum);
                stringStack.push(currentStr);
                currentNum = 0;
                currentStr = "";
            } else if (c == ']') {
                int count = countStack.pop();
                String prev = stringStack.pop();
                StringBuilder sb = new StringBuilder(prev);
                for (int i = 0; i < count; i++) {
                    sb.append(currentStr);
                }
                currentStr = sb.toString();
            } else {
                currentStr += c;
            }
        }

        return currentStr;
    }
}
