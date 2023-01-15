import com.thinking.machines.utils.*;
class psp
{
public static void main(String args[])
{
Keyboard k=new Keyboard();
int roll;
try
{
roll=k.getInt("Enter Roll Number: ");
System.out.print(roll);
}catch(Exception e)
{
System.out.print(e.getMessage());
}
}
}
