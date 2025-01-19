class Cat extends Animal {
    private String color;
    private String customInfo;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
        this.customInfo = "";
    }

    @Override
    public String getInfo() {
        String info = "Cat [Name: " + name + ", Age: " + age + ", Color: " + color + "]";
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