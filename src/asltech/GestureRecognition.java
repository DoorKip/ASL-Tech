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
 * Handles gesture recognition
 * @author DoorKip
 */
public class GestureRecognition {
	/**
	 * Attempts to find a match to the input finger positions.
	 * @param positions A four integer array that defines the position of each finger.
	 * @return Returns the gesture most closely matched to the input.
	 */
	public static String doRecognition(int[] positions){
		String bestMatchString = null;
		float bestMatchPercentage = 0;
		for(Gesture item : gestureList){
			float variance = 0;
			for(int i=0; i<4; i++){
				variance += (float) Math.abs( item.getPosition(i) - positions[i]/(SignalProcessor.getMaxSignalValue()*0.01) );
				System.out.print(Math.abs( item.getPosition(i) - positions[i]/(SignalProcessor.getMaxSignalValue()*0.01) )+" - ");
			}
			float matchPercent = 100 - variance*0.25f;
			System.out.println(item.getName()+": "+matchPercent);
			if(matchPercent > bestMatchPercentage && matchPercent > minimumMatchPercentage){
				bestMatchPercentage = matchPercent;
				bestMatchString = item.getName();
			}
		}
		return bestMatchString;
	}
	
	public static void setMinimumMatchPercentage(int percentage){
		minimumMatchPercentage = percentage;
	}
	
	/**
	 * 
	 */
	private static int minimumMatchPercentage;
	/**
	 * List of gestures that the system is capable of recognizing.
	 */
	private static final ArrayList<Gesture> gestureList = new ArrayList<>();
	static {
		gestureList.add(new Gesture("D",0,100,100,100));
		gestureList.add(new Gesture("E",100,80,90,100));
		gestureList.add(new Gesture("H",0,0,100,100));
		gestureList.add(new Gesture("L",0,90,90,90));
		gestureList.add(new Gesture("O",70,70,70,70));
		gestureList.add(new Gesture("R",10,0,100,100));
		gestureList.add(new Gesture("W",0,0,0,100));
	}
}
