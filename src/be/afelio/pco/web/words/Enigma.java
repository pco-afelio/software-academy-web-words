package be.afelio.pco.web.words;

import java.io.Serializable;

public class Enigma implements Serializable {

	private static final long serialVersionUID = 4550164661744368041L;
	private final String targetWord;
	private final String mixedLetters;
	private boolean resolved;
	
	public Enigma(String targetWord, String mixedLetters) {
		super();
		this.targetWord = targetWord;
		this.mixedLetters = mixedLetters;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public String getTargetWord() {
		return targetWord;
	}

	public String getMixedLetters() {
		return mixedLetters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mixedLetters == null) ? 0 : mixedLetters.hashCode());
		result = prime * result + (resolved ? 1231 : 1237);
		result = prime * result + ((targetWord == null) ? 0 : targetWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enigma other = (Enigma) obj;
		if (mixedLetters == null) {
			if (other.mixedLetters != null)
				return false;
		} else if (!mixedLetters.equals(other.mixedLetters))
			return false;
		if (resolved != other.resolved)
			return false;
		if (targetWord == null) {
			if (other.targetWord != null)
				return false;
		} else if (!targetWord.equals(other.targetWord))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enigma [targetWord=" + targetWord + ", mixedLetters=" + mixedLetters + ", resolved=" + resolved + "]";
	}
}
