import java.time.*;

public class date1 {
  public static void main(String[] args) {
    System.out.println(LocalDate.now());
    System.out.println(LocalTime.now());
    System.out.println(LocalDateTime.now());

    LocalDate date1 = LocalDate.of(2017, Month.JANUARY, 5);
    LocalDate date2 = LocalDate.of(2017, 1, 5);

    System.out.println(date1);
    System.out.println(date2);
  }
}
