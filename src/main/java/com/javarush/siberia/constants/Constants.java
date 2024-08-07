package com.javarush.siberia.constants;

import java.io.File;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String num = "1234567890";
    private static final String cym = "!@#$%^&*()_+-=*/.,<>[]{};:'\" `~";

    public static final char[] ALPHABET = (rus + rus.toLowerCase() + eng + eng.toLowerCase() + num + cym).toCharArray();
    public static final String ALPHABET_LENGTH_TXT = "Current alphabet length: " + ALPHABET.length + " symbols.";

    public static final String DEFAULT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;

    public static final String INPUT_FILE = DEFAULT_FOLDER + "text.txt";
    public static final String ENCODED_FILE = DEFAULT_FOLDER + "encoded.txt";
    public static final String DECODED_FILE = DEFAULT_FOLDER + "decoded.txt";
    public static final String BRUTEFORCE_FILE = DEFAULT_FOLDER + "bruteForce.txt";
    public static final String RU_DICTIONARY_PATH = DEFAULT_FOLDER + "ru_words.txt";
    public static final String EN_DICTIONARY_PATH = DEFAULT_FOLDER + "en_words.txt";

    public static final int DEFAULT_SHIFT = 3;

    public static final String MENU_TXT = "\nChose action:\n1. Encode\n2. Decode\n3. Brute Force.\n4. Analisis.\n5. EXIT.\ntype menu number: ";
    public static final String ENCODE_TXT = "Enter the path to the file to encrypt (or press Enter for the default path): ";
    public static final String DECODE_TXT = "Enter the path to the file to decrypt (or press Enter for the default path): ";
    public static final String BRUTEFORCE_TXT = "Enter the path to the encrypted file (or press Enter for the default path): ";
    public static final String OUTPUT_TXT = "Enter the path to save the result (or press Enter to use the default path): ";
    public static final String BRUTEFORCE_OUTPUT_TXT = "Enter the path to save the hack result (or press Enter to use the default path): ";
    public static final String KEY_TXT = "Enter the shift key (or press Enter to shift to default - 3): ";
    public static final String INVALID_CHOICE_TXT = "There is no such menu item, try again.";
    public static final String EXIT_TXT = "Exiting the program...";

    public static final String ANALYSIS_FILE = DEFAULT_FOLDER + "analysis.txt";
    public static final String ANALYSE_TXT = "Enter the path to the encrypted file to analyze (or press Enter to use the default file): ";
    public static final String ANALYSE_OUTPUT_TXT = "Enter the path to save the decrypted file (or press Enter to use the default file): ";

    public static final double PERCENT_OF_TEXT_UNDERSTANDING = 80.0;
}