public class Task1 {
    public static void main (String [] args)
	{
        System.out.println("Выполнение первого таска");
        System.out.println(remainder(1,3));
        System.out.println(remainder(3,4));
        System.out.println(remainder(-9,45));
        System.out.println(remainder(5,5));

        System.out.println("Выполнение второго таска");
        System.out.println(triArea(3,2));
        System.out.println(triArea(7,4));
        System.out.println(triArea(10,10));

        System.out.println("Выполнение третьего таска");
        System.out.println(animals(2,3,5));
        System.out.println(animals(1,2,3));
        System.out.println(animals(5,2,8));

        System.out.println("Выполнение четвертого таска");
        System.out.println(profitableGamble(0.2,50,9));
        System.out.println(profitableGamble(0.9,1,2));
        System.out.println(profitableGamble(0.9,3,2));
        
        System.out.println("Выполнение пятого таска");
        System.out.println(operation(24,15,9));
        System.out.println(operation(24,26,2));
        System.out.println(operation(15,11,11));

        System.out.println("Выполнение шестого таска");
        System.out.println(ctoa('A'));
        System.out.println(ctoa('m'));
        System.out.println(ctoa('['));

        System.out.println("Выполнение седьмого таска");
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(7));

        System.out.println("Выполнение восьмого таска");
        System.out.println(nextEdge(8,10));
        System.out.println(nextEdge(5,7));
        System.out.println(nextEdge(9,2));


        System.out.println("Выполнение девятого таска");
        int[] first = {1, 5, 9};
        int[] second = {3, 4, 5};
        int[] third = {2};
        int[] fourth = {};
        System.out.println(sumOfCubes(first));
        System.out.println(sumOfCubes(second));
        System.out.println(sumOfCubes(third));
        System.out.println(sumOfCubes(fourth));

        System.out.println("Выполнение десятого таска");
        System.out.println(abcmath(42,5,10));
        System.out.println(abcmath(5,2,1));
        System.out.println(abcmath(1,2,3));
	}
    
    public static int remainder (int a, int b)
    {
        return a-b*(a/b);
    }

    public static int triArea (int a, int b)
    {
        return a*b/2;
    }

    public static int animals (int a, int b, int c)
    {
        return a*2+b*4+c*4;
    }

    public static boolean profitableGamble (double a, double b, double c)
    {
        return a*b>c;
    }

    public static String operation (int N, int a, int b)
    {
        if (N == a+b)
            return "added";
        else if (N == a-b)
            return "subtracted";
        else if (N == a*b)
            return "multiplied";
        else if (N == a/b)
            return "divided";
        else 
            return "none";
    }

    public static int ctoa (char a)
    {
        return a;
    }

    public static int addUpTo (int n)
    {
        int count = 0;
        for (int i = 0; i <= n; i++)
            count = count + i;
        return count;
    }

    public static int nextEdge (int a, int b)
    {
        return a+b-1;
    }

    public static int sumOfCubes (int[] a)
    {
        int count = 0;
        for (int i = 0; i <= a.length - 1; i++) 
            count += Math.pow (a[i],3); // pow (Integer.parseInt(a[i]),3);
        return count;
    }

    public static boolean abcmath (int a, int b, int c)
    {
        int count = 0;
        for (int i=0; i <= b; i++)
        {
            count = count + a;
            a = count;
        }
        return count%c==0;
    }
}
