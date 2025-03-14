public class main {
    public static void main(String[] args) {    
        printEmployee(new Manager());
        printEmployee(new Salesman());

        


        

    }

    public static void printEmployee(Employee employee){
        System.out.printf("=======%s=======\n",employee.getClass().getCanonicalName());
        switch (employee) {
            case Manager manager ->{
                manager.setName("Joao");
                manager.setLogin("joao");
                manager.setSalary(5000d);
                manager.setPassword("12345");
                manager.setCode("123");
                manager.setComission(1200d);
                System.out.println(manager.getName());
                System.out.println(manager.getLogin());
                System.out.println(manager.getPassword());
                System.out.println(manager.getCode());
                System.out.println(manager.getSalary());  
                System.out.println(manager.getComission());
                break;
            }
            case Salesman salesman ->{
                salesman.setName("Lucas");
                salesman.setSalary(2800d);
                salesman.setPercentPerSold(10d);
                salesman.setCode("321");
                salesman.setSouldAmount(1000d);
    

                System.out.println(salesman.getCode());
                System.out.println(salesman.getSalary());  
                System.out.println(salesman.getName());
                System.out.println(salesman.getPercentPerSold());
                break;
            }
        
            
        }
        System.out.println(employee.getFullSalary());
        System.out.println(employee.getFullSalary(500d));
        System.out.printf("================\n");
    }
}

