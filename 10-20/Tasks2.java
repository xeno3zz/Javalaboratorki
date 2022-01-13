public class Tasks2 {

public static void main (String[] args)
{
    System.out.println("Выполнение первого таска");
    System.out.println(repeat("mice", 5));
    System.out.println(repeat("hello", 3));
    System.out.println(repeat("stop", 1));

    System.out.println("Выполнение второго таска");
    double[] mas1 = {10, 4, 1, 4, -10, -50, 32, 21};
    double[] mas2 = {44, 32, 86, 19};
    System.out.println(differenceMaxMin(mas1));
    System.out.println(differenceMaxMin(mas2));

    System.out.println("Выполнение третьего таска");
    int[] T3mas1 = {1, 3};
    int[] T3mas2 = {1, 2, 3, 4};
    int[] T3mas3 = {1, 5, 6};
    int[] T3mas4 = {1, 1, 1};
    int[] T3mas5 = {9, 2, 2, 5};
    System.out.println(isAvgWhole(T3mas1));
    System.out.println(isAvgWhole(T3mas2));
    System.out.println(isAvgWhole(T3mas3));
    System.out.println(isAvgWhole(T3mas4));
    System.out.println(isAvgWhole(T3mas5));

    System.out.println("Выполнение четвертого таска");
    int[] T4mas1 = {1, 2, 3};
    int[] T4mas2 = {1, -2, 3};
    int[] T4mas3 = {3, 3, -2, 408, 3, 3};
    T4mas1 = cumulativeSum(T4mas1);
    T4mas2 = cumulativeSum(T4mas2);
    T4mas3 = cumulativeSum(T4mas3);
    for (int i : T4mas1)
        System.out.print(i+" ");
    System.out.print("\n");
    for (int i : T4mas2)
        System.out.print(i+" ");
    System.out.print("\n");
    for (int i : T4mas3)
        System.out.print(i+" ");
    System.out.print("\n");

    System.out.println("Выполнение пятого таска");
    System.out.println(getDecimalPlaces("43.20"));
    System.out.println(getDecimalPlaces("400"));
    System.out.println(getDecimalPlaces("3.1"));

    System.out.println("Выполнение шестого таска");
    System.out.println(Fibonacci(3));
    System.out.println(Fibonacci(7));
    System.out.println(Fibonacci(12));

    System.out.println("Выполнение седьмого таска");
    System.out.println(isValid("59001"));
    System.out.println(isValid("853a7"));
    System.out.println(isValid("732 32"));
    System.out.println(isValid("393939"));

    System.out.println("Выполнение восьмого таска");
    System.out.println(isStrangePair("sparkling", "groups"));
    System.out.println(isStrangePair("bush", "hubris"));
    System.out.println(isStrangePair("", ""));

    System.out.println("Выполнение девятого таска");
    System.out.println(isPrefix("automation", "auto-"));
    System.out.println(isPrefix("retrospect", "sub-"));
    System.out.println(isSuffix("arachnophobia", "-phobia"));
    System.out.println(isSuffix("vocation", "-logy"));

    System.out.println("Выполнение десятого таска");
    System.out.println(boxSeq(0));
    System.out.println(boxSeq(1));
    System.out.println(boxSeq(2));
}
public static String repeat (String mes, int N)
{
    char[] work = mes.toCharArray();
    String rez = "";
    for(char symbol : work)
    {
        for(int i = 0; i<N; i++)
            rez += symbol;
    }
    return rez;
}
public static double differenceMaxMin(double[] input)
{
    double maxVal = input[0];
    double minVal = input[0];
    for(double val : input)
    {
        if(maxVal < val)
            maxVal = val;
        if(minVal > val)
            minVal = val;
    }
    return maxVal - minVal;
}
public static boolean isAvgWhole(int[] input)
{
    double sum = 0; 
    for(int val : input)
    {
        sum += val;
    }
    double rez = sum/input.length;
    if (rez == (int) rez)
        return true;
    else
        return false;
}
public static int[] cumulativeSum(int[] input)
{
    int k = 0;
    int sum = 0;
    for(int i : input)
    {
        input[k++] = sum += i; 
    }
    return input;
}
public static int getDecimalPlaces(String input)
{
    String rez = "0";
    for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == '.')
                rez += input.charAt(i+1);
        }
    return Integer.parseInt(rez);
}
public static int Fibonacci(int N)
{
    int firstVal = 0;
    int rez = 1;
    int tmp = 0;
    for (int i = 0; i < N; i++)
    {
        tmp = rez;
        rez = firstVal + rez;
        firstVal = tmp;
    }
    return rez;
}
public static boolean isValid(String mes)
{
    char[] nums = {'0','1','2','3','4','5','6','7','8','9'};
    boolean test = false;
    if (mes.length() != 5)
        return false;
    else
        {
            for (int i = 0; i < 5; i++)
            {
                test = false;
                for (char k : nums)
                    {
                        if (mes.charAt(i) == k)
                            test = true;
                    }

                if (test == false)
                {
                    return false;
                }                    
            }
            return true;
        }
}
public static boolean isStrangePair(String mes1, String mes2)
{
    if((mes1 == "") && (mes2 == ""))
        return true;
    else if (((mes1 == "") && (mes2 != "")) || ((mes2 == "") && (mes1 != "")))
        return false;
    else
        return (mes1.charAt(0) == mes2.charAt(mes2.length()-1) && (mes1.charAt(mes1.length()-1) == mes2.charAt(0)));
}
public static boolean isPrefix(String word, String prefix)
{
    boolean test = true;
    for (int i = 0; i < prefix.length() - 1; i++)
        if(word.charAt(i) != prefix.charAt(i))
            test = false;
    return test;
}
public static boolean isSuffix(String word, String suffix)
{
    boolean test = true;
    for (int i = 0; i < suffix.length() - 1; i++)
        if(word.charAt(word.length() - i - 1) != suffix.charAt(suffix.length()- i - 1))
            test = false;
    return test;
}
public static int boxSeq(int N)
{
    int rez = 0;
    int p = 3;
    for(int i = 0; i<N; i++)
    {
        rez += p;
        p = 2 - p;
    }
    return rez;
}
}