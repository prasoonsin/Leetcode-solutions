class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x= 0;
        for (int i = 0; i<operations.length; i++) {
            String operation = operations[i];
            if (operation.charAt(1) =='+') {
                x++;
            } else{
                x--;
            }
        }
        return x;
    }
}