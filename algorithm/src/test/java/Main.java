import java.util.*;

/**
 * @Author: Xuan Jing
 * @Date: 2020/6/2 10:41 AM
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int num = sc.nextInt();
        System.out.println(getList(s, num));
    }

    public static String getList(int s, int num) {
        int start = s/num - num/2;
        int sum = 0;
        for (int i = 0; i< num; i++) {
            sum += start + i;
        }
        StringBuilder sb = new StringBuilder();
        if (sum == s) {
            for (int i = 1; i< num; i++) {
                sb.append(start+i).append(" ");
            }
        } else if (Math.abs(s - sum) % num == 0) {
            start = start + (s - sum) / num;
            for (int i = 0; i< num; i++) {
                sb.append(start+i).append(" ");
            }
        } else {
            return "-1";
        }
        return sb.toString();
    }

    public static int[][] mix(int[][] intervals) {
        if(intervals==null || intervals.length==0) {
            return intervals;
        }
        List<int[]> arr = new ArrayList<>();

        int k = 0;
        int[][] intervalsTemp = new int[intervals.length * 100][2];
        for(int i=0;i<intervals.length;i++) {
            for(int j=i+1;j<intervals.length;j++) {
                //[x1,x2]和[y1,y2]比较，如果x2<y1说明这两个区间不相交
                if (intervals[j][1] < intervals[i][0] ||
                        intervals[j][0] > intervals[i][1]) {
                    continue;
                } else {
                    //否则，将这两个区间取交集
                    k++;
                    intervalsTemp[k][0] = Math.max(intervals[i][0], intervals[j][0]);
                    intervalsTemp[k][1] = Math.min(intervals[i][1], intervals[j][1]);
                }
            }
        }
        return intervalsTemp;
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0) {
            return intervals;
        }
        //先按区间的一个元素排序一遍
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> arr = new ArrayList<>();
        arr.add(intervals[0]);
        for(int i=1;i<intervals.length;++i) {
            //[x1,x2]和[y1,y2]比较，如果x2<y1说明这两个区间不想交
            if(arr.get(arr.size()-1)[1] < intervals[i][0]) {
                arr.add(intervals[i]);
            } else {
                //否则，将这两个区间合并为 [x1,max(x2,y2)]
                arr.get(arr.size()-1)[1] = Math.max(arr.get(arr.size()-1)[1],intervals[i][1]);
            }
        }
        return arr.toArray(new int[arr.size()][2]);
    }

    private static void print(int[][] intervals) {
        Arrays.stream(intervals).filter(interval -> interval[0] != 0 && interval[1] != 0).forEach( interval ->
                System.out.println(interval[0] + " " + interval[1])
        );
    }
}
