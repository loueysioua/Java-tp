public class MallarDuck extends Duck implements Quackable , Flyable {
    public void display() {
        System.out.println("i am a MallarDuck !");
    }
    public void quack() {
        System.out.println("MallarDuck quack quack");
    }

    @Override
    public void swim() {
        super.swim();
    }

    public void fly() {
        System.out.println("I am a flying MallarDuck");
    }

}
