package com.thinking.machines.utils;
import java.util.Scanner;
public class Keyboard
{
private Scanner k;
private boolean clearingBufferNeeded;
public Keyboard()
{
this.k=new Scanner(System.in);
this.clearingBufferNeeded=false;
}
public String getString()
{
if(this.clearingBufferNeeded==true)
{
this.k.nextLine();
this.clearingBufferNeeded=false;
}
return this.k.nextLine();
}
public String getString(String message)
{
System.out.print(message);
if(this.clearingBufferNeeded==true)
{
this.k.nextLine();
this.clearingBufferNeeded=false;
}
return this.k.nextLine();
}
public int getInt()
{
this.clearingBufferNeeded=true;
return this.k.nextInt();
}
public int getInt(String message)
{
System.out.print(message);
this.clearingBufferNeeded=true;
return this.k.nextInt();
}
}
