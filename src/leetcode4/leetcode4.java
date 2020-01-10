package leetcode4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 宁
 * Date: 2020-01-06
 * Time: 21:39
 */
public class leetcode4 {
    public static void main(String[] args) {
        int []nums1 = {3};
        int []nums2 = {1,2,4};
        System.out.println(Solution.findMedianSortedArrays(nums1,nums2));
    }
}

//class Solution {
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int Num1LeftIndex = 0;
//        int Num1RightIndex = Math.max(0,nums1.length-1);
//        int Num2LeftIndex = 0;
//        int Num2RightIndex = Math.max(0,nums2.length-1);
//        double Num1MiddleIndex = (double)(nums1.length-1)/2;
//        double Num2MiddleIndex = (double)(nums2.length-1)/2;
//        int Num1Length = nums1.length;
//        int Num2Length = nums2.length;
//
//        //假定num1的中位数为
//        double middle1 = Num1Length==0?0:(Num1MiddleIndex%1==0?nums1[(int)Num1MiddleIndex]:((double) (nums1[(int)(Num1MiddleIndex-0.5)]+nums1[(int)(Num1MiddleIndex+0.5)])/2));
//        double middle2 = Num2Length==0?0:(Num2MiddleIndex%1==0?nums2[(int)Num2MiddleIndex]:((double) (nums2[(int)(Num2MiddleIndex-0.5)]+nums2[(int)(Num2MiddleIndex+0.5)])/2));
//
//        if (Num1Length == 0){
//            if (Num2Length%2==0){
//                return (double)(nums2[Num2Length/2]+nums2[Num2Length/2-1])/2;
//            }else{
//                return (double) nums2[Num2Length/2];
//            }
//        }else if (Num2Length == 0){
//            if (Num1Length%2==0){
//                return (double)(nums1[Num1Length/2]+nums1[Num1Length/2-1])/2;
//            }else{
//                return (double) nums1[Num1Length/2];
//            }
//        }
//
//        while (middle1 != middle2){
//
//            if (middle1 < middle2){
//                Num1LeftIndex = (int)(Num1MiddleIndex%1==0?Num1MiddleIndex+1:Num1MiddleIndex+0.5);
//                Num2RightIndex = (int)(Num2MiddleIndex%1==0?Num2MiddleIndex-1:Num2MiddleIndex-0.5);
//            }else{
//                Num1RightIndex = (int)(Num1MiddleIndex%1==0?Num1MiddleIndex-1:Num1MiddleIndex-0.5);
//                Num2LeftIndex = (int)(Num2MiddleIndex%1==0?Num2MiddleIndex+1:Num2MiddleIndex+0.5);
//            }
//            if ((Num1Length==0 || (Num1RightIndex == Num1LeftIndex)) && (Num2Length==0 || (Num2RightIndex == Num2LeftIndex))){
//                //都只剩一个了
////                return (double)(nums1[Num1LeftIndex]+nums2[Num2LeftIndex])/2;
//                if (Num1Length==0){
//                    return nums2[Num2LeftIndex];
//                }else if (Num2Length==0){
//                    return nums1[Num1LeftIndex];
//                }
//                return (double)(nums1[Num1LeftIndex]+nums2[Num2LeftIndex])/2;
//            }
//            if (Num1LeftIndex > Num1RightIndex){
//                //只剩一个了
//                return middle1<middle2?
//                        ((Num1Length+Num2Length)%2==0?(double) (nums2[Num2RightIndex]+nums2[Num2RightIndex+1])/2:nums2[Num2RightIndex]):
//                        ((Num1Length+Num2Length)%2==0?(double) (nums2[Num2LeftIndex]+nums2[Num2LeftIndex-1])/2:nums2[Num2LeftIndex]);
//
//            }
//            if (Num2LeftIndex > Num2RightIndex){
//                //只剩一个了
//                return middle1<middle2?
//                        ((Num1Length+Num2Length)%2==0?(double) (nums1[Num1LeftIndex]+nums1[Num1LeftIndex-1])/2:nums1[Num1LeftIndex]):
//                        ((Num1Length+Num2Length)%2==0?(double) (nums1[Num1RightIndex]+nums1[Num1RightIndex+1])/2:nums1[Num2RightIndex]);
//            }
//            Num1MiddleIndex = (double) (Num1RightIndex+Num1LeftIndex)/2;
//            Num2MiddleIndex = (double) (Num2RightIndex+Num2LeftIndex)/2;
//
//            middle1 = Num1Length==0?0:(Num1MiddleIndex%1==0?nums1[(int)Num1MiddleIndex]:((double) (nums1[(int)(Num1MiddleIndex-0.5)]+nums1[(int)(Num1MiddleIndex+0.5)])/2));
//            middle2 = Num2Length==0?0:(Num2MiddleIndex%1==0?nums2[(int)Num2MiddleIndex]:((double) (nums2[(int)(Num2MiddleIndex-0.5)]+nums2[(int)(Num2MiddleIndex+0.5)])/2));
//
//        }
//        //如果num1和num2的中位数相等
//        return middle1;
//    }
//}

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int Nums1Length = nums1.length;
        int Nums2Length = nums2.length;
        if (Nums1Length > Nums2Length){
            int []tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int tmpl = Nums1Length;
            Nums1Length = Nums2Length;
            Nums2Length = tmpl;//保证Nums2Length>=Nums1Length
        }
        int Nums1IndexLeft = 0;
        int Nums1IndexRight = Nums1Length;

        while (Nums1IndexLeft<=Nums1IndexRight){
            int Nums1Index = (Nums1IndexLeft+Nums1IndexRight)/2;
            int Nums2Index = (Nums1Length+Nums2Length+1)/2-Nums1Index;
            if (Nums1Index>Nums1IndexLeft && nums1[Nums1Index-1] > nums2[Nums2Index]){
                //if (Nums2Index < Nums2Length && Num1Index > 0 nums1[Nums1Index-1] > nums2[Nums2Index])
                //Nums1Index需要变小
                Nums1IndexRight = Nums1Index-1;
            }else if (Nums1Index<Nums1IndexRight && nums1[Nums1Index] < nums2[Nums2Index-1]){
                //Nums1Index需要变大
                Nums1IndexLeft = Nums1Index+1;
            }else if ((Nums1Index == 0 || Nums2Index == Nums2Length || nums1[Nums1Index-1] <= nums2[Nums2Index]) || (Nums1Index == Nums1Length || Nums2Index == 0 || nums1[Nums1Index]>=nums2[Nums2Index-1])){//else if()
                int MaxLeft = 0;
                if (Nums1Index == 0){
                    MaxLeft = nums2[Nums2Index-1];
                }else if (Nums2Index == 0){
                    MaxLeft = nums1[Nums1Index-1];
                }else{
                    MaxLeft = Math.max(nums1[Nums1Index-1],nums2[Nums2Index-1]);
                }
                if ((Nums1Length+Nums2Length)%2 == 1){
                    return MaxLeft;
                }

                int MinRight = 0;
                if (Nums1Index == Nums1Length){
                    MinRight = nums2[Nums2Index];
                }else if (Nums2Index == Nums2Length){
                    MinRight = nums1[Nums1Index];
                }else{
                    MinRight = Math.min(nums1[Nums1Index],nums2[Nums2Index]);
                }
                return (MaxLeft+MinRight)/2.0;
            }

        }
        return 0.0;


    }
}