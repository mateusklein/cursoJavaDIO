package br.com.dio.validator;
import br.com.dio.exception.*;
import br.com.dio.model.*;

public class UserValidator {
    private UserValidator(){

    }

    public static void verifyModel(final UserModel model) throws ValidatorException{
        if(stringIsBlank(model.getName())){
            throw new ValidatorException("Informe um nome válido");
        }
        if(model.getName().length() <= 1){
            throw new ValidatorException("O nome deve ter mais de 1 caracter");
        }
        if(!model.getEmail().contains("@") || !model.getEmail().contains(".")){
            throw new ValidatorException("Informe um email válido");
        }
        if(stringIsBlank(model.getEmail())){
            throw new ValidatorException("Informe um email válido");
        }
    }

    private static boolean stringIsBlank(final String value){
        return value == null || value.isBlank();
    }
}
