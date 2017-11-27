import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
//nth line reader

public class line
{
  public static void main(String[] args)throws IOException

  {


    BufferedReader inq = new BufferedReader (new FileReader("mathq1.txt"));
    BufferedReader ina = new BufferedReader (new FileReader("matha1.txt"));

    String q = "",a="";
     int startLine = 7;

     // read prior junk
     for (int i = 0; i < startLine; i++)
     {
       q = inq.readLine();
      a = ina.readLine();

     }


     q = inq.readLine();
    a = ina.readLine();
         System.out.println(q);
         System.out.println(a);

     inq.close();
     ina.close();


  }
}
