import java.util.*;
/**
 * class deck to create a playing card with facevalue and suitvalue.
 * @author Ankith.
 */
class Deck implements Comparable<Deck> {
	int faceValue;
	int suitValue;

	/**
	 * constructor for deck class.
	 * @param suitValue the suitvalue of the card.
	 * @param faceValue the facevalue of the card.
	 */
	Deck (int suitValue, int faceValue) {
		this.suitValue = suitValue;
		this.faceValue = faceValue;
	}

	/**
	 * compare to method to compare the deck objects to sort.
	 * @param that the deck which is to be consider.
	 * @return integer 1, 0, -1.
	 * Constant complexity.
	 */
	public int compareTo (Deck that) {
		if (this.suitValue > that.suitValue) return 1;
		else if (this.suitValue < that.suitValue) return -1;
		else {
			if (this.faceValue > that.faceValue) return 1;
			return -1;
		}
	}
	/**
	 * toString method to dispaly the output.
	 */
	public String toString () {
		String sval = "";
		String fval = "";
		if (this.suitValue == 1) {
			sval = "spades";
		} else if (this.suitValue == 2) {
			sval = "hearts";
		} else if (this.suitValue == 3) {
			sval = "clubs";
		} else if (this.suitValue == 4) {
			sval = "diamonds";
		}

		if (this.faceValue == 1) {
			fval = "A";
		} else if (this.faceValue == 11) {
			fval = "J";
		} else if (this.faceValue == 12) {
			fval = "Q";
		} else if (this.faceValue == 13) {
			fval = "K";
		} else {
			fval += this.faceValue;
		}
		return sval + " " + fval;
	}
}