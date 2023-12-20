public class main {
    static public void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.size());
        System.out.println(list.get(2));
        System.out.println(list.isIn(3));
        System.out.println(list.find(3));
        list.add(2, 5);
        System.out.println(list.get(2));
        System.out.println(list.size());
        System.out.println(list.isIn(5));
        System.out.println(list.find(5));
        System.out.println(list.isEmpty());
        System.out.println(list.get(1));
        System.out.println(list.get(3));
        list.remove(5);
        System.out.println(list.get(2));
        System.out.println(list.get(1));
        System.out.println(list.get(list.size())-1);
        list.add(0, 5);
        System.out.println(list.get(0));
        list.add(list.size()-1, 5);
        System.out.println(list.get(list.size()-1));

    }
}
