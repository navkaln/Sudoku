//Code of Nikhil Navkal - not for resale - not for sale!

import java.awt.*;
import javax.swing.*;
public class Sudoku
{
	public static void main (String args[])
	{
		int[] poss = {-1,-1};
		/*int[][] dxbit = { IT WORKS!!!!
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,4,0,0,9,0,0,0,6},
		{0,8,0,9,0,0,0,3,5,0},
		{0,1,0,3,5,0,0,0,0,8},
		{0,0,0,0,8,4,0,0,0,0},
		{0,0,0,2,0,0,0,5,0,0},
		{0,0,0,0,0,2,1,0,0,0},
		{0,2,0,0,0,0,9,7,0,1},
		{0,0,1,6,0,0,0,2,0,3},
		{0,4,0,0,0,1,0,0,6,0}};*/
		/*
		int[][] dxbit = {
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0}};
		*/
		int[][] dxbit = {
		{0,0,0,0,0,0,0,0,0,0},
		{0,4,0,7,6,0,8,0,0,0},
		{0,5,0,8,4,0,9,0,0,0},
		{0,6,0,9,5,0,7,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0}};
		/*int[][] dxbit = { evil
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,1,0,8,3,0,0,0,0},
		{0,5,9,4,0,0,0,0,0,0},
		{0,0,0,0,0,1,0,0,5,0},
		{0,7,0,0,0,0,0,1,0,0},
		{0,0,5,0,4,0,7,0,3,0},
		{0,0,0,8,0,0,0,0,0,6},
		{0,0,2,0,0,5,0,0,0,0},
		{0,0,0,0,0,0,0,7,9,8},
		{0,0,0,0,0,6,9,0,1,0}};*/
		Methods sudo = new Methods();
		for(int a = 1; a < 10; a ++)
			for(int b = 1; b < 10; b ++)
				if(dxbit[b][a] != 0)
					sudo.store((dxbit[b][a]), b, a);
		/*for(int a=1;a<10;a++)
		{
			System.out.print("\n\n");
			for(int b=1;b<10;b++)
			{
				for(int c=1;c<10;c++)
				{
					if((sudo.xbit[a][b][c])==1)
						System.out.print(" "+ a);
					else if((sudo.xbit[a][b][c])==0)
						System.out.print(" ?");
					else if((sudo.xbit[a][b][c])==-1)
						System.out.print(" -");
				}
				System.out.print("\n");
			}
		}*/
		for(int a=0;a<50;a++)
		{
			//System.out.println("it is on the " + a + "th time");
			sudo.inLine();
			/*for(int i = 1; i < 10;i++)
			{
				poss = sudo.searchBox(i);
				System.out.println("" + poss[0] + poss[1]);
				if(poss[0] != -1)
				{
					sudo.store(i,poss[0],poss[1]);
					dxbit[poss[0]][poss[1]]=i;
					poss[0]=-1;
					poss[1]=-1;

				}
			}
			for(int i = 1; i < 10;i++)
			{
				poss = sudo.searchRow(i);
				if(poss[0] != -1)
				{
					sudo.store(i,poss[0],poss[1]);
					dxbit[poss[0]][poss[1]]=i;
					poss[0]=-1;
					poss[1]=-1;
				}
			}
			*/
			/*
			for(int i = 1; i < 10;i++)
			{
				poss = sudo.searchBox(i);
				if(poss[0] > 0)
				{
					sudo.store(i,poss[0],poss[1]);
					dxbit[poss[0]][poss[1]]=i;
					System.out.println("it is on the " + a + "th time. " + "Stored a " + i + " at Position " + poss[1] + " , " + poss[0]);
					poss[0]=-1;
					poss[1]=-1;
					
				}
			}
			for(int i = 1; i < 10;i++)
			{
				poss = sudo.searchRow(i);
				if(poss[0] > 0)
				{
					sudo.store(i,poss[1],poss[0]);
					dxbit[poss[1]][poss[0]]=i;
					System.out.println("it is on the " + a + "th time. " + "Stored a " + i + " at Position " + poss[0] + " , " + poss[1]);
					poss[0]=-1;
					poss[1]=-1;
					
				}
			}
			
			for(int i = 1; i < 10;i++)
			{
				poss = sudo.searchCol(i);
				if(poss[0] > 0)
				{
					sudo.store(i,poss[0],poss[1]);
					dxbit[poss[0]][poss[1]]=i;
					System.out.println("it is on the " + a + "th time. " + "Stored a " + i + " at Position " + poss[1] + " , " + poss[0]);
					poss[0]=-1;
					poss[1]=-1;
					
				}
			}
			*/
		}
		/*for(int a=1;a<10;a++)
		{
			for(int b=1;b<10;b++)
			{
				System.out.print(" "+dxbit[a][b]);
			}
			System.out.println("");
		}
		
		*/
		sudo.showSudoku();
	}
}
