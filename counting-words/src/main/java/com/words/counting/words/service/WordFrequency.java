package com.words.counting.words.service;

import org.springframework.stereotype.Service;

@Service
public interface WordFrequency {
	
	String getWord();
	int getFrequency();
}