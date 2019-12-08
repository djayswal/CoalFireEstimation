
import java.io.*;
import java.util.Scanner;
import java.util.ServiceLoader;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//
////        public class Page3 {
////
////
////            File fname;
////                public static void main(String args[])throws Exception{
////                    FileReader fr=new FileReader("abcc.txt");
////                    int i;
////                    while((i=fr.read())!=-1)
////                        System.out.print((char)i);
////                    fr.close();
////                }
////            }
//class Page3 {
//    public static void main(String args[]) {
//
//       // private void jButtonImportActionPerformed (java.awt.event.ActionEvent evt){
//
//            String filePath = "table.txt";
//            File file = new File(filePath);
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//                BufferedReader br = new BufferedReader(new FileReader(file));
//                // get the first line
//                // get the columns name from the first line
//                // set columns name to the jtable model
//                String firstLine = br.readLine().trim();
//                String[] columnsName = firstLine.split(",");
//                JTable jTable1 = null;
//
//                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//                model.setColumnIdentifiers(columnsName);
//
//                // get lines from txt file
//                Object[] tableLines = br.lines().toArray();
//
//                // extratct data from lines
//                // set data to jtable model
//                for (int i = 0; i < tableLines.length; i++) {
//                    String line = tableLines[i].toString().trim();
//                    String[] dataRow = line.split("/");
//                    model.addRow(dataRow);
//                }
//
//
//            } catch (Exception ex) {
//                Logger.getLogger(Page3.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//
//}
//import javax.swing.*;
//public class Page3 {
//    JFrame f;
//    String data[][]={ {"101","Amit","670000"},
//            {"102","Jai","780000"},
//            {"101","Sachin","700000"}};
//    Page3() throws IOException {
//        f=new JFrame();
//        String filePath = "tablee.txt";
//        File file = new File(filePath);
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        FileWriter fileWriter=new FileWriter(file);
//        BufferedReader bufferedReader=new BufferedReader(fileReader);
//        BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
//
//        bufferedWriter.write(String.valueOf(data));
//
//
//
//
//        String column[]={"ID","NAME","SALARY"};
//        JTable jt=new JTable(data,column);
//        jt.setBounds(30,40,200,300);
//        JScrollPane sp=new JScrollPane(jt);
//        f.add(sp);
//        f.setSize(300,400);
//        f.setVisible(true);
//    }
//    public static void main(String[] args) {
//        try {
//            new Page3();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

public class Page3
{

    /**
     *
     * This constructor takes in two parameters. It is also responsible
     * for writing the JTable contents to disk (to csv file)
     *
     *
     * @param  aData - the JTable data to be saved to disk
     * @param  afile  - the name of the file where the data shall be saved
     * (this is a .CSV type file)
     *
     *
     */
    public Page3(Object[][] aData, String afile)
    {
        writeToDisk(aData,afile);

        // This method prints the two-dimensional array to the command console
        //  printData();

    }

    /**
     *
     * This method is responsible for writing the contents of a JTable (2d
     * array object) to disk (csv text file)
     * <p>
     *
     * @param  aData - the 2D data (Jtable contents) to be stored to disk
     * @param  aDatafile - the file where the data shall be stored
     * to disk. This shall be of type.CSV
     *
     * @return
     *
     * @see
     *
     */

    public void writeToDisk(Object[][] aData, String aDatafile)
    {

        try
        {

            FileOutputStream fout =  new FileOutputStream(aDatafile, false);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));

            //Headers
            bw.append("Script No., Candidate No., Mark, Grade,Script No., Candidate No., Mark, Grade");
            // End of data row (Jable row) so append new line character in csv file
            bw.append('\n');

            for (int row = 0; row < aData.length; row++)
            {

                for (int column = 0; column < aData[row].length; column++)
                {

                    if(aData[row][column] == null)
                    {
                        bw.append("null");
                        // The comma separated value
                        bw.append(',');
                    }
                    else
                    {
              /* In my particular example, I am doing some checking on

                  the 2d array for types:
                  if the data is not of type null (as checked above)
                  then it must be of type Integer.
                  This is because the 2D data array only contains data of either
                  Integer or null

                  each of these object types have a method called toString().
                  we need this in order to convert the types to a string prior to wrting them to
                  the file.

              */
                        bw.append(aData[row][column].toString());
                        bw.append(',');
                    }

                }//end column loop (inner loop)

                bw.append('\n');

            }//end row loop (outer loop)

            bw.close();

        }
        catch (Exception e)
        {

            e.getStackTrace();
        }

    }//end of readFileFromDisk

    /**
     *
     * These methods is responsible for printing the random sample scripts
     * Into the command console.
     * <p>
     *
     *
     */
    public void printData()
    {
        //System.out.println();
        //System.out.println("=======WriteRandomSampleData Class===========");
        //System.out.println();

        for (int row = 0; row < data.length; row++)
        {
            for (int column = 0; column < data[row].length; column++)
            {
                System.out.println("data["+row+"]["+column+"] = " +data[row][column]);
            }
        }

    }

    //==================Instance Variables=============================
    // JTable contents hedata
    private Object[][] data;

    //====================Test Driver============================

    public static void main(String args[])
    {
        // file seperator for windows platform '\\'

        // Dummy values - 2D array which stores the contents of a

        Scanner sc =new Scanner(System.in);

        // JTable into a csv text file
        String a=sc.next();
        String b=sc.next();

        String c=sc.next();

        String d=sc.next();

        String e=sc.next();


        Object[][] testData = new Object [][] {

                {
                    a,b
                },
                {
                    c,d
                }
                ,{
                    e
        }

        };
// SampleData_TEST.csv gets created in the particular directory
// and the file gets populated with the contents of the JTable
        new Page3(testData,"kkk.txt"+"SampleData_TEST.csv");


    }
}