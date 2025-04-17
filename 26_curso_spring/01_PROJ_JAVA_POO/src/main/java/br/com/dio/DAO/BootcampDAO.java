package br.com.dio.DAO;

import br.com.dio.Model.Bootcamp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BootcampDAO {
    private List<Bootcamp> bootcamps = new ArrayList<>();

    public List<Bootcamp> insertBootcamp(Bootcamp bootcamp) {
        bootcamps.add(bootcamp);
        return bootcamps;
    }

}

