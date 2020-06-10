import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author: Xuan Jing
 * @Date: 2020/5/30 10:07 PM
 */
public class TestMain {
    public static void main(String[] args){
        // 统计最后一个单词的长度
//        String str = new Scanner(System.in).nextLine();
//        System.out.print(str.length()-str.lastIndexOf(" ")-1);

        // 字符出现次数
//        Scanner s = new Scanner(System.in);
//        String str = s.next();
//        char c = s.next().charAt(0);
//        int i = getCount2(str,c);
//        System.out.println(i);

        // 去重再排序
//        dupAndSort();

        // 拆分字符串
//        Scanner scanner=new Scanner(System.in);
//        while(scanner.hasNextLine()){
//            String s=scanner.nextLine();
//            split(s);
//        }

        // 十六转十进制
//        Scanner sc = new Scanner(System.in);
//
//        while(sc.hasNext()){
//            String str = sc.nextLine();
//            System.out.println(fun(str.substring(2)));
//        }

        // 按照从小到大的顺序输出它的所有质因子
//        Scanner str = new Scanner(System.in);
//        long num = str.nextLong();
//        String result = getResult(num);
//        System.out.println(result);

        // 四舍五入
//        Scanner scanner=new Scanner(System.in);
//        double d=scanner.nextDouble();
//        System.out.println(getReturn(d));

        // 合并并排序
//        Scanner str = new Scanner(System.in);
//        SortedMap<Integer,Integer> map = new TreeMap<>();
//        int n = Integer.parseInt(str.nextLine());
//        for (int i = 0;i<n;i++){
//            String[] mid = str.nextLine().split("\\s+");
//            addPare(map,mid);
//        }
//        System.out.println(mapToString(map));

        // 数字倒叙并去重
//        Scanner in=new Scanner(System.in);
//        int num=in.nextInt() ;
//        String str="";
//        while(num%10!=0){
//            str+=num%10+"";
//            num=num/10;
//        }
//        int i=0;
//        String str1=str.charAt(0)+"";
//
//        while(i<str.length()){
//            int flag=1;
//            int j=0;
//            while(j<str1.length()){
//                if(str.charAt(i)==str1.charAt(j)){
//                    flag=0;break;
//                }else{
//                    j++;
//                }
//            }
//            if(flag==1){
//                str1+=str.charAt(i);
//            }
//            i++;
//        }
//        System.out.println(str1);

        // 统计0-127的字符出现的个数
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            int len=getLen(s);
            System.out.println(len);
        }
    }

    public static int getCount(String str,char c){
        int count = 0;
        if(str != null && str.length() > 0){
            for(int i = 0;i < str.length();i++){
                if(c == str.charAt(i)){
                    count++;
                }
            }
        }else{
            count = 0;
        }
        return count;
    }

    public static int getCount2(String str,char c){
        return str.length() - str.toLowerCase().replace(String.valueOf(c).toLowerCase(), "").length();
    }

    public static void dupAndSort() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

            int num = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i = 0 ; i < num ;i++){
                int curr = sc.nextInt();
                set.add(curr);
            }
            for(Integer i : set){
                System.out.println(i);
            }
        }
    }

    public static void split(String s){
        while(s.length()>=8){
            System.out.println(s.substring(0, 8));
            s=s.substring(8);
        }
        if(s.length()<8&&s.length()>0){
            s=s+"00000000";
            System.out.println(s.substring(0, 8));
        }
    }

    public static int fun(String s){
        int n=0;
        int count= 0;
        int temp = 0;
        char ch;

        while(count<s.length())
        {
            ch = s.charAt(s.length()-count-1);
            if(ch>='0'&&ch<='9'){
                temp = ch-'0';
            }else if(ch>='A'&&ch<='Z'){
                temp = ch-'A'+10;
            }else if(ch>='a'&&ch<='z'){
                temp = ch-'a'+10;
            }else{
                break;
            }
            n += temp*Math.pow(16,count);
            count++;
        }

        return n;
    }

    public static String getResult(long num){
        int pum = 2;
        String result = "";
        while(num != 1){
            while(num%pum == 0){
                num = num/pum;
                result = result + pum + " ";
            }
            pum++;
        }
        return result;
    }

    public static int getReturn(double d) {
        int i=(int)d;
        return  (d-i)>=0.5?i+1:i;
    }

    private static String mapToString(SortedMap<Integer, Integer> map) {
        // TODO Auto-generated method stub
        StringBuilder builder = new StringBuilder();
        for(SortedMap.Entry<Integer,Integer>e:map.entrySet()){
            builder.append(e.getKey()).append(" ").append(e.getValue()).append("\r");
        }
        return builder.toString();
    }

    private static void addPare(SortedMap<Integer, Integer> map, String[] mid) {
        // TODO Auto-generated method stub
        int key = Integer.parseInt(mid[0]);
        int value = Integer.parseInt(mid[1]);
        if(map.containsKey(key)){
            map.put(key, map.get(key) + value);
        }else{
            map.put(key, value);
        }
    }

    public static int  getLen(String s) {
        int[] arr=new int[128];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)]=1;
        }
        int len=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                len++;
            }
        }
        return len;
    }
}
