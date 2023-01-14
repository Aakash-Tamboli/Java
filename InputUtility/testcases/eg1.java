import com.thinking.machines.utils.*;
class psp
{
public static void main(String []args)
{
Keyboard k=new Keyboard();
String name,anotherName;
char gender;
int age;
age=k.getInt("What is Your Age: ");
name=k.getString("What is Your Name: "); // We need to implement this
anotherName=k.getString("What is your friend name: ");
System.out.println("I found your name is: "+name+" and your age is: "+age+" and your friend name is: "+anotherName);
}
}
