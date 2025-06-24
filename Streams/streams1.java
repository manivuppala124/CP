import java.util.*;
import java.util.stream.*;

class test1 {
  public static void main(String args[]){
    // List<String> list = Arrays.asList("a1", "a2", "b1", "c2", "camel", "c1");

    // Stream<String> fromList =  list.stream();    
    // fromList
		// .filter(s -> s.startsWith("c"))
		// .peek(System.out::println)
		// .map(String::toUpperCase)
		// .peek(System.out::println)
		// .sorted()
		// .forEach(System.out::println);
    // Stream.of("Australia","India","US","UK","Singapore","Bangladesh")
    // .filter(s->s.length()>4)
    // .sorted()
    // .limit(2)
    // .forEach(System.out::println);
    // Stream.generate(()->"USA")
    // .filter(n->n.length()>4)
    // .peek(System.out::println)
    // .limit(2)
    // .sorted()
    // .forEach(System.out::println);

    // Stream<Integer> i=Stream.iterate(1, x->x+1);
    // i.filter(x->x%2==1)
    // .limit(5)
    // .forEach(System.out::println);
// int arr[]={1};
//   Arrays.sort(arr)  ;
//   System.out.println(arr[0]);

  

    // Stream.of("d2","a2","b1","b3","c")
    // .map(s->{
    //   System.out.println("map: "+s);
    //   return s.toUpperCase();
    // })
    // .filter(s->{
    //   System.out.println("filter: "+s);
    //   return s.startsWith("A");
    // })
    // .forEach(s->System.out.println("forEach: "+s));

    // System.out.println(list);
  }
}

class test2 {
  public static void main(String args[]){
    // Stream.of("d2", "a2", "b1", "b3", "c")
    //     .filter(s -> {
    //         System.out.println("filter: " + s);
    //         return true;}).forEach(s -> System.out.println("forEach: " + s));
            List<String> l=new ArrayList(Arrays.asList("one","two"));
  Stream<String> sl=l.stream();
  l.add("three");
  l.remove(1);
  String s=sl.collect(Collectors.joining(","));
  System.out.println(s);
  }
}




class test3 {
  public static void main(String args[]){
    Stream<String> empty = Stream.empty();
    empty.forEach(System.out::println);

    Stream<Integer> singleElement = Stream.of(1);
    singleElement.forEach(System.out::println);

    Stream<Integer> fromArray = Stream.of(2, 3, 4);
    fromArray.forEach(System.out::println);
  }
}

class test4 {
  public static void main(String args[]){
    List<String> list = Arrays.asList("A", "B", "C", "D", "E");
    Stream<String> fromList = list.stream();
    fromList.forEach(System.out::println);

    Stream<String> fromListParallel = list.parallelStream();
    fromListParallel.forEach(System.out::println);
  }
}

