package com.words.counting.words.service.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.words.counting.words.service.WordFrequency;
import com.words.counting.words.service.WordFrequencyAnalyzer;
import com.words.counting.words.utilities.Constants;

@Service
public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {

	private static final Logger logger = LoggerFactory.getLogger(WordFrequencyAnalyzerImpl.class);

	@Override
	public int calculateHighestFrequency(String text) {
		LinkedHashMap<String, Integer> countFrequency = countFrequencyMap(text);
		logger.debug("linked hash map::" + countFrequency);
		int maxValueInMap = Collections.max(countFrequency.values());

		logger.debug("Highest Frequency is: " + maxValueInMap);
		return maxValueInMap;
	}

	/**
	 * To Split the given strings and store each word
	 * Sort based on highest frequency  
	 */
	private LinkedHashMap<String, Integer> countFrequencyMap(String text) {
		LinkedHashMap<String, Integer> countFreq = new LinkedHashMap<String, Integer>();
		String totalWords[] = StringUtils.lowerCase(text).trim().split(Constants.isAlphabaste);

		for (String words : totalWords) {
			if (!countFreq.containsKey(words)) {
				countFreq.put(words, Constants.ONE);
			} else {
				countFreq.put(words, countFreq.get(words) + Constants.ONE);
			}
		}

		Map<String, Integer> sorted = countFreq.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		return (LinkedHashMap<String, Integer>) sorted;
	}
	
	/**
	 * calculate Frequency for specific word
	 */
	@Override
	public int calculateFrequencyForWord(String text, String word) {

		String input = StringUtils.lowerCase(text);
		int frequencyOfWord = StringUtils.countMatches(input, word.toLowerCase());
		logger.debug("frequencyOfWord is::" + frequencyOfWord);
		return frequencyOfWord;

	}

	@Override
	public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {

		LinkedHashMap<String, Integer> countFrequency = countFrequencyMap(text);

		List<String> nValues = countFrequency.keySet().stream().limit(n).collect(Collectors.toList());
		
		// To be done
		
		return null;
	}

}
