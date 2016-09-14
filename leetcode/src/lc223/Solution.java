package lc223;

import java.util.*;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (G<A || F>D || E>C || H<B) return (D-B)*(C-A)+(H-F)*(G-E);
        return (D-B)*(C-A)+(H-F)*(G-E)-(Math.min(H, D)-Math.max(F, B))*(Math.min(G, C)-Math.max(A, E));
    }

    public static void main(String[] args) {
    }
}