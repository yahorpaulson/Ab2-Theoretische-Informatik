package ab2.impl.Siarheyeu;

import ab2.Ab2;
import ab2.TuringMachine;
import ab2.TuringMachine.Transition;
import ab2.TuringMachineComputation;

import java.util.ArrayList;
import java.util.List;

public class Ab2Impl implements Ab2 {

    @Override
    public String[] matriculationNumbers() {

        //return new String[] { "1234567", "2345678", "3456789" };
        return new String[] {"11930943"};
    }

    @Override
	public TuringMachine createTuringMachine(int numberOfTapes, Transition[] transitions) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TuringMachineComputation initializeComputation(TuringMachine tm, Character[] input) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Transition[] toSingleTapeMachine(TuringMachine twoTapeMachine) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Transition[] larger() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Transition[] lastThree() {
        String matNum = matriculationNumbers()[0];
        if (matNum == null) {
            throw new IllegalArgumentException("Matriculation number is null");
        }
        matNum = matNum.trim();
        if (matNum.length() < 3) {
            throw new IllegalArgumentException("Matriculation number must have at least 3 digits");
        }

        //save last 3 digits of matriculation number
        char X = matNum.charAt(matNum.length() - 3);
        char Y = matNum.charAt(matNum.length() - 2);
        char Z = matNum.charAt(matNum.length() - 1);

        List<Transition> transitions = new ArrayList<>();

        //from start to first X
        transitions.add(
                new Transition(0,
                        new Character[]{X},
                        2 ,
                        new Character[]{'A'},
                        new TuringMachine.Movement[]{TuringMachine.Movement.Right}));

        transitions.add(
                new Transition(
                        2,
                        new Character[]{ 'A' },
                        2,
                        new Character[]{ 'A' },
                        new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
                )
        );

        //to Y
        transitions.add(
                new Transition(
                        2,
                        new Character[]{ Y },
                        3,
                        new Character[]{ 'B' },
                        new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
                )
        );
        transitions.add(
                new Transition(
                        3,
                        new Character[]{ 'B' },
                        3,
                        new Character[]{ 'B' },
                        new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
                )
        );

        //to Z
        transitions.add(
                new Transition(
                        3,
                        new Character[]{ Z },
                        4,
                        new Character[]{ 'C' },
                        new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
                )
        );
        transitions.add(
                new Transition(
                        4,
                        new Character[]{ 'C' },
                        4,
                        new Character[]{ 'C' },
                        new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
                )
        );
        //end of line
        transitions.add(
                new Transition(
                        4,
                        new Character[]{ null },
                        0,
                        new Character[]{ null },
                        new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
                )
        );







        return null;
    }

    @Override
    public Transition[] hasPath() {
        // TODO Auto-generated method stub
        return null;
    }
}
