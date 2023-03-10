class TMArrayList<T>
{
private Object[] collection;
private int capacity;
private int size;
TMArrayList()
{
this.collection=new Object[10];
this.size=0;
this.capacity=10;
}
public void add(T data)
{
if(this.capacity==this.size)
{
Object []o;
o=new Object[this.capacity*2];
for(int i=0;i<this.size;i++)
{
o[i]=this.collection[i];
}
this.collection=o;
this.capacity=this.capacity*2;
}
this.collection[this.size]=data;
this.size++;
}
public int size()
{
return this.size;
}
public T get(int i)
{
if(i>=this.size) return null;
else return (T)this.collection[i];
}
public int getCapacity()
{
return this.capacity;
}
}
class psp
{
public static void main(String []args)
{
TMArrayList<Integer> list=new TMArrayList<Integer>();
for(int i=0;i<500;i++) list.add(i);
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("currently capacity: "+list.getCapacity());
}
}