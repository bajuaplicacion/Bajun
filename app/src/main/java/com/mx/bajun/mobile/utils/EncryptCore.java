package com.mx.bajun.mobile.utils;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import java.security.KeyStore;
import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

import static android.security.keystore.KeyProperties.KEY_ALGORITHM_AES;

public class EncryptCore {

    private static final String BAJUN_APP_KEY_STORE = "bajunAppKeyStore";
    private static final String CIPHER_METHOD = "AES/GCM/NoPadding";
    private static byte[] ivBytes = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,0x00, 0x00, 0x00};

    public void generateKey (String alias) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM_AES, BAJUN_APP_KEY_STORE);
            keyGenerator.init( new KeyGenParameterSpec.Builder(alias,
                    KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                    .setRandomizedEncryptionRequired(false)
                    .build()
            );
            SecretKey key = keyGenerator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String message, String alias) {
        try {
            KeyStore keyStore = KeyStore.getInstance(BAJUN_APP_KEY_STORE);
            keyStore.load(null);
            GCMParameterSpec ivSpec = new GCMParameterSpec(128, ivBytes);
            SecretKey key = (SecretKey) keyStore.getKey(alias, null);
            Cipher cipher = Cipher.getInstance(CIPHER_METHOD);
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            byte[] encodedBytes = cipher.doFinal(message.getBytes());
            return Base64.encodeToString(encodedBytes, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String decrypt(String encryptedMessage, String alias) {
        try {
            KeyStore keyStore = KeyStore.getInstance(BAJUN_APP_KEY_STORE);
            keyStore.load(null);
            GCMParameterSpec ivSpec = new GCMParameterSpec(128, ivBytes);
            SecretKey key = (SecretKey) keyStore.getKey(alias, null);
            Cipher cipher = Cipher.getInstance(CIPHER_METHOD);
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
            byte [] decodedBytes = cipher.doFinal(Base64.decode(encryptedMessage, Base64.DEFAULT));
            return new String(decodedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
