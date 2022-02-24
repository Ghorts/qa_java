package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;


    @Test
    public void getSoundReturnsMeow() {
        String expected = "Мяу";
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals(actual, expected);
    }

    @Test
    public void getFoodReturnListOfPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(expected);

        List<String> actual = cat.getFood();
        assertEquals(expected, actual);
    }
}