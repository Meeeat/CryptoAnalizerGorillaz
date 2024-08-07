package com.javarush.siberia.commands;

import com.javarush.siberia.cipher.CaesarCipher;
import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.constants.ErrorsConstants;
import com.javarush.siberia.constants.FrequencyConstants;
import com.javarush.siberia.entity.Result;
import com.javarush.siberia.entity.ResultCode;
import com.javarush.siberia.utils.FileReadWrite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Analysis implements Action {

    private final CaesarCipher cipher = new CaesarCipher();

    @Override
    public Result execute(String[] parameters) {
        String inputFilePath = parameters[0];
        String outputFilePath = parameters[1];

        char[] text;
        try {
            text = FileReadWrite.readFile(inputFilePath);
        } catch (IOException e) {
            return new Result(ErrorsConstants.CANT_READ_FILE, ResultCode.ERROR);
        }

        for (int shift = 0; shift < Constants.ALPHABET.length; shift++) {
            char[] shiftedText = cipher.analysisDecryptText(text, shift, Constants.ALPHABET);
            if (isMeaningful(shiftedText, FrequencyConstants.RUSSIAN_FREQUENCY) ||
                    isMeaningful(shiftedText, FrequencyConstants.ENGLISH_FREQUENCY)) {
                try {
                    FileReadWrite.writeFile(outputFilePath, shiftedText);
                    System.out.println(ErrorsConstants.UNCIPHER_COMPLITE + shift); //todo переписать выводы
                    return new Result(new String(shiftedText), ResultCode.OK);
                } catch (IOException e) {
                    return new Result(ErrorsConstants.WRITE_FILE_ERROR, ResultCode.ERROR);
                }
            }
        }
        return new Result(ErrorsConstants.CANT_UNDERSTAND_TEXT, ResultCode.ERROR);
    }

    private boolean isMeaningful(char[] text, Map<Character, Double> frequencyMap) {
        String textStr = new String(text).toLowerCase();
        Map<Character, Integer> textFrequency = new HashMap<>();

        for (char c : textStr.toCharArray()) {
            textFrequency.put(c, textFrequency.getOrDefault(c, 0) + 1);
        }

        double score = 0.0;
        int totalChars = textStr.length();
        for (Map.Entry<Character, Double> entry : frequencyMap.entrySet()) {
            char c = entry.getKey();
            double expectedFrequency = entry.getValue();
            double actualFrequency = textFrequency.getOrDefault(c, 0) * 100.0 / totalChars;
            score += Math.abs(expectedFrequency - actualFrequency);
        }

        return score < Constants.PERCENT_OF_TEXT_UNDERSTANDING;
    }
}