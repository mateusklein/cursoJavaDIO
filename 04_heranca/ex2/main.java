public class main {
    public static void main(String[] args) {
        printUser(new Gerente());
        printUser(new Vendedor());
        printUser(new Atendente());
    }

    public static void printUser(Usuarios user){
        System.out.printf("================%s==============\n",user.getClass().getCanonicalName());
        switch(user){
            case Gerente gerente ->{
                gerente.setNome("João");
                gerente.setEmail("joao@gmail.com");
                gerente.setSenha("12345");

                System.out.printf("Nome: %s\n", gerente.getNome());
                System.out.printf("Email: %s\n", gerente.getEmail());
                System.out.printf("Senha: %s\n", gerente.getSenha());
                gerente.gerarRelatorioFinan();
                gerente.consultarVendas();
                


            }
            case Vendedor vendedor ->{
                vendedor.setNome("Marcos");
                vendedor.setEmail("marcos_pereira@outlook.com");
                vendedor.setSenha("54321");
                vendedor.setQtdVendas(22);
                System.out.printf("Nome: %s\n", vendedor.getNome());
                System.out.printf("Email: %s\n", vendedor.getEmail());
                System.out.printf("Senha: %s\n", vendedor.getSenha());
                System.out.printf("Quantidade de vendas realizada: %s\n", vendedor.getQtdVendas());
                vendedor.realizarVenda();
                vendedor.consultarVendas();
                



            }
            case Atendente atendente ->{
                atendente.setNome("Julio");
                atendente.setEmail("julio_almeida@mail.com");
                atendente.setSenha("julio123");
                atendente.setQtdCaixa(200d);

                System.out.printf("Nome: %s\n", atendente.getNome());
                System.out.printf("Email: %s\n", atendente.getEmail());
                System.out.printf("Senha: %s\n", atendente.getSenha());
                System.out.printf("Quantidade no caixa: %s\n", atendente.getQtdCaixa());
                atendente.receberPagamentos(30d);
                atendente.fecharCaixa();






            }
        }
        System.out.printf("====================================\n");
    
    }
}
