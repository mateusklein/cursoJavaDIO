package com.dio.springboot.springbeans;

public class Carro implements Veiculo {
    

    @Override
    public void acao() {
        System.out.println("É um carro");
    }
}
