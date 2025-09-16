/*A park has a row of flower plots represented as an array. 
Some plots already have flowers (1), and others are empty (0). 
Due to maintenance rules, no two flowers can be planted in adjacent plots. 

You’re asked to check if it’s possible to plant n new flowers without breaking this rule.

Given a binary array flowerbed and an integer n, determine whether n new flowers 
can be planted in flowerbed such that no two planted flowers are adjacent. 
Return "true" if possible, otherwise "false".

Input Format:
-------------
Line-1: An integer m — the number of plots.
Line-2: m space-separated integers (each 0 or 1) representing flowerbed.
Line-3: an integer n — the number of new flowers to plant.

Output Format:
--------------
Line-1: Either true or false (lowercase).

Constraints:
-------------
1 ≤ m ≤ 2 × 10^4
flowerbed[i] ∈ {0, 1}
0 ≤ n ≤ 2 × 10^4
Adjacent 1s will not appear in the initial flowerbed (it’s a valid starting state).

Sample Input-1:
---------------
5
1 0 0 0 1
1

Sample Output-1:
----------------
true

Explanation: 
------------
Plant at index 2 → [1,0,1,0,1].

Sample Input-2:
---------------
5
1 0 0 0 1
2

Sample Output-2:
----------------
false

Explanation: 
------------
Only one valid spot exists (index 2).

Sample Input-3:
---------------
1
0
1

Sample Output-3:
----------------
true

Explanation: 
------------
Single empty plot; planting is allowed.

Sample Input-4:
---------------
6
0 0 0 0 0 0
3

Sample Output-4:
----------------
true

Explanation: 
------------
One valid placement pattern is indices 0, 2, 4. */
public class Program3 {
    
}
