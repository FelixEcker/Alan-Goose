// 
// Decompiled by Procyon v0.5.36
// 

package geese.umdrehen;

import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.NoSuchPaddingException;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.security.Key;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.Cipher;

public class LXVIII
{
    Cipher ecipher;
    Cipher dcipher;
    byte[] salt;
    int iterationCount;
    
    public LXVIII() {
        this.salt = new byte[] { -87, -101, -56, 50, 86, 53, -29, 3 };
        this.iterationCount = 19;
    }
    
    public String encrypt(final String secretKey, final String plainText) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        final KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), this.salt, this.iterationCount);
        final SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        final AlgorithmParameterSpec paramSpec = new PBEParameterSpec(this.salt, this.iterationCount);
        (this.ecipher = Cipher.getInstance(key.getAlgorithm())).init(1, key, paramSpec);
        final String charSet = "UTF-8";
        final byte[] in = plainText.getBytes(charSet);
        final byte[] out = this.ecipher.doFinal(in);
        final String encStr = new String(Base64.getEncoder().encode(out));
        return encStr;
    }
    
    public String decrypt(final String secretKey, final String encryptedText) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, IOException {
        final KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), this.salt, this.iterationCount);
        final SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        final AlgorithmParameterSpec paramSpec = new PBEParameterSpec(this.salt, this.iterationCount);
        (this.dcipher = Cipher.getInstance(key.getAlgorithm())).init(2, key, paramSpec);
        final byte[] enc = Base64.getDecoder().decode(encryptedText);
        final byte[] utf8 = this.dcipher.doFinal(enc);
        final String charSet = "UTF-8";
        final String plainStr = new String(utf8, charSet);
        return plainStr;
    }
}
