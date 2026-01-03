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
        Character X = matNum.charAt(matNum.length() - 1);
        Character Y = matNum.charAt(matNum.length() - 2);
        Character Z = matNum.charAt(matNum.length() - 3);

        //mark the read characters
        Character A = 'A'; //for X
        Character B = 'B'; //for Y
        Character C = 'C'; //for Z

        List<Transition> transitions = new ArrayList<>();

        transitions.add(new Transition(
                0, new Character[]{ X },
                2, new Character[]{ A },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));

        transitions.add(new Transition(
                0, new Character[]{ A },
                0, new Character[]{ A },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));

        transitions.add(new Transition(
                0, new Character[]{ null },
                5, new Character[]{ null },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Stay }
        ));


        transitions.add(new Transition(
                2, new Character[]{ X },
                2, new Character[]{ X },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        transitions.add(new Transition(
                2, new Character[]{ A },
                2, new Character[]{ A },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        transitions.add(new Transition(
                2, new Character[]{ B },
                2, new Character[]{ B },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        transitions.add(new Transition(
                2, new Character[]{ C },
                2, new Character[]{ C },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        //  mark Y and search Z
        transitions.add(new Transition(
                2, new Character[]{ Y },
                3, new Character[]{ B },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));

        //skip
        transitions.add(new Transition(
                3, new Character[]{ Y },
                3, new Character[]{ Y },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        transitions.add(new Transition(
                3, new Character[]{ A },
                3, new Character[]{ A },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        transitions.add(new Transition(
                3, new Character[]{ B },
                3, new Character[]{ B },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        transitions.add(new Transition(
                3, new Character[]{ C },
                3, new Character[]{ C },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        //mark and go left if Z
        transitions.add(new Transition(
                3, new Character[]{ Z },
                4, new Character[]{ C },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Left }
        ));

        transitions.add(new Transition(
                4, new Character[]{ X },
                4, new Character[]{ X },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Left }
        ));
        transitions.add(new Transition(
                4, new Character[]{ Y },
                4, new Character[]{ Y },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Left }
        ));
        transitions.add(new Transition(
                4, new Character[]{ Z },
                4, new Character[]{ Z },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Left }
        ));
        transitions.add(new Transition(
                4, new Character[]{ A },
                4, new Character[]{ A },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Left }
        ));
        transitions.add(new Transition(
                4, new Character[]{ B },
                4, new Character[]{ B },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Left }
        ));
        transitions.add(new Transition(
                4, new Character[]{ C },
                4, new Character[]{ C },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Left }
        ));

        transitions.add(new Transition(
                4, new Character[]{ null },
                0, new Character[]{ null },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));

        transitions.add(new Transition(
                0, new Character[]{B},
                5, new Character[]{B},
                new TuringMachine.Movement[]{TuringMachine.Movement.Stay}
        ));
        transitions.add(new Transition(
                0, new Character[]{C},
                5, new Character[]{C},
                new TuringMachine.Movement[]{TuringMachine.Movement.Stay}
        ));




        transitions.add(new Transition(
                5, new Character[]{ A },
                5, new Character[]{ A },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        transitions.add(new Transition(
                5, new Character[]{ B },
                5, new Character[]{ B },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));
        transitions.add(new Transition(
                5, new Character[]{ C },
                5, new Character[]{ C },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Right }
        ));

        //accept
        transitions.add(new Transition(
                5, new Character[]{ null },
                1, new Character[]{ null },
                new TuringMachine.Movement[]{ TuringMachine.Movement.Stay }
        ));
        return transitions.toArray(new Transition[0]);
    }

    @Override
    public Transition[] hasPath() {


        List<Transition> transition = new ArrayList<>();

        //position
        for(int i = 0; i < 16; i++){ // 16-bits
            //flags
            for(int j = 0; j < 16; j ++){
                int state = i*16 + j;

                //es sind nur 4 boolean benötigt
                boolean transfer12 = (j & 1) != 0;  // 1-2 getroffen
                boolean transfer13 = (j & 2) != 0; //1-3 getroffen
                boolean transfer12and23 = (j & 4) != 0; // 1-2 und 2 -3
                boolean transfer13and24 = (j & 8) != 0; // 1-3 und 2-4

                char[] values = {'0', '1'};
                for (int k = 0; k < values.length; k++) {
                    char ch = values[k];

                    int newFlags = j;


                    //1 to 2
                    if (i == 1 && ch == '1') newFlags |= 1;

                    // 1 to 3
                    if (i == 2 && ch == '1') newFlags |= 2;

                    // 1to 4 - wird akzepziert
                    if (i == 3 && ch == '1') {
                        transition.add(new Transition(
                                state,
                                new Character[]{Character.valueOf(ch), null},
                                1,
                                new Character[]{Character.valueOf(ch), null},
                                new TuringMachine.Movement[]{
                                        TuringMachine.Movement.Stay,
                                        TuringMachine.Movement.Stay
                                }
                        ));
                        continue;
                    }

                    // 2 to 3 (1-2 and 2-3 if it was 1-2)
                    if (i == 6 && ch == '1' && transfer12) newFlags |= 4;

                    // 2-4 wenn es 1-2 existiert dann wirds akzeptiert
                    if (i == 7 && ch == '1' && transfer12) {
                        transition.add(new Transition(
                                state,
                                new Character[]{Character.valueOf(ch), null},
                                1,
                                new Character[]{Character.valueOf(ch), null},
                                new TuringMachine.Movement[]{
                                        TuringMachine.Movement.Stay,
                                        TuringMachine.Movement.Stay
                                }
                        ));
                        continue;
                    }
                    // wenns 1-3 gab dann 1-3und 2-4  1-3-2-4
                    if (i == 7 && ch == '1' && transfer13) newFlags |= 8;


                    // wenn es 1-3 & 2-4 und der Weg 3-2=1 dann Pfad 1-3-2-4 wird akzeptiert
                    if (i == 9 && ch == '1' && transfer13and24) {
                        transition.add(new Transition(
                                state,
                                new Character[]{Character.valueOf(ch), null},
                                1,
                                new Character[]{Character.valueOf(ch), null},
                                new TuringMachine.Movement[]{
                                        TuringMachine.Movement.Stay,
                                        TuringMachine.Movement.Stay
                                }
                        ));
                        continue;
                    }


                    // wenn 1-3 => dann 1-3 -4
                    // wenn 1-2 und 2-3 => dann 1-2-3-4
                    if (i == 11 && ch == '1' && (transfer13 || transfer12and23)) {
                        transition.add(new Transition(
                                state,
                                new Character[]{Character.valueOf(ch), null},
                                1,
                                new Character[]{Character.valueOf(ch), null},
                                new TuringMachine.Movement[]{
                                        TuringMachine.Movement.Stay,
                                        TuringMachine.Movement.Stay
                                }
                        ));
                        continue;
                    }

                    //nächster Schritt
                    int nextState = (i + 1) * 16 + newFlags;
                    transition.add(new Transition(
                            state,
                            new Character[]{Character.valueOf(ch), null},
                            nextState,
                            new Character[]{Character.valueOf(ch), null},
                            new TuringMachine.Movement[]{
                                    TuringMachine.Movement.Right,
                                    TuringMachine.Movement.Stay
                            }
                    ));


                }

            }


        }


        return transition.toArray(new Transition[0]);
    }
}
