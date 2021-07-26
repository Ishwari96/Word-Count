package com.words.counting.words.controller;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.words.counting.words.service.WordFrequency;
import com.words.counting.words.service.impl.WordFrequencyAnalyzerImpl;

public class WordFrequencyImpl implements WordFrequency {

	private static final Logger logger = LoggerFactory.getLogger(WordFrequencyImpl.class);
	Scanner input = new Scanner(System.in); // Create a Scanner object

	public String getWord() {

		String text = input.nextLine(); // Read user input
		return text;
	}

	public int getFrequency() {

		logger.debug("Enter number: ");
		int n = input.nextInt();

		return n;
	}

	public static void main(String[] args) {

		WordFrequencyAnalyzerImpl wordAnalyzer = new WordFrequencyAnalyzerImpl();
		WordFrequencyImpl wordFre = new WordFrequencyImpl();
		logger.debug("Enter your input text: ");
		wordAnalyzer.calculateHighestFrequency(wordFre.getWord());

		wordAnalyzer.calculateMostFrequentNWords(wordFre.getWord(), wordFre.getFrequency());

	}

}
