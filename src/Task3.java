//package lab1.example.third;
import java.util.Scanner;
public class Task3 {
static Scanner in;
static int [][] Input (int n){
System.out.println("Розмірність масиву ");
System.out.print("n = ");
n=in.nextInt();
int a[][] = new int[n][n];
for (int i = 0; i < n; ++i)
for (int j = 0; j < n; ++j)
{
System.out.print("a["+i+","+j+"]= ");
a[i][j]=in.nextInt();
}
return a;
}
static void Print(int[][] a){
for (int i = 0; i < a.length; ++i, System.out.println() )
for (int j = 0; j < a[i].length; ++j)
System.out.print(a[i][j]+"\t");
}
static double Result(int[][] a){
int k=0;
double s=0;
for (int i = 0; i < a.length; ++i)
for (int j = i+1; j < a[i].length; ++j)
if (a[i][j] %2!= 0) {++k; s+=a[i][j];}
if (k!=0) return s/k;
else return 0;
}
public static void main(String[] args) {
in = new Scanner(System.in);
int n = 0;
int[][] myArray=Input(n);
System.out.println("Вихідний масив:");
Print(myArray);
System.out.println("Результат: "+Result(myArray));
}
}
