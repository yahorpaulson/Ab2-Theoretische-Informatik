package ab2;

import java.util.Arrays;

/**
 * Interface zur Implementierung einer Turingmaschine wie folgt:
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
public interface TuringMachine {

    /**
     * Bewegerichtungen des Schreib/Lese-Kopfes
     */
    public enum Movement {
        /**
         * Kopf bewegt sich nach links
         */
        Left,

        /**
         * Kopf bewegt sich nach rechts
         **/
        Right,

        /**
         * Kopf bewegt sich nicht
         */
        Stay
    }

    /**
     * Ein Übergang der Turingmaschine
     */
    public final class Transition {

        /** Ausgangszustand des Übergangs */
        public final int fromState;
        /** Zu lesende Zeichen pro Band */
        public final Character[] read;
        /** Folgezustand des Übergangs */
        public final int toState;
        /** Zu schreibende Zeichen pro Band */
        public final Character[] write;
        /** Kopf-Bewegungen pro Band */
        public final Movement[] move;

        /**
         * Erzeugt einen neuen Übergang
         *
         * @param fromState Der Ausgangszustand, in dem der Übergang anwendbar ist
         * @param read Array mit den zu lesenden Zeichen pro Band
         * @param toState Der Folgezustand, wenn der Übergang ausgeführt wurde
         * @param write Array mit den zu schreibenden Zeichen pro Band
         * @param move Array mit den Kopf-Bewegungen pro Band
         */
        public Transition(int fromState, Character[] read, int toState, Character[] write, Movement[] move) {
            this.fromState = fromState;
            this.read = read;
            this.toState = toState;
            this.write = write;
            this.move = move;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("From State: ").append(fromState)
              .append(", Read: ").append(Arrays.toString(read))
              .append(", To State: ").append(toState)
              .append(", Write: ").append(Arrays.toString(write))
              .append(", Move: ").append(Arrays.toString(move));
            return sb.toString();
        }
    }

    /**
     * Liefert die Anzahl an Bändern zurück.
     *
     * @return Anzahl der Bänder
     */
    public int getNumberOfTapes();

    /**
     * Liefert alle Übergänge der Turingmaschine zurück.
     *
     * @return Array mit allen Übergängen
     */
    public Transition[] getTransitions();

    /**
     * Liefert den Übergang für den angegebenen Zustand und die gelesenen
     * Zeichen zurück. Implementieren Sie diese Methode so, dass die Laufzeit
     * (amortisiert) in O(1) liegt.
     *
     * @param fromState Der Ausgangszustand, in dem der Übergang anwendbar ist
     * @param read Array mit den zu lesenden Zeichen pro Band
     * @return Der gefundene Übergang oder null, wenn kein Übergang existiert
     *
     * @throws IllegalArgumentException wenn read null ist oder die Länge
     *         von read nicht der Anzahl der Bänder entspricht
     */
    public Transition getTransition(int fromState, Character[] read);
}
