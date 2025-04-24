import com.dio.springboot.springbeans.Carro;
import com.dio.springboot.springbeans.Moto;
import com.dio.springboot.springbeans.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;

public class Condutor {
    public static void main(String[] args) {
        Condutor condutor = new Condutor(new Moto());

        condutor.automovel();
    }

    @Autowired
    private Veiculo veiculo;

    public Condutor(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void automovel(){
        veiculo.acao();
    }
}
