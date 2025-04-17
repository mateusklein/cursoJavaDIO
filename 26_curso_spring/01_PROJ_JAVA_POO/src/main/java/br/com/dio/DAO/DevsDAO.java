package br.com.dio.DAO;

import br.com.dio.Model.Devs;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DevsDAO {
    private List<Devs> devs = new ArrayList<>();

    public List<Devs> insertDev(Devs dev) {
        this.devs.add(dev);
        return devs;
    }


}
