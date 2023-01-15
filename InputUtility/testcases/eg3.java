import com.thinking.machines.utils.Keyboard;
class psp
{
public static void main(String []args)
{
char c;
String name;
Keyboard k=new Keyboard();
System.out.print("Enter your character: ");
c=k.getChar();
System.out.print("Enter your name: ");
name=k.getString();
System.out.printf("%c and %s you entered\n",c,name);
}
}
