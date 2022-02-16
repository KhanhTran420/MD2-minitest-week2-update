import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[10];
        books[0] = new ProgrammingBook("P00", "Naruto", 50, "TG", "java", "P0");
        books[1] = new ProgrammingBook("P01", "Naruto1", 40, "TG1", "php", "P1");
        books[2] = new ProgrammingBook("P02", "Naruto2", 30, "TG2", "java", "P2");
        books[3] = new ProgrammingBook("P03", "Naruto3", 20, "TG3", "python", "P3");
        books[4] = new ProgrammingBook("P04", "Naruto4", 10, "TG4", "java", "P4");
        books[5] = new FictionBook("F00", "AOT", 80, "TG5", "vien tuong1");
        books[6] = new FictionBook("F01", "AOT1", 70, "TG6", "vien tuong2");
        books[7] = new FictionBook("F02", "AOT2", 60, "TG7", "vien tuong1");
        books[8] = new FictionBook("F03", "AOT3", 50, "TG8", "vien tuong3");
        books[9] = new FictionBook("F04", "AOT4", 40, "TG9", "vien tuong1");

        int sum = getTotalPrice(books);
        System.out.println("Tổng số tiền của 10 cuốn sách là: " + sum);
        int count = countBookByLanguage(books, "java");
        System.out.println("Số sách Programming có ngôn ngữ Java là: " + count);

        int count2 = countBookByPrice(books,100);
        System.out.println("Số sách Fiction có giá < 100 là: " + count2);

        int count1 = countBookByCategory(books,"vien tuong1");
        System.out.println("Số sách Fiction có category 'vien tuong1' là: " + count1);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập sách bạn cần tìm: ");
        String name = scanner.nextLine();
        findBook(books,name);

    }

    public static int getTotalPrice(Book[] books) {
        int sum = 0;
        for (int i = 0; i < books.length; i++) {
            sum += books[i].getPrice();
        }
        return sum;
    }

    public static int countBookByLanguage(Book[] books, String inputLanguage){
        int count = 0;
        // quet trong mang books
        for (int i = 0; i < books.length ; i++) {
            // kiem tra xem co nam trong Programming ko
            if (books[i] instanceof ProgrammingBook){
                // ep books[i] vao ProgrammingBook
                String language = ((ProgrammingBook)books[i]).getLanguage();
                // thuc hien so sanh
                if(language.equals(inputLanguage)){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countBookByCategory (Book[] books, String inputCategory){
        int count1 = 0;
        for (int i = 0; i < books.length ; i++) {
            if(books[i] instanceof FictionBook){
                String category = ((FictionBook)books[i]).getCategory();
                if (category.equals(inputCategory)){
                    count1++;
                }
            }
        }
        return count1;
    }


    public static int countBookByPrice (Book[] books, int inputPrice){
        int count2 = 0;
        for (int i = 0; i < books.length ; i++) {
            if(books[i] instanceof FictionBook){
                int price = ((FictionBook)books[i]).getPrice();
                if (price < inputPrice ){
                    count2++;
                }
            }
        }
        return count2;
    }


    public static int findBook(Book[] books, String inputBook){
        int index = -1;
        for (int i = 0; i < books.length ; i++) {
            String nameBook = books[i].getName();
            if(nameBook.equals(inputBook)){
                index = i;
            }
        }
        if (index>=0){
            System.out.println(inputBook + " price: " + books[index].getPrice());
        }
        else {
            System.out.println(inputBook +" Not found");
        }
        return index;
    }
}




