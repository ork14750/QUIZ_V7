package com.esiea.API_QUESTIONS.service;

import com.esiea.API_QUESTIONS.repository.QuestionsRepository;
import com.esiea.API_QUESTIONS.model.Questions;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class QuestionsServiceImpl implements QuestionsService {
	@Autowired
	private QuestionsRepository questionsRepository;
	private String filePath;


	@Override
	public void save(Questions questions) {
		questionsRepository.save(questions);
	}

	//@Override
	public Optional<Questions> findByQuestion(String question) {
		return questionsRepository.findByQuestion(question);
	}

	public void loadDataQuestions(){

		String DataUsers;
		this.filePath = new File("API_principal/src/main/resources/data/questions").getAbsolutePath();
		try
		{

			FileInputStream fis=new FileInputStream(this.filePath);

			Scanner sc= new Scanner(fis);    //file to be scanned

			while(sc.hasNextLine())
			{
				DataUsers = sc.nextLine();
				//System.out.println(DataUsers);
				if(DataUsers.charAt(0)!='#'){
					String[] listTemp=DataUsers.split(";");
					Questions questions = new Questions();
					questions.setId(Integer.parseInt(listTemp[0]));
					questions.setQuestion(listTemp[1]);
					questions.setAnswer1(listTemp[2]);
					questions.setAnswer2(listTemp[3]);
					questions.setAnswer3(listTemp[4]);
					questions.setGoodAnswer(listTemp[5]);
					questionsRepository.save(questions);
				}
			}
			sc.close();     //closes the scanner
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Questions> getAllQuestions() {

		return IteratorUtils.toList(questionsRepository.findAll().iterator());
	}

	@Override
	public List<Questions> getRandomQuestions() {
		List listAllQuestions = new ArrayList(IteratorUtils.toList(questionsRepository.findAll().iterator()));
		List randomQuestions = new ArrayList();

		Random rand = new Random(); //instance of random class
		int upperbound = listAllQuestions.size();
		//generate random values from 0-24

		for(int it=0;it<4;it++){
			int int_random = rand.nextInt(upperbound);
			randomQuestions.add(listAllQuestions.get(int_random));

		}
		return randomQuestions;
	}

}
