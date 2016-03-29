package com.ardublock.translator.block.FaireBot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
import com.ardublock.translator.block.exception.BlockException;

public class FaireBotLeftBlock extends TranslatorBlock
{
	public FaireBotLeftBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
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
		
		String ret = "digitalWrite(7, HIGH);\n";
        ret = ret + "for (int i = 0; i < " + rotationNumber + "; i++)\n{"; 
		ret = ret + "  leftServo.write(0);\n  rightServo.write(0);\n  delay(30);\n}";
        ret = ret + "digitalWrite(7, LOW);\nleftServo.write(90);\nrightServo.write(90);\ndelay(30);";
		
		//servoName + ".write( " + translatorBlock.toCode() + " );\n";
		translator.addHeaderFile("Servo.h");
		translator.addDefinitionCommand("Servo leftServo;");
		translator.addDefinitionCommand("Servo rightServo;");
		translator.addSetupCommand("leftServo.attach(A1);");
		translator.addSetupCommand("rightServo.attach(A2);");
		return ret;
	}

}
