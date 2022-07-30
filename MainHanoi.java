package aiapl.buscaapl.hanoi;

import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;

import aima.core.search.uninformed.UniformCostSearch;

import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class MainHanoi {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o número de discos (maximo 7):");
        int k = sc.nextInt();
        MainHanoi hanoi = new MainHanoi();
        hanoi.run(k);
    }
    
    public void run(int k){
       this.uniformCostSearch(k);
    }
    
    private void uniformCostSearch(int k) {
        EHanoi inicial = new EHanoi(k);
        Problem<EHanoi, JAction> problem;
        problem = new GeneralProblem<>(
                        inicial,
                        JFunctions::getActions,
                        JFunctions::getResult,
                        JFunctions::testGoal);
        SearchForActions<EHanoi, JAction> search = new UniformCostSearch<>();
        try {
            SearchAgent<EHanoi, JAction> agent = new SearchAgent<>(problem, search);
            Optional<List<JAction>> actions = search.findActions(problem);
            this.printActions(actions);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }

    }
  
    private void printActions(Optional<List<JAction>> actions) {
	List<JAction> acList ;
        Object aux = actions.get();
        acList = ((List<JAction>) aux);
        for (int i = 0; i < acList.size(); i++) {
            String act = (String) acList.get(i).getName();
            System.out.println(act);
	}
    }

}
