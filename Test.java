

现在有a，b，c三种物品，3种不同的物品可以换一个礼物，任意两个物品可以换a，b，c这三种物品中的一个，最多能换多少个礼物？
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能交换奖品的最大数量
     * @param a int整型 
     * @param b int整型 
     * @param c int整型 
     * @return int整型
     */
    public int numberofprize (int a, int b, int c) {
        // write code here
       
        int[] arr=new int[3];
        arr[0]=a;
        arr[1]=b;
        arr[2]=c;
        int res=0;
        boolean flag=true;
        while(flag){
            sort(arr);
            res+=arr[2];
            arr[0]=arr[0]-arr[2];
            arr[1]=arr[1]-arr[2];
            arr[2]=0;
            
            if(arr[0]==arr[1]){
                arr[0]=arr[0]-1;
                arr[1]=arr[1]-1;
                arr[2]=1;
            }else{
                arr[0]=arr[0]-2;
                arr[2]=1;
            }
            
            if(arr[0]<0||arr[1]<0) flag=false;
        }
        return res;
    }
    private void sort(int[] arr){
        if(arr[0]<arr[1]) swap(arr,0,1);
        if(arr[0]<arr[2]) swap(arr,0,2);
        if(arr[1]<arr[2]) swap(arr,1,2);
    }
    private void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}