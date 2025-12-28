package ab2;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Eine Berechnung einer Turingmaschine
 */
public interface TuringMachineComputation {

    /**
     * Konfiguration eines Bandes samt Schreib-/Lesekopf der Turingmaschine
     */
    public class TapeContent {

        /**
         * Alle Zeichen auf dem Band vom ersten vom Leerzeichen verschiedenen
         * Zeichen bis zur Stelle links vom Kopf (kann leer sein).
         */
        public final Character[] leftOfHead;

        /**
         * Das Zeichen, das sich aktuell unter dem Kopf befindet.
         */
        public final Character belowHead;

        /**
         * Alle Zeichen von der Stelle rechts vom Kopf bis zum letzten vom
         * Leerzeichen verschiedenen Zeichen (kann leer sein).
         */
        public final Character[] rightOfHead;

        /**
         * Erstellt eine neue Bandkonfiguration
         *
         * @param leftOfHead Alle Zeichen links vom Kopf
         * @param belowHead Zeichen unter dem Kopf
         * @param rightOfHead Alle Zeichen rechts vom Kopf
         */
        public TapeContent(Character[] leftOfHead, Character belowHead, Character[] rightOfHead) {
            this.leftOfHead = leftOfHead;
            this.belowHead = belowHead;
            this.rightOfHead = rightOfHead;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof TapeContent) {
            TapeContent tc = (TapeContent) obj;
            if (belowHead != tc.belowHead) return false;
            if (!Arrays.equals(leftOfHead, tc.leftOfHead)) return false;
            if (!Arrays.equals(rightOfHead, tc.rightOfHead)) return false;
            return true;
            } else {
            return false;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BEGIN:>")
              .append(Arrays.toString(leftOfHead))
              .append("[").append(belowHead).append("]")
              .append(Arrays.toString(rightOfHead))
              .append("<:END");
            return sb.toString();
        }
    }

    /**
     * Liefert die Turingmaschine zurück, auf der diese Berechnung basiert.
     *
     * @return die zugrundeliegende Turingmaschine
     */
    public TuringMachine getTuringMachine();

    /**
     * Führt einen Ableitungsschritt der Turingmaschine aus. Ist kein
     * passender Übergang in der Übergangsfunktion vorhanden, so befindet sich
     * die Maschine nach dem Schritt im Fehlerzustand (= nichtakzeptierender
     * Haltezustand, der aber nicht als tatsächlicher Zustand in der Maschine
     * vorkommt).
     *
     * @throws IllegalStateException
     *             Wird geworfen, wenn die Maschine bereits im Haltezustand
     *             oder Fehlerzustand ist.
     */
    public void step() throws IllegalStateException;

    /**
     * Liefert den aktuellen Zustand der Turingmaschine zurück.
     *
     * @return aktueller Zustand
     *
     * @throws IllegalStateException
     *             Wird geworfen, wenn die Maschine im Fehlerzustand ist.
     */
    public int getCurrentState() throws IllegalStateException;

    /**
     * Liefert true, wenn die Maschine im Haltezustand ist; sonst false
     */
    public boolean isInHaltingState();

    /**
     * Liefert true, wenn die Maschine im Fehlerzustand ist; sonst false
     */
    public boolean isInErrorState();

    /**
     * Liefert den Inhalt des angegebenen Bandes zurück.
     *
     * @param tapeIndex Index des Bandes
     * @return Inhalt des Bandes
     *
     * @throws IndexOutOfBoundsException
     *             Wird geworfen, wenn der angegebene Bandindex größer oder
     *             gleich der Anzahl der Bänder der Turingmaschine ist.
     */
    public TapeContent getCurrentTapeContent(int tapeIndex);
}
