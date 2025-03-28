import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.management.RuntimeErrorException;

public class Main {
    public static void main(String[] args) {
        test();
        
 
    }

    //dessa maneira fica a cargo do método na main tratar a excessão
    private static void teste() throws FileNotFoundException{
        var stream = new FileOutputStream(" ");
    }

    //tipo de erro runtime
    private static void teste2(){
        System.out.println(10/0); //vem da RUNTIMEEXCEPTION -> EM TEMPO DE EXECUÇÃO QUE OCORRE
    }
    private static void teste3(){
        throw new RuntimeException();
    }


    //Throwable
    private static void teste4(){
        new Throwable(); /*pai de excessões e de erros*/
        new Exception();/*excessões*/                  new Error(); /*errors*/                                                  
        new RuntimeException();/*unchecked*/  new FileNotFoundException();/*checkeds */   new OutOfMemoryError(); /*erros*/ 
    }



}
