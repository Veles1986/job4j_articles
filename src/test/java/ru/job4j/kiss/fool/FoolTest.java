package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoolTest {
    @Test
    public void when12ThenFizz() {
        String excepted = "Fizz";
        int input = 12;
        String result = Fool.returnText(input);
        assertThat(result).isEqualTo(excepted);
    }

    @Test
    public void when10ThenBuzz() {
        String excepted = "Buzz";
        int input = 10;
        String result = Fool.returnText(input);
        assertThat(result).isEqualTo(excepted);
    }

    @Test
    public void when15ThenFizzBuzz() {
        String excepted = "FizzBuzz";
        int input = 15;
        String result = Fool.returnText(input);
        assertThat(result).isEqualTo(excepted);
    }

    @Test
    public void when17Then17() {
        String excepted = String.valueOf(17);
        int input = 17;
        String result = Fool.returnText(input);
        assertThat(result).isEqualTo(excepted);
    }
}