package com.ardublock.translator.block.FaireBot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class FaireBotGoBlock extends TranslatorBlock
{
	public FaireBotGoBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		translator.addHeaderFile("Servo.h");
        translator.addDefinitionCommand("int FAIRE_forward = 3;");
        translator.addDefinitionCommand("int FAIRE_backward = 5;");
        translator.addDefinitionCommand("int FAIRE_left = 2;");
        translator.addDefinitionCommand("int FAIRE_right = 6;");
        translator.addDefinitionCommand("Servo leftServo;");
		translator.addDefinitionCommand("Servo rightServo;");
		translator.addSetupCommand("leftServo.attach(A1);");
		translator.addSetupCommand("rightServo.attach(A2);");
        translator.addSetupCommand("leftServo.write(90);");
        translator.addSetupCommand("rightServo.write(90);");
        
        String ret = "int command;";
        ret = ret + "for (int i = 0; i < memoryPtr; i++) {";
        ret = ret + "command = memory[i];";
        ret = ret + "if (command == FAIRE_forward) {";
        ret = ret + "digitalWrite(8, HIGH);";
        ret = ret + "for (int i = 0; i < FAIRE_movementDistance; i++) {";
        ret = ret + "leftServo.write(180);";
        ret = ret + "rightServo.write(0);";
        ret = ret + "delay(30);";
        ret = ret + "}";
        ret = ret + "digitalWrite(8, LOW);";
        ret = ret + "leftServo.write(90);";
        ret = ret + "rightServo.write(90);"; 
        ret = ret + "delay(30);";
        ret = ret + "}";
        ret = ret + "else if (command == FAIRE_backward) {";
        ret = ret + "digitalWrite(10, HIGH);";
        ret = ret + "for (int i = 0; i < FAIRE_movementDistance; i++) {";
        ret = ret + "leftServo.write(0);";
        ret = ret + "rightServo.write(180);";
        ret = ret + "delay(30);";
        ret = ret + "}";
        ret = ret + "digitalWrite(10, LOW);";
        ret = ret + "leftServo.write(90);";
        ret = ret + "rightServo.write(90);"; 
        ret = ret + "delay(30);";
        ret = ret + "}";
        ret = ret + "else if (command == FAIRE_right) {";
        ret = ret + "digitalWrite(7, HIGH);";
        ret = ret + "for (int i = 0; i < FAIRE_turn; i++) {";
        ret = ret + "leftServo.write(0);";
        ret = ret + "rightServo.write(0);"; 
        ret = ret + "delay(30);";
        ret = ret + "}";
        ret = ret + "digitalWrite(7, LOW);";
        ret = ret + "leftServo.write(90);";
        ret = ret + "rightServo.write(90);"; 
        ret = ret + "delay(30);";
        ret = ret + "}";
        ret = ret + "else if (command == FAIRE_left) {";
        ret = ret + "digitalWrite(9, HIGH);";
        ret = ret + "for (int i = 0; i < FAIRE_turn; i++) {";
        ret = ret + "leftServo.write(180);";
        ret = ret + "rightServo.write(180);"; 
        ret = ret + "delay(30);";
        ret = ret + "}";
        ret = ret + "digitalWrite(9, LOW);";
        ret = ret + "leftServo.write(90);";
        ret = ret + "rightServo.write(90);";
        ret = ret + "delay(30);";
        ret = ret + "}";
        ret = ret + "delay(1000);";
        ret = ret + "}";
        
		return ret;
	}

}
