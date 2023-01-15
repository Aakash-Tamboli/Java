import java.util.Scanner;
class psp
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
boolean bool,anotherBool;
String name;
System.out.print("Enter true or false: ");
bool=sc.nextBoolean();
System.out.print("Enter true or false: ");
anotherBool=sc.nextBoolean();
sc.nextLine();
System.out.print("Enter your name: ");
name=sc.nextLine();
System.out.print(bool+" | "+anotherBool+" | "+name);
}
}
