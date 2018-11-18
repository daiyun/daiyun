package com.godaiyun.upupup.tree;

public class Cell {

  public int x;
  public int y;

  public boolean isVisited;
  public char element;


  public Cell(int x, int y, boolean isVisited, char element) {
    this.x = x;
    this.y = y;
    this.element = element;
    this.isVisited = isVisited;
  }
}
