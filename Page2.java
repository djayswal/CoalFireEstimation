import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.*;
import java.util.Scanner;

import static java.lang.System.*;


public class Page2 extends Frame {


    private static final Object OpenFilesEvent = null;
    String OldFileName;
    public Button next, b1, save;

    public float GhramRatio, YoungsRatio, JonesTrcketRatio;

    public File NewFile;

    public float i_carbonmono, i_oxygen, i_nitrogen, i_carbondi, i_hydrogen, i_methane;

    TextField tf_newFile = new TextField(12);

    TextField tf_Oxygen = new TextField(10);
    TextField tf_CarbonDi = new TextField(10);
    TextField tf_CarbonMono = new TextField(10);
    TextField tf_Methane = new TextField(10);
    TextField tf_Hydrogen = new TextField(10);
    TextField tf_Nitrogen = new TextField(10);


    String columnn[] = {"Oxygen", "CarbonDi", "CarbonMono", "Methane", "Hydrogen", "Nitrogen"};
    Label l_ghrams, l_youngs, l_jones, l_willets, l_morris;


    Page2(String title) {

        super(title);

        this.setVisible(true);
        setSize(400, 500);
        setResizable(true);
        setBackground(Color.yellow);
        setLocation(400, 100);
        out.println(this.getLocation());
        Label l = new Label("Gas Composition");


        Choice choice = new Choice();
        choice.add("Percentage");
        choice.add("Volume");

        //out.println(tfArray.length);


        Label l_Oxygen = new Label("Enter Oxygen(O2):");
        Label l_CarbonDi = new Label("Enter Carbon Di Oxide (CO2):");
        Label l_CarbonMono = new Label("Enter Carbon MonoOxide (CO):");
        Label l_Methane = new Label("Enter Methane (CH4):");
        Label l_Hydrogen = new Label("Enter Hydrogen (H2):");
        Label l_Nitrogen = new Label("Enter Nitrogen (N2):");


        //-----------------------------------Search from old file------------------------------------------------


        Button OldFileCreate = new Button("Old File");


        OldFileCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //----------------------------- Select Old File -----------------------------------------------------


                JFileChooser OldFileChoser = new JFileChooser();
                int response = OldFileChoser.showOpenDialog((Component) OpenFilesEvent);
                if (response == JFileChooser.APPROVE_OPTION) ;
                {

                    String OldFileName;
                    tf_newFile.setText(OldFileName = OldFileChoser.getSelectedFile().toString());

                    out.println("File Selected");
                    out.println(OldFileName);


                    FileReader fr = null;
                    try {
                        fr = new FileReader(OldFileName);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }

                    BufferedReader br = new BufferedReader(fr);

                    //-------------------------- Set Text to Text Field------------------------------

                    try {
                        String s;
                        int count = 0;
                        while ((s = br.readLine()) != null) {

                            byte[] bArray = readFileToByteArray(OldFileName);
                            //displaying content of byte array
                            for (int i = 0; i < bArray.length; i++) {
                                System.out.print((char) bArray[i]);
                                if (equals(",")) {

                                    count = count + 1;


                                }
                                System.out.println("Count " + count);
                            }
                            String[] a = s.split(" ");
//                        for(int Counttf = 0;Counttf<tfArray.length;Counttf++)
//                            {

//                                    //tf_Oxygen.setText(String.valueOf(tfArray[Countt]));
                            tf_Oxygen.setText(a[0]);
                            tf_CarbonDi.setText(a[1]);
                            tf_CarbonMono.setText(a[2]);
                            tf_Methane.setText(a[3]);
                            tf_Hydrogen.setText(a[4]);
                            tf_Nitrogen.setText(a[5]);


//                                    if(equals(COMMA_DELIMITER)) {
//
//                                        count = count + 1;
//                                    }
//

//
//
//
//
//
//                            }
                        }

//                    File file =
//                            new File(OldFileName);
//                    Scanner sc = null;
//                    try {
//                        sc = new Scanner(file);
//                    } catch (FileNotFoundException e1) {
//                        e1.printStackTrace();
//                    }
//
                        //byte[] data = FileUtils.readFileToByteArray(file);


//                    String line;
//                    try {
//                        if (a != null) {
//                            while ((line = a.readLine()) != null) {
//
//                                System.out.print(line);


                        //tf_Oxygen.setText(String.valueOf(a.read()));

//                                if(Character.isWhitespace(a.read()))
//                                {
//                                    //tf_CarbonDi.setText(String.valueOf(a.read()));
//
//
//
//                                }
//                                else if(Character.isWhitespace(OldFileName.charAt(i)))
//                                {
//                                    tf_CarbonMono.setText(String.valueOf(a.read()));
//
//
//                                }
//
//                            }
//                        }
                    } catch (IOException ex) {
                        out.println("File Not Found");
                    }

                    try {
                        fr.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }


                }
                Scanner OldFileName = new Scanner(in);
                OldFileName.next();

                File OldFile = new File("D:\\" + String.valueOf(OldFileName));
                OldFile.getParentFile();


            }
        });


        //------------------------------------Create new file-----------------------------------


        Button NewFileCreate = new Button("New File");


        NewFileCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String NewFileName = tf_newFile.getText();


                NewFile = new File("D:\\S T U D Y\\P R O J E C T S\\CSIR - CIMFR\\" + String.valueOf(NewFileName) + ".txt");
                try {
                    NewFile.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                out.println("File Created Succesfully");


            }
        });


//-------------------------------------- Save into New File ----------------------------------------------


        save = new Button("Save new file");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(NewFile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                try {

                    bufferedWriter.write(tf_Oxygen.getText());
                    bufferedWriter.append(" ");
                    bufferedWriter.write(tf_CarbonDi.getText());
                    bufferedWriter.append(" ");
                    bufferedWriter.write(tf_CarbonMono.getText());
                    bufferedWriter.append(" ");
                    bufferedWriter.write(tf_Methane.getText());
                    bufferedWriter.append(" ");
                    bufferedWriter.write(tf_Hydrogen.getText());
                    bufferedWriter.append(" ");
                    bufferedWriter.write(tf_Nitrogen.getText());
                    bufferedWriter.write("\n");


                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                try {
                    bufferedWriter.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                System.out.println("File Saved");
            }
        });


        //-------------------------------------- Next Button ------------------------------------------------

            next = new Button("Next1");
            next.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Next1 Clicked");
                    String s_oxygen = (tf_Oxygen.getText());
                    i_oxygen = Integer.parseInt(s_oxygen);

                    if (i_oxygen > 60) {
                        out.println("High Chance Oxygen");
                    } else out.println("Low chance Oxygen");

                    String s_carbondi = (tf_CarbonDi.getText());
                    i_carbondi = Integer.parseInt(s_carbondi);

                    if (i_carbondi > 60) {
                        out.println("High Chance Carbon Di");
                    } else out.println("Low chance Carbon Di");

                    String s_carbonmono = (tf_CarbonMono.getText());
                    i_carbonmono = Integer.parseInt(s_carbonmono);

                    if (i_carbonmono > 60) {
                        out.println("High Chance Carbon mono");
                    } else out.println("Low chance Carbon Mono");

                    String s_methane = (tf_Methane.getText());
                    i_methane = Integer.parseInt(s_methane);

                    if (i_methane > 60) {
                        out.println("High Chance methane");
                    } else out.println("Low chance methane");

                    String s_hydrogen = (tf_Hydrogen.getText());
                    i_hydrogen = Integer.parseInt(s_hydrogen);

                    if (i_hydrogen > 60) {
                        out.println("High Chance hydrogen");
                    } else out.println("Low chance hydrogen");


                    if (choice.getItem(choice.getSelectedIndex()) == "Percentage") {
                        out.println("You selected Percentage");
                    } else {
                        out.println("You selected Volume");

                    }


                    out.println("\nsuccessfully executed!! Next");


                    //---------------------------------- Ratios -----------------------------------

                    Frame f1 = new Frame("Ratios");

                    //--------------------------------- Graham's Ratio  ----------------------------

                    float GhramRatio;
                    GhramRatio = (float) ((100 * i_carbonmono) / ((0.265 * i_nitrogen) - i_oxygen));
                    l_ghrams = new Label("Ghrams Ratio: " + GhramRatio);

                    out.println("Ghrams Ratio " + GhramRatio);

                    //---------------------------------- Young's Ratio -----------------------------------

                    float YoungsRatio;
                    YoungsRatio = (float) ((100 * (i_carbondi - 0.003)) / ((0.265 * i_nitrogen) - i_oxygen));
                    l_ghrams = new Label("Ghrams Ratio: " + GhramRatio);


                    out.println("Young's Ratio " + YoungsRatio);

                    //---------------------------------- Jones & Tricket Ratio ------------------------------

                    float JonesTricketRatio;
                    JonesTricketRatio = (float) ((i_carbondi + (0.75 * i_carbonmono) - (0.25 * i_hydrogen)) / ((0.265 * i_nitrogen) - i_oxygen));
                    l_ghrams = new Label("Ghrams Ratio: " + GhramRatio);


                    out.println("Jones & Tricket Ratio " + JonesTricketRatio);

                    //---------------------------------- Willet's Ratio -----------------------------------

                    float WilletsRatio;
                    WilletsRatio = ((i_carbonmono) / (i_nitrogen + i_carbondi));
                    l_willets = new Label("Ghrams Ratio: " + WilletsRatio);


                    out.println("Willets Ratio " + WilletsRatio);

                    //---------------------------------- CH Ratio ------------------------------------------

//        float CHRatio;
//        CHRatio= (float) (6*(i_carbondi+ i_carbonmono+ ) / ((0.265 * i_nitrogen)-i_oxygen));
//
//        System.out.println("C/H Ratio "+ CHRatio);

                    //---------------------------------- Morris Ratio -------------------------------------

                    float MorrisRatio;
                    MorrisRatio = ((i_nitrogen) / (i_carbonmono + i_carbondi));
                    l_morris = new Label("Ghrams Ratio: " + MorrisRatio);


                    out.println("Morris Ratio " + MorrisRatio);

                    f1.setForeground(Color.blue);


                    f1.setLayout(new FlowLayout());
                    f1.setSize(400, 300);
                    f1.setVisible(true);
                    f1.add(l_ghrams);
                    f1.add(l_youngs);
                    f1.add(l_jones);
                    f1.add(l_willets);
                    f1.add(l_morris);
                }
            });


        //----------------------------  Choice Selection  -------------------------------


        //---------------------------------- Layout ------------------------------------


        next.setForeground(Color.red);

        FlowLayout fl = new FlowLayout();

        this.setLayout(fl);


        Panel p01 = new Panel();
        p01.add(tf_newFile);

        p01.add(NewFileCreate);
        p01.add(OldFileCreate);
        // p01.add(tf_SelectFile);
        this.add(p01);

        Panel p0 = new Panel();
        p0.add(l);
        p0.add(choice);
        this.add(p0);

        Panel p1 = new Panel();
        p1.add(l_Oxygen);
        p1.add(tf_Oxygen);
        this.add(p1);

        Panel p2 = new Panel();
        p2.add(l_CarbonDi);
        p2.add(tf_CarbonDi);
        this.add(p2);

        Panel p3 = new Panel();
        p3.add(l_CarbonMono);

        Panel p6 = new Panel();
        p6.add(save);

        p6.add(next);
        p3.add(tf_CarbonMono);
        this.add(p3);

        Panel p4 = new Panel();
        p4.add(l_Methane);
        p4.add(tf_Methane);
        this.add(p4);

        Panel p5 = new Panel();
        p5.add(l_Hydrogen);
        p5.add(tf_Hydrogen);
        this.add(p5);

        Panel p7 = new Panel();
        p7.add(l_Nitrogen);
        p7.add(tf_Nitrogen);
        this.add(p7);

        this.add(p6);


    }

    private byte[] readFileToByteArray(String oldFileName) {
        return new byte[0];
    }
}



