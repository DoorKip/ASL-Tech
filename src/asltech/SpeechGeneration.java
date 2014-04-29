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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Uses Google's TTS API to produce audible speech
 * @author DoorKip
 */
public class SpeechGeneration {
	/**
	 * Plays audio representation of produced speech
	 * @param str The string to be played
	 */
	public static synchronized void sayString(String str){
		if(null == str || str.isEmpty()){
			System.out.println("String Error");
		} else {
			try {
				URL word = new URL("http://translate.google.com/translate_tts?ie=utf-8&tl=en&q="+str);
				HttpURLConnection connection = (HttpURLConnection) word.openConnection();
				connection.setRequestMethod("GET");
				connection.setReadTimeout(10000);
				connection.setDoOutput(true);
				connection.setRequestProperty("User-Agent", "Mozilla/5.0");
				connection.connect();
				InputStream stream = connection.getInputStream();
				Player play = new Player(stream);
				play.play();
				stream.close();
				connection.disconnect();
			} catch (IOException | JavaLayerException ex) {
				Logger.getLogger(ASLTech.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}