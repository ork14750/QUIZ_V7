package com.esiea.API_RANKINGS.service;

import com.esiea.API_RANKINGS.model.Player;
import com.esiea.API_RANKINGS.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.IteratorUtils;


import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepository playerRepository;
	private String filePath;


	@Override
	public void save(Player player) {
		playerRepository.save(player);

	}

	@Override
	public Optional<Player> findByUsername(String username) {
		return playerRepository.findByUsername(username);
	}

	public void loadDataUsers(){

		String DataUsers;
		this.filePath = new File("quiz_v7/src/main/resources/data/userData").getAbsolutePath();
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
					Player player = new Player();
					player.setId(Integer.parseInt(listTemp[0]));
					player.setUsername(listTemp[1]);
					player.setPoints(Integer.parseInt(listTemp[4]));

					playerRepository.save(player);
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
	public Collection<Player> getAllUsers() {
		return IteratorUtils.toList(playerRepository.findAll().iterator());
	}




}
