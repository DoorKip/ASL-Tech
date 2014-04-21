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

/**
 *
 * @author DoorKip
 */
public class Gesture {
	public Gesture(String inputName,int index,int middle,int ring,int pinkie){
		name = inputName;
		positions = new int[4];
		positions[0] = index;
		positions[1] = middle;
		positions[2] = ring;
		positions[3] = pinkie;
	}
	public String getName(){return name;}
	public int[] getPositions(){return positions;}
	public int getPosition(int index){
		return positions[index];
	}
	private final String name;
	private final int[] positions;
}
