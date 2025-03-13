/*
- Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
- Consultar saldo
- consultar cheque especial
- Depositar dinheiro;
- Sacar dinheiro;
- Pagar um boleto.
- Verificar se a conta está usando cheque especial.

Siga as seguintes regras para implementar:

- A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
- O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
- Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
- Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
- Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
*/

public class conta {
    private Float saldo;
    private Float chequeEspecial;
    private Boolean usandoCheque;
    

    public conta(Float saldo){
        this.saldo = saldo;
        this.usandoCheque = false;
        if(this.saldo <= 500){
            // caso saldo depositado no momento de criação da conta seja menor ou igual a 500 o cheque será de 50
            this.chequeEspecial = 50f;
        }else{
            // se for maior o cheque será de 50% da quantia que depositou
            this.chequeEspecial = (this.saldo * 0.5f);
        }
    }

    public void getSaldo(){
        System.out.printf("Saldo de %s", this.saldo);
    }

    public void getCheque(){
        System.out.printf("Cheque especial de %s", this.chequeEspecial);
    }

    public void getUsandoCheque(){
        if(this.usandoCheque){
            System.out.printf("Conta está usando cheque especial");
            return;
        }
        System.out.printf("Conta não está usando cheque especial");
    }


    public void depositaDinheiro(Float valor){
        if(valor <= 500){
            // caso saldo depositado seja menor ou igual a 500 o cheque será de 50
            this.chequeEspecial = this.chequeEspecial + 50f;
        }else{
            // se for maior o cheque será de 50% da quantia que depositou
            this.chequeEspecial = this.chequeEspecial + (valor * 0.5f);
        }
        this.saldo = this.saldo + valor;

        if(this.saldo >= 0){
            this.usandoCheque = false;
        }
        System.out.printf("Depósito realizado, novo saldo de %s e cheque de %s", this.saldo, this.chequeEspecial);
    }

    public void sacaDinheiro(Float valor){
        //SALDO DA
        if (saldo >= valor){
            this.saldo = this.saldo - valor;
            System.out.printf("Saque realizado, novo saldo de %s e cheque de %s", this.saldo, this.chequeEspecial);
            return;
        }
        // SALDO (POSITIVO) + CHEQUE DA 
        else if (saldo > 0 && (saldo + chequeEspecial) >= valor ){
            Float valor_dif = valor - this.saldo;
            this.saldo = 0f;
            this.chequeEspecial = this.chequeEspecial - valor_dif;
            this.usandoCheque = true; 
            verCheque(valor_dif);
            System.out.printf("Saque realizado, novo saldo de %s e cheque de %s", this.saldo, this.chequeEspecial);
            return;
        }
        //SALDO (NEGATIVO), PORÉM O CHEQUE DA 
        else if (saldo <= 0 && chequeEspecial >= valor ){
            this.chequeEspecial = this.chequeEspecial - valor;
            this.usandoCheque = true;
            verCheque(valor);
            System.out.printf("Saque realizado, novo saldo de %s e cheque de %s", this.saldo, this.chequeEspecial);
            return;
        }//CHEQUE NÃO DA (ULTIMA ALTERNATIVA EM QUE CLIENTE NÃO PODE SACAR)
        else{
            System.out.printf("Não foi possível realizar o saque, saldo de %s e cheque de %s", this.saldo, this.chequeEspecial);
            return;
        }

    }

    public void pagaBoleto(Float valor){
        //SALDO DA
        if (saldo >= valor){
            this.saldo = this.saldo - valor;
            System.out.printf("Boleto pago, novo saldo de %s e cheque de %s", this.saldo, this.chequeEspecial);
            return;
        }
        // SALDO (POSITIVO) + CHEQUE DA 
        else if (saldo > 0 && (saldo + chequeEspecial) >= valor ){
            Float valor_dif = valor - this.saldo;
            this.saldo = 0f;
            this.chequeEspecial = this.chequeEspecial - valor_dif;
            this.usandoCheque = true; 
            verCheque(valor_dif);
            System.out.printf("Boleto pago, novo saldo de %s e cheque de %s", this.saldo, this.chequeEspecial);
            return;
        }
        //SALDO (NEGATIVO), PORÉM O CHEQUE DA 
        else if (saldo < 0 && chequeEspecial >= valor ){
            this.chequeEspecial = this.chequeEspecial - valor;
            this.usandoCheque = true;
            verCheque(valor);
            System.out.printf("Boleto pago, novo saldo de %s e cheque de %s", this.saldo, this.chequeEspecial);
            return;
        }//CHEQUE NÃO DA (ULTIMA ALTERNATIVA EM QUE CLIENTE NÃO PODE SACAR)
        else{
            System.out.printf("Não foi possível pagar o boleto, saldo de %s e cheque de %s", this.saldo, this.chequeEspecial);
            return;
        }
    }

    public void verCheque(Float valor){
        // negativa o saldo em 20% caso seja usado o cheque especial
        this.saldo = this.saldo - (valor * 0.2f);
    }

}
