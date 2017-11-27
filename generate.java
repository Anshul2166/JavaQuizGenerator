import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


class generate
{

  generate(int sub,int choice,int n)throws IOException
  {

        BufferedReader q,a;
        PrintWriter writerq = new PrintWriter("Question.txt", "UTF-8");
        PrintWriter writera = new PrintWriter("Answer.txt", "UTF-8");



        if(sub==1)
        {
            if(choice==1)
            {
              q  = new BufferedReader(new FileReader("mathq1.txt"));
              a  = new BufferedReader(new FileReader("matha1.txt"));
            }

            else
            {
              q  = new BufferedReader(new FileReader("mathq2.txt"));
              a  = new BufferedReader(new FileReader("matha2.txt"));
            }

        }

        else
        {
          if(choice==1)
          {
            q  = new BufferedReader(new FileReader("engq1.txt"));
            a  = new BufferedReader(new FileReader("enga1.txt"));
          }

          else
          {
            q  = new BufferedReader(new FileReader("engq2.txt"));
            a  = new BufferedReader(new FileReader("enga2.txt"));
          }
        }


     Random random = new Random();
      ArrayList<Integer> lineNo = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++)
          lineNo.add(i);

          Collections.shuffle(lineNo);

          for (int i = 9; i > n-1 ; i--)
            lineNo.remove(i);


         Collections.sort(lineNo);

         String info = "";


         writerq.println("QUESTION :");

         for (int i = 0,c=0; i < 10; i++)
         { if(lineNo.contains(i))
            {
                info = q.readLine();
                writerq.println((++c)+". "+info);
              }

            else
                info = q.readLine();


          }


      writera.println("ANSWER :");

        for (int i = 0,c=0; i < 10; i++)
        {
          if(lineNo.contains(i))
           {
               info = a.readLine();
               writera.println((++c)+". "+info);
             }

             else
                 info = a.readLine();

         }

         q.close();
         a.close();
         writerq.close();
         writera.close();


  }

  public static void main(String[] args)throws IOException

  {
      new generate(2,2,4);

  }
}
