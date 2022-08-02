package aiapl.buscaapl.hanoi;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.framework.problem.StepCostFunction;
import java.util.Objects;

public class JFunctions {
    
    public static StepCostFunction<EHanoi, JAction> getJCostFunction() {
        return new JStepCostFunctionImpl();        
    }
    
    public static List<JAction> getActions(EHanoi state) {
        List<JAction> actions = new ArrayList<>();

        //disco 1
        if(state.getP1(state.getIndexTopo(state.p1))==1){
            actions.add(new JAction(JAction.D1P1P2));
            actions.add(new JAction(JAction.D1P1P3));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==1){
            actions.add(new JAction(JAction.D1P2P1));
            actions.add(new JAction(JAction.D1P2P3));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==1){
            actions.add(new JAction(JAction.D1P3P1));
            actions.add(new JAction(JAction.D1P3P2));
        }
        //disco 2
        if(state.getP1(state.getIndexTopo(state.p1))==2 && state.getP2(state.getIndexTopo(state.p2)) != 1){
            actions.add(new JAction(JAction.D2P1P2));
        }
        if(state.getP1(state.getIndexTopo(state.p1))==2 && state.getP3(state.getIndexTopo(state.p3)) != 1){
            actions.add(new JAction(JAction.D2P1P3));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==2 && state.getP1(state.getIndexTopo(state.p1)) != 1){
            actions.add(new JAction(JAction.D2P2P1));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==2 && state.getP3(state.getIndexTopo(state.p3)) != 1){
            actions.add(new JAction(JAction.D2P2P3));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==2 && state.getP1(state.getIndexTopo(state.p1)) != 1){
            actions.add(new JAction(JAction.D2P3P1));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==2 && state.getP2(state.getIndexTopo(state.p2)) != 1){
            actions.add(new JAction(JAction.D2P3P2));
        }
        //disco 3
        if(state.getP1(state.getIndexTopo(state.p1))==3 && (state.getP2(state.getIndexTopo(state.p2)) == -1 || state.getP2(state.getIndexTopo(state.p2))>3)){
            actions.add(new JAction(JAction.D3P1P2));
        }
        if(state.getP1(state.getIndexTopo(state.p1))==3 && (state.getP3(state.getIndexTopo(state.p3)) == -1 || state.getP3(state.getIndexTopo(state.p3))>3)){
            actions.add(new JAction(JAction.D3P1P3));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==3 && (state.getP1(state.getIndexTopo(state.p1)) == -1 || state.getP1(state.getIndexTopo(state.p1))>3)){
            actions.add(new JAction(JAction.D3P2P1));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==3 && (state.getP3(state.getIndexTopo(state.p3)) == -1 || state.getP3(state.getIndexTopo(state.p3))>3)){
            actions.add(new JAction(JAction.D3P2P3));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==3 && (state.getP1(state.getIndexTopo(state.p1)) == -1 || state.getP1(state.getIndexTopo(state.p1))>3)){
            actions.add(new JAction(JAction.D3P3P1));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==3 && (state.getP2(state.getIndexTopo(state.p2)) == -1 || state.getP2(state.getIndexTopo(state.p2))>3)){
            actions.add(new JAction(JAction.D3P3P2));
        }
        
        //disco 4
        if(state.getP1(state.getIndexTopo(state.p1))==4 && (state.getP2(state.getIndexTopo(state.p2)) == -1 || state.getP2(state.getIndexTopo(state.p2))>4)){
            actions.add(new JAction(JAction.D4P1P2));
        }
        if(state.getP1(state.getIndexTopo(state.p1))==4 && (state.getP3(state.getIndexTopo(state.p3)) == -1 || state.getP3(state.getIndexTopo(state.p3))>4)){
            actions.add(new JAction(JAction.D4P1P3));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==4 && (state.getP1(state.getIndexTopo(state.p1)) == -1 || state.getP1(state.getIndexTopo(state.p1))>4)){
            actions.add(new JAction(JAction.D4P2P1));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==4 && (state.getP3(state.getIndexTopo(state.p3)) == -1 || state.getP3(state.getIndexTopo(state.p3))>4)){
            actions.add(new JAction(JAction.D4P2P3));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==4 && (state.getP1(state.getIndexTopo(state.p1)) == -1 || state.getP1(state.getIndexTopo(state.p1))>4)){
            actions.add(new JAction(JAction.D4P3P1));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==4 && (state.getP2(state.getIndexTopo(state.p2)) == -1 || state.getP2(state.getIndexTopo(state.p2))>4)){
            actions.add(new JAction(JAction.D4P3P2));
        }
        //disco 5
        if(state.getP1(state.getIndexTopo(state.p1))==5 && (state.getP2(state.getIndexTopo(state.p2)) == -1 || state.getP2(state.getIndexTopo(state.p2))>5)){
            actions.add(new JAction(JAction.D5P1P2));
        }
        if(state.getP1(state.getIndexTopo(state.p1))==5 && (state.getP3(state.getIndexTopo(state.p3)) == -1 || state.getP3(state.getIndexTopo(state.p3))>5)){
            actions.add(new JAction(JAction.D5P1P3));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==5 && (state.getP1(state.getIndexTopo(state.p1)) == -1 || state.getP1(state.getIndexTopo(state.p1))>5)){
            actions.add(new JAction(JAction.D5P2P1));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==5 && (state.getP3(state.getIndexTopo(state.p3)) == -1 || state.getP3(state.getIndexTopo(state.p3))>5)){
            actions.add(new JAction(JAction.D5P2P3));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==5 && (state.getP1(state.getIndexTopo(state.p1)) == -1 || state.getP1(state.getIndexTopo(state.p1))>5)){
            actions.add(new JAction(JAction.D5P3P1));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==5 && (state.getP2(state.getIndexTopo(state.p2)) == -1 || state.getP2(state.getIndexTopo(state.p2))>5)){
            actions.add(new JAction(JAction.D5P3P2));
        }
        //disco 6
        if(state.getP1(state.getIndexTopo(state.p1))==6 && (state.getP2(state.getIndexTopo(state.p2)) == -1 || state.getP2(state.getIndexTopo(state.p2))==7)){
            actions.add(new JAction(JAction.D6P1P2));
        }
        if(state.getP1(state.getIndexTopo(state.p1))==6 && (state.getP3(state.getIndexTopo(state.p3)) == -1 || state.getP3(state.getIndexTopo(state.p3))==7)){
            actions.add(new JAction(JAction.D6P1P3));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==6 && (state.getP1(state.getIndexTopo(state.p1)) == -1 || state.getP1(state.getIndexTopo(state.p1))==7)){
            actions.add(new JAction(JAction.D6P2P1));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==6 && (state.getP3(state.getIndexTopo(state.p3)) == -1 || state.getP3(state.getIndexTopo(state.p3))==7)){
            actions.add(new JAction(JAction.D6P2P3));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==6 && (state.getP1(state.getIndexTopo(state.p1)) == -1 || state.getP1(state.getIndexTopo(state.p1))==7)){
            actions.add(new JAction(JAction.D6P3P1));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==6 && (state.getP2(state.getIndexTopo(state.p2)) == -1 || state.getP2(state.getIndexTopo(state.p2))==7)){
            actions.add(new JAction(JAction.D6P3P2));
        }
        //disco 7
        if(state.getP1(state.getIndexTopo(state.p1))==7 && state.getP2(state.getIndexTopo(state.p2)) == -1){
            actions.add(new JAction(JAction.D7P1P2));
        }
        if(state.getP1(state.getIndexTopo(state.p1))==7 && state.getP3(state.getIndexTopo(state.p3)) == -1){
            actions.add(new JAction(JAction.D7P1P3));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==7 && state.getP1(state.getIndexTopo(state.p1)) == -1){
            actions.add(new JAction(JAction.D7P2P1));
        }
        if(state.getP2(state.getIndexTopo(state.p2))==7 && state.getP3(state.getIndexTopo(state.p3)) == -1){
            actions.add(new JAction(JAction.D7P2P3));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==7 && state.getP1(state.getIndexTopo(state.p1)) == -1){
            actions.add(new JAction(JAction.D7P3P1));
        }
        if(state.getP3(state.getIndexTopo(state.p3))==7 && state.getP2(state.getIndexTopo(state.p2)) == -1){
            actions.add(new JAction(JAction.D7P3P2));
        }
        
        return actions;
    }
    
    public static EHanoi getResult(EHanoi e, JAction ac) {
        
        System.out.println("Action Name:" + ac.getName());
        
        EHanoi child = new EHanoi(e.discos);
        child.setP1(e.p1);
        child.setP2(e.p2);
        child.setP3(e.p3);
        /*
        System.out.println("\nP1: "+child.getP1(child.getIndexTopo(child.getP1())));
        System.out.println("P2: "+child.getP2(child.getIndexTopo(child.getP2())));
        System.out.println("P3: "+child.getP3(child.getIndexTopo(child.getP3())));
        */
        if (Objects.equals(ac.getName(), JAction.D1P1P2)) {
            child.p1[child.getIndexTopo(child.p1)] = 0;
            child.p2[child.getIndexTopo(child.p2)+1] = 1;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D1P1P3)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 1;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D1P2P1)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 1;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D1P2P3)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 1;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D1P3P1)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 1;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D1P3P2)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 1;
            return child;
        }else if (Objects.equals(ac.getName(), JAction.D2P1P2)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 2;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D2P1P3)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 2;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D2P2P1)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 2;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D2P2P3)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 2;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D2P3P1)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 2;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D2P3P2)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 2;
            return child;
        }else if (Objects.equals(ac.getName(), JAction.D3P1P2)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 3;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D3P1P3)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 3;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D3P2P1)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 3;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D3P2P3)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 3;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D3P3P1)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 3;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D3P3P2)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 3;
            return child;
        }else if (Objects.equals(ac.getName(), JAction.D4P1P2)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 4;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D4P1P3)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 4;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D4P2P1)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 4;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D4P2P3)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 4;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D4P3P1)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 4;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D4P3P2)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 4;
            return child;
        }else if (Objects.equals(ac.getName(), JAction.D5P1P2)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 5;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D5P1P3)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 5;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D5P2P1)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 5;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D5P2P3)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 5;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D5P3P1)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 5;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D5P3P2)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 5;
            return child;
        }else if (Objects.equals(ac.getName(), JAction.D6P1P2)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 6;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D6P1P3)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 6;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D6P2P1)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 6;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D6P2P3)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 6;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D6P3P1)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 6;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D6P3P2)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 6;
            return child;
        }else if (Objects.equals(ac.getName(), JAction.D7P1P2)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 7;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D7P1P3)) {
            child.p1[child.getIndexTopo(e.p1)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 7;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D7P2P1)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 7;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D7P2P3)) {
            child.p2[child.getIndexTopo(e.p2)] = 0;
            child.p3[child.getIndexTopo(e.p3)+1] = 7;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D7P3P1)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p1[child.getIndexTopo(e.p1)+1] = 7;
            return child;
        }else if(Objects.equals(ac.getName(), JAction.D7P3P2)) {
            child.p3[child.getIndexTopo(e.p3)] = 0;
            child.p2[child.getIndexTopo(e.p2)+1] = 7;
            return child;
        }
        return null;
    }

    public static boolean testGoal(EHanoi e) {
        GTHanoi gt = new GTHanoi(e.discos);
        return gt.test(e);
    } 
    
    
    //Provavelmente não precisa implementar
    
    private static class JStepCostFunctionImpl implements StepCostFunction<EHanoi, JAction> {

        private JStepCostFunctionImpl() {}

        @Override
        public double applyAsDouble(EHanoi state, JAction action, EHanoi statePrimed) {
            double jcost = 14;
            
            //induzindo movimentos úteis para resolver mais rapidademente o problema
            //movimentos de discos maiores tem menor custo, para evitar loop de movimento
            //dos discos menores
            if (action.getName().substring(6,8)=="d1") jcost = 14;
            if (action.getName().substring(6,8)=="d2") jcost = 12;
            if (action.getName().substring(6,8)=="d3") jcost = 10;
            if (action.getName().substring(6,8)=="d4") jcost = 8;
            if (action.getName().substring(6,8)=="d5") jcost = 6;
            if (action.getName().substring(6,8)=="d6") jcost = 4;
            if (action.getName().substring(6,8)=="d7") jcost = 2;
            
            if(state.getP3(state.getIndexTopo(state.p3)) == state.discos &&
                    statePrimed.getP3(statePrimed.getIndexTopo(statePrimed.p3))==state.discos-1) 
                jcost = 1;
                        
            if (Objects.equals(action.getName(), JAction.D3P1P3) && state.discos==3) jcost = 1;
            if (Objects.equals(action.getName(), JAction.D4P1P3) && state.discos==4) jcost = 1;
            if (Objects.equals(action.getName(), JAction.D5P1P3) && state.discos==5) jcost = 1;
            if (Objects.equals(action.getName(), JAction.D6P1P3) && state.discos==6) jcost = 1;
            if (Objects.equals(action.getName(), JAction.D7P1P3) && state.discos==7) jcost = 1;
            
            if (Objects.equals(action.getName(), JAction.D3P1P2) && state.discos==3) jcost = 14;
            if (Objects.equals(action.getName(), JAction.D4P1P2) && state.discos==4) jcost = 14;
            if (Objects.equals(action.getName(), JAction.D5P1P2) && state.discos==5) jcost = 14;
            if (Objects.equals(action.getName(), JAction.D6P1P2) && state.discos==6) jcost = 14;
            if (Objects.equals(action.getName(), JAction.D7P1P2) && state.discos==7) jcost = 14;
            
            return jcost;
        }
    }
    
}