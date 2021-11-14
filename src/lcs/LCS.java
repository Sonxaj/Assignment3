/*   Name:
 *   Jonas Turner
 *   COP3503 Fall 2021
 *   Programming Assignment 3
 */

package lcs;

public class LCS {

    // the strings to be tested
    private String s1;
    private String s2;

    // lcs to be found
    private String LCS;

    // constructor; uses 2 string parameters
    public LCS(String s1, String s2){
        this.s1 = s2;       // weird, but reversing yields the
        this.s2 = s1;       // same lcs as in the runner.
        this.LCS = "";
    }


    // dynamic programming solution; calls actual solution
    public void lcsDynamicSol() {
        lcsFunc(s1, s2, s1.length(), s2.length());
    }

    // actual length function, used for parameters
    private void lcsFunc(String s1, String s2, int m, int n){

        // create 2D array matrix
        int [][] lcsTable = new int[m+1][n+1];

        // build it up from bottom
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if(i == 0 || j == 0){
                    lcsTable[i][j] = 0;

                    // charAt method is awesome; no array conversion needed
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    lcsTable[i][j] = lcsTable[i-1][j-1] + 1;

                }else{
                    lcsTable[i][j] = max(lcsTable[i-1][j], lcsTable[i][j-1]);
                }
            }
        }

        // needed for printing
        int index = lcsTable[m][n];
        int temp = index;

        char[] lcs = new char[index+1];     // char array to store the lcs
        lcs[index] = '\u0000';              // null terminator at end of string

        // starting from bottom right corner, store every character in lcs
        int i = m;
        int j = n;
        while(i > 0 && j > 0){

            // if current character in s1 and s2 match
            if(s1.charAt(i-1) == s2.charAt(j-1)) {

                // add to result
                lcs[index-1] = s1.charAt(i-1);

                // decrement values
                i--;
                j--;
                index--;

                // if the chars don't match, move towards larger value
            }else if(lcsTable[i-1][j] > lcsTable[i][j-1]){
                i--;
            }else{
                j--;
            }
        }

        // assign lcs
        setLCS(lcs, temp);
    }

    // returns the larger of two ints
    private int max(int a, int b){
        return Math.max(a, b);
    }

    // getter
    public String getLCS() {
        return this.LCS;
    }

    // appends the LCS attribute of the class to the LCS found from solution
    public void setLCS(char[] lcs, int temp){
        // string builder ftw
        StringBuilder set = new StringBuilder();

        for (int i = 0; i < temp; i++) {
            set.append(lcs[i]);
        }

        this.LCS = set.toString();
    }
}
