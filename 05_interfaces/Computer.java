public class Computer implements VideoPlayer, MusicPlayer {
    @Override 
    public void playMusic(){
        System.out.println("O computador está tocando a musica");
    }

    @Override 
    public void pauseMusic(){
        System.out.println("O computador está pausando a musica");
    }

    @Override 
    public void pauseVideo(){
        System.out.println("O computador está pausando o video");
    }

    @Override 
    public void playVideo(){
        System.out.println("O computador está reproduzindo o video");
    }


}
