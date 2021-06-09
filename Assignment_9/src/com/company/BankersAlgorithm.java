package com.company;

import java.util.Scanner;

public class BankersAlgorithm {
    Scanner scanner = new Scanner(System.in);

    public String execute() {
        StringBuilder sb = new StringBuilder();

        System.out.println("Enter the number of resources");
        int noOfResources = scanner.nextInt();

        int[] availableRes = new int[noOfResources];
        int[] totalAvailable = new int[noOfResources];

        for(int i = 0;i<noOfResources;i++) {
            System.out.println("Enter the total availability of R" + (i+1));
            totalAvailable[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of processes:");
        int noOfProcesses = scanner.nextInt();

        int[][] maximumReq = new int[noOfProcesses][noOfResources];
        int[][] allocated = new int[noOfProcesses][noOfResources];
        int[][] neededRes = new int[noOfProcesses][noOfResources];
        boolean[] finished = new boolean[noOfProcesses];

        for(int i = 0;i<noOfProcesses;i++) {
            for(int j = 0;j<noOfResources;j++) {
                System.out.println("Enter the amount of R" +(j+1) + " allocated to P" + (i+1));
                allocated[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0;i<noOfProcesses;i++) {
            for(int j = 0;j<noOfResources;j++) {
                System.out.println("Enter the amount of R" +(j+1) + " maximum requirement to P" + (i+1));
                maximumReq[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0;i<noOfResources;i++) {
            int sum = 0;
            for(int j = 0;j<noOfProcesses;j++) {
                sum += allocated[j][i];
            }
            availableRes[i] = totalAvailable[i] - sum;
        }

        for(int i = 0;i<noOfProcesses;i++) {
            for(int j = 0;j<noOfResources;j++) {
                neededRes[i][j] = maximumReq[i][j] - allocated[i][j];
            }
        }

        int count = 0;
        boolean[] safeOrUnSafe = new boolean[noOfProcesses];
        while(count < noOfProcesses) {
            for(int i = 0;i<noOfProcesses;i++) {
                if(!finished[i]) {
                    boolean safe = true;
                    for(int j = 0;j<noOfResources;j++) {
                        if(neededRes[i][j] > availableRes[j]) {
                            safe = false;
                            break;
                        }
                    }

                    safeOrUnSafe[i] = safe;

                    if(safe) {
                        sb.append("P").append(i + 1);
                        finished[i] = true;
                        count++;
                        for(int j = 0;j<noOfResources;j++) {
                            availableRes[j] += allocated[i][j];
                            allocated[i][j] = 0;
                            maximumReq[i][j] = 0;
                        }
                    }
                }

            }

            boolean allSafe = false;
            for(int i = 0;i<noOfProcesses;i++) {
                if (safeOrUnSafe[i]) {
                    allSafe = true;
                    break;
                }
            }

            if(!allSafe) {
                return "DEADLOCK DETECTED";
            }
        }

        return sb.toString();
    }
}
