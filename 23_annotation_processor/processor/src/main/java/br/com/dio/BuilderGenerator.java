package br.com.dio;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import java.util.Map;

public class BuilderGenerator {


    public TypeSpec create(String packageName, String className, String builderName, Map<String, TypeMirror> fields) {
        var generatedBuilderClass = TypeSpec.classBuilder(builderName)
                .addModifiers(Modifier.PUBLIC);

        fields.forEach((k , v) -> generatedBuilderClass.addField(TypeName.get(v), k, Modifier.PRIVATE));
        fields.forEach((k , v) -> generatedBuilderClass.addMethod(genBuilderSetter(packageName,
                builderName,
                k,
                TypeName.get(v)))
        );

        var buildMethod = MethodSpec.methodBuilder("build")
                .addModifiers(Modifier.PUBLIC)
                .returns(ClassName.get(packageName, className))
                .addStatement("var target = new $N()", className);

        fields.keySet().forEach(f  -> buildMethod.addStatement(
                "target.set$N($N)",
                f.substring(0,1).toUpperCase() + f.substring(1),
                f
        ));
        buildMethod.addStatement("return target");


        return generatedBuilderClass.addMethod(buildMethod.build())
                .build();
    }

    private MethodSpec genBuilderSetter(final String packageName, final String name,
                                        final String param, final TypeName type) {
        return MethodSpec.methodBuilder(param)
                .addModifiers(Modifier.PUBLIC)
                .returns(ClassName.get(packageName, name))
                .addParameter(type,param, Modifier.FINAL)
                .addStatement("this.$N = $N", param, param)
                .addStatement("return this")
                .build();
    }
}
