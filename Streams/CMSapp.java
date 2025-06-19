/*You are given a list of Article objects. Each Article has three fields:
	int articleID – a unique identifier
	String authorName – the name of the article’s author
	int wordCount – the number of words in that article

Task: Write a Java program that:
	1. Computes the average word count for each author across all their articles.
	2. Determines which author has the highest average word count.
	3. Prints the author’s name along with their average word count (formatted to two decimal places).

	If there are no articles, the program should print “No data available.”
	
Expected Output:
----------------
Top author: Alice Smith (avg words: 636.67) */
import java.util.*;
import java.util.stream.*;

public class CMSapp {
    public static void main(String[] args) {
        // Sample data: list of articles
        List<Article> articles = List.of(
            new Article(101, "Alice Smith",   520),
            new Article(102, "Bob Johnson",   330),
            new Article(103, "Alice Smith",   780),
            new Article(104, "Carol Davis",   450),
            new Article(105, "Bob Johnson",   620),
            new Article(106, "Alice Smith",   610)
        );

        //WRITE YOUR CODE HERE
        
    }
}

// Non-public helper class in the same file
class Article {
    private final int    articleID;
    private final String authorName;
    private final int    wordCount;

   //WRITE YOUR CODE HERE
   Article(int a,String n,int wc){
       this.articleID=a;
       this.authorName=n;
       this.wordCount=wc;
   }
   String getAuthorName(){
       return authorName;
   }
   int getWordCount(){
       return wordCount;
   }
}