/*
 * Copyright (C) 2014 DoorKip.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */

package asltech;

import java.util.ArrayList;

/**
 * This main file is for testing only. Does not do much otherwise.
 * @author DoorKip
 */
public class ASLTech {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		array[0] = a1;
		array[1] = a2;
		array[2] = a3;
		array[3] = a4;
		
		SignalProcessor sP = new SignalProcessor();
		
		for(int i=0;i<40;i++){
			sP.insertSignal(SignalProcessor.getRandomSignal());
		}
		int[] sample = sP.getSample();
		System.out.print(sample[0]+" - ");
		System.out.print(sample[1]+" - ");
		System.out.print(sample[2]+" - ");
		System.out.println(sample[3]);
		String recognizedString = GestureRecognition.doRecognition(sample);
		//SpeechGeneration.sayString(recognizedString);
		System.out.println(recognizedString);
	}

	
static int a1 = 75;
static int a2 = 20;
static int a3 = 700;
static int a4 = 900;

static int[] array = new int[4];

}

