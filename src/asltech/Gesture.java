/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
