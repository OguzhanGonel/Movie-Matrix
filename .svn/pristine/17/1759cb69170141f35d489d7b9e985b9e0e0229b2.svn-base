package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import driver.ChangeDirectory;
import driver.Tree;

public class ChangeDirectoryTest {
  //Instance Variables for multiple methods 
  Tree x;
  Tree y;
  Tree z;
  ChangeDirectory cd;

  @Before
  public void setUp(){
    //Added Children that would be needed for multiple methods 
    cd = new ChangeDirectory(x);
    x = new Tree("ROOTFOLDER");
    y = new Tree("folder1");
    z = new Tree("folder2");
    x.addChild(y);
    y.addChild(z);
  }

  @Test
  public void testGetCurrentDirectory() {
    assertEquals("/", cd.getCurrentDirectory());
  }

  @Test
  public void testSetCurrentDirectory(){
    cd.setCurrentDirectory("y");
    assertEquals("y",cd.getCurrentDirectory());
  }

  @Test
  public void testSetCurrentDirectoryTree(){
    cd.setCurrentDirectoryTree(y);
    assertEquals("/",cd.getCurrentDirectory());
  }

  @Test
  public void testGetCurrentDirectoryTree(){
    assertEquals("ROOTFOLDER", cd.getCurrentDirectoryTree());
  }
  
  @Test 
  public void testChangeDirectory(){
    cd.ChangeDirectory(y);
    assertEquals("y", cd.getCurrentDirectoryTree());
  }
  

  @Test
  public void testCheckString(){
    assertEquals("Invalid Input", cd.CheckString("A B", x, x, x));
    cd.CheckString("hi", "x", cd, x);
  }
  
  @Test 
  public void testMoveFromRoot(){
    cd.moveFromRoot('/x/y', "x", cd, x);
    assertEquals("y", cd.getCurrentDirectory());
  }
  
  @Test 
  public void testMoveFromRelative(){
    cd.moveFromRelative(y, "x", cd, x);
    assertEquals("y", cd.getCurrentDirectory());
  }
  
  @Test 
  public void testMoveUP(){
    cd.moveFromRelative(y, x, x, x);
    cd.moveUP('..', 'x', cd, x);
    assertEquals("x", cd.getCurrentDirectory());
  }

}
