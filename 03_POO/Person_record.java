public record Person_record (String name, Integer age){
    
    public Person_record{
        System.out.println("===========");
        System.out.println(name);
        System.out.println(name);
        System.out.println("===========END");
    }

    public String getInfo(){
        return "\n\nUsando getinfo:\nName: "+ name+" age: " + age+"\n\n";
    }

    public Person_record(String name){
        this(name,1);
    }


}
