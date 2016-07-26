package com.ardublock.translator.block.FaireBot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class FaireBotAddLeftBlock extends TranslatorBlock
{
    public FaireBotAddLeftBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException
    {
        translator.addSetupCommand("pinMode( 9 , OUTPUT);");
        translator.addDefinitionCommand("int FAIRE_left = 2;");
        return "memory[memoryPtr] = FAIRE_left; memoryPtr++; while(digitalRead(FAIRE_left) == 1) {digitalWrite(9, HIGH);} digitalWrite(9, LOW);";
    }

}
