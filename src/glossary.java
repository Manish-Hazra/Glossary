import java.util.*;
import java.io.*;
class search
{
    public ArrayList<Integer> find(String word, File text) throws IOException
    {
        LineNumberReader rdr = new LineNumberReader(new FileReader(text));
        ArrayList<Integer> results = new ArrayList<Integer>(); 
        FileReader fr=new FileReader(text);   //reads the file
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream 
        String line;  
        while((line=br.readLine())!=null)  
        {  
            String line1 = rdr.readLine();
            if (line1.indexOf(word) >= 0) 
            {
                results.add(rdr.getLineNumber());
            } 
        }  
        fr.close();
        rdr.close();
        return results;
    }
    public void display(TreeMap<String,ArrayList<Integer>> t)
    {
        System.out.println("Word\tLine Occurence\n");
        Set<Map.Entry<String,ArrayList<Integer>>> entries = t.entrySet();
        for(Map.Entry<String,ArrayList<Integer>> entry : entries){
            System.out.println( entry.getKey() + "\t" + entry.getValue() );
        }
    }
}
public class glossary
{
    public static void main(String args[]) throws IOException
    {
        search s=new search();
        File fl = new File("C:\\Users\\MANISH\\Desktop\\text.txt");
        ArrayList<Integer> r=new ArrayList<Integer>();
        Scanner sc=new Scanner(System.in);
        TreeMap<String,ArrayList<Integer>> t=new TreeMap<String,ArrayList<Integer>>();
        char choice='y';
        int ch=0;
        String word;
        while(ch!=3)
        {
            System.out.println("-----------Main Menu-----------\n");
            System.out.println("1. Search word in file\n");
            System.out.println("2. Display all searched word\n");
            System.out.println("3. Exit\n");
            System.out.println("-------------------------------\n");
            System.out.println("Enter choice:");
            ch=sc.nextInt();
            sc.nextLine();
            switch(ch)
            {
                case 1:
                    while(choice=='y'||choice=='Y')
                    {
                        System.out.println("Enter a word to search in file :");
                        word=sc.nextLine();
                        r=s.find(word,fl);
                        t.put(word,r);
                        System.out.println("Occurs at lines:"+r);
                        System.out.println("Want to search more words??(y/n)");
                        choice=sc.next().charAt(0);
                        sc.nextLine();
                    }
                    break;
                case 2:
                    s.display(t);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}