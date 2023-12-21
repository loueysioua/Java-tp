public class Main {
    public static void main(String[] args) {
        Library library = new Library("library");
        Book book = new Book("title", "author", 2020);
        book.displayInformation();
        System.out.println("----------------");
        library.addBook(book);
        Novel novel = new Novel("title", "author", 2020);
        novel.displayInformation();
        System.out.println("----------------");
        library.addBook(novel);
        Textbook textbook = new Textbook("title", "author", 2020);
        textbook.displayInformation();
        System.out.println("----------------");
        library.addBook(textbook);
        library.listAllBooks();
        System.out.println("----------------");
        library.removeBook(book);
        System.out.println("----------------");
        library.listAllBooks();
        LibraryCard libraryCard = new LibraryCard("secondName", "firstName", 123456789);
        LibraryUser student = new Student(libraryCard);
        student.borrowBook();
        student.returnBook();
    }
}