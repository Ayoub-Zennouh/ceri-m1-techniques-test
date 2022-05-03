package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
	
	IPokemonTrainerFactory pokemonTrainerFactory;
	IPokedexFactory pokedexFactory;
	IPokedex pokedex;
	PokemonTrainer pokemonTrainer;
	
	@Before 
	public void initialize() {
		pokemonTrainerFactory = new PokemonTrainerFactory();
		pokedexFactory = new PokedexFactory();
		pokemonTrainer = pokemonTrainerFactory.createTrainer("Trainer", Team.INSTINCT, pokedexFactory);
	}
	
	@Test
	public void createTrainerTest() {
		assertEquals("Trainer", pokemonTrainer.getName());
		assertEquals(Team.INSTINCT, pokemonTrainer.getTeam());
	}

}