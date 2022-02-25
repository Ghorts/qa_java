package com.example;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;

    @Test
    public void getKittensShowsOne() throws Exception {
        int expected = 1;
        Lion lion = new Lion("Самец", feline);

        Mockito.when(feline.getKittens()).thenReturn(1);

        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }


    @Test
    public void getFoodReturnListOfPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самец", feline);

        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);

        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testLionConstructorException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion("Небинарный", feline);
    }
}