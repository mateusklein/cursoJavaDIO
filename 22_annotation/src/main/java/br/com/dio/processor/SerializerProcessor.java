package br.com.dio.processor;


import br.com.dio.annotation.SerializerMethod;
import br.com.dio.annotation.SerializerType;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerializerProcessor {
    public String serializer(final Object object) throws IllegalAccessException, InvocationTargetException {
        Objects.requireNonNull(object, "Enter with non-null object");
        var clazz = object.getClass();
        var typeAnnotation = Stream.of(clazz.getAnnotations())
                .filter(SerializerType.class::isInstance)
                .map(SerializerType.class::cast)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("For serialize object annotate ir with @SerializerType"));

        var fieldNameFormatter = typeAnnotation.fieldFormat().getFormat();
        var prettify = typeAnnotation.prettify();

        Map<String, Object> elements = new HashMap<>();
        for(var field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            elements.put(field.getName(), field.get(object));
        }

        var annotatedMethods = Stream.of(clazz.getDeclaredMethods())
                .filter(m -> Stream.of(m.getAnnotations()).anyMatch(a -> a.annotationType().equals(SerializerMethod.class)))
                .toList();

        for(var method : annotatedMethods){
            method.setAccessible(true);
            var customName = method.getAnnotation(SerializerMethod.class).value();
            elements.put(customName.isBlank() ? method.getName() : customName, method.invoke(object));
        }

        var jsonFields = elements.entrySet().stream()
                .map(e -> String.format(
                        "    \"%s\":%s", fieldNameFormatter.apply(e.getKey()),
                        formatValue(e.getValue())
                ))
                .collect(Collectors.joining(String.format(",%s", System.lineSeparator())));

        var json = String.format("{%s%s%s}",
                System.lineSeparator(),
                jsonFields,
                System.lineSeparator()
        );

        return prettify ? json : json.replaceAll(System.lineSeparator(), "").replaceAll("    ", "");
    }

    private String formatValue(final Object value){
        return value instanceof String s ? String.format("\"%s\"", s) : value.toString();
    }

}
