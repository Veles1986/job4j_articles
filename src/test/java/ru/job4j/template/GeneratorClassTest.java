package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GeneratorClassTest {
    @Test
    void whenKeyInTemplateOrInMapDoNotExist() {
        Generator generator = new GeneratorClass();
        String template = "I am a ${surname}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        assertThatThrownBy(() -> {
            generator.produce(template, args);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}