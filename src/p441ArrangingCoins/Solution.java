package p441ArrangingCoins;

class Solution {
    public int arrangeCoins(int n) {
        // (x^2+x)/2=Y
        return (int) (Math.sqrt(2 * (long) n + .25) -.5);
    }
}