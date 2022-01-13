

import java.awt.desktop.SystemEventListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task6 {

    public static void main(String[] args) {
        System.out.println("Выполнение первого таска");
        System.out.println(Bell(1));
        System.out.println(Bell(2));
        System.out.println(Bell(3));
        System.out.print("\n");

        System.out.println("Выполнение второго таска");
        System.out.println(translateWord("flag"));
        System.out.println(translateWord("Apple"));
        System.out.println(translateWord("button")) ;
        System.out.println(translateWord(""));
        System.out.println(translateSentence("I like to eat honey waffles."));
        System.out.println(translateSentence("Do you think it is going to rain today?"));
        System.out.print("\n");

        System.out.println("Выполнение третьего таска");
        System.out.println(validColor("rgb(0,0,0)"));
        System.out.println(validColor("rgb(0,,0)"));
        System.out.println(validColor("rgb(255,256,255)"));
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));
        System.out.print("\n");

        System.out.println("Выполнение четвертого таска");
        System.out.println(stripUrlParams("https://edabit.com?a=2&b=2&a=1") );
        System.out.println(stripUrlParams("https://edabit.com?a=2&b=2&a=1", "b"));
        System.out.println(stripUrlParams("https://edabit.com", "b"));
        System.out.print("\n");

        System.out.println("Выполнение пятого таска");
        System.out.println(getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        System.out.println(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year"));
        System.out.println(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
        System.out.println(getHashTags("Visualizing Science"));
        System.out.print("\n");

        System.out.println("Выполнение шестого таска");
        System.out.println(ulam(4));
        System.out.println(ulam(9));
        System.out.println(ulam(206));
        System.out.print("\n");

        System.out.println("Выполнение седьмого таска");
        System.out.println(longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(longestNonrepeatingSubstring("aaaaaaa"));
        System.out.println(longestNonrepeatingSubstring("abcde"));
        System.out.println(longestNonrepeatingSubstring("abcda"));
        System.out.print("\n");

        System.out.println("Выполнение восьмого таска");
        System.out.println(convertToRoman(2));
        System.out.println(convertToRoman(12));
        System.out.println(convertToRoman(16));

        System.out.print("\n");

        System.out.println("Выполнение девятого таска");
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));
        System.out.print("\n");

        System.out.println("Выполнение десятого таска");
        System.out.println(palindromeDescendant(11211230));
        System.out.println(palindromeDescendant(13001120));
        System.out.println(palindromeDescendant(23336014));
        System.out.println(palindromeDescendant(11));
    }

    static int S(int n, int k)
    {
        if (n == k)
            return 1;
        else if (k == 0)
            return 0;
        else
            return S(n - 1, k - 1) + k * S(n - 1, k);
    }

    public static int Bell(int num)
    {
        int bell =0;
        for (int m=0; m<num+1; m++)
        {
            bell+=S(num, m);
        }
        return bell;
    }

    public static String translateWord(String word)
    {
        String stic = "";
        if (word.equals(""))return "\"\"";
        boolean save = false;
        if (String.valueOf(word.charAt(0)).matches("[A-Z]"))
            save = true;
        word = word.toLowerCase();
        String[] str = word.split("");
        if (str[0].matches("^(?i:[aeiouy]).*"))
        {
            stic = word + "yay";
        }
        else
        {
            String sum = "";
            for (int i=1; i<str.length; i++)
            {
                sum += str[i];
            }
            sum+=str[0]+ "ya";
            stic = sum;
        }
        if (save)
        {
            return stic.substring(0,1).toUpperCase()+stic.substring(1,stic.length()-1);
        }
        return stic;
    }

    public static String translateSentence(String pred)
    {
        String[] str = pred.split(" ");
        String r = "";
        String rec = String.valueOf(str[str.length-1].charAt(str[str.length-1].length()-1));
        str[str.length-1]=str[str.length-1].substring(0, str[str.length-1].length()-1);
        String sum = "";
        for (int i=0;i<str.length;i++)
        {
            if(i< str.length-1)
                sum+=translateWord(str[i])+" ";
            else sum+=translateWord(str[i]);
        }
        return sum+rec;
    }

    public static boolean validColor(String str)
    {
        if(Pattern.matches("rgb\\([0-255],[0-255],[0-255]\\)", str))
            return true;
        else if(Pattern.matches("rgba\\([0-255],[0-255],[0-255],([0]*[.])?[0-9]+\\)", str))
        {
            return true;
        }
        else
            return false;
    }

    public static String stripUrlParams(String url)
    {
        boolean rec = false;
        int c = 0;
        int sum=0;
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\\?.+a");
        Matcher matcher = pattern.matcher(url);
        while (matcher.find())
        {
            result.append(url, matcher.start(), matcher.end() - 2);
            c=matcher.start();
            if (rec)
            {
                if (sum> (int) url.charAt(matcher.end()))
                {
                    result.append(url, matcher.start(), matcher.end() - 2);
                }
            }
            else{
                sum = (int) url.charAt(matcher.end());
            }
            rec=true;

        }
        return url.substring(0,c)+result;
    }

    public static String stripUrlParams(String url, String ff)
    {
        String url1 = stripUrlParams(url);
        boolean rec = true;
        Pattern pattern = Pattern.compile("b=+?[0-9]");
        Matcher matcher = pattern.matcher(url1);
        while (matcher.find())
        {
            url1 = url1.replaceAll(url1.substring(matcher.start()-1, matcher.end()), "");
            rec = false;
        }
        if (rec) return url;
        else return url1;
    }

    private static int getMaxLenght(String[] m)
    {
        int k = m[0].length();
        for(int i=1;i<m.length;i++)
            if(m[i].length() > k ) k = m[i].length();
        return k;
    }

    private static String getHashTags(String s)
    {
        s = s.replaceAll("([!@#$%^&*<>?.,\";':|])", "");
        String[] arr = s.split(" ");
        Arrays.sort(arr, Comparator.comparing(String::length).reversed());
        if(arr.length <= 3)
        {
            for(int i = 0; i < arr.length; i++)
            {
                arr[i] = "#" + arr[i];
            }
            return Arrays.toString(arr);
        }
        else
        {
            String[] rez = new String[3];
            for (int i = 0; i < 3; i++)
            {
                rez[i] = "#" + arr[i];
            }
            return Arrays.toString(rez);
        }
    }

    public static int ulam(int num)
    {
        int[] arr = new int[num];
        int count = 2;
        arr[0] = 1;
        arr[1] = 2;
        int check = 2;
        int control;
        int tmp;
        do
        {
            check += 1;
            control = 0;
            for (int n = 0; n < count; n++)
            {
                tmp = check - arr[n];
                for (int k = 0; k < count; k++)
                {
                    if((tmp == arr[k])&(tmp != arr[n]))
                        control++;
                    if(control > 2)
                        break;
                }
                if(control > 2)
                    break;
            }
            if(control == 2)
                arr[count++] = check;
        } while (count < num);
        return arr[arr.length - 1];
    }

    public static String longestNonrepeatingSubstring(String input)
    {
        String output = "";
        String output1 = "";
        boolean rec = true;
        for (int start = 0; start < input.length(); start++)
        {
            Set visited = new HashSet();
            int end = start;
            for (; end < input.length(); end++)
            {
                char currChar = input.charAt(end);
                if (visited.contains(currChar))
                {
                    break;
                } else
                {
                    visited.add(currChar);
                }
            }
            if ((output.length() < end - start + 1) && rec)
            {
                output = input.substring(start, end);
                rec = false;
            }
            if (output.length() < end - start + 1)
            {
                output1 = input.substring(start, end);
            }
            if (output.length()<output1.length())
            {
                output = output1;
            }
        }
        return output;
    }

    public static String convertToRoman(int num)
    {
        StringBuilder rez = new StringBuilder();
        String str = Integer.toString(num);
        for(int i = str.length(); i > 0; i--)
        {
            final char c = str.charAt(str.length() - i);
            switch (i)
            {
                case 4:
                    switch (c)
                    {
                        case '1': rez.append("M");
                            break;
                        case '2': rez.append("MM");
                            break;
                        case '3': rez.append("MMM");
                            break;
                        default: break;
                    }
                    break;
                case 3:
                    switch (c)
                    {
                        case '1': rez.append("C");
                            break;
                        case '2': rez.append("CC");
                            break;
                        case '3': rez.append("CCC");
                            break;
                        case '4': rez.append("CD");
                            break;
                        case '5': rez.append("D");
                            break;
                        case '6': rez.append("DC");
                            break;
                        case '7': rez.append("DCC");
                            break;
                        case '8': rez.append("DCCC");
                            break;
                        case '9': rez.append("CM");
                            break;
                        default: break;
                    }
                    break;
                case 2:
                    switch(c)
                    {
                        case '1': rez.append("X");
                            break;
                        case '2': rez.append("XX");
                            break;
                        case '3': rez.append("XXX");
                            break;
                        case '4': rez.append("XL");
                            break;
                        case '5': rez.append("L");
                            break;
                        case '6': rez.append("LX");
                            break;
                        case '7': rez.append("LXX");
                            break;
                        case '8': rez.append("LXXX");
                            break;
                        case '9': rez.append("XC");
                            break;
                        default: break;
                    }
                    break;
                case 1:
                    switch(c)
                    {
                        case '1': rez.append("I");
                            break;
                        case '2': rez.append("II");
                            break;
                        case '3': rez.append("III");
                            break;
                        case '4': rez.append("IV");
                            break;
                        case '5': rez.append("V");
                            break;
                        case '6': rez.append("VI");
                            break;
                        case '7': rez.append("VII");
                            break;
                        case '8': rez.append("VIII");
                            break;
                        case '9': rez.append("IX");
                            break;
                        default: break;
                    }
                    break;
                default : break;
            }
        }
        return rez.toString();
    }

    public static boolean formula(String form)
    {
        String[] splited = form.split("=");
        boolean check = true;
        double num_0 = 0;
        for(int k = 0; k<splited.length; k ++)
        {
            double num = 0;
            String[] tmp = splited[k].split(" ");
            for(int i = 0; i < tmp.length; i++)
            {
                if(tmp[i].equals(""))
                    i++;
                if (tmp[i].equals("/"))
                    num = num / Double.parseDouble(tmp[++i]);
                else if (tmp[i].equals("*"))
                    num = num * Double.parseDouble(tmp[++i]);
                else if (tmp[i].equals("+"))
                    num = num + Double.parseDouble(tmp[++i]);
                else if (tmp[i].equals("-"))
                    num = num - Double.parseDouble(tmp[++i]);
                else
                    num = Double.parseDouble(tmp[i]);
            }
            if(k != 0)
            {
                if (num_0 != num)
                    return false;
                else
                    num_0 = num;
            }
            else
                num_0 = num;
        }

        return true;
    }

    public static boolean isPalindrome(int x)
    {
        boolean isPolindrom = true;
        String s = Integer.toString(x);
        int[] arr = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--)
        {
            arr[i] = x % 10;
            x /= 10;
        }
        for(int i=0; i < arr.length;i++)
        {
            if(arr[i] != arr[arr.length-i-1])
            {
                isPolindrom = false;
                break;
            }
        }
        return isPolindrom;
    }

    public static boolean palindromeDescendant(int number)
    {
        String s;
        int num = number;
        int[] arr;
        int[] arr2;
        if (isPalindrome(number))
        {
            return true;
        }
        else
        {
            while (number-10>0)
            {
                if (isPalindrome(number))
                {
                    return true;
                }
                else if (number/10+number%10<10)
                {
                    return false;
                }
                else{
                    s = Integer.toString(number);
                    arr = new int[s.length()];
                    for (int i = s.length() - 1; i >= 0; i--)
                    {
                        arr[i] = num % 10;
                        num /= 10;
                    }
                    arr2 = new int[arr.length/2];
                    int a = 0;
                    for (int i=0; i<arr.length; i++)
                    {
                        arr2[a] = arr[i] + arr[i+1];
                        i++;
                        a+=1;
                    }
                    String n="";
                    for(int i: arr2)
                    {
                        n+=String.valueOf(i);
                    }
                    number=Integer.parseInt(n);
                    num = number;
                }
            }
            if (isPalindrome(number))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
