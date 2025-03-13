/*
Escreva um código onde controlamos as funções de um carro, ele deve ter as seguintes funções:
Ligar o carro;
Desligar o carro;
Acelerar;
diminuir velocidade;
virar para esquerda/direita
verificar velocidade;
trocar a marcha
Siga as seguintes regras na implementação

Quando o carro for criado ele deve começar desligado, em ponto morto e com sua velocidade em 0
O carro desligado não pode realizar nenhuma função;
Quando o carro for acelerado ele deve incrementar 1km em sua velocidade (pode chegar no máximo a 120km);
Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua velocidade (pode chegar no minimo a 0km);
o carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no carro;
A velocidade do carro deve respeitar os seguintes limites para cada velocidade
se o carro estiver na marcha 0 (ponto morto) ele não pode acelerar
se estiver na 1ª marcha sua velocidade pode estar entre 0km e 20km
se estiver na 2ª marcha sua velocidade pode estar entre 21km e 40km
se estiver na 3ª marcha sua velocidade pode estar entre 41km e 60km
se estiver na 4ª marcha sua velocidade pode estar entre 61km e 80km
se estiver na 5ª marcha sua velocidade pode estar entre 81km e 100km
se estiver na 6ª marcha sua velocidade pode estar entre 101km e 120km
O carro podera ser desligado se estiver em ponto morto (marcha 0) e sua velocidade em 0 km
O carro só pode virar para esquerda/direita se sua velocidade for de no mínimi 1km e no máximo 40km;
*/


public class carro {    
    private Boolean ligado;
    private Integer marcha;
    private Integer velocidade;
    public Integer MAX_VEL1 = 5;
    public Integer MAX_VEL2 = 10;
    public Integer MAX_VEL3 = 15;
    public Integer MAX_VEL4 = 20;
    public Integer MAX_VEL5 = 25;
    public Integer MAX_VEL6 = 30;
    public Integer MIN_VEL1 = 1;
    public Integer MIN_VEL2 = 6;
    public Integer MIN_VEL3 = 11;
    public Integer MIN_VEL4 = 16;
    public Integer MIN_VEL5 = 21;
    public Integer MIN_VEL6 = 26;

    public carro(){
        this.ligado = false;
        this.marcha = 0;
        this.velocidade = 0;
    }

    public void ligaCarro(){
        if(this.ligado){
            System.out.println("Carro já está ligado!");
            return;
        }
        this.ligado = true;
        System.out.println("Carro agora está ligado!");
    }

    public void desligaCarro(){
        if(this.marcha!=0){
            System.out.println("Carro não pode ser desligado, tem que estar em ponto morto (marcha 0)");
            return;
        }
        this.ligado = false;
        System.out.println("Carro agora está desligado!");
    }

    public void aumentaVelocidade(){
        if(this.ligado==false){
            System.out.println("Carro desligado, antes disso ligue o carro");
            return;
        }else if(this.marcha==0){
            System.out.println("Carro em marcha 0, antes disso troque a marcha");
            return;
        }else if(this.velocidade==MAX_VEL1 && this.marcha==1){
            System.out.println("Carro está na velocidade máxima da marcha 1, trocar marcha");
            return;
        }else if(this.velocidade==MAX_VEL2 && this.marcha==2){
            System.out.println("Carro está na velocidade máxima da marcha 2, trocar marcha");
            return;
        }else if(this.velocidade==MAX_VEL3 && this.marcha==3){
            System.out.println("Carro está na velocidade máxima da marcha 3, trocar marcha");
            return;
        }else if(this.velocidade==MAX_VEL4 && this.marcha==4){
            System.out.println("Carro está na velocidade máxima da marcha 4, trocar marcha");
            return;
        }else if(this.velocidade==MAX_VEL5 && this.marcha==5){
            System.out.println("Carro está na velocidade máxima da marcha 5, trocar marcha");
            return;
        }else if(this.velocidade==MAX_VEL6){
            System.out.println("Carro está na velocidade máxima, não é possível aumentar");
            return;
        }
        //SE NAO FOR NENHUM DOS CASOS INCREMENTA A VELOCIDADE EM 1
        this.velocidade+=1;
        System.out.printf("Velocidade aumentada em 1, nova velocidade de %s na marcha %s", this.velocidade, this.marcha);
    }

    public void aumentaMarcha(){
        if(this.ligado==false){
            System.out.println("Carro desligado, antes disso ligue o carro");
            return;
        }else if(this.marcha==1 && this.velocidade!=MAX_VEL1){
            System.out.println("Carro não está na velocidade máxima da marcha 1, não é possível trocar marcha");
            return;
        }else if(this.marcha==2 && this.velocidade!=MAX_VEL2){
            System.out.println("Carro não está na velocidade máxima da marcha 2, não é possível trocar marcha");
            return;
        }else if(this.marcha==3 && this.velocidade!=MAX_VEL3){
            System.out.println("Carro não está na velocidade máxima da marcha 3, não é possível trocar marcha");
            return;
        }else if(this.marcha==4 && this.velocidade!=MAX_VEL4){
            System.out.println("Carro não está na velocidade máxima da marcha 4, não é possível trocar marcha");
            return;
        }else if(this.marcha==5 && this.velocidade!=MAX_VEL5){
            System.out.println("Carro não está na velocidade máxima da marcha 5, não é possível trocar marcha");
            return;
        }else if(this.marcha==6 && this.velocidade==MAX_VEL6){
            System.out.println("Carro está na marcha 6, não é possível trocar marcha");
            return;
        }
        //SE NAO FOR NENHUM DOS CASOS INCREMENTA A MARCHA EM 1
        this.marcha+=1;
        this.velocidade+=1;
        System.out.printf("Marcha aumentada em 1, velocidade de %s na marcha %s", this.velocidade, this.marcha);
    }

    public void reduzVelocidade(){
        if(this.ligado==false){
            System.out.println("Carro desligado, antes disso ligue o carro");
            return;
        }else if(this.marcha==0){
            System.out.println("Carro em marcha 0, não é possível reduzir a velocidade");
            return;
        }else if(this.velocidade==MIN_VEL1 && this.marcha==1){
            System.out.println("Carro está na velocidade mínima da marcha 1, trocar marcha");
            return;
        }else if(this.velocidade==MIN_VEL2 && this.marcha==2){
            System.out.println("Carro está na velocidade mínima da marcha 2, trocar marcha");
            return;
        }else if(this.velocidade==MIN_VEL3 && this.marcha==3){
            System.out.println("Carro está na velocidade mínima da marcha 3, trocar marcha");
            return;
        }else if(this.velocidade==MIN_VEL4 && this.marcha==4){
            System.out.println("Carro está na velocidade mínima da marcha 4, trocar marcha");
            return;
        }else if(this.velocidade==MIN_VEL5 && this.marcha==5){
            System.out.println("Carro está na velocidade mínima da marcha 5, trocar marcha");
            return;
        }else if(this.velocidade==MIN_VEL6 && this.marcha==5){
            System.out.println("Carro está na velocidade mínima da marcha 6, trocar marcha");
            return;
        }
        //SE NAO FOR NENHUM DOS CASOS DECREMENTA A VELOCIDADE EM 1
        this.velocidade-=1;
        System.out.printf("Velocidade reduzida em 1, nova velocidade de %s na marcha %s", this.velocidade, this.marcha);
    }

    public void reduzMarcha(){
        if(this.ligado==false){
            System.out.println("Carro desligado, antes disso ligue o carro");
            return;
        }else if(this.marcha==0){
            System.out.println("Carro em marcha 0, não é possível reduzir a marcha");
            return;
        }else if(this.marcha==1 && this.velocidade!=MIN_VEL1){
            System.out.println("Carro não está na velocidade mínima da marcha 1, não é possível trocar marcha");
            return;
        }else if(this.marcha==2 && this.velocidade!=MIN_VEL2){
            System.out.println("Carro não está na velocidade mínima da marcha 2, não é possível trocar marcha");
            return;
        }else if(this.marcha==3 && this.velocidade!=MIN_VEL3){
            System.out.println("Carro não está na velocidade mínima da marcha 3, não é possível trocar marcha");
            return;
        }else if(this.marcha==4 && this.velocidade!=MIN_VEL4){
            System.out.println("Carro não está na velocidade mínima da marcha 4, não é possível trocar marcha");
            return;
        }else if(this.marcha==5 && this.velocidade!=MIN_VEL5){
            System.out.println("Carro não está na velocidade mínima da marcha 5, não é possível trocar marcha");
            return;
        }else if(this.marcha==6 && this.velocidade!=MIN_VEL6){
            System.out.println("Carro não está na velocidade mínima da marcha 6, não é possível trocar marcha");
            return;
        }
        //SE NAO FOR NENHUM DOS CASOS DECREMENTA A MARCHA EM 1
        this.marcha-=1;
        this.velocidade-=1;
        System.out.printf("Marcha reduzida em 1, velocidade de %s na marcha %s", this.velocidade, this.marcha);
    }

    public void virarEsqDir(char dir){
        if(this.velocidade < 1 || this.velocidade > 40){
            System.out.printf("Não é possível virar, velocidade de %s muito alta ou baixa", this.velocidade);
            return;
        }
        String msg = (dir == 'E') ? "Virou para a esquerda" :
                     (dir == 'D') ? "Virou para a direita" :
                     "Entrada inválida";
        System.out.println(msg);
    }

    public void getMarchaVel(){
        System.out.printf("Velocidade de %s na marcha %s", this.velocidade, this.marcha);
    }


}
