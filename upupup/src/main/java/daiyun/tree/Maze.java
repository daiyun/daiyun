package daiyun.tree;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

public class Maze {

  public static void main(String[] args) {
    char[][] mazeSource = new char[10][10];

    mazeSource[0] = new char[]{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'};
    mazeSource[1] = new char[]{'1', '0', '0', '1', '1', '1', '0', '0', '1', '1'};
    mazeSource[2] = new char[]{'1', '0', '0', '1', '1', '0', '0', '1', '0', '1'};
    mazeSource[3] = new char[]{'1', '0', '0', '0', '0', '0', '0', '1', '0', '1'};
    mazeSource[4] = new char[]{'1', '0', '0', '0', '0', '1', '1', '0', '0', '1'};
    mazeSource[5] = new char[]{'1', '0', '0', '1', '1', '1', '0', '0', '0', '1'};
    mazeSource[6] = new char[]{'1', '0', '0', '0', '0', '1', '0', '1', '0', '1'};
    mazeSource[7] = new char[]{'1', '0', '1', '1', '0', '0', '0', '1', '0', '1'};
    mazeSource[8] = new char[]{'1', '1', '0', '0', '0', '0', '1', '0', '0', '1'};
    mazeSource[9] = new char[]{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'};

    Cell[][] maze = createMaze(mazeSource);

    Cell start = maze[8][8];
    Cell end = maze[1][7];
    Stack<Cell> s = new StringStack();
    s.push(start);

    start.isVisited = true;

    while (!s.isEmpty()) {
      Cell p =  s.peek();

      if (end == p) {

        while (!s.isEmpty()) {
          Cell cell =  s.pop();

          while (!s.isEmpty() && !isAdjoinCell(cell,  s.peek())) {
            s.pop();
          }
          cell.element = '*';

        }

        printMaze(maze);
        return;

      } else {
        int x = p.x;
        int y = p.y;
        int count = 0;

        //下
        if (isValidWayCell(maze[x][y + 1])) {
          s.push(maze[x][y + 1]);
          maze[x][y + 1].isVisited = true;
          count++;
        }

        // 右
        if (isValidWayCell(maze[x + 1][y])) {
          s.push(maze[x + 1][y]);
          maze[x + 1][y].isVisited = true;
          count++;
        }

        // 上
        if (isValidWayCell(maze[x][y - 1])) {
          s.push(maze[x][y - 1]);
          maze[x][y - 1].isVisited = true;
          count++;
        }

        //左
        if (isValidWayCell(maze[x - 1][y])) {
          s.push(maze[x - 1][y]);
          maze[x - 1][y].isVisited = true;
          count++;
        }
        if (count == 0) {
          p = s.pop();
        }

      }
    }

  }

  public static boolean isValidWayCell(Cell cell) {
    return cell.element == '0' && !cell.isVisited;
  }

  public static boolean isAdjoinCell(Cell cell1, Cell cell2) {
    if (cell1.x == cell2.x && Math.abs(cell1.y - cell2.y) < 2) return true;
    if (cell1.y == cell2.y && Math.abs(cell1.x - cell2.x) < 2) return true;
    return false;

  }

  public static Cell[][] createMaze(char[][] source) {
    Cell[][] maze = new Cell[source.length][];
    for (int i = 0; i < source.length; i++) {
      maze[i] = new Cell[source[i].length];
      for (int j = 0; j < source[i].length; j++) {
        maze[i][j] = new Cell(i, j, false, source[i][j]);
      }
    }
    return maze;
  }

  private static void printMaze(Cell[][] cells) {
    for (int x = 0; x < cells.length; x++) {
      for (int y = 0; y < cells[x].length; y++)
        System.out.print(cells[x][y].element);
      System.out.println();
    }
  }
}
