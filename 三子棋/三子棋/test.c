#include "game.h"

int main()
{
	test();
	system("pause");
	return 0;
}

void test()
{
	srand((unsigned int)time(NULL));
	int input = 0;
	do
	{
		menu();
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("�����˳���Ϸ");
			break;
		default:
			printf("����������������룺");
			break;
		}
	} while (input);
}