package com.javarush.siberia.constants;

import java.util.Map;
import java.util.TreeMap;

public class FrequencyConstants {

    public static final Map<Character, Double> ENGLISH_FREQUENCY = createEnglishFrequency();
    public static final Map<Character, Double> RUSSIAN_FREQUENCY = createRussianFrequency();


    private static Map<Character, Double> createEnglishFrequency() {
        Map<Character, Double> frequencyMap = new TreeMap<>();
        char[] characters = {'e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r', 'd', 'l', 'u', 'c', 'm', 'f', 'y', 'w', 'g', 'p', 'b', 'v', 'k', 'x', 'q', 'j', 'z', ' '};
        double[] frequencies = {12.70, 9.06, 8.17, 7.51, 6.97, 6.75, 6.33, 6.09, 5.99, 4.25, 4.03, 2.76, 2.23, 2.02, 1.82, 1.97, 1.92, 1.73, 1.66, 1.49, 1.11, 0.77, 0.15, 0.10, 0.10, 0.07, 16.00};

        for (int i = 0; i < characters.length; i++) {
            frequencyMap.put(characters[i], frequencies[i]);
        }
        return frequencyMap;
    }

    private static Map<Character, Double> createRussianFrequency() {
        Map<Character, Double> frequencyMap = new TreeMap<>();
        char[] characters = {'о', 'е', 'а', 'и', 'н', 'т', 'с', 'р', 'л', 'в', 'д', 'м', 'к', 'у', 'ы', 'з', 'ь', 'я', 'ч', 'г', 'б', 'ш', 'э', 'ю', 'ж', 'х', 'ц', 'щ', 'ф', 'ъ', ' '};
        double[] frequencies = {10.97, 8.45, 8.01, 7.34, 6.71, 6.60, 5.43, 4.81, 4.46, 4.43, 3.96, 3.79, 3.52, 3.47, 3.31, 2.86, 2.63, 2.54, 2.51, 2.46, 2.29, 1.96, 1.87, 1.59, 1.25, 1.14, 1.09, 0.89, 0.60, 0.25, 17.00};
        for (int i = 0; i < characters.length; i++) {
            frequencyMap.put(characters[i], frequencies[i]);
        }

        return frequencyMap;
    }
}

//    private static Map<Character, Double> createEnglishFrequency() {
//        Map<Character, Double> frequencyMap = new TreeMap<>();
//        frequencyMap.put('e', 12.70);
//        frequencyMap.put('t', 9.06);
//        frequencyMap.put('a', 8.17);
//        frequencyMap.put('o', 7.51);
//        frequencyMap.put('i', 6.97);
//        frequencyMap.put('n', 6.75);
//        frequencyMap.put('s', 6.33);
//        frequencyMap.put('h', 6.09);
//        frequencyMap.put('r', 5.99);
//        frequencyMap.put('d', 4.25);
//        frequencyMap.put('l', 4.03);
//        frequencyMap.put('u', 2.76);
//        frequencyMap.put('c', 2.23);
//        frequencyMap.put('m', 2.02);
//        frequencyMap.put('f', 1.82);
//        frequencyMap.put('y', 1.97);
//        frequencyMap.put('w', 1.92);
//        frequencyMap.put('g', 1.73);
//        frequencyMap.put('p', 1.66);
//        frequencyMap.put('b', 1.49);
//        frequencyMap.put('v', 1.11);
//        frequencyMap.put('k', 0.77);
//        frequencyMap.put('x', 0.15);
//        frequencyMap.put('q', 0.10);
//        frequencyMap.put('j', 0.10);
//        frequencyMap.put('z', 0.07);
//        frequencyMap.put(' ', 16.00);
//        return frequencyMap;
//    }

//    private static Map<Character, Double> createRussianFrequency() {
//        Map<Character, Double> frequencyMap = new TreeMap<>();
//        frequencyMap.put('о', 10.97);
//        frequencyMap.put('е', 8.45);
//        frequencyMap.put('а', 8.01);
//        frequencyMap.put('и', 7.34);
//        frequencyMap.put('н', 6.71);
//        frequencyMap.put('т', 6.60);
//        frequencyMap.put('с', 5.43);
//        frequencyMap.put('р', 4.81);
//        frequencyMap.put('л', 4.46);
//        frequencyMap.put('в', 4.43);
//        frequencyMap.put('д', 3.96);
//        frequencyMap.put('м', 3.79);
//        frequencyMap.put('к', 3.52);
//        frequencyMap.put('у', 3.47);
//        frequencyMap.put('ы', 3.31);
//        frequencyMap.put('з', 2.86);
//        frequencyMap.put('ь', 2.63);
//        frequencyMap.put('я', 2.54);
//        frequencyMap.put('ч', 2.51);
//        frequencyMap.put('г', 2.46);
//        frequencyMap.put('б', 2.29);
//        frequencyMap.put('ш', 1.96);
//        frequencyMap.put('э', 1.87);
//        frequencyMap.put('ю', 1.59);
//        frequencyMap.put('ж', 1.25);
//        frequencyMap.put('х', 1.14);
//        frequencyMap.put('ц', 1.09);
//        frequencyMap.put('щ', 0.89);
//        frequencyMap.put('ф', 0.60);
//        frequencyMap.put('ъ', 0.25);
//        frequencyMap.put(' ', 17.00);
//        return frequencyMap;
//    }