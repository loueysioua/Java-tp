public class Main {
    public static void main(String[] args) {
CustomStack stack = new CustomStack(5);
        stack.addElement(1);
        stack.addElement(2);
        stack.addElement(3);
        stack.addElement(4);
        stack.addElement(5);
        stack.addElement(6);
        System.out.println(stack.lastInStack());
        stack.removeElement();
        System.out.println(stack.lastInStack());
        stack.removeElement();
        System.out.println(stack.lastInStack());
        stack.removeElement();
        System.out.println(stack.lastInStack());
        stack.removeElement();
        System.out.println(stack.lastInStack());
        stack.removeElement();
        System.out.println(stack.lastInStack());
        stack.removeElement();
        System.out.println(stack.lastInStack());
    }
}