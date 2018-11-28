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
	char mine[ROWS][COLS] = { '0' };    //�������̴�С
	InitBoard(mine, ROWS, COLS, '0'); //�����̳�ʼ����0
	InitBoard(show, ROWS, COLS, '*'); //�����̳�ʼ����*
	SetMine(mine, ROW, COL);  
	DisplayBoard(mine, ROW, COL);//
	DisplayBoard(show, ROW, COL);      //��ӡ����
	FindMine(mine, show, ROW, COL);    //��ʼ����
}

void InitBoard(char board[ROWS][COLS], int rows, int cols, char set)   //��ʼ������
{
	memset(&board[0][0], set, rows*cols*sizeof(board[0][0]));
}

void DisplayBoard(char board[ROWS][COLS], int row, int col)      //��ӡ����
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

void SetMine(char board[ROWS][COLS], int row, int col)                       //����
{
	int count = COUNT;
	while (count)
	{
		int x = rand()%row+1;
		int y = rand()%col+1;
		if (board[x][y] == '0')                //�ж����������Ƿ�����
		{
			board[x][y] = '1';
			count--;
		}
	}
}

void FindMine(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col)//ɨ��
{
	int x = 0;
	int y = 0;
	int win = 0;
	int a = 0;
	int b = 0;
	int input = 0;
	int c = 0;
	while (1)     //�ж����Ӯ��������
	{
		printf("--------------------\n");
		do               //ÿһ��ǰ������ѡ���Ƿ����׵�
		{
			printf("1.����׵�  0.����һ��\n");
			scanf("%d", &input);
			switch (input)
			{
			case 1:
				RemarkBoard(show, row, col);
				DisplayBoard(show, ROW, COL);
				break;
			case 0:
				printf("��һ���� ");
				break;
			default:
				printf("����������������룡 ->");
				break;
			}
		} while (input);
		scanf("%d %d", &x, &y);      //������������    
		if (x >= 1 && x <= row && y >= 1 && y <= col) //�ж����������Ƿ�Ϸ�
		{
			if (win == 0)    //�ߵ�һ��ʱ������׽������Ų��
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
			if (mine[x][y] == '1')              //ը����  ��Ϸ����
			{
				printf("���ź�,�㱻ը���ˡ�\n");
				DisplayBoard(mine, ROW, COL);
				break;
			}
			else
			{
				SpreadBoard(mine, show, row, col, x, y);  //չ����ɢ����
				DisplayBoard(show, ROW, COL);
				c = CountShow(show, ROW, COL);
				if ( c == COUNT)
				{
					printf("��Ϸ������ɨ�׳ɹ�\n");
					break;
				}

			}
		}
		else
		{
			printf("����Ƿ�������������:\n");
		}
	}
}
int GetMine(char mine[ROWS][COLS], int x, int y)   //ͳ����Χ�׵ĸ���
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
void SpreadBoard(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col, int x, int y)    //չ��������Ӧ�õݹ�˼�룬��չ���Աߵ�8������ʱ�����0�����չ���������
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

void RemarkBoard(char show[ROWS][COLS], int row, int col)                    //��Ǻ��������Ѿ���ǳ������׸�Ϊ'!'��
{
	int x = 0;
	int y = 0;
	printf("��������Ҫ��ǵ����꣺");
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
			printf("����������������룺");
		}
	}
}

int CountShow(char show[ROWS][COLS], int row, int col)     //�ж�ʣ��δ֪����ĸ���������Ϊ����ʱ���Ӯ
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
