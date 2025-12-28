package ab2;

import ab2.TuringMachine;
import ab2.TuringMachine.Transition;

public interface  Ab2 {

	/** Diese Methode liefert ein String-Array der Länge 1, 2, oder 3, in
	 * dem die Matrikelnummern der Gruppenmitglieder enthalten sind.
	 *
	 * @return String-Array mit Matrikelnummern
	 */
	public String[] matriculationNumbers();

	/**
	 * Erstellen Sie eine Turingmaschine mit den gegebenen Übergängen und
	 * der angegebenen Anzahl an Bändern.
	 *
	 * - Deterministisch
	 * - Mehrere Schreib-/Lese-Bänder (mindestens 1)
	 * - Fixes Alphabet (java.Character), wobei das Leerzeichen durch null
	 *   repräsentiert wird
	 * - Zustände implizit durch Übergangsfunktion definiert
	 * - Zustand 0 ist der Startzustand
	 * - Zustand 1 ist der (akzeptierende) Haltezustand
	 * - Kein expliziter verwerfender Haltezustand (Fehlerzustand)
	 */
	public TuringMachine createTuringMachine(int numberOfTapes, Transition[] transitions);

	/**
	 * Initialisiert eine Berechnung der gegebenen Turingmaschine mit dem
	 * angegebenen Eingabewort auf dem ersten Band (alle anderen Bänder sind
	 * leer).
	 *
	 * @param tm die Turingmaschine
	 * @param input das Eingabewort auf dem ersten Band
	 * @return die initialisierte Berechnungs-Instanz
	 */
	public TuringMachineComputation initializeComputation(TuringMachine tm, Character[] input);

	/**
	 * Wandelt eine gegebene Zweiband-Turingmaschine in eine äquivalente
	 * Standard-Turingmaschine (also mit einem Band) um. Die gegebene
	 * Zweibandmaschine verwendet das Zeichen '#' nicht. Verwenden Sie dieses
	 * Zeichen '#' als Trennzeichen zwischen den Inhalten der beiden Bänder in
	 * der Simulation auf dem Band der Standard-Turingmaschine.
	 *
	 * @param twoTapeMachine die 2-Band Turingmaschine
	 * @return die Übergangsfunktion der äquivalente 1-Band Turingmaschine
	 */
	public Transition[] toSingleTapeMachine(TuringMachine twoTapeMachine);

	/**
	 * Erstellen Sie die Übergangsfunktion für eine Standard-Turingmaschine (mit
	 * einem Band), die alle Wörter der Form "X^nY^nZ^n" akzeptiert, wobei X, Y
	 * und Z die letzten drei Ziffern einer Ihrer Matrikelnummern sind
	 * (siehe matriculationNumbers()).
	 */
	public Transition[] lastThree();

	/**
	 * Erstellen Sie die Übergangsfunktion für eine Turingmaschine mit zwei
	 * Bändern, die als Input den String "num1 num2" erhält, wobei num1 und num2
	 * Zahlen in Binärdarstellung sind. Die Maschine soll akzeptieren, wenn num1
	 * größer als num2 ist, und sonst verwerfen. Die Zahlen sind durch ein
	 * ASCII-Leerzeichen (' ') getrennt.
	 */
	public Transition[] larger();

	/**
	 * Erstellen Sie eine Übergangsfunktion für eine Turingmaschine mit zwei
	 * Bändern, die bestimmt, ob es in einem gerichteten Graph mit vier Knoten
	 * einen Weg vom Knoten 1 zum Knoten 4 gibt. Die Turingmaschine erhält als
	 * Input ein Wort bestehend aus 16 1en oder 0en, die die vier Zeilen einer
	 * 4x4-Adjazenzmatrix eines Graphen repräsentieren. Die Maschine soll
	 * akzeptieren, wenn es einen Pfad von Knoten 1 zu Knoten 4 gibt, und
	 * verwerfen, wenn nicht.
	 *
	 * Sie können davon ausgehen, dass die Eingabe immer korrekt formatiert
	 * ist (also genau 16 Zeichen lang ist und nur aus 1en und 0en besteht).
	 *
	 * Hinweis: Eine Möglichkeit, dieses Problem zu lösen, ist die Breitensuche.
	 * Hierfür können die vier Bänder der Turingmaschine wie folgt benutzt
	 * werden:
	 * - Band 1: Eingabeband (Adjazenzmatrix)
	 * - Band 2: Potentieller Pfad von Knoten 1 zu Knoten 4
	 * Die Maschine würde also auf Band 2 iterativ alle möglichen Pfade von
	 * Knoten 1 zu Knoten 4 aufbauen und dann prüfen, ob diese gültig sind.
	 * Für Ersteres kann z.B. die TM aus Beispiel 7.1 der UE verwendet werden.
	 */
	public Transition[] hasPath();
}
