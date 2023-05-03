package com.backendlist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackEndListApplicationTests {

    @Test
    void contextLoads() {
        int[][] list=new int[10][10];
        int i=0;
        int j=0;
        for (i = 0; i <=9;i++){
            for (j = 0; j < i+1;j++){
                // list[i][j]=j;
                list[i][0]=1;
                list[i][i]=1;
                if (i>=2&&j>=1){
                    if (j!=i){
                        list[i][j]=list[i-1][j-1]+list[i-1][j];
                    }
                }
                // System.out.print("list["+i+"]["+j+"]"+list[i][j]);
                System.out.print(list[i][j]+" ");
            }
            System.out.println();
        }

    }

}
