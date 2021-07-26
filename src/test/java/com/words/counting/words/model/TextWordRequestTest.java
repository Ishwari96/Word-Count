package com.words.counting.words.model;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

class TextWordRequestTest {

	TextWordRequest textWordRequest;
	  @Test
	    public void textWordRequestTest() {
	        PojoClass pojoClass = PojoClassFactory.getPojoClass(TextWordRequest.class);
	        com.openpojo.validation.Validator validator = ValidatorBuilder.create()
	                .with(new SetterMustExistRule())
	                .with(new GetterMustExistRule())
	                .with(new GetterTester())
	                .with(new SetterTester())
	                .build();
	        validator.validate(pojoClass);
	    }

	//Test Constructor
		@Test
		public void constructorTest() {
			String text = "The Sun the shine";
			String word = "the";

			textWordRequest = new TextWordRequest(text, word);

			assertThat(text, is(textWordRequest.getText()));
			assertThat(word, is(textWordRequest.getWord()));
		}
}
