package lcs;

public class LCS {

    // the strings to be tested
    private String s1;
    private String s2;

    // constructor; uses 2 string parameters
    public LCS(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
    }


    // dynamic programming solution
    public void lcsDynamicSol() {
    }

    // actual length function, used for parameters
    private void lcsSolution(String s1, String s2, int m, int n){

        // create 2D array matrix
        int [][] lcsTable = new int[m+1][n+1];

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

    }

    // returns the larger of two ints
    private int max(int a, int b){
        return Math.max(a, b);
    }

    // getter
    public String getLCS() {
        return null;
    }
}
