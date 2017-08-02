package com.cyj.real_test;

import java.util.Scanner;

public class 今日头条_句子查询 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n=0;
			int m=0;
			n=sc.nextInt();
			System.out.println(n);
			m=sc.nextInt();
			System.out.println(m);
			String []para = new String[n];
			String []query = new String[m];
			//注意后面有一个"\n"
			//前面用的nextInt，则后面要用两次nextLine()!!!!!!
			//否则第一个是空值！！
			para[0]=sc.nextLine();
			//System.out.println();
			for(int y=0;y<n;y++){
				para[y]=sc.nextLine();
				System.out.println(y+para[y]);
			}
			//System.out.println();
			//query[0]=sc.nextLine();
			for(int z=0;z<m;z++){
				query[z]=sc.nextLine();
				System.out.println(query[z]);
			}
			//System.out.println();
			for(int i=0;i<m;i++){
				String cur=allToLow((String)query[i]);
				//System.out.println(cur);
				String []curS = cur.split(" ");
				int maxpair = 0;
				int maxpos = 0;
				int count=0;
				int k=0;
				//全部匹配完
				for(;k<n;k++){
					String cur2=allToLow((String)para[k]);
					//System.out.println(cur2);
					String []curS2 = cur2.split(" ");
					//匹配完一句
					for(int j=0;j<curS.length;j++){
						for(int x=0;x<curS2.length;x++){
							if(allToLow(curS[j]).equals(allToLow(curS2[x]))){
								count++;
							}
						}
					}
					//System.out.println(count);
					if(count>=maxpair){
						maxpos=k;
						maxpair=count;

					}
					count=0;
				}
				System.out.println(para[maxpos]);
				maxpair = 0;
				maxpos = 0;
				count=0;
			}
		}
		sc.close();
	}
    //把字符串转换为小写
    public static String allToLow(String str){
        StringBuffer sb = new StringBuffer();
        if(str!=null){
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(Character.isUpperCase(c)){
                    sb.append(Character.toLowerCase(c));
                    continue;
                }
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
