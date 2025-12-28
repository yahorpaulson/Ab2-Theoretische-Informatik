package ab2;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ab2.impl.Siarheyeu.Ab2Impl;
import ab2.TuringMachine.Transition;
import ab2.TuringMachine.Movement;

public class Ab2Tests {

    private static Ab2 factory = new Ab2Impl();
    private static Random rand = new Random();

    // nur das Leerwort
    public static TuringMachine tm1() {
        TuringMachine m = factory.createTuringMachine(1,
            new Transition[] {
                new Transition(0,
                               new Character[] { null }, 1,
                               new Character[] { null },
                               new Movement[] { Movement.Stay })
            }
        );

        return m;
    }

    // [a-z]
    public static TuringMachine tm2() {
        TuringMachine m = factory.createTuringMachine(1,
            new Transition[] {
                new Transition(0,
                               new Character[] { 'a' }, 2,
                               new Character[] { 'a' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'b' }, 2,
                               new Character[] { 'b' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'c' }, 2,
                               new Character[] { 'c' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'd' }, 2,
                               new Character[] { 'd' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'e' }, 2,
                               new Character[] { 'e' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'f' }, 2,
                               new Character[] { 'f' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'g' }, 2,
                               new Character[] { 'g' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'h' }, 2,
                               new Character[] { 'h' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'i' }, 2,
                               new Character[] { 'i' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'j' }, 2,
                               new Character[] { 'j' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'k' }, 2,
                               new Character[] { 'k' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'l' }, 2,
                               new Character[] { 'l' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'm' }, 2,
                               new Character[] { 'm' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'n' }, 2,
                               new Character[] { 'n' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'o' }, 2,
                               new Character[] { 'o' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'p' }, 2,
                               new Character[] { 'p' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'q' }, 2,
                               new Character[] { 'q' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'r' }, 2,
                               new Character[] { 'r' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 's' }, 2,
                               new Character[] { 's' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 't' }, 2,
                               new Character[] { 't' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'u' }, 2,
                               new Character[] { 'u' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'v' }, 2,
                               new Character[] { 'v' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'w' }, 2,
                               new Character[] { 'w' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'x' }, 2,
                               new Character[] { 'x' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'y' }, 2,
                               new Character[] { 'y' },
                               new Movement[] { Movement.Right }),
                new Transition(0,
                               new Character[] { 'z' }, 2,
                               new Character[] { 'z' },
                               new Movement[] { Movement.Right }),
                new Transition(2,
                               new Character[] { null }, 1,
                               new Character[] { null },
                               new Movement[] { Movement.Stay })
            }
        );

        return m;
    }

    // kopiere band 1 nach band 2 und prüfe (alphabet 0, 1)
    public static TuringMachine tm3() {
        TuringMachine m = factory.createTuringMachine(2,
            new Transition[] {
                new Transition(0,
                               new Character[] { '1', null }, 0,
                               new Character[] { '1', '1' },
                               new Movement[] { Movement.Right, Movement.Right }),
                new Transition(0,
                               new Character[] { '0', null }, 0,
                               new Character[] { '0', '0' },
                               new Movement[] { Movement.Right, Movement.Right }),
                new Transition(0,
                               new Character[] { null, null }, 2,
                               new Character[] { null, null },
                               new Movement[] { Movement.Left, Movement.Left }),
                new Transition(2,
                               new Character[] { '1', '1' }, 2,
                               new Character[] { '1', '1' },
                               new Movement[] { Movement.Left, Movement.Left }),
                new Transition(2,
                               new Character[] { '0', '0' }, 2,
                               new Character[] { '0', '0' },
                               new Movement[] { Movement.Left, Movement.Left }),
                new Transition(2,
                               new Character[] { null, null }, 1,
                               new Character[] { null, null },
                               new Movement[] { Movement.Right, Movement.Right })
            }
        );

        return m;
    }

    @Test
    public void testConstruction() {

	    TuringMachine tm = tm1();

	    assertEquals(1, tm.getNumberOfTapes());
	    assertEquals(1, tm.getTransition(0, new Character[] { null }).toState);
	    assertEquals(null, tm.getTransition(0, new Character[] { null }).write[0]);
	    assertEquals(Movement.Stay, tm.getTransition(0, new Character[] { null }).move[0]);
    }

    @Test
    public void testComputationSanity1() {

	    TuringMachine m = tm1();
	    TuringMachineComputation c = factory.initializeComputation(m, new Character[] { });

	    assertEquals(0, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);

	    c.step();

            assertEquals(1, c.getCurrentState());
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);

	    c = factory.initializeComputation(m, new Character[] { 'a' });

	    assertEquals(0, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('a'), c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);

	    c.step();

	    assertEquals(false, c.isInHaltingState());
	    assertEquals(true, c.isInErrorState());
    }

    @Test
    public void testComputationSanity2() {

	    TuringMachine m = tm2();
	    TuringMachineComputation c = factory.initializeComputation(m, new Character[] { });

	    assertEquals(0, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);

	    c.step();

	    assertEquals(false, c.isInHaltingState());
	    assertEquals(true, c.isInErrorState());

	    c = factory.initializeComputation(m, new Character[] { 'a' });

	    assertEquals(0, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('a'), c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);

	    c.step();

	    assertEquals(2, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(1, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('a'), c.getCurrentTapeContent(0).leftOfHead[0]);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);

	    c.step();

	    assertEquals(1, c.getCurrentState());
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(1, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('a'), c.getCurrentTapeContent(0).leftOfHead[0]);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);

	    c = factory.initializeComputation(m, new Character[] { 'a', 'a' });

	    assertEquals(0, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('a'), c.getCurrentTapeContent(0).belowHead);
	    assertEquals(1, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(Character.valueOf('a'), c.getCurrentTapeContent(0).rightOfHead[0]);

	    c.step();

	    assertEquals(2, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(1, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('a'), c.getCurrentTapeContent(0).leftOfHead[0]);
	    assertEquals(Character.valueOf('a'), c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);

	    c.step();

	    assertEquals(false, c.isInHaltingState());
	    assertEquals(true, c.isInErrorState());
    }

    @Test
    public void testComputationSanity3() {

	    TuringMachine m = tm3();
	    TuringMachineComputation c = factory.initializeComputation(m, new Character[] { });

	    assertEquals(0, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(0, c.getCurrentTapeContent(1).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(1).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(1).rightOfHead.length);

	    c.step();

	    assertEquals(2, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(0, c.getCurrentTapeContent(1).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(1).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(1).rightOfHead.length);

	    c.step();

	    assertEquals(1, c.getCurrentState());
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(0, c.getCurrentTapeContent(1).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(1).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(1).rightOfHead.length);

	    c = factory.initializeComputation(m, new Character[] { '0' });

	    assertEquals(0, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('0'), c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(0, c.getCurrentTapeContent(1).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(1).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(1).rightOfHead.length);

	    c.step();

	    assertEquals(0, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(1, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('0'), c.getCurrentTapeContent(0).leftOfHead[0]);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(1, c.getCurrentTapeContent(1).leftOfHead.length);
	    assertEquals(Character.valueOf('0'), c.getCurrentTapeContent(1).leftOfHead[0]);
	    assertEquals(null, c.getCurrentTapeContent(1).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(1).rightOfHead.length);

	    c.step();

	    assertEquals(2, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('0'), c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(0, c.getCurrentTapeContent(1).leftOfHead.length);
	    assertEquals(Character.valueOf('0'), c.getCurrentTapeContent(1).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(1).rightOfHead.length);

	    c.step();

	    assertEquals(2, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(0).belowHead);
	    assertEquals(1, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(Character.valueOf('0'), c.getCurrentTapeContent(0).rightOfHead[0]);
	    assertEquals(0, c.getCurrentTapeContent(1).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(1).belowHead);
	    assertEquals(1, c.getCurrentTapeContent(1).rightOfHead.length);
	    assertEquals(Character.valueOf('0'), c.getCurrentTapeContent(1).rightOfHead[0]);

	    c.step();

	    assertEquals(1, c.getCurrentState());
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('0'), c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(0, c.getCurrentTapeContent(1).leftOfHead.length);
	    assertEquals(Character.valueOf('0'), c.getCurrentTapeContent(1).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(1).rightOfHead.length);

	    c = factory.initializeComputation(m, new Character[] { 'a' });

	    assertEquals(0, c.getCurrentState());
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
	    assertEquals(0, c.getCurrentTapeContent(0).leftOfHead.length);
	    assertEquals(Character.valueOf('a'), c.getCurrentTapeContent(0).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(0).rightOfHead.length);
	    assertEquals(0, c.getCurrentTapeContent(1).leftOfHead.length);
	    assertEquals(null, c.getCurrentTapeContent(1).belowHead);
	    assertEquals(0, c.getCurrentTapeContent(1).rightOfHead.length);

	    c.step();

	    assertEquals(false, c.isInHaltingState());
	    assertEquals(true, c.isInErrorState());
    }


    @Test
    public void testToSingleTape() {

	    TuringMachine m = tm3();
	    TuringMachine stdm = factory.createTuringMachine(1, factory.toSingleTapeMachine(m));

	    TuringMachineComputation c = factory.initializeComputation(m, new Character[] { });
	    TuringMachineComputation stdc = factory.initializeComputation(stdm, new Character[] { });

	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    while(!stdc.isInHaltingState() && !stdc.isInErrorState()) stdc.step();

	    assertEquals(c.isInHaltingState(), stdc.isInHaltingState());
	    assertEquals(c.isInErrorState(), stdc.isInErrorState());

	    c = factory.initializeComputation(m, new Character[] { '0' });
	    stdc = factory.initializeComputation(stdm, new Character[] { '0' });

	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    while(!stdc.isInHaltingState() && !stdc.isInErrorState()) stdc.step();

	    assertEquals(c.isInHaltingState(), stdc.isInHaltingState());
	    assertEquals(c.isInErrorState(), stdc.isInErrorState());

	    c = factory.initializeComputation(m, new Character[] { 'a' });
	    stdc = factory.initializeComputation(stdm, new Character[] { 'a' });

	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    while(!stdc.isInHaltingState() && !stdc.isInErrorState()) stdc.step();

	    assertEquals(c.isInHaltingState(), stdc.isInHaltingState());
	    assertEquals(c.isInErrorState(), stdc.isInErrorState());
    }

    @Test
    public void testLastThree() {

	String[] mn = factory.matriculationNumbers();
	char d[][] = new char[3][3];
	d[2][0] = d[1][0] = d[0][0] = mn[0].toCharArray()[mn[0].length()-1];
        d[2][1] = d[1][1] = d[0][1] = mn[0].toCharArray()[mn[0].length()-2];
	d[2][2] = d[1][2] = d[0][2] = mn[0].toCharArray()[mn[0].length()-3];
	if(mn.length > 1) {
	    d[1][0] = mn[1].toCharArray()[mn[1].length()-1];
	    d[1][1] = mn[1].toCharArray()[mn[1].length()-2];
	    d[1][2] = mn[1].toCharArray()[mn[1].length()-3];
	}
	if(mn.length > 2) {
	    d[2][0] = mn[2].toCharArray()[mn[2].length()-1];
	    d[2][1] = mn[2].toCharArray()[mn[2].length()-2];
	    d[2][2] = mn[2].toCharArray()[mn[2].length()-3];
	}

	// random tests
	for(int i = 0; i < 100; ++i) {
	    int n = rand.nextInt(0, 3);
	    int length = rand.nextInt(3, 8);
	    
	    // erstelle X^nY^nZ^n 
	    Character[] input = new Character[3*length];
	    for(int digit = 0; digit < 3; ++digit)
		for(int j = 0; j < length; ++j)
		    input[digit*length + j] = Character.valueOf(d[n][digit]);

	    // teste auf Akzeptanz
	    TuringMachine m = factory.createTuringMachine(1, factory.lastThree());
	    TuringMachineComputation c = factory.initializeComputation(m, input);

	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());

	    // teste falschen Input auf Verwerfen
	    input[input.length - 1] = Character.valueOf('a');
	    c = factory.initializeComputation(m, input);

	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(true, c.isInErrorState());
	}
    }

    @Test
    public void testLarger() {

	    Character[] input1 = "0 0".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
	    Character[] input2 = "0 1".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
	    Character[] input3 = "1 0".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
	    Character[] input4 = "100 011".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
	    Character[] input5 = "100 11".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
	    Character[] input6 = "11 010".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
	    Character[] input7 = "010 11".chars().mapToObj(c -> (char)c).toArray(Character[]::new);

	    TuringMachine m = factory.createTuringMachine(2, factory.larger());

	    TuringMachineComputation c = factory.initializeComputation(m, input1);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(true, c.isInErrorState());

	    c = factory.initializeComputation(m, input2);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(true, c.isInErrorState());

	    c = factory.initializeComputation(m, input3);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());

	    c = factory.initializeComputation(m, input4);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());

	    c = factory.initializeComputation(m, input5);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());

	    c = factory.initializeComputation(m, input5);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());

	    c = factory.initializeComputation(m, input6);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());

	    c = factory.initializeComputation(m, input7);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(true, c.isInErrorState());
    }

    @Test
    public void testHasPath1() {

	    Character[] input = "0100001000010000".chars().mapToObj(c -> (char)c).toArray(Character[]::new);

	    TuringMachine m = factory.createTuringMachine(2, factory.hasPath());
	    TuringMachineComputation c = factory.initializeComputation(m, input);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(true, c.isInHaltingState());
	    assertEquals(false, c.isInErrorState());
    }

    @Test
    public void testHasPath2() {

	    Character[] input = "0100001010000000".chars().mapToObj(c -> (char)c).toArray(Character[]::new);

	    TuringMachine m = factory.createTuringMachine(2, factory.hasPath());
	    TuringMachineComputation c = factory.initializeComputation(m, input);
	    while(!c.isInHaltingState() && !c.isInErrorState()) c.step();
	    assertEquals(false, c.isInHaltingState());
	    assertEquals(true, c.isInErrorState());
    }
}
