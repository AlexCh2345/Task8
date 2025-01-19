public class Main {
    public static void main(String[] args) {
        Company company = new Company();


        Manager manager = new Manager("Alice", 1, 5000, "HR");
        Engineer engineer = new Engineer("Bob", 2, 4000, "Software Development");

        company.addEmployee(manager);
        company.addEmployee(engineer);


        System.out.println("List of employees:");
        company.listEmployees();


        System.out.println("\nRemoving employee with ID 1...");
        company.removeEmployee(1);


        System.out.println("\nList of employees after removal:");
        company.listEmployees();

        PetStore petStore = new PetStore();


        Dog dog = new Dog("Buddy", 3, "Labrador");
        Cat cat = new Cat("Whiskers", 2, "Gray");


        petStore.addAnimal(dog);
        petStore.addAnimal(cat);


        petStore.customizeAnimalInfo("Buddy", "Loves to fetch balls");


        System.out.println("List of animals in the store:");
        petStore.listAnimals();


        petStore.removeAnimal("Whiskers");


        System.out.println("\nList of animals after removing Whiskers:");
        petStore.listAnimals();
    }
}
