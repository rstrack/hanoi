package aiapl.buscaapl.hanoi;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.framework.Node;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.problem.StepCostFunction;
import java.util.Objects;

public class JFunctions {

    public static StepCostFunction<EHanoi, JAction> getJCostFunction() {
        return new JStepCostFunctionImpl();        
    }
    
    public static List<JAction> getActions(EHanoi state) {
        List<JAction> actions = new ArrayList<>();
        // encher pote de 4L
        
        if ((state.getVol3L()<0) || (state.getVol4L()<0) || (state.getVol7L()<0)) {
            System.out.println("Erro consistência.");
            System.exit(0);
        } 
        
        if (state.getVol7L()<7) 
            actions.add(new JAction(JAction.COMPLETAR_J7));
                
        if (state.getVol4L()<4) 
            actions.add(new JAction(JAction.COMPLETAR_J4));
        
        // encher pote de 3L
        if (state.getVol3L()<3) 
            actions.add(new JAction(JAction.COMPLETAR_J3));
      
        //esvaziar pote de 4L no pote 3L
        if (state.getVol3L()>0)
            actions.add(new JAction(JAction.ESVAZIAR_J3));

        // esvaziar pote de 4L
        if (state.getVol4L()>0)
            actions.add(new JAction(JAction.ESVAZIAR_J4));
        
        if (state.getVol7L()>0)
            actions.add(new JAction(JAction.ESVAZIAR_J7));
        
        // despejar 4L em 3L
        if ((state.getVol4L()>0) & (state.getVol3L()<3))
            if (state.getVol4L() <= (3-state.getVol3L()))
                actions.add(new JAction(JAction.DESPEJAR_J4_J3));
        
        // despejar 3L em 4L
        if ((state.getVol3L()>0) & (state.getVol4L()<4))
            if (state.getVol3L() <= (4-state.getVol4L()))
                actions.add(new JAction(JAction.DESPEJAR_J3_J4));
        
        // despejar 7L em 3L
        if ((state.getVol7L()>0) & (state.getVol3L()<3))
            if (state.getVol7L() <= (3-state.getVol3L()))
                actions.add(new JAction(JAction.DESPEJAR_J7_J3));
        
        // despejar 3L em 7L
        if ((state.getVol3L()>0) & (state.getVol7L()<7))
            if (state.getVol3L() <= (7-state.getVol7L()))
                actions.add(new JAction(JAction.DESPEJAR_J3_J7));
        
        // despejar 7L em 4L
        if ((state.getVol7L()>0) & (state.getVol4L()<4))
            if (state.getVol7L() <= (4-state.getVol4L()))
                actions.add(new JAction(JAction.DESPEJAR_J7_J4));
        
        // despejar 4L em 7L
        if ((state.getVol4L()>0) & (state.getVol7L()<7))
            if (state.getVol4L() <= (7-state.getVol7L()))
                actions.add(new JAction(JAction.DESPEJAR_J4_J7));
        
        //completar 3L com 4L
        if((state.getVol3L()<3)&&(state.getVol4L()>3-state.getVol3L()))
            actions.add(new JAction(JAction.COMPLETAR_J3_COM_J4));
        
        //completar 3L com 7L
        if((state.getVol3L()<3)&&(state.getVol7L()>3-state.getVol3L()))
            actions.add(new JAction(JAction.COMPLETAR_J3_COM_J7));
        
        //completar 4L com 7L
        if((state.getVol4L()<4)&&(state.getVol7L()>4-state.getVol4L()))
            actions.add(new JAction(JAction.COMPLETAR_J4_COM_J7));
        
        //completar 4L com 3L
        if((state.getVol4L()<4)&&(state.getVol3L()>4-state.getVol4L()))
            actions.add(new JAction(JAction.COMPLETAR_J4_COM_J3));
        
        //completar 7L com 3L
        if((state.getVol7L()<7)&&(state.getVol3L()>7-state.getVol7L()))
            actions.add(new JAction(JAction.COMPLETAR_J7_COM_J3));
        
        //completar 7L com 4L
        if((state.getVol7L()<7)&&(state.getVol4L()>7-state.getVol7L()))
            actions.add(new JAction(JAction.COMPLETAR_J7_COM_J4));
        
        return actions;
    }
    
    public static EJarros getResult(EJarros e, JAction ac) {
        System.out.println("Action Name:" + ac.getName());
        if (Objects.equals(ac.getName(), JAction.COMPLETAR_J4)) {
            EJarros child = new EJarros();
            child.setVol(e.getVol3L(),4,e.getVol7L());
            return child;
        } else  if (Objects.equals(ac.getName(), JAction.COMPLETAR_J3)) {
            EJarros child = new EJarros();
            child.setVol(3, e.getVol4L(), e.getVol7L());
            return child;
        }else  if (Objects.equals(ac.getName(), JAction.COMPLETAR_J7)) {
            EJarros child = new EJarros();
            child.setVol(e.getVol3L(), e.getVol4L(), 7);
            return child; 
        }else if (Objects.equals(ac.getName(), JAction.ESVAZIAR_J3)) {
            EJarros child = new EJarros();
            child.setVol(0, e.getVol4L(), e.getVol7L());
            return child;
        } else if (Objects.equals(ac.getName(), JAction.ESVAZIAR_J4)) {
            EJarros child = new EJarros();
            child.setVol(e.getVol3L(), 0, e.getVol7L());
            return child;
        }else if (Objects.equals(ac.getName(), JAction.ESVAZIAR_J7)) {
            EJarros child = new EJarros();
            child.setVol(e.getVol3L(), e.getVol4L(), 0);
            return child;
        } else if (Objects.equals(ac.getName(), JAction.DESPEJAR_J3_J4)) {
            EJarros child = new EJarros();
            int vj4 = e.getVol4L()+e.getVol3L();
            child.setVol(0, vj4, e.getVol7L());
            return child;
        }
        else if (Objects.equals(ac.getName(), JAction.DESPEJAR_J3_J7)) {
            EJarros child = new EJarros();
            int vj7 = e.getVol7L()+e.getVol3L();
            child.setVol(0,e.getVol4L(),vj7);
            return child;
        }else if (Objects.equals(ac.getName(), JAction.DESPEJAR_J4_J3)) {
            EJarros child = new EJarros();
            int vj3 = e.getVol3L()+e.getVol4L();
            child.setVol(vj3,0,e.getVol7L());
            return child;
        }else if (Objects.equals(ac.getName(), JAction.DESPEJAR_J4_J7)) {
            EJarros child = new EJarros();
            int vj7 = e.getVol7L()+e.getVol4L();
            child.setVol(e.getVol3L(),0,vj7);
            return child;
        }else if (Objects.equals(ac.getName(), JAction.DESPEJAR_J7_J3)) {
            EJarros child = new EJarros();
            int vj3 = e.getVol3L()+e.getVol7L();
            child.setVol(vj3,e.getVol4L(),0);
            return child;
        }else if (Objects.equals(ac.getName(), JAction.DESPEJAR_J7_J4)) {
            EJarros child = new EJarros();
            int vj4 = e.getVol4L()+e.getVol7L();
            child.setVol(e.getVol3L(),vj4,0);
            return child;
        }else if (Objects.equals(ac.getName(), JAction.COMPLETAR_J3_COM_J4)) {
            EJarros child = new EJarros();
            int folgaJ3 = 3 - e.getVol3L(); 
            int transf = 0;
            if (folgaJ3>=e.getVol4L())
                transf = e.getVol4L();
            else 
                transf = folgaJ3;
            int vj4 = e.getVol4L()-transf;
            child.setVol(3, vj4, e.getVol7L());
            return child;
        }else if (Objects.equals(ac.getName(), JAction.COMPLETAR_J3_COM_J7)) {
            EJarros child = new EJarros();
            int folgaJ3 = 3 - e.getVol3L(); 
            int transf = 0;
            if (folgaJ3>=e.getVol7L())
                transf = e.getVol7L();
            else 
                transf = folgaJ3;
            int vj7 = e.getVol7L()-transf;
            child.setVol(3, e.getVol4L(), vj7);
            return child;
        }else if (Objects.equals(ac.getName(), JAction.COMPLETAR_J4_COM_J7)) {
            EJarros child = new EJarros();
            int folgaJ4 = 4 - e.getVol4L(); 
            int transf = 0;
            if (folgaJ4>=e.getVol7L())
                transf = e.getVol7L();
            else 
                transf = folgaJ4;
            int vj7 = e.getVol7L()-transf;
            child.setVol(e.getVol3L(),4, vj7);
            return child;
        }else if (Objects.equals(ac.getName(), JAction.COMPLETAR_J4_COM_J3)) {
            EJarros child = new EJarros();
            int folgaJ4 = 4 - e.getVol4L(); 
            int transf = 0;
            if (folgaJ4>=e.getVol3L())
                transf = e.getVol3L();
            else 
                transf = folgaJ4;
            int vj3 = e.getVol3L()-transf;
            child.setVol(vj3, 4, e.getVol7L());
            return child;
        }else if (Objects.equals(ac.getName(), JAction.COMPLETAR_J7_COM_J3)) {
            EJarros child = new EJarros();
            int folgaJ7 = 7 - e.getVol7L(); 
            int transf = 0;
            if (folgaJ7>=e.getVol3L())
                transf = e.getVol3L();
            else 
                transf = folgaJ7;
            int vj3 = e.getVol3L()-transf;
            child.setVol(vj3,e.getVol4L(), 7);
            return child;
        }else if (Objects.equals(ac.getName(), JAction.COMPLETAR_J7_COM_J4)) {
            EJarros child = new EJarros();
            int folgaJ7 = 7 - e.getVol7L(); 
            int transf = 0;
            if (folgaJ7>=e.getVol4L())
                transf = e.getVol4L();
            else 
                transf = folgaJ7;
            int vj4 = e.getVol4L()-transf;
            child.setVol(e.getVol3L(), vj4 ,7);
            return child;
        }    
        return null;
    }

    public static boolean testGoal(EJarros e) {
        GTJarros gt = new GTJarros(3,0,1);
        return gt.test(e);
    } 
    
    private static class JStepCostFunctionImpl implements StepCostFunction<EJarros, JAction> {

        private static double constantCost = 1.0;

        private JStepCostFunctionImpl() {

        }

        @Override
        public double applyAsDouble(EJarros state, JAction action, EJarros statePrimed) {
            double jcost = 0;
            if (Objects.equals(action.getName(), JAction.COMPLETAR_J3)) jcost = 3 - statePrimed.getVol3L();
            if (Objects.equals(action.getName(), JAction.COMPLETAR_J4)) jcost = 4 - statePrimed.getVol4L();
            if (Objects.equals(action.getName(), JAction.COMPLETAR_J7)) jcost = 7 - statePrimed.getVol7L();
            return jcost;
        }
    }
}