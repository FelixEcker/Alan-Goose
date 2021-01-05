// 
// Decompiled by Procyon v0.5.36
// 

package geese.umdrehen;

import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.NoSuchPaddingException;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

public class VIV
{
    public static final String EEEE = "hFNLjTUemh1jzOIM84/0FbhOo1UCLxMI62Fw04eAbPm4TeUX87y59upCNbPGdylL8TX3lgUxrxnPnQBhCkLAdQ==";
    public static final String FFFF = "M1lyVkccDCKzdzcfCSetjwyBWBFH95QK";
    
    public static String katz(final String KEY) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, IOException {
        final LXVIII lxvii = new LXVIII();
        return lxvii.decrypt(KEY, "hFNLjTUemh1jzOIM84/0FbhOo1UCLxMI62Fw04eAbPm4TeUX87y59upCNbPGdylL8TX3lgUxrxnPnQBhCkLAdQ==");
    }
    
    public static void main(final String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, IOException {
    }
}
