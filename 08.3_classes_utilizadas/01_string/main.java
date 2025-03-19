import java.time.OffsetDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        /* 
        var value = "java;java;java;java";

        var values = value.split(";");

        for (var v: values){
            System.out.println(v);
        }


        System.out.println(value.toUpperCase());
        System.out.println(value.toLowerCase());

        //indexOf(busca, comeco_intervalo, final_intervalo)
        System.out.println(value.indexOf("j", 1, 5));

        System.out.println(value.isEmpty());
        System.out.println(value.isBlank());



        var palavra = "   mateus     ";
        //elimina espaços em branco
        System.out.println(palavra.trim());


        System.out.println(palavra.substring(3, 5));


        var value3 = """
        {"name":"João", "age":18}""";
        
        value3 = value3.replace("{", "").replace("}","").replace("\"", "");
        var valueArr = value3.split(",");

        Map<String, String> map = new HashMap<>();

        for (var v: valueArr){
            var keyValue = v.split(":");
            map.put(keyValue[0], keyValue[1]);
        }

        System.out.println(map);
        


        String stringConcat = "value";
        stringConcat += "2";
        System.out.println(stringConcat);

        // Medindo tempo da concatenação ineficiente
        var stringStart = OffsetDateTime.now();
        for (int i = 0; i < 1_000_000; i++) {
            stringConcat += i;
        }
        var stringEnd = OffsetDateTime.now();
        System.out.println("Tempo (String concatenação): " + Duration.between(stringStart, stringEnd).toMillis() + "ms");

        // Medindo tempo do StringBuilder
        stringStart = OffsetDateTime.now();
        StringBuilder builderConcater = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            builderConcater.append(i);
        }
        stringEnd = OffsetDateTime.now();
        System.out.println("Tempo (StringBuilder - single-thread): " + Duration.between(stringStart, stringEnd).toMillis() + "ms");

        // Medindo tempo do StringBuffer
        stringStart = OffsetDateTime.now();
        StringBuffer bufferConcater = new StringBuffer();
        for (int i = 0; i < 1_000_000; i++) {
            bufferConcater.append(i);
        }
        stringEnd = OffsetDateTime.now();
        System.out.println("Tempo (StringBuffer - multithread): " + Duration.between(stringStart, stringEnd).toMillis() + "ms");
        */
        

        //OPERAÇÕES COM STRINGBUILDER
        var builder = new StringBuilder("12345678");
        System.out.println(builder.insert(5, "a"));
        System.out.println(builder.length());
        builder.setLength(5);
        System.out.println(builder);
    }
}
