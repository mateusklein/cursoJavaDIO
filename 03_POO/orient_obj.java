public class orient_obj {
    public static void main (String[] args){
        var male = new Person("João");
        male.incAge();
        Person.setTeste("test 123");

        var female = new Person("Maria");
        male.incAge();
       

        System.out.println("Male name " + male.getName() + " age " + male.getAge() + " teste "+ male.getTeste());
        System.out.println("Female name " + female.getName() + " age " + female.getAge() + " teste "+ female.getTeste());
    }
}
