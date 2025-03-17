public class Smartphone implements VideoPlayer, MusicPlayer {
    @Override 
    public void playMusic(){
        System.out.println("O smartphone está tocando a musica");
    }

    @Override 
    public void pauseMusic(){
        System.out.println("O smartphone está pausando a musica");
    }

    @Override 
    public void pauseVideo(){
        System.out.println("O smartphone está pausando o video");
    }

    @Override 
    public void playVideo(){
        System.out.println("O smartphone está reproduzindo o video");
    }


}
