public record Sms (String msg, String orig, String dest) implements Redes {
    @Override
    public String getMsg(){
        return "Mensagem de " + orig + " para " + dest + ": " +  msg + " (enviado através de sms)";
    }

}
