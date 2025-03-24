/*
2 - Escreva um código que receba entradas sem formatação e as retorne formatadas, os tipos de entradas que o código deve retornar 
são as seguintes:

- Telefone fixo (8 dígitos sem DDD xxxx-xxxx, 10 Dígitos com DDD (xx)xxxx-xxxx);
- Celular (9 dígitos sem DDD xxxxx-xxxx, 11 dígitos (xx)xxxxx-xxxx);

O código deve ser capaz de detectar as seguintes situações:

- Se receber somente números detectar se corresponde com algum dos formatos aceitos e retornar formatado;
- Se receber uma entrada com quantidade de números diferentes dos padrões descritos acima, informar que não se trata de um número válido;
- Se receber um número formatado, retorna-lo do mesmo jeito e informar de qual tipo de dispositivo se trata;
- Se receber com mascara incorreta, corrigir e retornar
- Se receber qualquer entrada que tenha números e outros caracteres verificar se tem números para compor um dos tipos aceitos e retornar do que se trata ou retornar que foi uma entrada inválida.  
*/


import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class main {

    public static String removeCarac(String input) {
        if (input == null || input.isEmpty()) {
            return input; 
        }
        
        return input.replaceAll("[^0-9]", ""); 
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o número:");
        var num = scanner.next();
        num = removeCarac(num);

        /* 
         * Telefone fixo (8 dígitos sem DDD xxxx-xxxx, 10 Dígitos com DDD (xx)xxxx-xxxx);
         * Celular (9 dígitos sem DDD xxxxx-xxxx, 11 dígitos (xx)xxxxx-xxxx);
         * deve ter no mínimo 8 dígitos e no máximo 14 (número já formatado)
        */


        if(num.length() == 8){
            System.out.println("TELEFONE");
            StringBuilder sb = new StringBuilder(num);
            sb.insert(4, "-");
            System.out.println("Numero apos formatar: " + sb);
        }else if(num.length() == 9){
            if(num.charAt(0) != '9'){
                System.out.println("Número não corresponde aos padrões, para um celular precisa ter 9 na posicao 1");
                
            }else{
                System.out.println("CELULAR");
                StringBuilder sb = new StringBuilder(num);
                sb.insert(5, "-");
                System.out.println("Numero apos formatar: " + sb);
            }
        }else if(num.length() == 10){
            System.out.println("TELEFONE");
            StringBuilder sb = new StringBuilder(num);
            sb.insert(0, "(");
            sb.insert(3, ")");
            sb.insert(8, "-");
            System.out.println("Numero apos formatar: " + sb);
        }else if(num.length() == 11){
            if(num.charAt(2) != '9'){
                System.out.println("Número não corresponde aos padrões, para um celular precisa ter 9 na posicao 3");
            }else{
                System.out.println("CELULAR");
                StringBuilder sb = new StringBuilder(num);
                sb.insert(0, "(");
                sb.insert(3, ")");
                sb.insert(9, "-");
                System.out.println("Numero apos formatar: " + sb);
            }
        }else{
            System.out.println("Número não corresponde aos padrões");
        }

    }
}
