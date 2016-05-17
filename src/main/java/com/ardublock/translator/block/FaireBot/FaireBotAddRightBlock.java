package com.ardublock.translator.block.FaireBot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class FaireBotAddRightBlock extends TranslatorBlock
{
    public FaireBotAddRightBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException
    {
        translator.addSetupCommand("pinMode( 7 , OUTPUT);");
        translator.addDefinitionCommand("int FAIRE_right = 6;");
        return "memory[memoryPtr] = FAIRE_right; memoryPtr++; while(digitalRead(FAIRE_right) == 1) {digitalWrite(7, HIGH);} digitalWrite(7, LOW);";
    }

}
