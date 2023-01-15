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
public long getLong()
{
this.clearingBufferNeeded=true;
return this.k.nextLong();
}
public long getLong(String message)
{
System.out.print(message);
this.clearingBufferNeeded=true;
return this.k.nextLong();
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

public short getShort()
{
this.clearingBufferNeeded=true;
return this.k.nextShort();
}

public short getShort(String message)
{
System.out.print(message);
this.clearingBufferNeeded=true;
return this.k.nextShort();
}

public byte getByte()
{
this.clearingBufferNeeded=true;
return this.k.nextByte();
}

public byte getByte(String message)
{
System.out.print(message);
this.clearingBufferNeeded=true;
return this.k.nextByte();
}

public char getChar()
{
this.clearingBufferNeeded=true;
return this.k.next().charAt(0);
}

public char getChar(String message)
{
System.out.print(message);
this.clearingBufferNeeded=true;
return this.k.next().charAt(0);
}

public float getFloat()
{
this.clearingBufferNeeded=true;
return this.k.nextFloat();
}

public float getFloat(String message)
{
System.out.print(message);
this.clearingBufferNeeded=true;
return this.k.nextFloat();
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

public double getDouble()
{
this.clearingBufferNeeded=true;
return this.k.nextDouble();
}
public double getDouble(String message)
{
System.out.print(message);
this.clearingBufferNeeded=true;
return this.k.nextDouble();
}
} // class closing parenthesis
