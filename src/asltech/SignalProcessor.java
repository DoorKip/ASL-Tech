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
import java.util.Collections;

/**
 *
 * @author DoorKip
 */
public class SignalProcessor {
	public SignalProcessor(){
		listLock = new Object();
		temporalList = new ArrayList<>();
		temporalList.add(getRandomSignal());
		temporalList.ensureCapacity(30);
	}
	public void insertSignal(int[] signal){
		synchronized(listLock){
			if(temporalList.size()>=30){
				temporalList.remove(0);
			}
			System.out.println(signal[0]+" "+signal[1]+" "+signal[2]+" "+signal[3]);
			temporalList.add(signal);
		}
	}
	public int[] getSample(){
		ArrayList<int[]> temporalListClone;
		synchronized(listLock){ temporalListClone = new ArrayList<>(temporalList); }
		int[] avgSignal = new int[4];
		for(int i = 0; i<temporalListClone.size(); i++){
			int[] listSample = temporalListClone.get(i);
			System.out.println(listSample[0]+" "+listSample[1]+" "+listSample[2]+" "+listSample[3]);
			for(int j = 0; j<4; j++){
				avgSignal[j] += listSample[j];
			}
		}
		for(int k = 0; k<4; k++){
			avgSignal[k] = avgSignal[k]/Math.max(temporalListClone.size(),1);
		}
		return avgSignal;
	}
	
	public static int[] getBlankSignal(){
		int[] temp = new int[4];
		temp[0]=0;
		temp[1]=0;
		temp[2]=0;
		temp[3]=0;
		return temp;
	}
	public static int[] getRandomSignal(){
		int[] temp = new int[4];
		temp[0] = (int) Math.round(Math.random()*maxSignalValue);
		temp[1] = (int) Math.round(Math.random()*maxSignalValue);
		temp[2] = (int) Math.round(Math.random()*maxSignalValue);
		temp[3] = (int) Math.round(Math.random()*maxSignalValue);
		return temp;
	}
	
	public static int getMaxSignalValue(){
		return maxSignalValue;
	}
	public static void setMaxSignalValue(int value){
		maxSignalValue = value;
	}
	
	private static int maxSignalValue = 1024;
	private final ArrayList<int[]> temporalList;
	private final Object listLock;
}
