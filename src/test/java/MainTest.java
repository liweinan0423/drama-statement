import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        Main.main(new String[]{});

        String expected = "Statement for RigCo\n" +
                " Hamlet: $650 (55 seats)\n" +
                " As You Like It: $580 (35 seats)\n" +
                " Othello: $500 (40 seats)\n" +
                "Amount owed is $1730\n" +
                "You earned 47 credits\n" +
                "\n";
        assertEquals(expected, buffer.toString());
    }
}