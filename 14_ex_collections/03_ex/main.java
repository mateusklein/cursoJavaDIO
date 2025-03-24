/*
 3 - Escreva um código que receba 3 valores separados por um caracter de sua escolha n vezes
( n é o número de vezes que o usuário desejar informar) ex.: nome;Lucas;Texto. Quando o usuário 
parar de informar valores o código deve retornar todos esses campos compondo um json, um xml e um yaml 
(Json: https://pt.wikipedia.org/wiki/JSON, XML: https://pt.wikipedia.org/wiki/XML, yaml: https://www.treinaweb.com.br/blog/o-que-e-yaml) as entradas devem seguir o seguinte padrão:

NOME_CAMPO;VALOR;TIPO;
Os tipos que devem ser aceitos são: texto, datas, data e hora, números inteiros, números com pontos flutuantes, boleanos,
array dos tipos anteriores ( opcional, possibilitar definir arrays de objetos e objetos internos).
*/

import java.util.*;
import java.text.SimpleDateFormat;

public class main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var opcao = -1;
        String valores;
        String json = "{\n  ";
        String[] valoresArray;
        while(opcao != 0){
            System.out.println("Informe os valores que serão usados separados por vírgula (ex:nome,Lucas,text):");
            System.out.println("Tipos que serão aceitos: TEXT, DATE, DATEHOUR, INT, FLOAT, BOOLEAN, LIST");
            valores = scanner.next();
            valoresArray = valores.split(",");
            while(valoresArray.length > 3 || !Tipos.isValidTipo(valoresArray[2].toUpperCase())){
                System.out.println("Tipo incorreto ou quantidade excedida");
                valores = scanner.next();
                valoresArray = valores.split(",");
            }
            var type = valoresArray[2].trim().toUpperCase();
            switch(type){
                case "TEXT":
                    json = json + "'" + valoresArray[0] + "':'" + valoresArray[1] + "'"; 
                    break;
                case "DATE":
                    json = json + "'" + valoresArray[0] + "':'" + valoresArray[1] + "'"; 
                    break;
                case "DATEHOUR":
                    json = json + "'" + valoresArray[0] + "':'" + valoresArray[1] + "'"; 
                    break;
                case "INT":
                    json = json + "'" + valoresArray[0] + "': " + Integer.parseInt(valoresArray[1]) + ""; 
                    break;
                case "FLOAT":
                    json = json + "'" + valoresArray[0] + "': " + Float.parseFloat(valoresArray[1]) + ""; 
                    break;
                case "BOOLEAN":
                    if(!valoresArray[1].equals("true") && !valoresArray[1].equals("false")){
                        System.out.println("Uma variável booleana só aceita true ou false, favor digite novamente a variável");
                        var proxElemento = scanner.next();
                        while(!proxElemento.equals("true") && !proxElemento.equals("false")){
                            System.out.println("Uma variável booleana só aceita true ou false, favor digite novamente a variável");
                            proxElemento = scanner.next();
                        }
                        valoresArray[1] = proxElemento;
                    }
                    json = json + "'" + valoresArray[0] + "':'" + valoresArray[1] + "'";
                    break;
                case "LIST":
                    json = json + "'" + valoresArray[0] + "':[" + valoresArray[1];
                    var add = 1;
                    while(add!=0){
                        System.out.println("Tem mais elementos na lista? digite 0 para não");
                        add = scanner.nextInt();
                        if(add != 0){
                            System.out.println("Digite então o proximo elemento:");
                            var proxElemento = scanner.next();
                            json = json + ", " + proxElemento;
                        }
                    }
                    json = json + "]";
                    break;


            }
            

            System.out.println("Deseja continuar? digite 0 para sair:");
            opcao = scanner.nextInt();
            if(opcao!=0){
                json = json + ",\n  ";
            }
        }
        json = json + "\n}";
        System.out.println(json);
    }
}
