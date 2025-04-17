package br.com.dio.Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Devs {
    private String name;
    private List<Content> registeredContents = new ArrayList<>();
    private List<Content> finishedContents = new ArrayList<>();

    public Devs(String name) {
        this.name = name;
    }

    public void registeredBootcamp(Bootcamp bootcamp) {
        this.registeredContents.addAll(bootcamp.getContents());
        bootcamp.getDevs().add(this);
    }

    public void progredir(){
        Optional<Content> content = this.registeredContents.stream().findFirst();
        if(content.isPresent()){
            this.finishedContents.add(content.get());
            this.registeredContents.remove(content.get());
        }else{
            System.err.println("Voce nao esta matriculado em nenhum conteudo");
        }
    }
    
    public double calcTotalXp() {
        return this.finishedContents
                .stream()
                .mapToDouble(Content::calcXP).sum();
    }

}
