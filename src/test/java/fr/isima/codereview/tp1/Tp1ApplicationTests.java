package fr.isima.codereview.tp1;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Tp1ApplicationTests {

	@Test
    public void TestInstance() {
        AwesomePasswordChecker APC1 = null;
        AwesomePasswordChecker APC2 = null;
        try {
            File f = new File("existepas");
            APC1 = AwesomePasswordChecker.getInstance(f);
        } catch (Exception e) {}
        assertFalse(APC1 == null); 

        try {
            APC2 = AwesomePasswordChecker.getInstance();
        } catch (IOException e) {
        }
        assertFalse(APC2 == null);
    }

	
    @Test
    public void TestmaskAff(){
        AwesomePasswordChecker APC;
        try {
            APC = AwesomePasswordChecker.getInstance();
            int mask[] = APC.maskAff("eE%dD9;");
            int expectedmask[] = {1,3,6,2,4,5,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            assertArrayEquals(expectedmask, mask);

            assertNull(APC.maskAff(null));
        } catch (IOException e) {}
    }

    @Test
    public void TestDistance(){
        AwesomePasswordChecker APC;
        try {
            APC = AwesomePasswordChecker.getInstance();
            double resul = APC.getDIstance("eE%dD9;");
            assertTrue(resul == 8.51304255193901);

            assertTrue(APC.getDIstance(null) == -1);
        }
        catch (IOException e){

        }
    }

    @Test
    public void TestMD5(){
        String passHash = AwesomePasswordChecker.ComputeMD5("password");
        assertTrue(passHash.equals("5f4dcc3b5aa765d61d8327deb882cf99"));
        assertNull(AwesomePasswordChecker.ComputeMD5(null));
    }
}
