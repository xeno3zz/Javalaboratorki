import java.security.MessageDigest;

public class Tasks5 {

    public static void main(String[] args)
    {
        System.out.println("Выполнение первого таска");
        int[] rez1 = encrypt("Hello");
        for (int i : rez1) 
        {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        int[] rez2 = encrypt("Sunshine");
        for (int i : rez2) 
        {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        System.out.println(decrypt(new int[]{72, 33, -73, 84, -12, -3, 13, -13, -68}));
        System.out.print("\n");

        System.out.println("Выполнение второго таска");
        System.out.println(canMove("Knight", "A1", "B3"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));
        System.out.print("\n");

        System.out.println("Выполнение третьего таска");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.print("\n");

        System.out.println("Выполнение четвертого таска");
        System.out.println(sumDigProd(16, 28));
        System.out.println(sumDigProd(0));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.print("\n");

        System.out.println("Выполнение пятого таска");
        System.out.println(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"}));
        System.out.println(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"}));
        System.out.println(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"}));
        System.out.print("\n");

        System.out.println("Выполнение шестого таска");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));
        System.out.println(validateCard(2202201251751984L));
        System.out.print("\n");

        System.out.println("Выполнение седьмого таска");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(760));
        System.out.println(numToRus(0));
        System.out.println(numToRus(18));
        System.out.println(numToRus(760));
        System.out.println(numToRus(909));
        System.out.print("\n");

        System.out.println("Выполнение восьмого таска");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash("Hey dude!"));
        System.out.print("\n");

        System.out.println("Выполнение девятого таска");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.print("\n");

        System.out.println("Выполнение десятого таска");
        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));
        System.out.print("\n");
    }

    public static int[] encrypt(String mess)
    {
        int[] arr = new int[mess.length()];
        char[] word = mess.toCharArray();
        int tmp = 0;
        int letter;
        int count = 0;
        for (char c : word) 
        {
            letter = (c - 0) - tmp;
            tmp = c - 0;
            arr[count++] = letter;
        }
        return arr;
    }
    public static String decrypt(int[] arr)
    {
        String rez = "";
        int tmp = 0;
        for (int i : arr) 
        {
            i = i + tmp;
            tmp = i;
            rez += (char)(i);
        }
        return rez;
    }

    public static boolean canMove(String name, String a, String b)
    {
        int xCoord = a.charAt(0) - 64;
        int yCoord = Integer.parseInt(Character.toString(a.charAt(1)));
        int xCoordDIF = Math.abs((b.charAt(0) - 64) - xCoord);
        int yCoordDIF = Math.abs(yCoord - Integer.parseInt(Character.toString(b.charAt(1))));
        switch (name)
        {
            case "Knight":
                return (((xCoordDIF == 2) & (yCoordDIF == 1)) || ((xCoordDIF == 1) & (yCoordDIF == 2)));
            case "Pawn":
                if(yCoord == 2)
                    return Integer.parseInt(Character.toString(b.charAt(1))) - yCoord <= 2;
                else
                    return Integer.parseInt(Character.toString(b.charAt(1))) - yCoord == 1;
            case "Queen":
                return (((xCoordDIF == 0) & (yCoordDIF != 0)) || ((xCoordDIF != 0) & (yCoordDIF == 0)) || (xCoordDIF == yCoordDIF));
            case "King":
                return (xCoordDIF <= 1) & (yCoordDIF <= 1);
            case "Bishop":
                return (xCoordDIF == yCoordDIF);
            case "Rook":
                return ((xCoordDIF == 0) & (yCoordDIF != 0)) || ((xCoordDIF != 0) & (yCoordDIF == 0));
            default:
                return false;
        }
        //return false;
    }
    
    public static boolean canComplete(String cut, String word)
    {
        char[] arr1 = cut.toCharArray();
        char[] arr2 = word.toCharArray();
        int count = 0;
        for(int i = 0; i<arr2.length; i++)
        {
            if(arr1[count] == arr2[i])
                    count++;
        }
        return count == arr1.length;
    }

    public static int sumDigProd(int ... args)
    {
        int sum = 0;
        for (int i : args) 
        {
            sum += i; 
        }
        String num = Integer.toString(sum);
        while(num.length() != 1)
        {
            char[] tmp = num.toCharArray();
            num = "1";
            for (char c : tmp) 
            {
                num = Integer.toString(Integer.parseInt(num) * Integer.parseInt(Character.toString(c)));
            }
        }
        return Integer.parseInt(num);
    }

    public static String sameVowelGroup(String[] words)
    {
        String rez = words[0] + " ";
        String[] newArr = new String[words.length];

        for (int i = 0; i < newArr.length; i++) 
        {
            newArr[i] = words[i].replaceAll("[^(aeiouy)]","").replaceAll("(.)(?=.*?\\1)", "");
        }
        int  sum = 0;
        for(int i = 1; i < newArr.length; i++)
        {
            if((newArr[0].length() == newArr[i].length()) & (sum == 0))
            {
                char[] tmp = newArr[0].toCharArray();
                for (char c : tmp) 
                {
                    sum += c - 0;
                }
                char[] anyWord = newArr[i].toCharArray();
                int wordSum = 0;
                for (char c : anyWord) 
                {
                    wordSum += c - 0;
                }
                if(sum == wordSum)
                    rez += words[i] + " ";
            }
            else if ((newArr[0].length() == newArr[i].length()) & (sum != 0))
            {
                char[] anyWord = newArr[i].toCharArray();
                int wordSum = 0;
                for (char c : anyWord) 
                {
                    wordSum += c - 0;
                }
                if(sum == wordSum)
                    rez += words[i] + " ";
            }
        }
        
        return rez;   
    }

    public static boolean validateCard(Long num)
    {
        char[] arr = (num.toString()).toCharArray();
        int[] mas = new int[arr.length - 1];
        int zero = 0;
        int check = Character.getNumericValue(arr[mas.length]);

        for (int i = mas.length - 1; i >= 0; i --) 
        {
            mas[zero++] = Character.getNumericValue(arr[i]);
        }
        int sum = 0;
        for(int k = 0; k < mas.length ; k ++)
        {
            if((mas[k]* 2 >= 10) & (k % 2 == 0))
            {
                int tmp = mas[k] * 2;
                sum += tmp/10 + (tmp - (tmp/10 * 10));
            }
            else if (k % 2 != 0)
            {
                sum += mas[k];
            }
            else
                sum += mas[k] * 2;
        }
        return check == (10 - (sum - (sum/10 * 10)));
    }

    static public String numToEng(int num)
    {
        String rez = "";
        String tmp = Integer.toString(num);
        while (tmp.length() < 3)
            tmp = "0" + tmp;
        char[] ObO = tmp.toCharArray();
        for(int i = ObO.length - 1; i >= 0; i--)
        {
            switch (i)
            {
                case 2:
                    switch (ObO[0])
                    {
                        case '1': rez += "one hundred ";
                        break;
                        case '2': rez += "two hundreds ";
                        break;
                        case '3': rez += "tree hundreds ";
                        break;
                        case '4': rez += "four hundreds ";
                        break;
                        case '5': rez += "five hundreds ";
                        break;
                        case '6': rez += "six hundreds ";
                        break;
                        case '7': rez += "seven hundreds ";
                        break;
                        case '8': rez += "eight hundreds ";
                        break;
                        case '9': rez += "nine hundreds ";
                        default : break;
                    }
                    if((ObO[0] != '0') & ((ObO[2] != '0') || (ObO[1] != '0')))
                        rez += "and ";
                    break;
                case 1:
                    switch (ObO[1])
                    {
                        case '1':
                                switch (ObO[2])
                                {
                                    case '0': return rez += "ten";
                                    case '1': return rez += "eleven";
                                    case '2': return rez += "twelve";
                                    case '3': return rez += "thirteen";
                                    case '4': return rez += "fourteen";
                                    case '5': return rez += "fifteen";
                                    case '6': return rez += "sixteen";
                                    case '7': return rez += "seventeen";
                                    case '8': return rez += "eighteen";
                                    default : return rez += "nineteen";
                                }
                        case '2': rez += "twenty ";
                        break;
                        case '3': rez += "thirty ";
                        break;
                        case '4': rez += "fourty ";
                        break;
                        case '5': rez += "fifty ";
                        break;
                        case '6': rez += "sixty ";
                        break;
                        case '7': rez += "seventy ";
                        break;
                        case '8': rez += "eighty ";
                        break;
                        case '9': rez += "ninety ";
                        break;
                        default:
                        break;
                    }
                break;
                default :
                    if((ObO.length == 1) | (ObO[1] != '1'))
                        switch (ObO[ObO.length - 1])
                        {
                            case '0':
                                if((ObO[0] == '0') & (ObO[1] == '0'))
                                    rez += "zero";
                            break;
                            case '1': rez += "one";
                            break;
                            case '2': rez += "two";
                            break;
                            case '3': rez += "three";
                            break;
                            case '4': rez += "four";
                            break;
                            case '5': rez += "five";
                            break;
                            case '6': rez += "six";
                            break;
                            case '7': rez += "seven";
                            break;
                            case '8': rez += "eight";
                            break;
                            default: rez += "nine";
                            break;
                        }
                break;
            }
        }
       return rez;
    }

    static public String numToRus(int num)
    {
        String rez = "";
        String tmp = Integer.toString(num);
        while (tmp.length() < 3)
            tmp = "0" + tmp;
        char[] ObO = tmp.toCharArray();
        for(int i = ObO.length - 1; i >= 0; i--)
        {
            switch (i)
            {
                case 2:
                    switch (ObO[0])
                    {
                        case '1': rez += "сто ";
                            break;
                        case '2': rez += "двести ";
                            break;
                        case '3': rez += "триста ";
                            break;
                        case '4': rez += "четыреста ";
                            break;
                        case '5': rez += "пятсот ";
                            break;
                        case '6': rez += "шестьсот ";
                            break;
                        case '7': rez += "семьсот ";
                            break;
                        case '8': rez += "восемьсот ";
                            break;
                        case '9': rez += "девятьсот ";
                        default : break;
                    }
                    break;
                case 1:
                    switch (ObO[1])
                    {
                        case '1':
                            switch (ObO[2])
                            {
                                case '0': return rez += "десять";
                                case '1': return rez += "одиннадцать";
                                case '2': return rez += "двенадцать";
                                case '3': return rez += "тринадцать";
                                case '4': return rez += "четырнадцать";
                                case '5': return rez += "пятнадцать";
                                case '6': return rez += "шестнадцать";
                                case '7': return rez += "семнадцать";
                                case '8': return rez += "восемнадцать";
                                default : return rez += "девятнадцать";
                            }
                        case '2': rez += "двадцать ";
                            break;
                        case '3': rez += "тридцать ";
                            break;
                        case '4': rez += "сорок ";
                            break;
                        case '5': rez += "пятдесят ";
                            break;
                        case '6': rez += "шестьдесят ";
                            break;
                        case '7': rez += "семьдесят ";
                            break;
                        case '8': rez += "восемьдесят ";
                            break;
                        case '9': rez += "девяносто ";
                            break;
                        default:
                            break;
                    }
                    break;
                default :
                    if((ObO.length == 1) | (ObO[1] != '1'))
                        switch (ObO[ObO.length - 1])
                        {
                            case '0':
                                if((ObO[0] == '0') & (ObO[1] == '0'))
                                    rez += "ноль";
                                break;
                            case '1': rez += "один";
                                break;
                            case '2': rez += "два";
                                break;
                            case '3': rez += "три";
                                break;
                            case '4': rez += "четыре";
                                break;
                            case '5': rez += "пять";
                                break;
                            case '6': rez += "шесть";
                                break;
                            case '7': rez += "семь";
                                break;
                            case '8': rez += "восемь";
                                break;
                            default: rez += "девять";
                                break;
                        }
                    break;
            }
        }
        return rez;
    }

    private static String getSha256Hash(String mess)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] byteHash = md.digest(mess.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * byteHash.length);
            for (int i = 0; i < byteHash.length; i++)
            {
                String hex = Integer.toHexString(0xff & byteHash[i]);
                if (hex.length() == 1)
                {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (java.security.NoSuchAlgorithmException e) {}
        return "Произошла непредвиденная ошиба";
    }

    private static String correctTitle(String title)
    {
        String[] words = title.split(" ");
        String rez = "";
        for (String word : words)
        {
            word = word.toLowerCase();
            if((word.equals("and")) || (word.equals("in")) || (word.equals("the")) || (word.equals("of")))
                rez += word + " ";
            else
                rez += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }
        return rez;
    }

    private static String hexLattice(int num)
    {
        if(num == 1)
            return  "o";
        int a0 = 0;
        int a1 = 1;
        int count = 0;
        while (true)
        {
            if(a1 == num)
                break;
            else if(a1 > num)
                return "Invalid";
            a0 = a1;
            a1 = count++ * 6 + a0;
        }
        String rez = "";
        int leftSide = count + 1;
        int mid = count - 1;
        int rightSide = count + 1;
        for(int z = 0; z < count; z++)
        {

            leftSide -= 1;
            mid += 1;
            rightSide -= 1;
            for (int i = 0; i < leftSide; i++)
            {
                rez += " ";
            }
            for (int i = 0; i < mid; i++)
            {
                rez += "o ";
            }
            for (int i = 0; i < rightSide - 1; i++)
            {
                rez += " ";
            }
            rez += "\n";
        }
        for(int z = 0; z < count - 1; z++)
        {
            leftSide += 1;
            mid -= 1;
            rightSide += 1;
            for (int i = 0; i < leftSide; i++)
            {
                rez += " ";
            }
            for (int i = 0; i < mid; i++)
            {
                rez += "o ";
            }
            for (int i = 0; i < rightSide - 1; i++)
            {
                rez += " ";
            }
            rez += "\n";
        }
        return rez;
    }
}