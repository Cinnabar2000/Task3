import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер таска: ");
        int numb = in.nextInt();
        switch (numb){
            case (1):
                System.out.println("Введите a: ");
                int t11 = in.nextInt();
                System.out.println("Введите b: ");
                int t12 = in.nextInt();
                System.out.println("Введите c: ");
                int t13 = in.nextInt();
                System.out.println("Количество возможных решений: " + solutions(t11, t12, t13));
                break;
            case (2):
                System.out.println("Введите строку: ");
                String t2 = in.nextLine();
                System.out.println("Результат: " + findZip(t2));
                break;
            case (3):
                System.out.println("Введите число: ");
                int t3 = in.nextInt();
                System.out.println("Результат: " + checkPerfect(t3));
                break;
            case (4):
                System.out.println("Введите строку: ");
                String t4 = in.nextLine();
                System.out.println("Результат: " + flipEndChars(t4));
                break;
            case (5):
                System.out.println("Введите строку: ");
                String t5 = in.nextLine();
                System.out.println("Результат: " + isValidHexCode(t5));
                break;
            case (6):
                System.out.println("Введите длинну первого массива: ");
                int t61 = in.nextInt();
                int[] array1 = new int[t61];
                for(int i = 0; i< t61; i++){
                    System.out.println("Введите элемент массива под номером: " + i);
                    array1[i] = in.nextInt();
                }
                System.out.println("Введите длинну второго массива: ");
                int t62 = in.nextInt();
                int[] array2 = new int[t62];
                for(int i = 0; i< t62; i++){
                    System.out.println("Введите элемент массива под номером: " + i);
                    array2[i] = in.nextInt();
                }
                boolean rez = same(array1, array2);
                System.out.println("Результат: " + rez);
                break;
            case (7):
                System.out.println("Введите число: ");
                int t7 = in.nextInt();
                System.out.println("Результат: " + isKaprekar(t7));
                break;
            case (8):
                System.out.println("Введите строку: ");
                String t8 = in.nextLine();
                System.out.println("Результат: " + longestZero(t8));
                break;
            case (9):
                System.out.println("Введите число: ");
                int t9 = in.nextInt();
                System.out.println("Результат: " + nextPrime(t9));
                break;
            case (10):
                System.out.println("Введите стороны треугольника: ");
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();

                System.out.println(rightTriangle(a ,b ,c ));

                break;
        }


    }




    public static int solutions(int a, int b, int c){

        int d = (b*b) + (4*a*c);
        if(d< 0){
            return 0;
        }else if(d>0){
            return 2;
        }else{
            return 1;
        }
    }


    public static int findZip(String str){
        String z = "zip";
        if(str.indexOf(z) == -1){
            return -1;
        }else{
            int ind = str.indexOf(z);
            String newStr = str.substring(ind+2);
            if(newStr.indexOf(z) == -1){
                return -1;}
            else{
                return newStr.indexOf(z) + ind + 2;
            }
        }
    }

    public static boolean checkPerfect(int x){
        int sum = 1;
        int multiplier = 2;
        while (multiplier < x)
        {
            if (x % multiplier == 0)
            {
                sum += multiplier;
            }
            multiplier++;
        }

        if (sum == x){
            return true;
        }else{
            return false;
        }
    }

public static String flipEndChars(String str){

        if(str.length() < 2){
            return "Incompatible.";
        }else if (str.charAt(0) == str.charAt(str.length()-1)){
            return "Two's a pair.";
        }else{
            String nstr = str.charAt(str.length()-1) + str.substring(1,str.length()-1) + str.charAt(0);
            return nstr;
        }
}

public static boolean isValidHexCode(String str){

        String newStr = str.substring(1);
        if(str.length()!= 7 || str.charAt(0) != '#'){
            return false;
        }else{
            for ( int i = 0 ; i < newStr.length(); i++) {
                char ch = newStr.charAt(i);

                if ((ch < '0' || ch > '9' ) && (ch < 'A' || ch > 'F' ) && (ch < 'a' || ch > 'f' )) {
                    return false;

                }
            }

        }
        return true;
}

public static boolean same(int arr1[], int arr2[]){
        int rez1 = 1;
        int rez2 = 1;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(arr1.length > 1){
            for(int i = 1;i<arr1.length; i++){
                if (arr1[i] != arr1[i-1]){
                    rez1++;
                }
            }
        }
        if(arr2.length > 1){
            for(int i = 1;i<arr2.length; i++){
                if (arr2[i] != arr2[i-1]){
                    rez2++;
                }
            }
        }
        return rez1 == rez2;

}

    public static boolean isKaprekar(int num){
        int val = num*num;
        int cnum = val;
        int count = 0;
        while (cnum!=0){
            cnum = cnum/10;
            count++;
        }
        int fircou = count/2;
        int seccou = count - fircou;
        int f = (int)(val/Math.pow(10,fircou+1));
        int s = (int)(val%Math.pow(10,seccou));
        if (f+s == num){
            return true;
        }else{
            return false;
        }
    }

public static String longestZero(String str){
        boolean contin = false;
        int count = 0;
        int max = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '0'){
                if(!contin){
                    count = 1;
                    contin = true;
                }else{
                    count ++;
                }
                if (count > max){
                    max = count;
                }
            }else{
                contin = false;
            }

        }
        String re = "";
        for (int i = 0; i< max; i++){
            re += "0";
        }
        return re;
}

    static boolean isPrime(int n)
    {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }


    static int nextPrime(int num)
    {

        if (num <= 1)
            return 2;
        int prime = num;
        boolean found = false;
        while (!found)
        {
            prime++;

            if (isPrime(prime))
                found = true;
        }
        return prime;
    }

    public static boolean rightTriangle(int x, int y, int z){
        if((x*x==y*y+z*z)||(y*y==x*x+z*z)||(z*z==x*x+y*y)){
            return true;
        }else{
            return false;
        }
    }
}