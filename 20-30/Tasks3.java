public class Tasks3 {

public static void main(String[] args)
{
    System.out.println("Выполнение первого таска");
    System.out.println(solutions(1,0,-1));
    System.out.println(solutions(1,0,0));
    System.out.println(solutions(1,0,1));

    System.out.println("Выполнение второго таска");
    System.out.println(findZip("all zip files are zipped"));
    System.out.println(findZip("all zip files are compressed"));

    System.out.println("Выполнение третьего таска");
    System.out.println(checkPerfect(6));
    System.out.println(checkPerfect(28));
    System.out.println(checkPerfect(496));
    System.out.println(checkPerfect(12));
    System.out.println(checkPerfect(97));

    System.out.println("Выполнение четвертого таска");    
    System.out.println(flipEndChars("Cat, dog, and mouse."));
    System.out.println(flipEndChars("ada"));
    System.out.println(flipEndChars("Ada"));
    System.out.println(flipEndChars("z"));

    System.out.println("Выполнение пятого таска");
    System.out.println(isValidHexCode("#CD5C5C"));
    System.out.println(isValidHexCode("#EAECEE"));
    System.out.println(isValidHexCode("#eaecee"));
    System.out.println(isValidHexCode("#CD5C58C"));
    System.out.println(isValidHexCode("#CD5C5Z"));
    System.out.println(isValidHexCode("#CD5C&C"));
    System.out.println(isValidHexCode("CD5C5C"));

    System.out.println("Выполнение шестого таска");
    int[] task611 = {1, 3, 4, 4, 4};
    int[] task612 = {2, 5, 7};
    int[] task621 = {9, 8, 7, 6};
    int[] task622 = {4, 4, 3, 1};
    int[] task631 = {2};
    int[] task632 = {3, 3, 3, 3, 3};
    System.out.println(same(task611, task612));
    System.out.println(same(task621, task622));
    System.out.println(same(task631, task632));

    System.out.println("Выполнение седьмого таска");
    System.out.println(isKaprekar(3));
    System.out.println(isKaprekar(5));
    System.out.println(isKaprekar(297));

    System.out.println("Выполнение восьмого таска");
    System.out.println(longestZero("01100001011000"));
    System.out.println(longestZero("100100100"));
    System.out.println(longestZero("11111"));

    System.out.println("Выполнение девятого таска");
    System.out.println(nextPrime(11));
    System.out.println(nextPrime(12));
    System.out.println(nextPrime(24));

    System.out.println("Выполнение десятого таска");
    System.out.println(rightTriangle(3, 4, 5));
    System.out.println(rightTriangle(145, 105, 100));
    System.out.println(rightTriangle(70, 130, 110));
}

public static int solutions(double a, double b, double c)
{
    if((Math.pow(b,2)-4*a*c) == 0)
        return 1;
    else if((Math.pow(b,2)-4*a*c) < 0)
        return 0;
    else
        return 2;
}
public static int findZip(String mes)
{
    int countZip = 0;
    boolean test = true;
    char[] zip = {'z', 'i', 'p'};
    char[] inputOne = mes.toCharArray();
    for(int i = 0; i<inputOne.length - 2; i++)
    {
        test = true;
        for(int k = 0; k<3; k++)
        {
            if(zip[k] != inputOne[i+k])
                test = false;
        }
        if(test)
            {
                countZip++;
                if(countZip == 2)
                    {
                        return i;
                    }
            }
    }
    return -1;
}
public static boolean checkPerfect(int N)
{
    int cheakOut = 0;
    for(int i = 1; i<N; i++)
    {
        if(N%i == 0)
            cheakOut += i;
    }
    return cheakOut == N;
}
public static String flipEndChars(String mes)
{
    if(mes.length() < 2)
        return "Incompatible.";
    else if(mes.charAt(0) == mes.charAt(mes.length() - 1))
        return "Two's a pair."; 
    else
        {
            char[] newChar = mes.toCharArray();
            newChar[0] = newChar[newChar.length - 1];
            String rez = "";
            for(char i : newChar)
                {
                    rez += i;
                }
            return rez;
        }
}
public static boolean isValidHexCode(String mes)
{
    if  ((mes.length() != 7) | (mes.charAt(0) != '#'))
        return false;
    else 
        {
            boolean test = false;
            String ref = "#0123456789abcdef";
            mes = mes.toLowerCase();
            for(int i = 0; i<mes.length(); i++)
            {
                test = false;
                for(int k = 0; k<ref.length(); k++)
                {
                    
                    if(mes.charAt(i) == ref.charAt(k))
                    {
                        test = true;
                        break;
                    }
                    
                }
                if (test == false)
                    return false;
            }
            return true;    
        }
}
public static boolean same(int[] mas1, int[] mas2) 
{
    return countUniqe(mas1) == countUniqe(mas2);
}
public static int countUniqe(int[] mas)
{
    String ref = "";
    boolean test = false;
    char tmp;
    for(int t = 0; t<mas.length; t++)
    {
        tmp = Integer.toString(mas[t]).charAt(0);
        test = false;
        for(int s = 0; s<ref.length(); s++)
        {
            if (tmp == ref.charAt(s))
                test = true;
        }
        if(test == false)
            ref += tmp;
    }
    return ref.length();
}
public static boolean isKaprekar(int n)
{
    int tmp = (int) Math.pow(n,2);
    String num = Integer.toString(tmp);
    if(num.length() == 1)
    {
        return (n == (tmp + 0));
    }
    else 
        {
            String val1 = "";
            String val2 = "";
            for(int i = 0; i<num.length()/2; i++)
                {
                    val1 += Character.toString(num.charAt(i));
                }
            for(int k = num.length()/2; k<num.length(); k++)
                {
                    val2 += Character.toString(num.charAt(k));
                }
            return (n == Integer.parseInt(val1) + Integer.parseInt(val2));
        }
}   
public static String longestZero(String input)
{
    int countZero = 0;
    int maxZero = 0;
    String rez = "";
    for(int i = 0; i < input.length(); i++)
    {
        if(input.charAt(i) == '0')
            countZero++;
        else
            {
                if(countZero > maxZero)
                    maxZero = countZero;
                countZero = 0;
            }
    }
    for(int k = 0; k < maxZero; k++)
    {
        rez += "0";
    }
    return rez;
}

public static int nextPrime(int input)
{
    int i = 2;
    while(true)
    {
        if((input % i == 0) & (i != input))
            {
                input++;
                i = 2;
            }
        else if (i >= input)
            return input;
        i++;
    }
}
public static boolean rightTriangle(int a, int b, int c)
{
    int val1 = 0;
    int val2 = 0;
    //int max = (a > b ? a : b) > c ? (a > b ? a : b) : c;
    int max = Math.max(Math.max(a,b),c);
    if((a > b) & (a > c))
        {
            val1 = b;
            val2 = c;
        }
    else if(((b > a) & (b > c)))
        {
            val1 = a;
            val2 = c;
        }
    else if((c > a) & (c > b))
        {
            val1 = a;
            val2 = b;
        }
    return (Math.pow(max,2) == (Math.pow(val1,2) + Math.pow(val2,2)));
}
}
