import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HasManeTest {
    private final String sex;
    private final boolean expectedHasMane;

    public HasManeTest(String sex, boolean expectedHasMane){
        this.sex= sex;
        this.expectedHasMane = expectedHasMane;
    }
    @Parameterized.Parameters
    public static Object[][] Data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }
  @Test
  public void PresenceMane() throws Exception{
      Feline feline = new Feline();
      Lion lion = new Lion(sex, feline);
            assertEquals("Грива для пола '" + sex + "'", expectedHasMane, lion.doesHaveMane());
  }
    }







