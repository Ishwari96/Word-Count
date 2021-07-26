package com.words.counting.words.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.words.counting.words.service.WordFrequency;

@ExtendWith(MockitoExtension.class)
public class WordFrequencyAnalyzerImplTest {

	@InjectMocks
	private WordFrequencyAnalyzerImpl wordFrequencyAnalyzerImpl;

	@Test()
	void testCalculateHighestFrequency() {
		// Arrange
		String text = "The sun shines over the lake";
		int frequency = 2;

		// Act
		int freq = wordFrequencyAnalyzerImpl.calculateHighestFrequency(text);

		// Assert
		assertEquals(frequency, freq);

	}

	@Test()
	void testCalculateFrequencyForWord() {
		// Arrange
		String text = "The sun shines over the lake";
		int frequency = 2;
		String word = "tHe";

		// Act
		int freq = wordFrequencyAnalyzerImpl.calculateFrequencyForWord(text, word);

		// Assert
		assertEquals(frequency, freq);

	}

	@Test()
	void testCalculateMostFrequentNWords() {
		// Arrange
		String text = "The sun shines over the lake";
		int n = 1;

		// Act
		List<WordFrequency> freq = wordFrequencyAnalyzerImpl.calculateMostFrequentNWords(text, n);

		// Assert

	}

}
