

import java.util.Random;

public class SudokuMaker {

    static int[][] board = new int[9][9];

    public static void main(String[] args) 
    {
        boardmaker();
        System.out.println("---Final Board---");
        boardprinter();
    }

    public static void boardmaker() 
    {
        int atmpts = 0;

        for (int r = 0; r < 9; r++) 
        {
            for (int c = 0; c < 9; c++) 
            {

                boolean done = false;

                while (!done) {
                    
                    int num = (int)(Math.random() * 9) + 1;

                    if (!rowcheck(r, num) && !colcheck(c, num) && !boxcheck(r, c, num)) 
                    {
                        board[r][c] = num;
                        done = true;
                    }

                    atmpts++;

                    if (atmpts > 10000) 
                    {
                        resetboard();
                        r = 0;
                        c = -1;
                        atmpts = 0;
                        break;
                    }
                }
            }
        }
    }

    public static void resetboard() 
    {
        for (int r = 0; r < 9; r++) 
        {
            for (int c = 0; c < 9; c++) 
            {
                board[r][c] = 0;
            }
        }
    }

    public static boolean rowcheck(int r, int num) 
    {
        for (int i = 0; i < 9; i++) 
        {
            if (board[r][i] == num) 
            {
                return true;
            }
        }
        return false;
    }

    public static boolean colcheck(int c, int num) 
    {
        for (int i = 0; i < 9; i++) 
        {
            if (board[i][c] == num) 
            {
                return true;
            }
        }
        return false;
    }

    public static boolean boxcheck(int r, int c, int num)
    {
    
        int startR = 0;
        int startC = 0;

        if (r/3 == 0)
        {
            startR = 0;
        }
        else if (r/3 == 1)
        {
            startR = 3;
        }
        else
        {
            startR = 6;
        }

        if (c/3 == 0)
        {
            startC = 0;
        }
        else if (c/3 == 1)
        {
            startC = 3;
        }
        else
        {
            startC = 6;
        }

        for (int i = startR; i < startR + 3; i++)
        {
            for (int j = startC; j < startC + 3; j++)
            {
                if (board[i][j] == num)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static void boardprinter() 
    {
        for (int r = 0; r < 9; r++) 
        {
            for (int c = 0; c < 9; c++) 
            {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
