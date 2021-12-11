package otus.ualesh;

public class Animal {
    private String name;
    private int age;
    private int weight;
    private String color;

    public Animal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return "Привет!" +
                " меня зовут " + name +
                ", мне " + this.getAgeString(age) +
                ", я вешу-" + weight + " кг " +
                ", мой цвет-" + color
                ;
    }

    private String getAgeString(int age) {
        String years;
        if (age == 1) {
            years = "год";
        } else if (age < 5) {
            years = "года";
        } else {
            years = "лет";
        }
        return age + " " + years;
    }
}
