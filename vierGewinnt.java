
import java.io.Serializable;
public class vierGewinnt implements Serializable
{
  private int row=6;
  private int column=7;
  private int player;
  int [][] board= new int[row][column];
 
  public vierGewinnt(int row, int column, int player)
  {
    this.row=row;
    this.column=column;
    this.player=player;
  }
 
 
 
  public void fillboard()
  {
    for (int a = 0; a < row; a++) {
      for (int b = 0; b < column; b++) {
        board[a][b]=0;
      } // end of for
    } // end of for
  }
 
 
 
  public void throwcoin(int b)
  {
    for (int a = 0; a < column; a++) {
      if (board[a][b] < 1) {
        board[a][b] = player;
        a=column;
      } // end of if
    } // end of for
  }
 
 
 
  public void setplayer()
  {
    if (player > 1) {
      player = 1;
    } // end of if
    else {
      player = 2;
    } // end of if-else
  }
 
 
 
  public void printboard()
  {
    for(int a = row - 1; a >= 0; a--)
    {
      for(int b = 0; b < column; b++)
      {
        System.out.printf("%5d", board[a][b]);
      }
      System.out.println();
    }
  }
 
 
 
  public int checkwinner()
  {
    int streak=0;
    int winner=0;
    int colour=0;
    //reihe von links nach rechts
    for (int a = 0; a < row; a++) {
      streak = 0;
      for (int b = 0; b < column; b++) {
        if(board[a][b]<colour || board[a][b]>colour)
        {
          streak = 0;
        }
        else
        {
          streak = streak + 1;
        }
        if (streak>2)
        {
          if (colour>1)
          {
            winner = 2;
          }
          else
          {
            if(colour>0)
            {
              winner = 1;
            }
          }
        }
        colour = board[a][b];
      } // end of for
    } // end of for
    
    streak = 0;
    
    //spalte von unten nach oben
    for (int b = 0; b < column; b++) {
      streak = 0;
      for (int a = 0; a < row; a++) {
        if(board[a][b]<colour || board[a][b]>colour)
        {
          streak = 0;
        }
        else
        {
          streak = streak + 1;
        }
        if (streak>2)
        {
          if (colour>1)
          {
            winner = 2;
          }
          else
          {
            if(colour>0)
            {
              winner = 1;
            }
          }
        }
        colour = board[a][b];
      } // end of for
    } // end of for
    
    streak = 0;
    
    //diagonale von links-unten nach rechts-oben
    for (int i = 0; i < 3; i++)
    {
      int  b = 0;
      for (int a = i; a < 6; a++)
      {
        if(board[a][b]<colour || board[a][b]>colour)
        {
          streak = 0;
        }
        else
        {
          streak = streak + 1;
        }
        if (streak>2)
        {
          if (colour>1)
          {
            winner = 2;
          }
          else
          {
            if(colour>0)
            {
              winner = 1;
            }
          }
        }
        colour = board[a][b];
        b++;
      } // end of for
      
      streak = 0;
      
    }
    
    
    
    //diagonale von links-unten nach rechts-oben
    for (int i = 1; i < 4; i++)
    {
      int  b = i;
      for (int a = 0; a < 7 - i; a++)
      {
        if(board[a][b]<colour || board[a][b]>colour)
        {
          streak = 0;
        }
        else
        {
          streak = streak + 1;
        }
        if (streak>2)
        {
          if (colour>1)
          {
            winner = 2;
          }
          else
          {
            if(colour>0)
            {
              winner = 1;
            }
          }
        }
        colour = board[a][b];
        b++;
      } // end of for
      
      streak = 0;
      
    }
    
    
    
    //diagonale von rechts-unten nach links-oben
    for (int i = 0; i < 3; i++)
    {
      int  b = 6;
      for (int a = i; a < 6; a++)
      {
        if(board[a][b]<colour || board[a][b]>colour)
        {
          streak = 0;
        }
        else
        {
          streak = streak + 1;
        }
        if (streak>2)
        {
          if (colour>1)
          {
            winner = 2;
          }
          else
          {
            if(colour>0)
            {
              winner = 1;
            }
          }
        }
        colour = board[a][b];
        b--;
      } // end of for
      
      streak = 0;
      
    }
    
    
    
    //diagonale von rechts-unten nach links-oben
    for (int i = 3; i < 6; i++)
    {
      int  b = i;
      for (int a = 0; a < 1 + i; a++)
      {
        if(board[a][b]<colour || board[a][b]>colour)
        {
          streak = 0;
        }
        else
        {
          streak = streak + 1;
        }
        if (streak>2)
        {
          if (colour>1)
          {
            winner = 2;
          }
          else
          {
            if(colour>0)
            {
              winner = 1;
            }
          }
        }
        colour = board[a][b];
        b--;
      } // end of for
      
      streak = 0;
      
    }
    
    return winner;
  }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
  public int ComputerZug()
  {
    int streak=0;
    int colour=1;
    //erster Zug immer in der Mitte
    if (board[0][3]<1)
    {
      return 3;
    } // end of if
    
    for (int c = 1; c > 0;c--)
    {
      c++;    
      colour = 1;
      //für Gelb
      //reihe von links nach rechts
      for (int a = 0; a < row; a++) {
        streak = 0;
        for (int b = 0; b < column - 1; b++) {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a][b+1] < 1 && board[5][b+1]<1) {
              if (a<1 || board[a-1][b+1]<1)
              {
                return b+1;
              }
            } // end of if
          }
        } // end of for
      } // end of for
      
      streak = 0;
      
      //reihe von rechts nach links
      for (int a = 0; a < row; a++) {
        streak = 0;
        for (int b = column - 1; b >= 0; b--) {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a][b-1] < 1 && board[5][b-1]<1) {
              if (a<1 || board[a-1][b-1] < 1)
              {
                return b-1;
              }
            } // end of if
          }
        } // end of for
      } // end of for
      
      streak = 0;
      
      //spalte von unten nach oben
      for (int b = 0; b < column; b++) {
        streak = 0;
        for (int a = 0; a < row - 1; a++) {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b] < 1) {
              if (board[5][b+1]<1)
              {
                return b;
              }
            } // end of if
          }
        } // end of for
      } // end of for
      
      streak = 0;
      
      //diagonale von links-unten nach rechts-oben
      for (int i = 0; i < 2; i++)
      {
        int  b = 0;
        for (int a = i; a < 5; a++)
        {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b+1] < 1 && board[5][b+1]<1) {
              if (a<1 || board[a][b+1]<1)
              {
                return b+1;
              }
            } // end of if
          }
          b++;
        } // end of for
        
        streak = 0;
        
      }
      
      
      
      //diagonale von links-unten nach rechts-oben
      for (int i = 1; i < 3; i++)
      {
        int  b = i;
        for (int a = 0; a < 6 - i; a++)
        {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b+1] < 1 && board[5][b+1]<1) {
              if (a<1 || board[a][b+1]<1)
              {
                return b+1;
              }
            } // end of ifreturn b;
          }
          b++;
        } // end of for
        
        streak = 0;
        
      }
      
      
      
      //diagonale von rechts-unten nach links-oben
      for (int i = 0; i < 2; i++)
      {
        int  b = 5;
        for (int a = i; a < 6; a++)
        {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b-1] < 1 && board[5][b-1]<1) {
              if (a<1 || board[a][b-1]<1)
              {
                return b-1;
              }
            } // end of ifreturn b;
          }
          b--;
        } // end of for
        
        streak = 0;
        
      }
      
      
      
      //diagonale von rechts-unten nach links-oben
      for (int i = 3; i < 5; i++)
      {
        int  b = i;
        for (int a = 0; a < 0 + i; a++)
        {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b-1] < 1 && board[5][b-1]<1) {
              if (a<1 || board[a][b-1]<1)
              {
                return b-1;
              }
            } // end of ifreturn b;
          }
        }
        b--;
      } // end of for
      
      streak = 0;
      
      
      
      colour = 2;
      c--;
      
      //für Rot
      //reihe von links nach rechts
      for (int a = 0; a < row; a++) {
        streak = 0;
        for (int b = 0; b < column - 1; b++) {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a][b+1] < 1 && board[5][b+1]<1) {
              if (a<1 || board[a-1][b+1]<1)
              {
                return b+1;
              }
            } // end of if
          }
        } // end of for
      } // end of for
      
      streak = 0;
      
      //reihe von rechts nach links
      for (int a = 0; a < row; a++) {
        streak = 0;
        for (int b = column - 1; b >= 0; b--) {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a][b-1] < 1 && board[5][b-1]<1) {
              if (a<1 || board[a-1][b-1]<1)
              {
                return b-1;
              }
            } // end of if
          }
        } // end of for
      } // end of for
      
      streak = 0;
      
      //spalte von unten nach oben
      for (int b = 0; b < column; b++) {
        streak = 0;
        for (int a = 0; a < row - 1; a++) {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b] < 1) {
              if (board[5][b+1]<1)
              {
                return b;
              }
            } // end of if
          }
        } // end of for
      } // end of for
      
      streak = 0;
      
      //diagonale von links-unten nach rechts-oben
      for (int i = 0; i < 2; i++)
      {
        int  b = 0;
        for (int a = i; a < 5; a++)
        {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b+1] < 1 && board[5][b+1]<1) {
              if (a<1 || board[a][b+1]<1)
              {
                return b+1;
              }
            } // end of if
          }
          b++;
        } // end of for
        
        streak = 0;
        
      }
      
      
      
      //diagonale von links-unten nach rechts-oben
      for (int i = 1; i < 3; i++)
      {
        int  b = i;
        for (int a = 0; a < 6 - i; a++)
        {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b+1] < 1 && board[5][b+1]<1) {
              if (a<1 || board[a][b+1]<1)
              {
                return b+1;
              }
            } // end of ifreturn b;
          }
          b++;
        } // end of for
        
        streak = 0;
        
      }
      
      
      
      //diagonale von rechts-unten nach links-oben
      for (int i = 0; i < 2; i++)
      {
        int  b = 5;
        for (int a = i; a < 6; a++)
        {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b-1] < 1 && board[5][b-1]<1) {
              if (a<1 || board[a][b-1]<1)
              {
                return b-1;
              }
            } // end of ifreturn b;
          }
          b--;
        } // end of for
        
        streak = 0;
        
      }
      
      
      
      //diagonale von rechts-unten nach links-oben
      for (int i = 3; i < 5; i++)
      {
        int  b = i;
        for (int a = 0; a < 0 + i; a++)
        {
          if(board[a][b]<colour || board[a][b]>colour)
          {
            streak = 0;
          }
          else
          {
            streak = streak + 1;
          }
          if (streak>c)
          {
            if (board[a+1][b-1] < 1 && board[5][b-1]<1) {
              if (a<1 || board[a][b-1]<1)
              {
                return b-1;
              }
            } // end of ifreturn b;
          }
        }
        b--;
      } // end of for
      
      streak = 0;
      
    }
    
    
    
    return 7;
  }
  
  public static void main (String[]args)
  {
    vierGewinnt p1 = new vierGewinnt(6, 7, 1);
    p1.fillboard();
    p1.printboard(); 
  } 
  }
