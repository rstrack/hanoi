package aiapl.buscaapl.hanoi;

import aima.core.search.framework.problem.GoalTest;
import java.util.Arrays;

public class GTHanoi implements GoalTest {
    
    public int[] gtp1;
    public int[] gtp2;
    public int[] gtp3;
    public GTHanoi(int k) {
        gtp1 = new int[k]; 
        gtp2 = new int[k]; 
        gtp3 = new int[k]; 
        for(int i=0;i<k;i++){
            gtp1[i] = 0;
            gtp2[i] = 0;
            gtp3[i] = k-i;
        }
    }
    
    public boolean test(Object state) {
        EHanoi hanoi = (EHanoi) state;
        /*
        System.out.println(this.gtp1[0]);
        System.out.println(this.gtp1[1]);
        System.out.println(this.gtp1[2]);
        System.out.println(hanoi.getP1(0));
        System.out.println(hanoi.getP1(1));
        System.out.println(hanoi.getP1(2));
        System.out.println("\n");
        */
        if(Arrays.equals(gtp1, hanoi.getP1())){
            if(Arrays.equals(gtp2, hanoi.getP2())){
                if(Arrays.equals(gtp3, hanoi.getP3())){
                    return true;
                }
            }
        }
        return false;
    }
    
    public int[][] getObjetive() {
        return new int[][] {gtp1, gtp2, gtp3};
    }
}
