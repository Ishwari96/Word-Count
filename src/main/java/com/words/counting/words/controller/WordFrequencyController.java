package com.words.counting.words.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.words.counting.words.model.TextWordRequest;
import com.words.counting.words.service.WordFrequencyAnalyzer;
import com.words.counting.words.utilities.Constants;


@RestController
@RequestMapping(Constants.START_WORD_COUNT )
public class WordFrequencyController {
	
	@Autowired
	WordFrequencyAnalyzer wordFreq;
	
	private static final Logger logger = LoggerFactory.getLogger(WordFrequencyController.class);
	
	@GetMapping(Constants.INPUT_TEXT)
	@ResponseStatus(HttpStatus.OK)
	public int getHighestFrequency(@PathVariable("text") String text) {
		logger.debug("Input string received : {}", text);
		return wordFreq.calculateHighestFrequency(text);
	}
	
	@GetMapping(Constants.TEXT_WORD)
	@ResponseStatus(HttpStatus.OK)
	public int getFrequencyForWord(@Valid @RequestBody TextWordRequest textandWord) {
		logger.debug("Input string received : {}", textandWord);
		return wordFreq.calculateFrequencyForWord(textandWord.getText(), textandWord.getWord());
	}


}
