/**
 * @Author: Xuan Jing
 * @Date: 2020/5/13 11:17 PM
 */
public final class SortUtils {

    private SortUtils() {}

    public static void insertSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] >= arr[j-1]) {
                    break;
                } else {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    --j;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,1,2,3};
//        insertSort(arr);
        shellSort(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int a: arr) {
            System.out.print(a + ",");
        }
    }

    public static void shellSort(int [] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // quick sort
                int temp = arr[i];

                int j;
                for (j = i; j>=gap && temp<=arr[j-gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
