package aiapl.buscaapl.hanoi;

public class EHanoi {

    int[] p1 = new int[8];
    int[] p2 = new int[8];
    int[] p3 = new int[8];
    int discos;
    
    public EHanoi(int k) { //k = numero de discos
        this.discos = k;
        for(int i=0;i<k;i++){
            p1[i] = k-i;
            p2[i] = 0;
            p3[i] = 0;
        }
    }
    /*
    public void setVol(int a, int b, int c) {
        this.J3=a;
        this.J4=b;
        this.J7=c;
    }
    */
    public int[] getP1() {
        return this.p1;
    }
    
    public int getP1(int k){
        return this.p1[k];
    }
    
    public int[] getP2() {
        return this.p2;
    }
    
    public int getP2(int k){
        return this.p2[k];
    }
    
    public int[] getP3() {
        return this.p3;
    }
    
    public int getP3(int k){
        return this.p3[k];
    }
    
    public int getIndexTopo(int[] pilha){
        for(int i=discos-1;i>=0; i--){
            if (pilha[i]>0)
                return i;
        }
        return 7;//fugindo do out of bounds
    }
    
    public boolean vazio(int[] pilha){
        return pilha[0] == 0;
    }
}
