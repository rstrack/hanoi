package aiapl.buscaapl.hanoi;

import aima.core.search.framework.problem.GoalTest;

public class GTHanoi implements GoalTest {
    
    public GTHanoi(int k) {
        
    }
    
    public boolean test(Object state) {
        EHanoi hanoi = (EHanoi) state;
        for(int i=0;i<hanoi.discos;i++){
            if(hanoi.getP1(i) != 0)
                return false;
            if(hanoi.getP2(i) != 0)
                return false;
            if(hanoi.getP3(i) != hanoi.discos-i)
                return false;
        }
        return true;
    }

    /*
    public int[] getObjetive() {
        return new int[] {sf3L, sf4L, sf7L};
    }
    */
}
