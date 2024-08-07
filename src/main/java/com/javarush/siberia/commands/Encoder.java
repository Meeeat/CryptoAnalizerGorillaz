package com.javarush.siberia.commands;

import com.javarush.siberia.cipher.CaesarCipher;
import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.constants.ErrorsConstants;
import com.javarush.siberia.entity.Result;
import com.javarush.siberia.entity.ResultCode;
import com.javarush.siberia.utils.FileReadWrite;


import java.io.IOException;

public class Encoder implements Action{

    private final CaesarCipher cipher = new CaesarCipher();

    @Override
    public Result execute(String[] parameters) {

        String inputFilePath = parameters[1];
        String outputFilePath = parameters[2];
        String shiftParameter = parameters[0];

        int shift = Constants.DEFAULT_SHIFT;

        if (parameters.length > 0) {
            try {
                shift = Integer.parseInt(shiftParameter);
            } catch (NumberFormatException e) {
                return new Result(ErrorsConstants.NO_NUMBER_FOR_SHIFT, ResultCode.ERROR);
            }
        }

        char[] text;
        try {
            text = FileReadWrite.readFile(inputFilePath);
        } catch (IOException e) {
            return new Result(ErrorsConstants.CANT_READ_FILE, ResultCode.ERROR);
        }

        char[] encryptedText = cipher.encrypt(text, shift);

        try {
            FileReadWrite.writeFile(outputFilePath, encryptedText);
        } catch (IOException e) {
            return new Result(ErrorsConstants.WRITE_FILE_ERROR, ResultCode.ERROR  );
        }
        return new Result(new String(encryptedText), ResultCode.OK);
    }
}