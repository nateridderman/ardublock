package com.ardublock.translator.block.FaireBot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
import com.ardublock.translator.block.exception.BlockException;

public class FaireBotTurningBlock extends TranslatorBlock
{
    public FaireBotTurningBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException
    {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        if (!(translatorBlock instanceof NumberBlock))
        {
            throw new BlockException(this.blockId, "the FaireBot turn must a number");
        }
        
        
        NumberBlock turnNumberBlock = (NumberBlock)translatorBlock;
        String turnNumber = turnNumberBlock.toCode();
        
        translator.addDefinitionCommand("int FAIRE_turn;");
        return "FAIRE_turn = " + turnNumber + ";";
    }

}
