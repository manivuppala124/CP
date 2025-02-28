/*Viraj Aanand is a wedding planner, He ordered his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4
 */

import java.time.LocalDate;

public class DistinctShapes {
    public static void main(String[] args) {
        Integer i=10;
        Integer j=i;
        i++;
        j--;
        System.out.println(i+" "+j);
        Double d1=3.0;
        int i1=3;
        Double d2=d1.valueOf("3.0d");
        if(d1==i1){
System.out.println("equla");
        }else{
            System.out.println("no");
        }
        Integer x=123;
        Integer y=x;
        System.out.println(x==y);
        y++;
        System.out.println(x+" "+y);
        System.out.println(x==y);
        LocalDate date=LocalDate.now();
System.out.println(date);
date=date.plusDays(2);
System.out.println(date);
date=date.plusWeeks(1);
System.out.println(date);

    }
}
