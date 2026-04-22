import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LionTest {

    @Test(expected = Exception.class)
    public void invalidSexShouldThrowException() throws Exception {
        new Lion("Другое", new Feline());
               }

    @Test
    public void getKittensWithMockFelineReturnsExpectedValue() throws Exception{
        Feline mockFeline = Mockito.mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(5);
           Lion lion = new Lion("Самец", mockFeline);
            int actualKittens = lion.getKittens();
            assertEquals("Количество котят должно совпадать", 5, actualKittens);
                }

    @Test
    public void getFoodShouldReturnFelineFood() throws Exception{
        Feline mockFeline = Mockito.mock(Feline.class);
        List<String> expectedFood = Arrays.asList("мясо", "рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", mockFeline);
        List<String> actualFood = lion.getFood();

        assertEquals("Список продуктов должен совпадать с тем, что вернула Feline", actualFood, expectedFood);
        verify(mockFeline).getFood("Хищник"); // Проверяем вызов метода
    }
}
