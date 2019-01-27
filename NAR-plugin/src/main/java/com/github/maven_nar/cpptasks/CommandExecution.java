package com.github.maven_nar.cpptasks;


import org.apache.tools.ant.Project;

import java.io.*;


class StreamGobbler extends Thread {
    InputStream is;
    String type;
    CCTask task;


    StreamGobbler(InputStream is, String type, CCTask task) {
        this.is = is;
        this.type = type;
        this.task = task;
    }


    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null)
                task.log(type +">"+ line );

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}


public class CommandExecution {




    public static int runCommand(String[] cmdArgs, File workDir, CCTask task) throws  IOException{


        try {

            //Create ProcessBuilder with the command arguments
            ProcessBuilder pb = new ProcessBuilder(cmdArgs);

            //Redirect the stderr to the stdout
            pb.redirectErrorStream(true);

            pb.directory(workDir);

            //Start the new process
            Process process = pb.start();


            // Adding to log the command
            StringBuilder builder = new StringBuilder();
            for(String s : cmdArgs) {

                builder.append(s);
                //Append space
                builder.append(" ");
            }
            task.log("Executing - " + builder.toString(), Project.MSG_INFO);


            //Create the StreamGobbler to read the process output
            StreamGobbler outputGobbler = new StreamGobbler(process.getInputStream(), "OUTPUT",task);

            outputGobbler.start();

            int exit_value;

            //Wait for the process to finish
            exit_value = process.waitFor();


            return exit_value;

        } catch (InterruptedException e) {

            e.printStackTrace();
            return -2;
        }

    }

}
