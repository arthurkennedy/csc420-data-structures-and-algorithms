/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processinfo;

/**
 *
 * @author arthu
 */

public class ProcessInfo implements Comparable<ProcessInfo> {
    private String processName;
    private int processId;
    private int processPriority;

    private int processRemainingRuntime;

    private long processStartTime;
    private long processEndTime;
    private long processElapsedTime;
    
    private boolean executeEnded = false;

    // Constructors

    public ProcessInfo() {
        // Default constructor
    }

    public ProcessInfo(String processName, int processId, int processPriority, int processRemainingRuntime) {
        this.processName = processName;
        this.processId = processId;
        this.processPriority = processPriority;
        this.processRemainingRuntime = processRemainingRuntime;
        this.processStartTime = System.currentTimeMillis(); // Set start time to current time
    }

    // Setters and getters (unchanged)
    
    public String getProcessName(){
        return processName;
    }
    
    
    public int getProcessPriority(){
        return processPriority;
    }
    
    public int processRemainingRuntime(){
        return processRemainingRuntime;
    }
    
    public long getProcessElapsedTime(){
        return processElapsedTime;
    }

    // Additional methods

    /**
     * Execute the process for a given amount of time.
     *
     * @param runtime The time to execute the process.
     * @return true if the process completed, false if there's remaining runtime.
     */
    public boolean executeProcess(int runtime) {
        
        if(!executeEnded){
            if (processRemainingRuntime <= runtime) {
                processEndTime = System.currentTimeMillis();
                processElapsedTime = processEndTime - processStartTime;
                processRemainingRuntime = 0;
                return true; // Process completed
            } else {
                processRemainingRuntime -= runtime;
                processElapsedTime = System.currentTimeMillis() - processStartTime;
                return false; // Process still has remaining runtime
            }
        }else {
            return false;
        }
    }

    /**
     * Compare this process to another based on their priority.
     *
     * @param otherProcess The process to compare to.
     * @return Negative if this process has lower priority, positive if higher, 0 if equal.
     */
    @Override
    public int compareTo(ProcessInfo otherProcess) {
        return Integer.compare(this.processPriority, otherProcess.processPriority);
    }

    /**
     * Get a string representation of the process information.
     */
    @Override
    public String toString() {
        return "\nProcess Name: "+ processName +
                " \tProcess Id: " + processId+ 
                " \tProcess Priority: " + processPriority + 
                " \tProcess Remaining Runtime: " + processRemainingRuntime;
    }

    /**
     * Get a string representation of the completed process information.
     */
    public String displayCompletedInfo() {
        return "Process has completed: " + processName + "-" + processPriority;
    }

    /**
     * End the process and update end time and elapsed time.
     */
    public void endProcess() {
        processEndTime = System.currentTimeMillis();
        processElapsedTime = processEndTime - processStartTime;
        processRemainingRuntime = 0;
        executeEnded = true;
    }
}