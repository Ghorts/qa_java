package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestWithParameters {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;
    private final String sex;
    private final Boolean hasMane;

    public LionTestWithParameters(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;

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
}
