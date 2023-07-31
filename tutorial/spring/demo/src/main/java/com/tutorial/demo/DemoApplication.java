package com.tutorial.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/randomfact")
	public String getRandomFact() {
		String[] facts = {
				"The word hundred comes from the old Norse term, hundrath, which actually means 120 and not 100.",
				"In a room of 23 people there’s a 50% chance that two people have the same birthday.",
				"Most mathematical symbols weren’t invented until the 16th century. Before that, equations were written in words.",
				"Forty is the only number that is spelt with letters arranged in alphabetical order.",
				" Conversely, one is the only number that is spelt with letters arranged in descending order.",
				"From 0 to 1000, the only number that has the letter a in it is one thousand.",
				"Four is the only number in the English language that is spelt with the same number of letters as the number itself.",
				"Every odd number has an e in it.",
				"Over 2000 years ago, Eratosthenes estimated the Earth's circumference using math, without ever leaving Egypt, and he was accurate to within 2%",
				"Markings on animal bones indicate that humans have been doing math since around 30,000BC."
		};
		String randFact = facts[(int) Math.floor(Math.random() * facts.length)];
		return randFact;
	}
}
