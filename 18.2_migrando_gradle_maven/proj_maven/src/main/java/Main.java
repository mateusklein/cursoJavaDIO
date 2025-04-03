import br.com.dio.dto.UserDTO;
import br.com.dio.mapper.UserMapper;
import br.com.dio.model.UserModel;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class Main {
    private final static UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public static void main(String[] args) {
        var model = new UserModel();
        model.setCode(1);
        model.setUsername("James");
        model.setBirthdate(LocalDate.now().minusYears(30));
        System.out.println(mapper.toDTO(model));


        var dto = new UserDTO();
        dto.setId(2); //com o lombock a data gera
        dto.setName("John");
        dto.setBirthdate(LocalDate.now().minusYears(30));
        System.out.println(mapper.toModel(dto));
    }
}


//APENAS DIGITAR GRADLE INIT NO CMD E REALIZAR AS CONFIGURACOES PARA MIGRAR DE MAVEN PARA GRADLE
//após isso basta deletar o arquivo pom.xml ja que agora é um projeto gradle
