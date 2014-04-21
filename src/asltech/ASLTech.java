/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asltech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author DoorKip
 */
public class ASLTech {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		if(debug == true){
			testing();
		}else{
			//Create thread to get number array
			//Have comms library send and array of arrays for filtering?
		}
		//Manipulate the array of numbers into extension percentage -> Expand, Filter, Linearize
		//Pass results through gesture analysis
		//Report gestures to speech generator
	}
	
	static void init(){
		
	}
	
	static void testing(){
		//GestureRecognition.sayShit("lolololol");
		GestureRecognition.sayShit(null);
	}
	
	static boolean debug = true;
	
}