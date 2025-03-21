import dao.*;
import domain.*;

public class main {
    private final static GenericDAO<Integer, UserDomain> dao = new UserDAO();
    private final static GenericDAO<String, ClientDomain> clientDAO = new ClientDAO(); 
    public static void main(String[] args) {
        var user = new UserDomain("1", "Joao", 36);
        System.out.println(dao.count());
        System.out.println(dao.save(user));
        
        System.out.println(dao.findAll());
        System.out.println(dao.find(d -> d.getId().equals(1)));
        System.out.println(dao.find(d -> d.getId().equals(2)));
        System.out.println(dao.count());

        System.out.println(dao.delete(new UserDomain("-1", "", -1)));
        System.out.println(dao.delete(user));
    }

}

