//package lab1.example.second;
import java.util.Scanner;
public class Task2 {
static Scanner in;
static int [] Input()
{
System.out.println("Розмірність масиву");
int n=in.nextInt();
int []a=new int[n];
for (int i = 0; i < n; ++i)
{
System.out.print("a["+i+"]= ");
a[i]=in.nextInt();
}
return a;
}
static void Print(int[] a)
{
for (int i = 0; i < a.length; ++i)
System.out.print(a[i]+" ");
System.out.println();
}
static void Change(int[] a)
{
for (int i = 0; i < a.length; ++i)
if (a[i] > 0) a[i] = -a[i];
}
public static void main(String[] args) {
in = new Scanner(System.in);
int[] myArray=Input();
System.out.println("Вихідний масив:");
Print(myArray);
Change(myArray);
System.out.println("Змінений массив:");
Print(myArray);
}
}