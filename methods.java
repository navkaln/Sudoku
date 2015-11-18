

import javax.swing.*;
public class Methods
{
	public static int[][][] xbit = new int[10][10][10];
	public Methods()
	{
		super();
	}
	public void store(int num, int x, int y)
	{
		int xbox = (x-1)/3;//coordinate system for horizontal boxes from 0-2
		int ybox = (y-1)/3;//coordinate system for vertical boxes from 0-2
		for (int p = 1; p <10; p ++)//rows
			xbit[num][p][y] = -1;
		for (int p = 1; p <10; p++)//columns
			xbit[num][x][p]= -1;
		for (int p = 1; p <10; p++)//other numbers in given xcoord, ycoord
			xbit[p][x][y]=-1;
		for (int p=xbox*3+1; p<((xbox*3)+4); p++)
		{
			for(int k=(ybox*3)+1; k<((ybox*3)+4); k++)
			{
				xbit[num][p][k]=-1;//all coords in xcoords and ycoords xbox and ybox
			}
		}
		xbit[num][x][y] = 1;		
	}
	
	
	
	
	
	
	
	
	
	
	
	public int[] searchCol(int num)//returns [x,y] or [p,k]
	{
		int array[] = new int[2];//{xcoord, ycoord}
		int count = 0;//temporary counter - counts zeros in a column
		int temp = 0;
		for(int p = 1; p<10; p++)//columns - islolates x
		{
			count = 0;
			for(int k = 1; k<10; k++)
			{
				if(xbit[num][p][k]==0)
				{
					count ++;
					temp = k;
				}
			}
			if (count == 1)//if there is only 1 zero (one possible place for the number
			{
				//System.out.println("There was only one blank space in row " + p + ", should place a number.");
				array[0] = p;//stores isolated x
				array[1] = temp;//and stores the column - y value
				p=10;
			}
			//else if (count != 0)
			//	System.out.println("Found " + count + " 0's in row " + p);
		}
		if (count>1)
		{
			array [0] = -1;
			array [1] = -1;
		}
		return array;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public int[] searchRow(int num)//returns [x,y] or [p,k]
	{
		int array[] = new int[2];
		int count = 0;
		int temp = 0;
		for(int p = 1; p<10; p++)//Rows -  islolates y
		{
			count = 0;
			for(int k = 1; k<10; k++)
			{
				if(xbit[num][k][p]==0)
				{
					count ++;
					temp = k;
				}
			}
			if (count == 1)
			{
				array[0] = p;
				array[1] = temp;
				p=10;
			}
		}
		if (count>1)
		{
			array [0] = -1;
			array [1] = -1;
		}
		return array;
	}
	
	public int[] searchBox(int num)//returns [x,y] or [p,k]
	{
		int array[] = new int [2];
		int count=0, tempx = 0, tempy=0;
		for (int xbox = 0; xbox < 3; xbox ++)//searches all columns of xboxes
		{
			for (int ybox = 0; ybox < 3; ybox ++)//and all rows of yboxes
			{
				count = 0;//counts the zeros in each box
				for(int p = 1; p < 4; p++)//isolates x value
				{
					for(int k = 1; k < 4; k++)//y value changes
					{
						if (xbit [num][3*(xbox) + p][3*(ybox) + k] == 0)// if there is a zero in a box
						{
							count ++;//counts the zeros
							tempx = 3*(ybox) + k;//stores the the x value (not used if there is more than one possibility
							tempy = 3*(xbox) + p;
						}
					}
				}
					if (count == 1)//if it finds
					{
						array[0] = tempy;
						array[1] = tempx;
						return array;
					}
			}
		}
		if (count>1)
		{
			array [0] = -1;
			array [1] = -1;
		}
		return array;
	}


	//when all else fails, looks for linear zeros within a 3x3 box
	public void inLine()
	{
		int xcell=0, ycell=0, hasZeros=0, temp=0;
		for (int p = 1;p < 10;p++)//searches all numbers
		{
			for (int xbox = 0; xbox < 3; xbox++)
			{
				xcell = xbox*3;   //for xbox 0-2
				for (int ybox = 0; ybox < 3; ybox++)
				{
					ycell = ybox*3;//for ybox 0-2
					temp = 0;
					for(int s = 1; s < 4; s++)//xcoord
						for(int t = 1; t < 4; t++)//ycoord
							if (xbit[p][xcell+s][ycell+t] == 0)
								temp++;
					if( temp == 2 || temp == 3)
					{
						for(int u = 1; u < 4; u++)
						{
							hasZeros = temp;
							for(int v = 1; v <= 4; v++)
							{	if (xbit[p][xcell + v][ycell + u] == 0)
									hasZeros--;
								if(hasZeros == 0)
								{
									for(int d=0; d<3; d++)
									{
										for(int c=1; c<4; c++)
											if(d*3!=ycell)
												xbit[p][d*3+c][ycell+v] = -1;
									}
								}
							}
						}
					}
				}
			}
		}
		for (int p = 1;p <10;p++)
		{
			for (int q = 0; q <3; q++)
			{
				ycell = q*3;   //for xbox 0-2
				for (int r = 0; r <3; r++)
				{
					xcell = r*3;//for ybox 0-2
					for(int s = 1; s<4; s++)//xcoord
						for(int t = 1; t < 4; t++)//ycoord
							if (xbit[p][xcell+s][ycell+t] == 0)
								temp++;
					if( temp == 2 || temp == 3)
					{
						for(int u = 1; u < 4; u++)
						{
							hasZeros = temp;
							for(int v = 1; v <4; v++)
							{	if (xbit[p][xcell + v][ycell + u] == 0)
									hasZeros--;
								if(hasZeros == 0)
								{
									for(int d = 0; d<3;d++)
									{
										for(int c=1;c<4;c++)
											if(d*3!=ycell)
												xbit[p][d*3+c][ycell+v] = -1;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void showSudoku()
	{
		for(int a = 1; a<10;a++)
		{	
			for(int b = 1; b<10; b++)
			{
				for(int c = 1; c<10;c++)
				{
					if(xbit[a][b][c]!=-1)
					{
						System.out.print("  " + xbit[a][b][c]);
					}
					else
						System.out.print(" " + xbit[a][b][c]);
				}
				System.out.println("");
			}
			System.out.println("\n");
		}
	}
}		
