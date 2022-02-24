package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final Boolean hasMane;
    @Mock
    private Feline feline;

    public LionTest(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensShowsOne() throws Exception {
        int expected = 1;
        Lion lion = new Lion("Самец", feline);

        Mockito.when(feline.getKittens()).thenReturn(1);

        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveManeSexMaleShowsTrueSexFemaleShowsFalse() throws Exception {
        Lion lion = new Lion(sex, feline);
        Boolean actual = lion.doesHaveMane();
        assertEquals(hasMane, actual);
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void getFoodReturnListOfPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самец", feline);

        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);

        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
}