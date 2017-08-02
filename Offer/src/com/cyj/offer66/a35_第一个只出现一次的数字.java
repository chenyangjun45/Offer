package com.cyj.offer66;

public class a35_第一个只出现一次的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a35_第一个只出现一次的数字 test = new a35_第一个只出现一次的数字();
		String str = "hasldhfkahsifhaoi";
		int position = test.FirstNotRepeatingChar(str);
		System.out.println(position);
		System.out.println(str.charAt(position));
	}
    public int FirstNotRepeatingChar(String str) {
        //创建hash表
        int mapArr[]=new int[256];
        //初始化
        for(int i=0;i<mapArr.length;i++){
            mapArr[i]=0;
        }
        char chs[]=str.toCharArray();
        int lens=chs.length;
        for(int i=0;i<lens;i++){
            mapArr[chs[i]]++;
        }
        for(int i=0;i<lens;i++){
            if(mapArr[chs[i]]==1){
                return i;
            }
        }
        return -1;
    }
}
