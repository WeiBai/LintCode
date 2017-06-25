package ArrayGroup.TwoPointer;

/**
 * Created by baiwe on 2017/6/23.
 */
public class SortColor {
    public void sort(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }

        int left = 0, right = nums.length - 1;
        int mid = 0;

        while(mid<= right){
            if (nums[mid] == 1){
                mid++;
            } else if (nums[mid] == 0){
                swap(nums, mid++, left++);
            } else {
                swap(nums, mid, right--);
            }
        }
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
