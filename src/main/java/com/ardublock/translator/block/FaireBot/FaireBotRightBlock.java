package com.ardublock.translator.block.FaireBot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
import com.ardublock.translator.block.exception.BlockException;

public class FaireBotRightBlock extends TranslatorBlock
{
    public FaireBotRightBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException
    {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        if (!(translatorBlock instanceof NumberBlock))
        {
            throw new BlockException(this.blockId, "the rotation of FaireBotForward must a number");
        }
        
        
        NumberBlock rotationNumberBlock = (NumberBlock)translatorBlock;
        String rotationNumber = rotationNumberBlock.toCode();
        //String servoName = "servo_pin_" + pinNumber;
        
        //translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        
        String ret = "digitalWrite(9, HIGH);";
        ret = ret + "for (int i = 0; i < " + rotationNumber + "; i++) {"; 
        ret = ret + "leftServo.write(180); rightServo.write(180); delay(30);}";
        ret = ret + "digitalWrite(9, LOW);";
        ret = ret + "leftServo.write(90); rightServo.write(90); delay(30);";
        
        //servoName + ".write( " + translatorBlock.toCode() + " );\n";
        translator.addHeaderFile("Servo.h");
        translator.addDefinitionCommand("Servo leftServo;");
        translator.addDefinitionCommand("Servo rightServo;");
        translator.addSetupCommand("pinMode( 7 , OUTPUT);");
        translator.addSetupCommand("leftServo.attach(A1);");
        translator.addSetupCommand("rightServo.attach(A2);");
        return ret;
    }

}
