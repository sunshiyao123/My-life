#ifndef _GMAE_H__
#define _GAME_H__

#define _CRT_SECURE_NO_DEPRECATE
#include<stdlib.h>
#include<stdio.h>
#include<time.h>
#include<string.h>
#define ROW 9     //��������
#define COL 9     //��������
#define ROWS ROW+2
#define COLS COL+2  
#define COUNT 10   //���õ��׵ĸ���

void InitBoard(char board[ROWS][COLS], int rows, int cols, char ret);         //��ʼ������
void DisplayBoard(char board[ROWS][COLS], int row, int col);                  //��ӡ����
void SetMine(char board[ROWS][COLS], int row, int col);                       //����
void FindMine(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col);//ɨ��
int GetMine(char a[ROWS][COLS], int x, int y);                                //�����Χ�˸������׵ĸ���
void SpreadBoard(char mine[ROWS][COLS], char show[ROWS][COLS], int row, int col, int x, int y);//չ������
void RemarkBoard(char show[ROWS][COLS], int row, int col);                    //��Ǻ���
int CountShow(char mine[ROWS][COLS], int row, int col);                       //�жϵ�ǰʣ��δ�жϵĸ���

void game();
void test();
void menu();

#endif  //_TEST_H__