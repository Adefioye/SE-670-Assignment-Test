package com.junit.test;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void WhenPerformToString_returnPersonObject(){

        Person person = new Person("Koko", 45);

        assertThat(person.toString()).isEqualTo("Person[name=Koko, age=45]");
    }
}
