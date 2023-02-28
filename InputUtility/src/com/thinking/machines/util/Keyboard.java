package com.thinking.machines.util;
import java.io.*;
public class Keyboard
{
private BufferedReader bufferReader;
public Keyboard()
{
this.bufferReader=new BufferedReader(new InputStreamReader(System.in));
}

public String getString()
{
String variable;
try
{
variable=this.bufferReader.readLine();
}catch(IOException ioException)
{
variable="";
}
return variable;
}
public String getString(String message)
{
System.out.print(message);
return this.getString();
}

public char getCharacter()
{
return this.getString().charAt(0);
}

public char getCharacter(String message)
{
System.out.print(message);
return this.getCharacter();
}

public long getLong()
{
long variable;
try
{
variable=Long.parseLong(this.getString());
}catch(NumberFormatException numberFormateException)
{
variable=0;
}
return variable;
}
public long getLong(String message)
{
System.out.print(message);
return this.getLong();
}


public int getInt()
{
int variable;
try
{
variable=Integer.parseInt(this.getString());
}catch(NumberFormatException numberFormateException)
{
variable=0;
}
return variable;
}
public int getInt(String message)
{
System.out.print(message);
return this.getInt();
}


public short getShort()
{
short variable;
try
{
variable=Short.parseShort(this.getString());
}catch(NumberFormatException numberFormateException)
{
variable=0;
}
return variable;
}
public short getShort(String message)
{
System.out.print(message);
return this.getShort();
}


public byte getByte()
{
byte variable;
try
{
variable=Byte.parseByte(this.getString());
}catch(NumberFormatException numberFormateException)
{
variable=0;
}
return variable;
}
public byte getByte(String message)
{
System.out.print(message);
return this.getByte();
}

public double getDouble()
{
double variable;
try
{
variable=Double.parseDouble(this.getString());
}catch(NumberFormatException numberFormateException)
{
variable=0;
}
return variable;
}
public double getDouble(String message)
{
System.out.print(message);
return this.getDouble();
}

public float getFloat()
{
float variable;
try
{
variable=Float.parseFloat(this.getString());
}catch(NumberFormatException numberFormateException)
{
variable=0;
}
return variable;
}
public float getFloat(String message)
{
System.out.print(message);
return this.getFloat();
}


public boolean getBoolean()
{
boolean variable;
try
{
variable=Boolean.parseBoolean(this.getString());
}catch(NumberFormatException numberFormateException)
{
variable=false;
}
return variable;
}
public boolean getBoolean(String message)
{
System.out.print(message);
return this.getBoolean();
}
}
