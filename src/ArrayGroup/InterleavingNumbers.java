package ArrayGroup;
/*
1. 先用parition把数组分为左边为负数，右边为正数。

2. 如果负数比较多，把多余的负数与尾部的值交换。（这样多余的数会放在数组的末尾）

3. left 指向数组的左边，right指向数组的右边减掉多余的数。

4. 第3步中，根据是正数多，还是负数多，起始位置要变一下。正数多，我们希望开始的是正数：

例如 3 -1 2

负数多，我们希望开始的是负数，如 -1 3 -2

5. 不断交换left, right指针，并一次前进步长2. 直到left, right 相遇。
 */
public class InterleavingNumbers {
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length == 0){
            return;
        }

        int length = A.length;
        int left = 0;
        int right = length - 1;
        while (left <= right){
            while(left <= right && A[left] < 0){
                left++;
            }
            while(left <= right && A[right] > 0){
                right--;
            }

            if (left <= right){
                swap(A, left, right);
                left++;
                right--;
            }
        }

        int negNum = left;
        int posNum = length - left;

        int lessLength = Math.min(negNum, posNum);
        int dif = Math.abs(negNum - posNum);

        if (negNum > posNum){
            int lef = lessLength;
            int rit = length - 1;
            int count = dif;

            while(count > 0){
                swap(A, lef, rit);
                lef++;
                rit--;
                count--;
            }

            left = -1;
            right = length - dif;
        } else {
            left = -2;
            right = length - dif + 1;
        }

        while(true){
            left += 2;
            right -= 2;
            if (left >= lessLength){
                break;
            }
            swap(A, left, right);
        }
    }
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
