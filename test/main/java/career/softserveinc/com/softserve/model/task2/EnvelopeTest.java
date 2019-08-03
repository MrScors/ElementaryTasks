package main.java.career.softserveinc.com.softserve.model.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopeTest {

    @Test
    void compareToTestEnvelope1IsBigger() {
        Envelope envelope1 = new Envelope(5.6, 2.2);
        Envelope envelope2 = new Envelope(2.1, 4.3);
        int actual = envelope1.compareTo(envelope2);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void compareToTestEnvelope2IsBigger() {
        Envelope envelope1 = new Envelope(4.3, 2.1);
        Envelope envelope2 = new Envelope(2.2, 5.6);
        int actual = envelope1.compareTo(envelope2);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void compareToTestEnvelopesAreSame() {
        Envelope envelope1 = new Envelope(5.6, 2.2);
        Envelope envelope2 = new Envelope(2.2, 5.6);
        int actual = envelope1.compareTo(envelope2);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void compareToTestEnvelopesDoesNotMatch() {
        Envelope envelope1 = new Envelope(5.6, 2.1);
        Envelope envelope2 = new Envelope(2.2, 4.3);
        int actual = envelope1.compareTo(envelope2);
        int expected = 0;
        assertEquals(expected, actual);
    }
}