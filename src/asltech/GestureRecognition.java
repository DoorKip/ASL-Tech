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
	public static String doRecognition(int[] positions){
		String bestMatchString = null;
		float bestMatchPercentage = 0;
		for(Gesture item : gestureList){
			float matchPercent = 0;
			for(int i=0; i<4; i++){
				double x;
				if(positions[i]/10.24 > 1){
					x = positions[i]/10.24;
				} else { x = 1; }
				matchPercent += Math.abs(item.getPosition(i)-x)/x;
			}
			matchPercent = 100 - matchPercent/4;
			if(matchPercent > bestMatchPercentage){
				bestMatchPercentage = matchPercent;
				bestMatchString = item.getName();
			}
		}
		return bestMatchString;
	}
	
	static final ArrayList<Gesture> gestureList = new ArrayList<>();
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
