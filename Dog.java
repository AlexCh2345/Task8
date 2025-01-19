class Dog extends Animal {
    private String breed;
    private String customInfo;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
        this.customInfo = "";
    }

    @Override
    public String getInfo() {
        String info = "Dog [Name: " + name + ", Age: " + age + ", Breed: " + breed + "]";
        if (!customInfo.isEmpty()) {
            info += ", Custom Info: " + customInfo;
        }
        return info;
    }

    @Override
    public void customizeInfo(String customInfo) {
        this.customInfo = customInfo;
    }
}
