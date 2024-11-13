package fr.isima.codereview.tp1;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Tp1ApplicationTests {

	@Test
    public void TestInstance() {
        AwesomePasswordChecker APC = null;
        try {
            File f = new File("");
            APC = AwesomePasswordChecker.getInstance(f);
        } catch (Exception e) {
            
        }
        assertTrue(APC != null);

        try {
            APC = AwesomePasswordChecker.getInstance();
        } catch (IOException e) {

        }
        assertFalse(APC == null);
    }

	
    @Test
    public void TestmaskAff(){
        AwesomePasswordChecker APC;
        try {
            APC = AwesomePasswordChecker.getInstance();
            int mask[] = APC.maskAff("eE%dD9;");
            int expectedmask[] = {1,3,6,2,4,5,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            assertArrayEquals(expectedmask, mask);
        } catch (IOException e) {
            
        }
    }

    @Test
    public void TestDistance(){
        AwesomePasswordChecker APC;
        try {
            APC = AwesomePasswordChecker.getInstance();
            double resul = APC.getDIstance("eE%dD9;");
        }
        catch (IOException e){

        }
    }
}
