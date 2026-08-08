class Solution {
    public String interpret(String command) {
        String ans="";
        int i =0;
        while (i<command.length()) {
            if (command.charAt(i) == 'G') {
                ans = ans +"G";
                i++;
            } else if (command.charAt(i+1) ==')') {
                ans = ans+"o";
                i = i+2;
            }
            else {
                ans = ans +"al";
                i = i+4;
            }
        }
        return ans;
    }
}