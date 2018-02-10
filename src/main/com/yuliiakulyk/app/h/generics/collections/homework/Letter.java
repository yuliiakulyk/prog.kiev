package main.com.yuliiakulyk.app.h.generics.collections.homework;

import java.text.DecimalFormat;

/**
 * Created by Yuliia Kulyk on 10.02.2018.
 */
public class Letter implements Comparable {

    private Character character;
    private int repetitions;
    private int stringLength;
    private double relativeRepetitions;

    public Letter(Character character, int repetitions, int stringLength) {
        this.character = character;
        this.repetitions = repetitions;
        this.stringLength = stringLength;
        this.relativeRepetitions = (double) repetitions / (double) stringLength;
    }

    public Letter(Character character, int stringLength) {
        this.character = character;
        this.repetitions = 1;
        this.stringLength = stringLength;
        this.relativeRepetitions = 1.0 / (double)stringLength;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public double getRelativeRepetitions() {
        return relativeRepetitions;
    }

    public void setRelativeRepetitions(double relativeRepetitions) {
        this.relativeRepetitions = relativeRepetitions;
    }

    public Letter increaseRepetitionsBy1() {
        this.repetitions++;
        this.relativeRepetitions = (double) this.repetitions / (double) this.stringLength;
        return this;
    }


    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        Letter anotherLetter = (Letter) o;
        if (this.getRelativeRepetitions() > anotherLetter.getRelativeRepetitions()) {
            return -1;
        } else if(this.getRelativeRepetitions() < anotherLetter.getRelativeRepetitions()) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter letter = (Letter) o;

        return character.equals(letter.character);
    }

    @Override
    public int hashCode() {
        return character.hashCode();
    }

    @Override
    public String toString() {
        return "{'"
                + character +
                "', " //+ relativeRepetitions +
                + new DecimalFormat("#,###%").format(relativeRepetitions) +
                '}';
    }
}
