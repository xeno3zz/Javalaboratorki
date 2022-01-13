import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.regex.*;

public class Tasks4 {

    final static void main(String[] args)
    {
        System.out.println("Выполнение первого таска");
        System.out.println(Bessie(7, "hello my name is Bessie and this is my essay"));

        System.out.print("\n");

        System.out.println("Выполнение второго таска");
        String[] task21 = split("()()()");
        String[] task22 = split("((()))");
        String[] task23 = split("((()))(())()()(()())");
        String[] task24 = split("((())())(()(()()))");
        for(String k : task21)
        {
            System.out.print(k + " ");
        }
        System.out.print("\n");
        for(String k : task22)
        {
            System.out.print(k + " ");
        }
        System.out.print("\n");
        for(String k : task23)
        {
            System.out.print(k + " ");
        }
        System.out.print("\n");
        for(String k : task24)
        {
            System.out.print(k + " ");
        }

        System.out.print("\n" + "\n");

        System.out.println("Выполнение третьего таска");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toSnakeCase("getColor"));
        System.out.print("\n");

        System.out.println("Выполнение четвертого таска");
        System.out.println(overTime(new double[] {9, 17, 30, 1.5}));
        System.out.println(overTime(new double[] {16, 18, 30, 1.8}));
        System.out.println(overTime(new double[] {13.25, 15, 30, 1.5}));
        System.out.print("\n");

        System.out.println("Выполнение пятого таска");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.print("\n");

        System.out.println("Выполнение шeстого таска");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
        System.out.print("\n");

        
        System.out.println("Выполнение седьмого таска");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));
        System.out.print("\n");

        System.out.println("Выполнение восьмого таска");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        System.out.print("\n");

        System.out.println("Выполнение девятого таска");
        System.out.println(trouble(451999277, 41177722899L));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));
        System.out.print("\n");

        System.out.println("Выполнение десятого таска");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
    }

    public static String Bessie(int k, String mess)
    {
        String[] arr = mess.split(" ");
        String rez = "";
        int sum = 0;
        for(String word : arr)
        {
            sum += word.length();
            if(sum > k)
                {
                    rez += "\n" + word + " ";
                    sum = word.length();
                }
            else
                rez += word + " ";
        }
        return rez.trim();
    }

    public static String[] split(String mes)
    {
        int open = 0;
        String rez = "";
        char[] arr = mes.toCharArray();
        for(char one : arr)
        {
            if(one == '(')
                open++;
            if(one == ')')
                open--;
            rez += one;
            if(open == 0)
            {
                rez += " ";
            }
        }
        return rez.split(" ");
    }

    public static String toCamelCase(String mes)
    {
        String rez = "";
        char[] arr = mes.toCharArray();
        for (int i = 0; i < arr.length; i++) 
        {
            if(arr[i] != '_')
                rez += arr[i];
            else
                {
                    i++;
                    rez += Character.toUpperCase(arr[i]);
                }
        }
        return rez;
    }
    public static String toSnakeCase(String mes)
    {
        String rez = "";
        char[] arr = mes.toCharArray();
        for (char letter : arr) 
        {
            if(Character.isUpperCase(letter))
                rez += "_" + Character.toLowerCase(letter);
            else
                {
                    rez += letter;
                }
        }
        return rez;
    }

    public static String overTime(double [] in)
    {
        if(in[1] > 17)
            {
                BigDecimal bd = new BigDecimal((17 - in[0]) * in[2] + (in[1] - 17) * in[2] * in[3]);
                return (bd.setScale(2, RoundingMode.HALF_UP)).toString();
            }
        else
            {
                BigDecimal bd = new BigDecimal(in[2] * (in[1] - in[0]));
                return (bd.setScale(2, RoundingMode.HALF_UP)).toString();
            }
    }
    public static String BMI(String weigth, String height)
    {
        double numWeight = 0;
        double numHeight = 0;
        String[] wei = weigth.split(" ");
        String[] hei = height.split(" ");
        if (wei[1].equals("pounds"))
            numWeight = Double.parseDouble(wei[0]) / 2.2046;
        else if (wei[1].equals("kilos"))
            numWeight = Double.parseDouble(wei[0]);

        if(hei[1].equals("inches"))
            numHeight = Double.parseDouble(hei[0]) / 39.370;
        else if(hei[1].equals("meters"))
            numHeight = Double.parseDouble(hei[0]);

        if(numWeight/(numHeight*numHeight) < 18.5)
        {
            BigDecimal bd = new BigDecimal(numWeight/(numHeight*numHeight));
            return (bd.setScale(1, RoundingMode.HALF_UP)).toString() + " Underweight";
        }
        else if(numWeight/(numHeight*numHeight) > 25)
        {
            BigDecimal bd = new BigDecimal(numWeight/(numHeight*numHeight));
            return (bd.setScale(1, RoundingMode.HALF_UP)).toString() + " Overweight";
        }
        else 
        {
            BigDecimal bd = new BigDecimal(numWeight/(numHeight*numHeight));
            return (bd.setScale(1, RoundingMode.HALF_UP)).toString() + " Normal weight";
        }
    }

    public static int bugger(int num)
    {
        int count = 0;
        while (true)
        {
            int len = Integer.toString(num).length();
            int sum = 1;
            if(len == 1)
                return count;
            char[] arr = (Integer.toString(num)).toCharArray();
            for (char one : arr) 
            {
                sum = sum * Character.getNumericValue(one);
            }
            num = sum;
            count++;
        }
    }

    public static String toStarShorthand(String mes)
    {
        char[] arr = mes.toCharArray();
        int count = 1;
        char lastOne = ' ';
        String rez = "";
        for (char c : arr)
        {
            if((count != 1) & (c != lastOne))
            {
                rez += "*" + count + c;
                count = 0;
                lastOne = c;
            }

            if(c != lastOne)
            {
                rez += c;
                lastOne = c;
            }
            else
                count++;
        }
        if(count != 1)
            return rez + "*" + count;
        return rez;
    }
    
    public static boolean doesRhyme(String mes, String mes2)
    {
        String[] arr = mes.split(" ");
        String[] arr2 = mes2.split(" ");
        return arr2[arr2.length - 1].toLowerCase().replaceAll("c|d|f|g|h|j|k|l|m|n|p|q|r|s|t|x|z|v|w|,|!|\\.|\\?", "")
            .equals(arr[arr.length - 1].toLowerCase().replaceAll("c|d|f|g|h|j|k|l|m|n|p|q|r|s|t|x|z|v|w|,|!|\\.|\\?", ""));
    }

    public static boolean trouble(long num1, long  num2)
    {
        String str1 = Long.toString(num1);
        String str2 = Long.toString(num2);
        Pattern pattern = Pattern.compile("(\\d)\\1{2}");
        Matcher matcher = pattern.matcher(str1);
        String nums = "";
        while (matcher.find()) 
        {
            nums = str1.substring(matcher.start(), matcher.end());
        }
        if(nums == "")
            return false;
        pattern = Pattern.compile("("+nums.charAt(0)+")\\1{1}");
        matcher = pattern.matcher(str2);
        nums = "";
        while (matcher.find()) 
        {
            nums = str2.substring(matcher.start(), matcher.end());
        }
        return nums != "";
    }

    public static int countUniqueBooks(String mes, char book)
    {
        String letter = "";
        if((book == '$')||(book == '.')||(book == '?'))
            letter = "\\" + book;
        else
            letter += book;
        Pattern pattern = Pattern.compile(letter + ".+?" + letter);
        Matcher matcher = pattern.matcher(mes);
        String check = "";
        while (matcher.find()) 
        {
            check += mes.substring(matcher.start(), matcher.end());
        }
        return check.replaceAll(letter, "").replaceAll("(.)(?=.*?\\1)","").length();
    }
}