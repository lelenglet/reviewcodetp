package fr.isima.codereview.tp1;

import java.io.IOException;


public class Tp1Application {
	public static void main(String[] args) {
        try {
            AwesomePasswordChecker APC = AwesomePasswordChecker.getInstance();
            int mask[] = APC.maskAff("eE%dD9;");
            for(int i = 0; i < 28; i++) System.out.println(mask[i]);
        } catch (IOException e) {
        }
	}
}
