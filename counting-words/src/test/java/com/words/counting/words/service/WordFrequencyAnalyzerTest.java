package com.words.counting.words.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WordFrequencyAnalyzerTest {

	@Mock
	private WordFrequencyAnalyzer wordFrequencyAnalyzer;
	
	@Test()
	void testCalculateHighestFrequency() {
		// Arrange
		String text = "The sun shines over the lake";
		int frequency = 2;
		
		when(wordFrequencyAnalyzer.calculateHighestFrequency(anyString())).thenReturn(frequency);
		
		// Act
		int freq = wordFrequencyAnalyzer.calculateHighestFrequency(text);
		
		// Assert
		assertEquals(frequency, freq);

	}

	@Test()
	void testCalculateFrequencyForWord() {
		// Arrange
		String text = "The sun shines over the lake";
		int frequency = 2;
		String word = "tHe";

		when(wordFrequencyAnalyzer.calculateFrequencyForWord(anyString(), anyString())).thenReturn(frequency);

		// Act
		int freq = wordFrequencyAnalyzer.calculateFrequencyForWord(text, word);

		// Assert
		assertEquals(frequency, freq);

		verify(wordFrequencyAnalyzer, times(1)).calculateFrequencyForWord(text, word);

	}

	@Test()
	void testCalculateMostFrequentNWords() {
		// Arrange
		String text = "The sun shines over the lake";
		int n = 1;
		//when(wordFrequencyAnalyzer.calculateMostFrequentNWords(anyString(), any(int.class))).thenReturn(any());

		// Act
		List<WordFrequency> freq = wordFrequencyAnalyzer.calculateMostFrequentNWords(text, n);

		// Assert

	}

}
