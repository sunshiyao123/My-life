package Day39;

public class Printer {
    public static void main(String[] args) {
        int[][] data = new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},
        };
        int[] result = arrayPrint(data,4);
        for (int i : result) {
            System.out.println(i);
        }
    }
    public static int[] arrayPrint(int[][] arr, int n) {
        int[] result = new int[n*n];
        int temp = 0;
        for (int i = n-1;i >= 0;i--) {
            int j = 0;
            while (j < n && i < n) {
                result[temp] = arr[j][i];
                j++;
                i++;
                temp++;
            }
            i -= j;

        }
        for (int i = 1;i < n;i++) {
            int j = 0;
            while (i < n && j < n) {
                result[temp] = arr[i][j];
                i++;
                j++;
                temp++;
            }
            i -= j;
        }
        return result;
    }
}
