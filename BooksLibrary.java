import java.util.*;

class Library
{ 
    String bookName;
    String author;
    Library()
    {
    }
    Library(String bookName,String author)
    {
        this.bookName=bookName;
        this.author=author;
    }
    public HashMap<Integer,Library> createLibraryMap(String booksInLibrary)
    {
        HashMap<Integer, Library> bookmap = new HashMap<>();
        String[] books = booksInLibrary.split("\\|");
        for (String i:books){
          String[] book = i.split(",");
          Library nameauthor = new Library(book[1], book[2]);
          bookmap.put(Integer.parseInt(book[0]), nameauthor);
        }
        return bookmap;
    }
    public HashMap<Integer,Integer> createUserMap(String borrowedUsers)
    {
        HashMap<Integer, Integer> usermap = new HashMap<>();
        String[] users = borrowedUsers.split("\\|");
        for (String user: users){
          String[] u = user.split(",");
          usermap.put(Integer.parseInt(u[0]), Integer.parseInt(u[1]));
        }        
        return usermap;
    }
 
    public String getQuery(String booksInLibrary,String borrowedUsers,String query)
    {
        String[] q = query.split(",");
        String query_type = q[0];
        String query_bookid = q[1];
        String ans = "";
        HashMap<Integer, Library> books = createLibraryMap(booksInLibrary);
        HashMap<Integer, Integer> user = createUserMap(borrowedUsers);
        switch(query_type){
            case "1":
                for (Integer b: user.keySet()){
                    books.remove(b);
                }
                Integer q_bookid = Integer.parseInt(query_bookid);
                if (books.containsKey(query_bookid)){
                  String author = books.get(q_bookid).author;
                  ans = "It is available\nAuthor is "+ author+"\n";
                } else{
                  Integer usid = user.get(q_bookid);
                  ans = "No Stock\nIt is owned by "+usid+"\n";
                }
                break;

            case "2":
                for (Integer us: user.keySet()){
                  Integer value = user.get(us);
                  if (value == Integer.parseInt(query_bookid)){
                    String bookname = books.get(us).bookName;
                    ans += us+" "+bookname+"\n";
                  }
                }
                break;
          
            case "3":
                int count1 = 0;
                int count2 = 0;
                for(Integer entry: user.keySet()) {
                  String name = books.get(entry).bookName;
                  if (name.equals(query_bookid)){
                    count1 += 1;
                    books.remove(entry);
                  }
                }

                for (Integer book: books.keySet()){
                    if (books.get(book).bookName.equals(query_bookid)){
                        count2 += 1;
                    }
                }
                ans = count1+" out\n"+count2+" in\n";
                break;

            case "4":
                for(Integer entry: books.keySet()){
                    if (books.get(entry).author.equals(query_bookid)){
                        ans += books.get(entry).bookName+"\n";
                    }
                }

            case "5":
                for (Integer entry: books.keySet()){
                    String bname = books.get(entry).bookName;
                    if (bname.toLowerCase().indexOf(query_bookid.toLowerCase()) != -1){
                        ans += entry+" "+bname+"\n";
                    }
                }
                break;
        }
        return ans;
    }
    
}

class BooksLibrary{
    public static void main(String[] args) {
        Library li = new Library();
        String answer = li.getQuery("1001,Python Tricks,Dan Bader|1002,The Complete Software Developer's Career Guide,John Sonmez|1003,Mastering Deep Learning Fundamentals with Python,Richard Wilson|1004,Cracking the Coding Interview,Gayle Laakmann McDowell|1005,Python Programming,Joseph Mining|1006,Effective Java,Joshua Bloch|1007,Java,Nathan Clark|1008,JavaScript Programming,Brian Jenkins|1009,Functional-Light JavaScript,Kyle Simpson","1006,101|1009,102|1003,101","5,java");
        System.out.println(answer);
    }
}
