package aiapl.buscaapl.hanoi;

import java.lang.reflect.Array;

public class EHanoi {

    int[] p1 = new int[7];
    int[] p2 = new int[7];
    int[] p3 = new int[7];
    int discos;
    
    public EHanoi(int k) { //k = numero de discos
        this.discos = k;
        for(int i=0;i<k;i++){
            p1[i] = k-i;
            p2[i] = 0;
            p3[i] = 0;
        }
    }
    
    public void setP1(int[] p){
        for(int i=0;i<this.discos;i++){
            Array.set(this.p1, i, p[i]);
        }
    }
    
    public void setP2(int[] p){
        for(int i=0;i<this.discos;i++){
            Array.set(this.p2, i, p[i]);
        }
    }
    
    public void setP3(int[] p){
        for(int i=0;i<this.discos;i++){
            Array.set(this.p3, i, p[i]);
        }
    }
    
    public int[] getP1() {
        return this.p1;
    }
    
    public int getP1(int k){
        if (k == -1)
            return -1;
        return this.p1[k];
    }
    
    public int[] getP2() {
        return this.p2;
    }
    
    public int getP2(int k){
        if (k == -1)
            return -1;
        return this.p2[k];
    }
    
    public int[] getP3() {
        return this.p3;
    }
    
    public int getP3(int k){
        if (k == -1)
            return -1;
        return this.p3[k];
    }
    
    public int getIndexTopo(int[] pilha){
        for(int i=discos-1;i>=0; i--){
            if (pilha[i]>0)
                return i;
        }
        return -1;
    }
    
    public boolean vazio(int[] pilha){
        return pilha[0] == 0;
    }
}
