import java.time.LocalDate;

public class FreeUser extends User{
    public int nbBooksMaxToBorrowAtOnce;

    public FreeUser(String password, String username, String name, String adress, int phoneNum , Library L) {
        super(password, username, name, adress, phoneNum , L);
        userType="Free User";
        nbBooksMaxToBorrowAtOnce=3;
    }

    public FreeUser() {
        super();
        nbBooksMaxToBorrowAtOnce=3;
    }

    @Override
    public void borrowBook(Book b) {
        int index =L.searchBook(b.getIsbn());
        if( ( (index !=-1) ) && ( (this.getDelay()) <= 5 ) && ( (this.borrowedBooks).size() < nbBooksMaxToBorrowAtOnce ) && (b.getEdition() != 1) && ( L.books.get(index).getCopies() >1 ) )
        {
            BorrowedBook bB = new BorrowedBook(b.getTitle() , b.getAuthor() , b.getIsbn() ,b.getGenre() ,b.getPublicationYear(), b.getPublisher() ,b.getEdition() ,b.getLanguage() ,b.getNbPages() ,this.getLibrary());
            (this.borrowedBooks).add(bB);
            (this.historyOfUser).add(bB);
            bB.setCopies( bB.getCopies()-1 );
            L.books.get( index ).setCopies( (L.books.get(index)).getCopies() - 1 );
            bB.setBorrowDate(LocalDate.now());
            bB.setReturnDeadLine( bB.getBorrowDate().plusDays(10) );
            if(this.getDelay()>=3){
                System.out.println("You have more than 3 late books returned !! If you reach 5 you can't borrow anymore books please pay attention to the deadlines !");
            }
        }
        else if(this.getDelay()>5){
            System.out.println("You returned late more than 5 books !! You can't borrow anymore Books !");
        }
        else if(b.getEdition() == 1){
            System.out.println("Free users can't get first edition books please upgrade your account to prenium user .");
        }
        else if( (this.borrowedBooks).size()>= nbBooksMaxToBorrowAtOnce ){
            System.out.println("Books borrowed limit exceeded !");
        }
        else if(L.books.get(index).getCopies() <= 1 ){
            System.out.println("Sorry we don't have enough copies to give you this book :(");
        }
        else{
            System.out.println("Sorry but we don't have this book in our library :(");
        }
    }


}
