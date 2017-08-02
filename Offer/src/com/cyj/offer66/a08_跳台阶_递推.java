package com.cyj.offer66;

public class a08_跳台阶_递推 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(JumpFloor(4));
	}
   public static int JumpFloor(int target) {
        if(target <= 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int one = 1;
        int two = 2;
        int result = 0;
        for(int i = 2; i < target; i++){
            result = one+ two;
            one = two;
            two = result;
        }
        return result;
    }
}
