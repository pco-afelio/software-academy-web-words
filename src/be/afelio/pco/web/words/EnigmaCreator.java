package be.afelio.pco.web.words;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EnigmaCreator {

	private List<String> words = new ArrayList<>();
	private Random random = new Random();

	public EnigmaCreator(int length) {
		try (
			InputStream ips = getClass().getResourceAsStream("/words");
			InputStreamReader ipsr = new InputStreamReader(ips, "UTF-8");
			BufferedReader reader = new BufferedReader(ipsr)
		) {
			String word = reader.readLine();
			while (word != null) {
				if (word.length() >= length && !word.contains("'")) {
					word = word.toLowerCase();
					words.add(word);
				}
				word = reader.readLine();
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Enigma createEnigma() {
		Enigma enigma = null;
		
		int index = random.nextInt(words.size());
		String targetWord = words.get(index);
		String[] characters = targetWord.split("");
		List<String> letters = Arrays.asList(characters);
		Collections.shuffle(letters);
		
		String mixedLetters = String.join("", letters);
		
		enigma = new Enigma(targetWord, mixedLetters);
		
		return enigma;
	}
	
	public void checkWord(Enigma enigma, String word) {
		if (enigma != null) {
			boolean found = enigma.getTargetWord().equalsIgnoreCase(word);
			enigma.setResolved(found);
		}
	}
}







