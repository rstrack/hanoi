package aiapl.buscaapl.hanoi;

import aima.core.search.framework.problem.GoalTest;

public class GTHanoi implements GoalTest {
    
    int gtp1[] = new int[7]; 
    int gtp2[] = new int[7]; 
    int gtp3[] = new int[7]; 
    
    public GTHanoi(int k) {
        for(int i=0;i<k;i++){
            this.gtp1[i] = 0;
            this.gtp2[i] = 0;
            this.gtp3[i] = k-i;
        }
    }
    
    public boolean test(Object state) {
        EHanoi hanoi = (EHanoi) state;
        for(int i=0;i<hanoi.discos;i++){
            if(hanoi.getP1(i) != this.gtp1[i]){
                return false;
            }if(hanoi.getP2(i) != this.gtp2[i]){
                return false;
            }if(hanoi.getP3(i) != this.gtp3[i]){
                return false;
            }
        }
        return true;
    }

    public int[][] getObjetive() {
        return new int[][] {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{7,6,5,4,3,2,1}};
    }
}
