package com.ardublock.translator.block.FaireBot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class FaireBotAddBackwardBlock extends TranslatorBlock
{
    public FaireBotAddBackwardBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException
    {
        translator.addSetupCommand("pinMode( 10 , OUTPUT);");
        translator.addDefinitionCommand("int FAIRE_backward = 5;");
        return "memory[memoryPtr] = FAIRE_backward; memoryPtr++; while(digitalRead(FAIRE_backward) == 1) {digitalWrite(10, HIGH);} digitalWrite(10, LOW);";
    }
    
}
