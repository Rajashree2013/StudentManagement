package se.lexicon.rajashree.sequencer;

public class StudentIdSequencer {
    private static int sequencer = 0;
    public static int nextId(){
        return ++sequencer;
    }
}
