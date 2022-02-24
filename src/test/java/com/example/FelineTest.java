package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void eatMeatReturnListOfPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Feline feline = new Feline();

        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);

    }

    @Test
    public void getFamilyReturnsKoshachyi() {
        String expected = "Кошачьи";
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensReturns1() {
        int expected = 1;
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensFiveAmountReturnsFive() {
        int expected = 5;
        Feline feline = new Feline();
        int actual = feline.getKittens(5);
        assertEquals(expected, actual);
    }
}