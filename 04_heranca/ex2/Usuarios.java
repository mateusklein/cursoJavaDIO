public sealed abstract class Usuarios permits Vendedor, Gerente, Atendente {
    protected String nome;
    protected String email;
    protected String senha;
    private Boolean isAdm;


    public Usuarios(String nome, String email, String senha, Boolean isAdm) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdm = isAdm;
    }

    public Usuarios(){

    }

    public Boolean getIsAdm() {
        return isAdm;
    }

    public void setIsAdm(Boolean isAdm) {
        this.isAdm = isAdm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public void realizarLogin(){
        System.out.printf("O usuário %s está realizando login", this.nome);
    }

    public void realizarLogof(){
        System.out.printf("O usuário %s está realizando logof", this.nome);
    }

    public void alterarDados(String email){
        this.email = email;
        System.out.printf("O usuário %s alterou seu email para: %s ", this.nome ,this.email);
    }

    public void alterarSenha(String senha){
        this.senha = senha;
        System.out.printf("O usuário %s alterou seu senha para: %s ", this.nome, this.senha);
    }

}
