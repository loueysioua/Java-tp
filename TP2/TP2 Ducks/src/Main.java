public class Main {
    public static void main(String[] args) {
        MallarDuck duck = new MallarDuck();
        duck.display();
        duck.swim();
        duck.fly();
        duck.quack();
        System.out.println("---------------------------");
        DecoyDuck decoy = new DecoyDuck();
        decoy.display();
        decoy.swim();
        System.out.println("---------------------------");
        RedheadDuck redhead = new RedheadDuck();
        redhead.display();
        redhead.swim();
        redhead.fly();
        redhead.quack();
        System.out.println("---------------------------");
        RubberDuck rubber = new RubberDuck();
        rubber.display();
        rubber.swim();
        rubber.quack();
        System.out.println("---------------------------");
    }
}