public class MusicBox implements MusicPlayer {
    @Override 
    public void playMusic(){
        System.out.println("O MusicPlayer está tocando a musica");
    }

    @Override 
    public void pauseMusic(){
        System.out.println("O MusicPlayer está pausando a musica");
    }


}
