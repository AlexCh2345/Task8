class Engineer extends Employee {
    private String specialty;


    public Engineer(String name, int age, int position, String specialty) {

        super(name, age, position);
        this.specialty = specialty;
    }


    @Override
    public String getDetails() {
        return super.getDetails() + ", Specialty: " + specialty;
    }
}

