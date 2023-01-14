package com.thinking.machines.utils;
import java.util.Scanner;
public class Keyboard
{
private Scanner k;
public Keyboard()
{
k=new Scanner(System.in);
}
public String getString()
{
return k.nextLine();
}
public String getString(String message)
{
System.out.print(message);
return k.nextLine();
}
}
