import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class KittensTest {

    private final int inputCount;

    public KittensTest(int inputCount) {
        this.inputCount = inputCount;
           }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0 },
                { 1 },
                { 2 },
                { 5 },
                { 10 },
        }) ;
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens(inputCount);
        assertEquals("Количество котят", inputCount, actual);
    }
}
