#include "game.h"

void menu()
{
	    printf("���������ѡ��\n");
		printf("*********************************\n");
		printf("*******     1.����Ϸ      *******\n");
		printf("*******     0.�˳�        *******\n");
		printf("*********************************\n");
}

void game()
{
	char a = 0;
	char board[ROW][COL] = { '0' };
	InitBoard(board, ROW, COL);   //��ʼ������
	DisplayBoard(board, ROW, COL); //��ӡ
	while (1)
	{
		PlayerMove(board, ROW, COL);   //�����
		a = IsWin(board, ROW, COL);    //�ж���Ӯ
		if (a != 'c')
			break;
		ComputerMove(board, ROW, COL);  //������
		a = IsWin(board, ROW, COL);    //�ж���Ӯ
		if (a != 'c')
			break;
	}
	if (a == '*')
		printf("���Ӯ��\n");
	if (a == '+')
		printf("����Ӯ��\n");
	if (a == 'p')
		printf("ƽ�֡�\n");
	DisplayBoard(board, ROW, COL);
}


void InitBoard(char Board[ROW][COL], int row, int col)   //��ʼ������
{
	memset(Board, ' ', row*col*sizeof(Board[0][0]));
}

void DisplayBoard(char Board[ROW][COL], int row, int col)  //��ӡ����
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			printf(" %c ", Board[i][j]);
			if (j < col - 1)
			{
				printf("|");
			}
		}
		printf("\n");
		if (i < row-1)
		{
			for (j = 0; j < col; j++)
			{
				printf("---");
				if (j < col - 1)
				{
					printf("|");
				}
			}
			printf("\n");
		}
	}
}
	
void PlayerMove(char Board[ROW][COL], int row, int col)  //�����
{
	int x = 0;
	int y = 0;
	int count = 1;
	printf("���������꣺");
	while (1)
	{
		scanf("%d %d", &x, &y);
		if (x >= 1 && x <= row && y >= 1 && y <= col)
		{
			if (Board[x - 1][y - 1] == ' ')
			{
				Board[x - 1][y - 1] = '*';
				DisplayBoard(Board, ROW, COL);
				break;
			}
			else
			{
				printf("�����ѱ�ռ�ã����������룺");
			}
		}
		else
			printf("��������������������룺");
	}
}

void ComputerMove(char Board[ROW][COL], int row, int col)
{
	int x = 0;
	int y = 0;
	printf("�����ߣ�\n");
	while (1)
	{
		x = rand() % row;
		y = rand() % col;
		if (Board[x][y] != '+' && Board[x][y] != '*')
		{
			Board[x][y] = '+';
			break;
		}
	}
	DisplayBoard(Board, ROW, COL);
}

char IsWin(char Board[ROW][COL], int row, int col)
{
	int i = 0;
	int j = 0;
	int count = 0;
	for (i = 0; i < row; i++)   //�����ж�
	{
		for (j = 0; j < col-1; j++)
		{
			if (Board[i][j] != ' ' && Board[i][j] == Board[i][j + 1])
				count++;
		}
		if (count == col-1)
			return Board[i][0];
		count = 0;
	}
	count = 0;
	for (j = 0; j < col; j++)   //�����ж�
	{
		for (i = 0; i < row-1; i++)
		{
			if (Board[i][j] != ' ' && Board[i][j] == Board[i + 1][j])
				count++;
		}
		if (count == row-1)
			return Board[0][j];
		count = 0;
	}
	count = 0;
	for (j = 0; j < row-1; j++)   //��б�����ж�
	{
		if (Board[j][j] != ' ' && Board[j][j] == Board[j + 1][j + 1])
			count++;
	}
		if (count == col-1)
			return Board[j][j];
	count = 0;
	i = 0;
	j = col - 1;
	while (i < row - 1 && j > 0)
	{
		if (Board[i][j] != ' ' && Board[i][j] == Board[i + 1][j - 1])
			count++;
		i++;
		j--;

	}	
		if (count == col-1)
			return Board[i][j];
	if (IsFull(Board, row, col) == 1)
		return 'p';
	else
		return 'c';

}

static int IsFull(char Board[ROW][COL], int row, int col)  //����Ҫ����
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < row; j++)
		{
			if (Board[i][j] == ' ')
				return 0;
		}
	}
	return 1;
}
