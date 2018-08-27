class swap
{
    public static void main(String arg[])
    {
        int x=100;
        int y=20;
        System.out.println("x:"+x);
        System.out.println("y:"+y);
        System.out.println("swapping x and y");
        x=x+y;
        y=x-y;
        x=x-y;
        System.out.println("new value of x:"+x);
        System.out.println("new value of y:"+y);
    }
}

