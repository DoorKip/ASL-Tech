/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asltech;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.net.HttpURLConnection;

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
	
	public static void sayShit(String str){
		if(null == str){
			System.out.println("String Error");
		} else {
			try {
				URL word = new URL("http://translate.google.com/translate_tts?ie=utf-8&tl=en&q="+str);
				//BufferedReader in = new BufferedReader();
				HttpURLConnection cnct = (HttpURLConnection) word.openConnection();
				cnct.setRequestMethod("GET");
				cnct.setReadTimeout(10000);
				cnct.setDoOutput(true);
				cnct.setRequestProperty("User-Agent", "Mozilla/5.0");
				cnct.connect();
				System.out.println(cnct.getContentType());
				InputStream stream = cnct.getInputStream();
				Player play = new Player(stream);
				play.play();
			} catch (IOException | JavaLayerException ex) {
				Logger.getLogger(ASLTech.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
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
