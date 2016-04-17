package com.ardublock.translator.block.FaireBot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class FaireBotAddForwardBlock extends TranslatorBlock
{
    public FaireBotAddForwardBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException
    {
        translator.addSetupCommand("pinMode( 8 , OUTPUT);");
        translator.addDefinitionCommand("int FAIRE_forward = 3;");
        return "memory[memoryPtr] = FAIRE_forward ; memoryPtr++; while(digitalRead(FAIRE_forward) == 1) {digitalWrite(8, HIGH);} digitalWrite(8, LOW);";
    }

}
