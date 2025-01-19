import java.util.ArrayList;
import java.util.List;

class PetStore {
    private List<Animal> animals;

    public PetStore() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(String name) {
        animals.removeIf(animal -> animal.name.equals(name));
    }

    public void listAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the store.");
        } else {
            for (Animal animal : animals) {
                System.out.println(animal.getInfo());
            }
        }
    }

    public void customizeAnimalInfo(String name, String customInfo) {
        for (Animal animal : animals) {
            if (animal.name.equals(name)) {
                animal.customizeInfo(customInfo);
                return;
            }
        }
        System.out.println("Animal with name " + name + " not found.");
    }
}