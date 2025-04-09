package org.example;

import br.com.dio.model.Person;
import br.com.dio.model.User;
import br.com.dio.processor.SerializerProcessor;

import java.lang.reflect.InvocationTargetException;
import java.security.InvalidAlgorithmParameterException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        var processor = new SerializerProcessor();
        System.out.println(processor.serializer(new Person(1L, "Joao da silva", 26)));
        System.out.println(processor.serializer(new User(2L, "Maria Silva", 39, 333.24)));
    }
}