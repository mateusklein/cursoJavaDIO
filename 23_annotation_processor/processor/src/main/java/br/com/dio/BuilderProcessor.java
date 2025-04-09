package br.com.dio;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@SupportedAnnotationTypes("br.com.dio.Builder")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
@AutoService(Processor.class) //METODO2 -> LIB DO GOOGLE
public class BuilderProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(var annotation : annotations) {
            for(var element : roundEnv.getElementsAnnotatedWith(annotation)) {
                Map<String, TypeMirror> fields = element.getEnclosedElements().stream()
                        .filter(e -> e.getKind() == ElementKind.FIELD)
                        .collect(Collectors.toMap(e -> e.getSimpleName().toString(), Element::asType));
                var packageName = processingEnv.getElementUtils().getPackageOf(element).toString();
                var className = element.getSimpleName().toString();
                var builderName = className + "Builder";

                var typeSpec = new BuilderGenerator().create(packageName, className, builderName, fields);
                var javaFile = JavaFile.builder(packageName, typeSpec)
                        .indent("    ")
                        .build();

                try(
                        var out = new PrintWriter(processingEnv.getFiler()
                                .createSourceFile(builderName)
                                .openWriter())
                ){
                    out.write(javaFile.toString());
                }catch (IOException ex){
                    throw new RuntimeException(ex);
                }

            }

        }
        return true;
    }

}
