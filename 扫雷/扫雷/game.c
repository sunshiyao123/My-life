#include "game.h"

void menu()
{
	printf("*************************************\n");
	printf("********      1.play      ***********\n");
	printf("********      0.exit      ***********\n");
	printf("*************************************\n");
}

void game()
{
	char show[ROWS][COLS] = { '0' };
	char mine[ROWS][COLS] = { '0' };    //定义棋盘大小
	InitBoard(mine, ROWS, COLS, '0'); //把棋盘初始化成0
	InitBoard(show, ROWS, COLS, '*'); //把棋盘初始化成*
	SetMine(mine, ROW, COL);  
	DisplayBoard(mine, ROW, COL);//
	DisplayBoard(show, ROW, COL);      //打印出来
	FindMine(mine, show, ROW, COL);    //开始排雷
}

void InitBoard(char board[ROWS][COLS], int rows, int cols, char set)   //初始化棋盘
{
	memset(&board[0][0], set, rows*cols*sizeof(board[0][0]));
}

void DisplayBoard(char board[ROWS][COLS], int row, int col)      //打印棋盘
{
	int i = 0;
	int j = 0;
	printf("____________________\n");
	for (i = 0; i <= row; i++)
	{
		printf("%d ", i);
	}
	printf("\n");
	for (i = 1; i <= row; i++)
	{
		printf("%d ", i);
		for (j = 1; j <= col; j++)
		{
			printf("%c ", board[i][j]);
		}
		printf("\n");
	}
	printf("____________________\n");
}

void SetMine(char board[ROWS][COLS], int row, int col)                       //布雷
{
	int count = COUNT;
	while (count)
	{
		int x = rand()%row+1;
		int y = rand()%col+1;
		if (board[x][y] == '0')                //判断生成坐标是否有雷
		{
			board[x][y] = '1';
			count--;
		}
	}
}

void FindMine(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col)//扫雷
{
	int x = 0;
	int y = 0;
	int win = 0;
	int a = 0;
	int b = 0;
	int input = 0;
	int c = 0;
	while (1)     //判断最后赢的条件。
	{
		printf("--------------------\n");
		do               //每一步前都给出选择是否标记雷点
		{
			printf("1.标记雷点  0.走下一步\n");
			scanf("%d", &input);
			switch (input)
			{
			case 1:
				RemarkBoard(show, row, col);
				DisplayBoard(show, ROW, COL);
				break;
			case 0:
				printf("下一步： ");
				break;
			default:
				printf("输入错误，请重新输入！ ->");
				break;
			}
		} while (input);
		scanf("%d %d", &x, &y);      //进行坐标输入    
		if (x >= 1 && x <= row && y >= 1 && y <= col) //判断输入坐标是否合法
		{
			if (win == 0)    //走第一步时如果有雷将这个雷挪走
			{
				if (mine[x][y] == '1')
				{
					do
					{
						a = rand() % row + 1;
						b = rand() % col + 1;
					} while (mine[a][b] == '1');
					mine[x][y] = '0';
					mine[a][b] = '1';
				}
			}
			if (mine[x][y] == '1')              //炸死了  游戏结束
			{
				printf("很遗憾,你被炸死了。\n");
				DisplayBoard(mine, ROW, COL);
				break;
			}
			else
			{
				SpreadBoard(mine, show, row, col, x, y);  //展开扩散函数
				DisplayBoard(show, ROW, COL);
				c = CountShow(show, ROW, COL);
				if ( c == COUNT)
				{
					printf("游戏结束，扫雷成功\n");
					break;
				}

			}
		}
		else
		{
			printf("坐标非法，请重新输入:\n");
		}
	}
}
int GetMine(char mine[ROWS][COLS], int x, int y)   //统计周围雷的个数
	{
		{
			int i = 0;
			int j = 0;
			int sum = 0;
			for (i = 0; i < 3; i++)
			{
				for (j = 0; j < 3; j++)
				{
					sum = sum + mine[x - 1 + i][y - 1 + j] - '0';
				}
			}
			return sum;
		}
	}
void SpreadBoard(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col, int x, int y)    //展开函数，应用递归思想，当展开旁边的8个格子时如果有0则继续展开这个格子
{
	if (mine[x][y] == '0'&& x >= 0 && y >= 0 && show[x][y] == '*')
	{
		show[x][y] = GetMine(mine, x, y) + '0';
	}
	if (mine[x - 1][y] == '0'&& x >= 0 && y >= 0 && show[x - 1][y] == '*')
	{
		show[x - 1][y] = GetMine(mine, x - 1, y) + '0';
		if (GetMine(mine, x - 1, y) == 0)
		{
			SpreadBoard(mine, show, row, col, x - 1, y);
		}
	}
	if (mine[x - 1][y - 1] == '0'&& x >= 0 && y >= 0 && show[x - 1][y - 1] == '*')
	{
		show[x - 1][y - 1] = GetMine(mine, x - 1, y - 1) + '0';
		if (GetMine(mine, x - 1, y - 1) == 0)
		{
			SpreadBoard(mine, show, row, col, x - 1, y - 1);
		}
	}
	if (mine[x - 1][y + 1] == '0'&& x >= 0 && y >= 0 && show[x - 1][y + 1] == '*')
	{
		show[x - 1][y + 1] = GetMine(mine, x - 1, y + 1) + '0';
		if (GetMine(mine, x - 1, y + 1) == 0)
		{
			SpreadBoard(mine, show, row, col, x - 1, y + 1);
		}
	}
	if (mine[x][y + 1] == '0'&& x >= 0 && y >= 0 && show[x][y + 1] == '*')
	{
		show[x][y + 1] = GetMine(mine, x, y + 1) + '0';
		if (GetMine(mine, x, y + 1) == 0)
		{
			SpreadBoard(mine, show, row, col, x, y + 1);
		}
	}
	if (mine[x][y - 1] == '0'&& x >= 0 && y >= 0 && show[x][y - 1] == '*')
	{
		show[x][y - 1] = GetMine(mine, x, y - 1) + '0';
		if (GetMine(mine, x, y - 1) == 0)
		{
			SpreadBoard(mine, show, row, col, x, y - 1);
		}
	}
	if (mine[x + 1][y] == '0'&& x >= 0 && y >= 0 && show[x + 1][y] == '*')
	{
		show[x + 1][y] = GetMine(mine, x + 1, y) + '0';
		if (GetMine(mine, x + 1, y) == 0)
		{
			SpreadBoard(mine, show, row, col, x + 1, y);
		}
	}
	if (mine[x + 1][y - 1] == '0'&& x >= 0 && y >= 0 && show[x + 1][y - 1] == '*')
	{
		show[x + 1][y - 1] = GetMine(mine, x + 1, y - 1) + '0';
		if (GetMine(mine, x + 1, y - 1) == 0)
		{
			SpreadBoard(mine, show, row, col, x + 1, y - 1);
		}
	}
	if (mine[x + 1][y + 1] == '0'&& x >= 0 && y >= 0 && show[x + 1][y + 1] == '*')
	{
		show[x + 1][y + 1] = GetMine(mine, x + 1, y + 1) + '0';
		if (GetMine(mine, x + 1, y + 1) == 0)
		{
			SpreadBoard(mine, show, row, col, x + 1, y + 1);
		}
	}
}

void RemarkBoard(char show[ROWS][COLS], int row, int col)                    //标记函数，将已经标记出来的雷改为'!'。
{
	int x = 0;
	int y = 0;
	printf("请输入你要标记的坐标：");
	while (1)
	{
		scanf("%d %d", &x, &y);
		if (x >= 1 && x <= row && y >= 1 && y <= col)
		{
			show[x][y] = '!';
			break;
		}
		else
		{
			printf("输入错误请重新输入：");
		}
	}
}

int CountShow(char show[ROWS][COLS], int row, int col)     //判断剩余未知区域的个数，个数为雷数时玩家赢
{
	int count = 0;
	int i = 0;
	int j = 0;
	for (i = 1; i <= row; i++)
	{
		for (j = 1; j <= col; j++)
		{
			if (show[i][j] == '*')
			{
				count++;
			}
		}
	}
	return count;
}
