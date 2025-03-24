import java.util.ArrayList;
import java.util.List;

public class Square {
    public static final  int MAX_NUM = 9;
    public List<String> pos = new ArrayList<>();
    public List<Boolean> posFixo = new ArrayList<>();

    public Square() {
        //CRIANDO UMA LISTA COM 9 POSICOES
        for (int i = 0; i < MAX_NUM; i++) {
            pos.add(" ");
        }
        for (int i = 0; i < MAX_NUM; i++) {
            posFixo.add(false);
        }
    }



    public static int getMaxNum() {
        return MAX_NUM;
    }

    public List<String> getPos() {
        return pos;
    }


    public void setPos(List<String> pos) {
        if (pos.size() == MAX_NUM) {
            this.pos = pos;
        } else {
            throw new IllegalArgumentException("A lista deve ter exatamente " + MAX_NUM + " elementos.");
        }
    }

    public String getPosList(int i) {
        if(i>=0 && i<MAX_NUM){
            return pos.get(i);
        }else{
            throw new IndexOutOfBoundsException("Índice fora dos limites permitidos.");
        }
    }

    public void setPosList(int i, String num) {
        if(i>=0 && i<MAX_NUM){
            pos.set(i, num);
        }else{
            throw new IndexOutOfBoundsException("Índice fora dos limites permitidos.");
        }
    }








    public List<Boolean> getPosfixo() {
        return posFixo;
    }


    public void setPosfixo(List<Boolean> posFixo) {
        if (pos.size() == MAX_NUM) {
            this.posFixo = posFixo;
        } else {
            throw new IllegalArgumentException("A lista deve ter exatamente " + MAX_NUM + " elementos.");
        }
    }

    public Boolean getPosfixoList(int i) {
        if(i>=0 && i<MAX_NUM){
            return posFixo.get(i);
        }else{
            throw new IndexOutOfBoundsException("Índice fora dos limites permitidos.");
        }
    }

    public void setPosfixoList(int i, Boolean num) {
        if(i>=0 && i<MAX_NUM){
            posFixo.set(i, num);
        }else{
            throw new IndexOutOfBoundsException("Índice fora dos limites permitidos.");
        }
    }


    public Boolean verErro(){
        for(int i=0; i<MAX_NUM-1; i++){
            for(int j=i+1; j<MAX_NUM; j++){
                if((!pos.get(i).equals(" ") || !pos.get(j).equals(" ")) && pos.get(i).equals(pos.get(j))){
                    return true;
                }
            }
        }
        return false;
    }
}
