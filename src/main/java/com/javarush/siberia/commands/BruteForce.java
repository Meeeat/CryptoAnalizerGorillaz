package com.javarush.siberia.commands;

import com.javarush.siberia.cipher.CaesarCipher;
import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.constants.ErrorsConstants;
import com.javarush.siberia.entity.Result;
import com.javarush.siberia.entity.ResultCode;
import com.javarush.siberia.utils.DictionaryLoader;
import com.javarush.siberia.utils.FileReadWrite;

import java.io.IOException;
import java.util.Set;

public class BruteForce implements Action{

    private final CaesarCipher cipher = new CaesarCipher();

    private final Set<String> ruWords;
    private final Set<String> enWords;

    public BruteForce() {
        try {
            ruWords = DictionaryLoader.loadDictionary(Constants.RU_DICTIONARY_PATH);
            enWords = DictionaryLoader.loadDictionary(Constants.EN_DICTIONARY_PATH);
        } catch (IOException e) {
            throw new RuntimeException(ErrorsConstants.DICTIONARY_LOAD_FAILURE, e);
        }
    }

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

        int foundShift = -1;

        for (int shift = 0; shift < Constants.ALPHABET.length; shift++) {
            char[] bruteforcedText = cipher.decrypt(text, shift);

            if (isMeaningful(bruteforcedText, ruWords) || isMeaningful(bruteforcedText, enWords)) {
                foundShift = shift + 1; //i need this for correctly save text with this shift
                break;
            }
        }

        if (foundShift != -1) {
            char[] shiftedText = cipher.decrypt(text, foundShift);
            try {
                FileReadWrite.writeFile(outputFilePath, shiftedText);
            } catch (IOException e) {
                return new Result(ErrorsConstants.WRITE_FILE_ERROR, ResultCode.ERROR);
            }
            System.out.println(ErrorsConstants.UNCIPHER_COMPLITE + foundShift); // todo переписать выводы
            return new Result(new String(shiftedText), ResultCode.OK);
        } else {
            return new Result(ErrorsConstants.CANT_UNDERSTAND_TEXT, ResultCode.ERROR);
        }
    }

    private boolean isMeaningful(char[] text, Set<String> dictionary) {
        String[] words = new String(text).split("\\W+");
        int meaningfulWordCount = 0;

        for (String word : words) {
            if (dictionary.contains(word.toLowerCase())) {
                meaningfulWordCount++;
            }
        }
        return  meaningfulWordCount > words.length * 0.8;
    }

}